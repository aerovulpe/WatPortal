package me.aerovulpe.watportal;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.aerovulpe.watportal.food.menu.Date;
import me.aerovulpe.watportal.food.menu.Dinner;
import me.aerovulpe.watportal.food.menu.Lunch;
import me.aerovulpe.watportal.food.menu.Meals;
import me.aerovulpe.watportal.food.menu.Menu;
import me.aerovulpe.watportal.food.menu.Outlet;
import me.aerovulpe.watportal.food.menu.WatMenu;

import static me.aerovulpe.watportal.Constants.API_KEY;
import static me.aerovulpe.watportal.Constants.API_KEY_PARAM;
import static me.aerovulpe.watportal.Constants.BASE_URI;
import static me.aerovulpe.watportal.Constants.BUILDINGS_RESOURCE;
import static me.aerovulpe.watportal.Constants.CODES_RESOURCE;
import static me.aerovulpe.watportal.Constants.COURSES_RESOURCE;
import static me.aerovulpe.watportal.Constants.DATA_KEY;
import static me.aerovulpe.watportal.Constants.DATE_KEY;
import static me.aerovulpe.watportal.Constants.DAY_KEY;
import static me.aerovulpe.watportal.Constants.DIET_TYPE;
import static me.aerovulpe.watportal.Constants.DINNER_KEY;
import static me.aerovulpe.watportal.Constants.END_KEY;
import static me.aerovulpe.watportal.Constants.EVENTS_RESOURCE;
import static me.aerovulpe.watportal.Constants.FOOD_RESOURCE;
import static me.aerovulpe.watportal.Constants.LUNCH_KEY;
import static me.aerovulpe.watportal.Constants.MEALS_KEY;
import static me.aerovulpe.watportal.Constants.MENU_KEY;
import static me.aerovulpe.watportal.Constants.MESSAGE_KEY;
import static me.aerovulpe.watportal.Constants.META_KEY;
import static me.aerovulpe.watportal.Constants.METHOD_ID_KEY;
import static me.aerovulpe.watportal.Constants.NEWS_RESOURCE;
import static me.aerovulpe.watportal.Constants.NOTES_KEY;
import static me.aerovulpe.watportal.Constants.OUTLETS_KEY;
import static me.aerovulpe.watportal.Constants.OUTLET_ID_KEY;
import static me.aerovulpe.watportal.Constants.OUTLET_NAME_KEY;
import static me.aerovulpe.watportal.Constants.PRODUCT_ID_KEY;
import static me.aerovulpe.watportal.Constants.PRODUCT_NAME_KEY;
import static me.aerovulpe.watportal.Constants.REQUESTS_KEY;
import static me.aerovulpe.watportal.Constants.RESOURCES_RESOURCE;
import static me.aerovulpe.watportal.Constants.START_KEY;
import static me.aerovulpe.watportal.Constants.STATUS_KEY;
import static me.aerovulpe.watportal.Constants.TERMS_RESOURCE;
import static me.aerovulpe.watportal.Constants.TIMESTAMP_KEY;
import static me.aerovulpe.watportal.Constants.WEATHER_RESOURCE;
import static me.aerovulpe.watportal.Constants.WEEK_KEY;
import static me.aerovulpe.watportal.Constants.YEAR_KEY;


/**
 * Created by Aaron on 17/11/2014.
 */


enum Resource {

    FOOD_MENU(FOOD_RESOURCE, "menu"),
    FOOD_NOTES(FOOD_RESOURCE, "notes"),
    FOOD_DIETS(FOOD_RESOURCE, "diets"),
    FOOD_OUTLETS(FOOD_RESOURCE, "outlets"),
    FOOD_LOCATIONS(FOOD_RESOURCE, "locations"),
    FOOD_WATCARD(FOOD_RESOURCE, "watcard"),
    FOOD_ANNOUNCEMENTS(FOOD_RESOURCE, "announcements"),
    FOOD_PRODUCTS(FOOD_RESOURCE + "/products"),

    COURSES(COURSES_RESOURCE),
    COURSES_SCHEDULE(COURSES_RESOURCE, "schedule"),
    COURSES_PREREQUISITES(COURSES_RESOURCE, "prerequisites"),
    COURSES_EXAMSCHEDULE(COURSES_RESOURCE, "examschedule"),

    EVENTS(EVENTS_RESOURCE),
    EVENTS_HOLIDAYS(EVENTS_RESOURCE, "holidays"),

    NEWS(NEWS_RESOURCE),

    WEATHER_CURRENT(WEATHER_RESOURCE, "current"),

    TERMS_LIST(TERMS_RESOURCE, "list"),
    TERMS_SCHEDULE(TERMS_RESOURCE, "schedule"),
    TERMS_EXAMSCHEDULE(TERMS_RESOURCE, "examschedule"),
    TERMS_INFOSESSIONS(TERMS_RESOURCE, "infosessions"),

    RESOURCES_TUTORS(RESOURCES_RESOURCE, "tutors"),
    RESOURCES_PRINTERS(RESOURCES_RESOURCE, "printers"),
    RESOURCES_INFOSESSIONS(RESOURCES_RESOURCE, "infosessions"),
    RESOURCES_GOOSEWATCH(RESOURCES_RESOURCE, "goosewatch"),

    CODES_UNITS(CODES_RESOURCE, "units"),
    CODES_TERMS(CODES_RESOURCE, "terms"),
    CODES_GROUPS(CODES_RESOURCE, "groups"),
    CODES_SUBJECTS(CODES_RESOURCE, "subjects"),
    CODES_INSTRUCTIONS(CODES_RESOURCE, "instructions"),

    BUILDINGS(BUILDINGS_RESOURCE),
    BUILDINGS_LIST(BUILDINGS_RESOURCE, "list"),
    BUILDINGS_COURSES(BUILDINGS_RESOURCE, "courses");


    private StringBuilder endpointBuilder;
    private String methodName;

    private boolean isBuilt = false;
    private int baseCount;

    Resource(String serviceName) {
        endpointBuilder = new StringBuilder();
        endpointBuilder.append(serviceName);
        baseCount = endpointBuilder.length();
    }

    Resource(String serviceName, String methodName) {
        this(serviceName);
        this.methodName = '/' + methodName;
    }

    public Resource addParams(String... params) {
        if (isBuilt)
            endpointBuilder.delete(baseCount, endpointBuilder.length());

        for (int i = 0; i < params.length; i++)
            endpointBuilder.append('/').append(params[i]);
        isBuilt = false;

        return this;
    }

    public String buildEndpoint() {
        if (isBuilt)
            endpointBuilder.delete(baseCount, endpointBuilder.length());

        if (methodName != null)
            endpointBuilder.append(methodName);
        endpointBuilder.append(".json");
        isBuilt = true;

        return endpointBuilder.toString();
    }

}

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
                    WatMenu watMenu = new WatMenu();

                    WatMenu.Data data = new WatMenu.Data();

                    JSONObject dateObject = dataObject.getJSONObject(DATE_KEY);
                    Date date = new Date();
                    date.setWeek(dateObject.getInt(WEEK_KEY));
                    date.setYear(dateObject.getInt(YEAR_KEY));
                    date.setStart(dateObject.getString(START_KEY));
                    date.setEnd(dateObject.getString(END_KEY));

                    JSONArray outletArray = dataObject.getJSONArray(OUTLETS_KEY);
                    List<Outlet> outlets = new ArrayList<Outlet>();
                    for (int i = 0; i < outletArray.length(); i++) {
                        JSONObject outletObject = outletArray.getJSONObject(i);
                        Outlet outlet = new Outlet();

                        JSONArray menuArray = outletObject.getJSONArray(MENU_KEY);
                        List<Menu> menus = new ArrayList<Menu>();
                        for (int j = 0; j < menuArray.length(); j++) {
                            JSONObject menuObject = menuArray.getJSONObject(j);
                            Menu menu = new Menu();

                            JSONObject mealsObject = menuObject.getJSONObject(MEALS_KEY);
                            Meals meals = new Meals();

                            JSONArray lunchArray = mealsObject.getJSONArray(LUNCH_KEY);
                            JSONArray dinnerArray = mealsObject.getJSONArray(DINNER_KEY);
                            List<Lunch> lunches = new ArrayList<Lunch>();
                            List<Dinner> dinners = new ArrayList<Dinner>();

                            for (int k = 0; k < lunchArray.length(); k++) {
                                JSONObject lunchObject = lunchArray.getJSONObject(k);
                                Lunch lunch = new Lunch();
                                lunch.setProduct_name(lunchObject.getString(PRODUCT_NAME_KEY));
                               try{
                                   lunch.setProduct_id(lunchObject.getInt(PRODUCT_ID_KEY));
                               }catch (JSONException e){
                                   Log.e(LOG_TAG, "PRODUCT ID IS NULL");
                               }
                                lunch.setDiet_type(lunchObject.getString(DIET_TYPE));
                                lunches.add(lunch);
                            }

                            for (int l = 0; l < dinnerArray.length(); l++) {
                                JSONObject dinnerObject = dinnerArray.getJSONObject(l);
                                Dinner dinner = new Dinner();
                                dinner.setProduct_name(dinnerObject.getString(PRODUCT_NAME_KEY));
                                try{
                                    dinner.setProduct_id(dinnerObject.getInt(PRODUCT_ID_KEY));
                                }catch (JSONException e){
                                    Log.e(LOG_TAG, "PRODUCT ID IS NULL");
                                }
                                dinner.setDiet_type(dinnerObject.getString(DIET_TYPE));
                                dinners.add(dinner);
                            }

                            meals.setLunches(lunches);
                            meals.setDinners(dinners);

                            menu.setDate(menuObject.getString(DATE_KEY));
                            menu.setDay(menuObject.getString(DAY_KEY));
                            menu.setMeals(meals);
                            menu.setNotes(menuObject.getString(NOTES_KEY));
                            menus.add(menu);
                        }

                        outlet.setOutlet_name(outletObject.getString(OUTLET_NAME_KEY));
                        outlet.setOutlet_id(outletObject.getInt(OUTLET_ID_KEY));
                        outlet.setMenus(menus);
                        outlets.add(outlet);
                    }

                    data.setDate(date);
                    data.setOutlets(outlets);

                    watMenu.setMeta(meta);
                    watMenu.setData(data);
                    watObjectHandler.setWatObject(watMenu);
                    break;
            }
        }
    }
}
