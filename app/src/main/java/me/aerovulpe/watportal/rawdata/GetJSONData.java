package me.aerovulpe.watportal.rawdata;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import me.aerovulpe.watportal.constants.WatObject;
import me.aerovulpe.watportal.constants.WatObjectHandler;
import me.aerovulpe.watportal.resources.Meta;
import me.aerovulpe.watportal.resources.Resource;
import me.aerovulpe.watportal.resources.food.announcements.WatAnnouncement;
import me.aerovulpe.watportal.resources.food.diets.WatDiet;
import me.aerovulpe.watportal.resources.food.locations.WatLocation;
import me.aerovulpe.watportal.resources.food.menu.WatMenu;
import me.aerovulpe.watportal.resources.food.notes.WatNote;
import me.aerovulpe.watportal.resources.food.outlets.WatOutlet;
import me.aerovulpe.watportal.resources.food.products.WatProduct;
import me.aerovulpe.watportal.resources.food.watcard.WatCard;

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

    public void execute(WatObjectHandler watObjectHandler) {
        this.watObjectHandler = watObjectHandler;
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
            Meta meta = new Meta();
            meta.setRequests(metaObject.getInt(REQUESTS_KEY));
            meta.setTimestamp(metaObject.getInt(TIMESTAMP_KEY));
            meta.setStatus(metaObject.getInt(STATUS_KEY));
            meta.setMessage(metaObject.getString(MESSAGE_KEY));
            meta.setMethod_id(metaObject.getInt(METHOD_ID_KEY));

            switch (resource) {
                case FOOD_MENU:
                    watObject = WatMenu.parse(meta, rootObject.getJSONObject(DATA_KEY));
                    break;
                case FOOD_NOTES:
                    watObject = WatNote.parse(meta, rootObject.getJSONArray(DATA_KEY));
                    break;
                case FOOD_DIETS:
                    watObject = WatDiet.parse(meta, rootObject.getJSONArray(DATA_KEY));
                    break;
                case FOOD_OUTLETS:
                    watObject = WatOutlet.parse(meta, rootObject.getJSONArray(DATA_KEY));
                    break;
                case FOOD_LOCATIONS:
                    watObject = WatLocation.parse(meta, rootObject.getJSONArray(DATA_KEY));
                    break;
                case FOOD_WATCARD:
                    watObject = WatCard.parse(meta, rootObject.getJSONArray(DATA_KEY));
                    break;
                case FOOD_ANNOUNCEMENTS:
                    watObject = WatAnnouncement.parse(meta, rootObject.getJSONArray(DATA_KEY));
                    break;
                case FOOD_PRODUCTS:
                    watObject = WatProduct.parse(meta, rootObject.getJSONObject(DATA_KEY));
                    break;
            }

            watObjectHandler.onWatObjectReceived(watObject);
        }
    }
}
