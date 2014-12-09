package me.aerovulpe.watportal.downloaders;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import me.aerovulpe.watportal.resources.WatObject;
import me.aerovulpe.watportal.resources.WatObjectHandler;
import me.aerovulpe.watportal.resources.Resource;

import static me.aerovulpe.watportal.Constants.API_KEY;
import static me.aerovulpe.watportal.Constants.API_KEY_PARAM;
import static me.aerovulpe.watportal.Constants.BASE_URI;


/**
 * Created by Aaron on 17/11/2014.
 */
public class GetJSONData extends GetRawData {
    private static final String LOG_TAG = GetJSONData.class.getSimpleName();

    private Resource mResource;
    private WatObjectHandler mWatObjectHandler;

    public GetJSONData(Resource resource, String... params) {
        super();
        this.mResource = resource;
        setUrl(buildCourseUri(resource, params).toString());
    }

    public void execute(WatObjectHandler watObjectHandler) {
        this.mWatObjectHandler = watObjectHandler;
        execute(new JSONDataDownloader());
        Log.v(LOG_TAG, "Built URI = " + getUrl());
    }

    private Uri buildCourseUri(Resource resource, String... params) {
        Uri.Builder uriBuilder = Uri.parse(BASE_URI).buildUpon();
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);

        uriBuilder.appendEncodedPath(resource.addParams(params).buildEndpoint());

        return uriBuilder.build();
    }

    public class JSONDataDownloader extends RawDataDownloader {

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                processResult();
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(LOG_TAG, "Error processing JSON data");
            }
        }

        private void processResult() throws JSONException {
            if (getDownloadStatus() != DownloadStatus.OK) {
                Log.e(LOG_TAG, "Error downloading raw data file!");
                return;
            }

            WatObject watObject = WatObject.parse(mResource, new JSONObject(getData()));

            mWatObjectHandler.onWatObjectReceived(watObject);
        }
    }
}
