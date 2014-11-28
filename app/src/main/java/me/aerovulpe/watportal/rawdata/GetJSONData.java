package me.aerovulpe.watportal.rawdata;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import me.aerovulpe.watportal.resources.Resource;
import me.aerovulpe.watportal.constants.WatObject;
import me.aerovulpe.watportal.constants.WatObjectHandler;
import me.aerovulpe.watportal.resources.food.menu.WatMenu;
import me.aerovulpe.watportal.resources.Meta;

import static me.aerovulpe.watportal.constants.Constants.API_KEY;
import static me.aerovulpe.watportal.constants.Constants.API_KEY_PARAM;
import static me.aerovulpe.watportal.constants.Constants.BASE_URI;
import static me.aerovulpe.watportal.constants.Constants.DATA_KEY;
import static me.aerovulpe.watportal.constants.Constants.MESSAGE_KEY;
import static me.aerovulpe.watportal.constants.Constants.META_KEY;
import static me.aerovulpe.watportal.constants.Constants.METHOD_ID_KEY;
import static me.aerovulpe.watportal.constants.Constants.REQUESTS_KEY;
import static me.aerovulpe.watportal.constants.Constants.STATUS_KEY;
import static me.aerovulpe.watportal.constants.Constants.TIMESTAMP_KEY;


/**
 * Created by Aaron on 17/11/2014.
 */
public class GetJSONData extends GetRawData {
    private static final String LOG_TAG = GetJSONData.class.getSimpleName();

    private Resource resource;
    private WatObjectHandler watObjectHandler;

    public GetJSONData(Resource resource, String... params) {
        super();
        this.resource = resource;
        setUrl(buildCourseUri(resource, params).toString());
    }

    @Override
    public void execute() {
        new DownloadJSONData().execute(getUrl());
        Log.v(LOG_TAG, "Built URI = " + getUrl());
    }

    public void execute(WatObjectHandler watObjectHandler) {
        this.watObjectHandler = watObjectHandler;
        execute();
    }

    private Uri buildCourseUri(Resource resource, String... params) {
        Uri.Builder uriBuilder = Uri.parse(BASE_URI).buildUpon();
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);

        uriBuilder.appendEncodedPath(resource.addParams(params).buildEndpoint());

        return uriBuilder.build();
    }

    public class DownloadJSONData extends DownloadRawData {
        @Override
        protected String doInBackground(String... params) {
            return super.doInBackground(params);
        }

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

            WatObject watObject = null;

            JSONObject rootObject = new JSONObject(getData());

            JSONObject metaObject = rootObject.getJSONObject(META_KEY);
            JSONObject dataObject = rootObject.getJSONObject(DATA_KEY);

            Meta meta = new Meta();
            meta.setRequests(metaObject.getInt(REQUESTS_KEY));
            meta.setTimestamp(metaObject.getInt(TIMESTAMP_KEY));
            meta.setStatus(metaObject.getInt(STATUS_KEY));
            meta.setMessage(metaObject.getString(MESSAGE_KEY));
            meta.setMethod_id(metaObject.getInt(METHOD_ID_KEY));

            switch (resource) {
                case FOOD_MENU:
                    watObject = WatMenu.parse(meta, dataObject);
                    break;
            }

            watObjectHandler.setWatObject(watObject);
        }
    }
}
