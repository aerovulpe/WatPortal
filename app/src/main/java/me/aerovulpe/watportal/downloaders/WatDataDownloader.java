package me.aerovulpe.watportal.downloaders;

import android.content.Context;
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

import me.aerovulpe.watportal.Utility;
import me.aerovulpe.watportal.data.Resource;

/**
* Created by Aaron on 10/12/2014.
*/
public class WatDataDownloader extends AsyncTask<String, Void, Void> {
    private static final String LOG_TAG = WatDataDownloader.class.getSimpleName();

    Context mContext;

    public WatDataDownloader(Context context){
        mContext = context;
    }

    @Override
    protected Void doInBackground(String... params) {

        try {
            String json = getJSONString("https://api.uwaterloo.ca/v2/foodservices/locations.json?key=759f046d712dc42cc5a5b65745d635c3");
            Log.d(LOG_TAG, json);
            Utility.parseJSON(mContext, Resource.FOOD_LOCATIONS, new JSONObject(json));
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error processing JSON data!", e);
        } catch (NullPointerException e){
            Log.e(LOG_TAG, "Empty JSON data string!", e);
        }

        return null;
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
