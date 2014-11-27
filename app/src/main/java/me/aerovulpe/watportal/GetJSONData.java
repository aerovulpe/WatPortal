package me.aerovulpe.watportal;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Aaron on 17/11/2014.
 */

interface ResourceConstants {
    final String FOOD_RESOURCE = "foodservices";
    final String COURSES_RESOURCE = "courses";
    final String EVENTS_RESOURCE = "events";
    final String NEWS_RESOURCE = "news";
    final String WEATHER_RESOURCE = "weather";
    final String TERMS_RESOURCE = "terms";
    final String RESOURCES_RESOURCE = "resources";
    final String CODES_RESOURCE = "codes";
    final String BUILDINGS_RESOURCE = "buildings";
}

enum Resource implements ResourceConstants {

    FOOD_MENU(ResourceConstants.FOOD_RESOURCE, "menu"),
    FOOD_NOTES(ResourceConstants.FOOD_RESOURCE, "notes"),
    FOOD_DIETS(ResourceConstants.FOOD_RESOURCE, "diets"),
    FOOD_OUTLETS(ResourceConstants.FOOD_RESOURCE, "outlets"),
    FOOD_LOCATIONS(ResourceConstants.FOOD_RESOURCE, "locations"),
    FOOD_WATCARD(ResourceConstants.FOOD_RESOURCE, "watcard"),
    FOOD_ANNOUNCEMENTS(ResourceConstants.FOOD_RESOURCE, "announcements"),
    FOOD_PRODUCTS(ResourceConstants.FOOD_RESOURCE + "/products"),

    COURSES(ResourceConstants.COURSES_RESOURCE),
    COURSES_SCHEDULE(ResourceConstants.COURSES_RESOURCE, "schedule"),
    COURSES_PREREQUISITES(ResourceConstants.COURSES_RESOURCE, "prerequisites"),
    COURSES_EXAMSCHEDULE(ResourceConstants.COURSES_RESOURCE, "examschedule"),

    EVENTS(ResourceConstants.EVENTS_RESOURCE),
    EVENTS_HOLIDAYS(ResourceConstants.EVENTS_RESOURCE, "holidays"),

    NEWS(ResourceConstants.NEWS_RESOURCE),

    WEATHER_CURRENT(ResourceConstants.WEATHER_RESOURCE, "current"),

    TERMS_LIST(ResourceConstants.TERMS_RESOURCE, "list"),
    TERMS_SCHEDULE(ResourceConstants.TERMS_RESOURCE, "schedule"),
    TERMS_EXAMSCHEDULE(ResourceConstants.TERMS_RESOURCE, "examschedule"),
    TERMS_INFOSESSIONS(ResourceConstants.TERMS_RESOURCE, "infosessions"),

    RESOURCES_TUTORS(ResourceConstants.RESOURCES_RESOURCE, "tutors"),
    RESOURCES_PRINTERS(ResourceConstants.RESOURCES_RESOURCE, "printers"),
    RESOURCES_INFOSESSIONS(ResourceConstants.RESOURCES_RESOURCE, "infosessions"),
    RESOURCES_GOOSEWATCH(ResourceConstants.RESOURCES_RESOURCE, "goosewatch"),

    CODES_UNITS(ResourceConstants.CODES_RESOURCE, "units"),
    CODES_TERMS(ResourceConstants.CODES_RESOURCE, "terms"),
    CODES_GROUPS(ResourceConstants.CODES_RESOURCE, "groups"),
    CODES_SUBJECTS(ResourceConstants.CODES_RESOURCE, "subjects"),
    CODES_INSTRUCTIONS(ResourceConstants.CODES_RESOURCE, "instructions"),

    BUILDINGS(ResourceConstants.BUILDINGS_RESOURCE),
    BUILDINGS_LIST(ResourceConstants.BUILDINGS_RESOURCE, "list"),
    BUILDINGS_COURSES(ResourceConstants.BUILDINGS_RESOURCE, "courses");



    private StringBuilder endpointBuilder;
    private String endpoint;
    private String methodName;

    private boolean isBuilt = false;

    Resource(String serviceName) {
        endpointBuilder = new StringBuilder();
        endpointBuilder.append(serviceName);
    }

    Resource(String serviceName, String methodName) {
        this(serviceName);
        this.methodName = '/' + methodName;
    }

    public Resource addParams(String... params) {
        for (int i = 0; i < params.length; i++)
            endpointBuilder.append('/').append(params[i]);
        return this;
    }

    public String buildEndpoint() {
        if (!isBuilt) {
            if (methodName != null)
                endpointBuilder.append(methodName);
            endpointBuilder.append(".json");
            endpoint = endpointBuilder.toString();
            isBuilt = true;
        }

        return endpoint;
    }

}

public class GetJSONData extends GetRawData {
    private static final String LOG_TAG = GetJSONData.class.getSimpleName();
    private static final String API_KEY = "759f046d712dc42cc5a5b65745d635c3";

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
        final String BASE_URI = "https://api.uwaterloo.ca/v2/";
        final String API_KEY_PARAM = "key";

        Uri.Builder uriBuilder = Uri.parse(BASE_URI).buildUpon();
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);

        uriBuilder.appendEncodedPath(Resource.EVENTS.buildEndpoint());

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

            final String DATA_KEY = "data";

            JSONObject rootObject = new JSONObject(getData());
            JSONArray itemsArray = rootObject.getJSONArray(DATA_KEY);

            switch (resource) {

            }


        }
    }
}
