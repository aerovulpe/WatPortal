package me.aerovulpe.watportal.downloaders;

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

import me.aerovulpe.watportal.resources.Resource;
import me.aerovulpe.watportal.resources.WatObject;
import me.aerovulpe.watportal.resources.WatObjectHandler;

/**
* Created by Aaron on 10/12/2014.
*/
public class WatDataDownloader extends AsyncTask<String, Void, WatObject> {
    private static final String LOG_TAG = WatDataDownloader.class.getSimpleName();

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
