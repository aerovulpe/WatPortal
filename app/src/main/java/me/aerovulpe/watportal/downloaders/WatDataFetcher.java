package me.aerovulpe.watportal.downloaders;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import me.aerovulpe.watportal.resources.Resource;
import me.aerovulpe.watportal.resources.WatObject;
import me.aerovulpe.watportal.resources.WatObjectHandler;

import static me.aerovulpe.watportal.Constants.API_KEY;
import static me.aerovulpe.watportal.Constants.API_KEY_PARAM;
import static me.aerovulpe.watportal.Constants.BASE_URI;


/**
 * Created by Aaron on 17/11/2014.
 */
public class WatDataFetcher extends RawDataFetcher {
    private static final WatDataFetcher INSTANCE = new WatDataFetcher();

    private static final String LOG_TAG = WatDataFetcher.class.getSimpleName();

    private WatObjectHandler mWatObjectHandler;


    private WatDataFetcher() {
        //Restrict instantiation.
    }

    public static WatDataFetcher getInstance(){
        return INSTANCE;
    }

    public void execute(WatObjectHandler watObjectHandler, Resource resource, String... params) {
        mWatObjectHandler = watObjectHandler;
        setUrl(buildCourseUri(resource, params).toString());
        execute(new WatDataDownloader(resource));
        Log.v(LOG_TAG, "Built URI = " + getUrl());
    }

    private Uri buildCourseUri(Resource resource, String... params) {
        Uri.Builder uriBuilder = Uri.parse(BASE_URI).buildUpon();
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);

        uriBuilder.appendEncodedPath(resource.addParams(params).buildEndpoint());

        return uriBuilder.build();
    }

    public class WatDataDownloader extends RawDataDownloader {
        private Resource mResource;

        public WatDataDownloader(Resource resource) {
            mResource = resource;
        }

        @Override
        protected Object doInBackground(String... params) {
            try {
                return WatObject.parse(mResource, new JSONObject((String) super.doInBackground(params)));
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(LOG_TAG, "Error processing JSON data, watObject is null!", e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);
            if (result instanceof WatObject) {
                mWatObjectHandler.onWatObjectReceived((WatObject) result);
            }
        }
    }
}
