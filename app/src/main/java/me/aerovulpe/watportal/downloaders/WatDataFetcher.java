package me.aerovulpe.watportal.downloaders;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import me.aerovulpe.watportal.resources.Resource;
import me.aerovulpe.watportal.resources.WatObject;
import me.aerovulpe.watportal.resources.WatObjectHandler;

import static me.aerovulpe.watportal.Constants.API_KEY;
import static me.aerovulpe.watportal.Constants.API_KEY_PARAM;
import static me.aerovulpe.watportal.Constants.BASE_URI;


/**
 * Created by Aaron on 17/11/2014.
 */
public class WatDataFetcher {
    private static final WatDataFetcher INSTANCE = new WatDataFetcher();

    private static final String LOG_TAG = WatDataFetcher.class.getSimpleName();

    private List<WatDataDownloader> mDataDownloaders;


    private WatDataFetcher() {
        //Restrict instantiation.
        mDataDownloaders = new ArrayList<>();
    }

    public static WatDataFetcher getInstance() {
        return INSTANCE;
    }

    public void execute(WatObjectHandler watObjectHandler, Resource resource, String... params) {
        String urlStr = buildResourceUri(resource, params).toString();

        WatDataDownloader dataDownloader = new WatDataDownloader(watObjectHandler, resource);
        dataDownloader.execute(urlStr);

        mDataDownloaders.add(dataDownloader);
        Log.v(LOG_TAG, "Built URI = " + urlStr);
    }

    private Uri buildResourceUri(Resource resource, String... params) {
        Uri.Builder uriBuilder = Uri.parse(BASE_URI).buildUpon();
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);

        uriBuilder.appendEncodedPath(resource.addParams(params).buildEndpoint());

        return uriBuilder.build();
    }

    public void killDataDownloaders() {
        for (WatDataDownloader mDataDownloader : mDataDownloaders) {
            mDataDownloader.cancel(true);
        }
    }

    public class WatDataDownloader extends AsyncTask<String, Void, WatObject> {
        private WatObjectHandler mWatObjectHandler;
        private Resource mResource;

        public WatDataDownloader(WatObjectHandler watObjectHandler, Resource resource) {
            mWatObjectHandler = watObjectHandler;
            mResource = resource;
        }

        @Override
        protected WatObject doInBackground(String... params) {
            try {
                return WatObject.parse(mResource, new JSONObject(getJSONString(params[0])));
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(LOG_TAG, "Error processing JSON data, watObject is null!", e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(WatObject result) {
            super.onPostExecute(result);
            if (result != null) {
                mWatObjectHandler.onWatObjectReceived(result);
            }
        }

        private String getJSONString(String urlStr){
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            if (urlStr == null)
                return null;

            try {
                URL url = new URL(urlStr);

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();

                if (inputStream == null)
                    return null;

                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                return buffer.toString();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error!", e);
                return null;
            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();

                if (reader != null)
                    try {
                        reader.close();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "Error closing the reader", e);
                    }
            }
        }
    }
}
