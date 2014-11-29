package me.aerovulpe.watportal.resources.food.menu;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.aerovulpe.watportal.resources.Meta;
import me.aerovulpe.watportal.constants.WatObject;

import static me.aerovulpe.watportal.constants.Constants.DATE_KEY;
import static me.aerovulpe.watportal.constants.Constants.DAY_KEY;
import static me.aerovulpe.watportal.constants.Constants.DIET_TYPE_KEY;
import static me.aerovulpe.watportal.constants.Constants.DINNER_KEY;
import static me.aerovulpe.watportal.constants.Constants.END_KEY;
import static me.aerovulpe.watportal.constants.Constants.LUNCH_KEY;
import static me.aerovulpe.watportal.constants.Constants.MEALS_KEY;
import static me.aerovulpe.watportal.constants.Constants.MENU_KEY;
import static me.aerovulpe.watportal.constants.Constants.NOTES_KEY;
import static me.aerovulpe.watportal.constants.Constants.OUTLETS_KEY;
import static me.aerovulpe.watportal.constants.Constants.OUTLET_ID_KEY;
import static me.aerovulpe.watportal.constants.Constants.OUTLET_NAME_KEY;
import static me.aerovulpe.watportal.constants.Constants.PRODUCT_ID_KEY;
import static me.aerovulpe.watportal.constants.Constants.PRODUCT_NAME_KEY;
import static me.aerovulpe.watportal.constants.Constants.START_KEY;
import static me.aerovulpe.watportal.constants.Constants.WEEK_KEY;
import static me.aerovulpe.watportal.constants.Constants.YEAR_KEY;

public class WatMenu implements WatObject {
    private static final String LOG_TAG = WatMenu.class.getName();

    private Data data;
    private Meta meta;

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Data {
        private Date date;
        private List<Outlet> outlets;

        public Date getDate() {
            return this.date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public List<Outlet> getOutlets() {
            return this.outlets;
        }

        public void setOutlets(List<Outlet> outlets) {
            this.outlets = outlets;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "date=" + date +
                    ", outlets=" + outlets +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatMenu{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatMenu parse(Meta meta, JSONObject dataObject) throws JSONException {
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
                    try {
                        lunch.setProduct_id(lunchObject.getInt(PRODUCT_ID_KEY));
                    } catch (JSONException e) {
                        Log.e(LOG_TAG, "PRODUCT ID IS NULL");
                    }
                    lunch.setDiet_type(lunchObject.getString(DIET_TYPE_KEY));
                    lunches.add(lunch);
                }

                for (int l = 0; l < dinnerArray.length(); l++) {
                    JSONObject dinnerObject = dinnerArray.getJSONObject(l);
                    Dinner dinner = new Dinner();
                    dinner.setProduct_name(dinnerObject.getString(PRODUCT_NAME_KEY));
                    try {
                        dinner.setProduct_id(dinnerObject.getInt(PRODUCT_ID_KEY));
                    } catch (JSONException e) {
                        Log.e(LOG_TAG, "PRODUCT ID IS NULL");
                    }
                    dinner.setDiet_type(dinnerObject.getString(DIET_TYPE_KEY));
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
        return watMenu;
    }
}
