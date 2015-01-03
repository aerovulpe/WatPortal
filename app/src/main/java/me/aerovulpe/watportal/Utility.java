package me.aerovulpe.watportal;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

import me.aerovulpe.watportal.data.Resource;
import me.aerovulpe.watportal.data.tables.buildings.BuildingsEntry;
import me.aerovulpe.watportal.data.tables.food.AnnouncementsEntry;
import me.aerovulpe.watportal.data.tables.food.DietsEntry;
import me.aerovulpe.watportal.data.tables.food.LocationsEntry;
import me.aerovulpe.watportal.data.tables.food.MenuEntry;
import me.aerovulpe.watportal.data.tables.food.NotesEntry;
import me.aerovulpe.watportal.data.tables.food.OutletsEntry;
import me.aerovulpe.watportal.data.tables.food.ProductsEntry;
import me.aerovulpe.watportal.data.tables.food.WatCardEntry;

/**
 * Created by Aaron on 30/12/2014.
 */
public class Utility {

    private static final String BASE_URI = "https://api.uwaterloo.ca/v2/";
    private static final String API_KEY_PARAM = "key";
    private static final String API_KEY = "759f046d712dc42cc5a5b65745d635c3";

    private static final String DATA_KEY = "data";

    private static final String DATE_KEY = "date";
    private static final String DAY_KEY = "day";
    private static final String WEEK_KEY = "week";
    private static final String YEAR_KEY = "year";
    private static final String START_KEY = "start";
    private static final String END_KEY = "end";

    private static final String OUTLETS_KEY = "outlets";
    private static final String OUTLET_NAME_KEY = "outlet_name";
    private static final String OUTLET_ID_KEY = "outlet_id";
    private static final String MENU_KEY = "menu";
    private static final String MEALS_KEY = "meals";
    private static final String LUNCH_KEY = "lunch";
    private static final String DINNER_KEY = "dinner";

    private static final String PRODUCT_NAME_KEY = "product_name";
    private static final String PRODUCT_ID_KEY = "product_id";
    private static final String DIET_ID_KEY = "diet_id";
    private static final String DIET_TYPE_KEY = "diet_type";
    private static final String NOTES_KEY = "notes";

    private static final String NOTE_KEY = "note";

    private static final String HAS_BREAKFAST_KEY = "has_breakfast";
    private static final String HAS_LUNCH_KEY = "has_lunch";
    private static final String HAS_DINNER_KEY = "has_dinner";

    private static final String BUILDING_KEY = "building";
    private static final String LOGO_KEY = "logo";
    private static final String LATITUDE_KEY = "latitude";
    private static final String LONGITUDE_KEY = "longitude";
    private static final String DESCRIPTION_KEY = "description";
    private static final String NOTICE_KEY = "notice";
    private static final String IS_OPEN_NOW_KEY = "is_open_now";
    private static final String IS_CLOSED_KEY = "is_closed";
    private static final String OPENING_HOURS_KEY = "opening_hours";
    private static final String OPENING_HOUR_KEY = "opening_hour";
    private static final String CLOSING_HOUR_KEY = "closing_hour";
    private static final String SPECIAL_HOURS_KEY = "special_hours";
    private static final String DATES_CLOSED_KEY = "dates_closed";

    private static final String SUNDAY_KEY = "sunday";
    private static final String MONDAY_KEY = "monday";
    private static final String TUESDAY_KEY = "tuesday";
    private static final String WEDNESDAY_KEY = "wednesday";
    private static final String THURSDAY_KEY = "thursday";
    private static final String FRIDAY_KEY = "friday";
    private static final String SATURDAY_KEY = "saturday";

    private static final String VENDOR_ID_KEY = "vendor_id";
    private static final String VENDOR_NAME_KEY = "vendor_name";
    private static final String ADDRESS_KEY = "address";
    private static final String PHONE_NUMBER_KEY = "phone_number";

    private static final String AD_TEXT_KEY = "ad_text";

    private static final String INGREDIENTS_KEY = "ingredients";
    private static final String SERVING_SIZE_KEY = "serving_size";
    private static final String SERVING_SIZE_ML_KEY = "serving_size_ml";
    private static final String SERVING_SIZE_G_KEY = "serving_size_g";
    private static final String CALORIES_KEY = "calories";
    private static final String TOTAL_FAT_G_KEY = "total_fat_g";
    private static final String TOTAL_FAT_PERCENT_KEY = "total_fat_percent";
    private static final String FAT_SATURATED_G_KEY = "fat_saturated_g";
    private static final String FAT_SATURATED_PERCENT_KEY = "fat_saturated_percent";
    private static final String FAT_TRANS_G_KEY = "fat_trans_g";
    private static final String FAT_TRANS_PERCENT_KEY = "fat_trans_percent";
    private static final String CHOLESTEROL_MG_KEY = "cholesterol_mg";
    private static final String SODIUM_MG_KEY = "sodium_mg";
    private static final String SODIUM_PERCENT_KEY = "sodium_percent";
    private static final String CARBO_G_KEY = "carbo_g";
    private static final String CARBO_PERCENT_KEY = "carbo_percent";
    private static final String CARBO_FIBRE_G_KEY = "carbo_fibre_g";
    private static final String CARBO_FIBRE_PERCENT_KEY = "carbo_fibre_percent";
    private static final String CARBO_SUGARS_G_KEY = "carbo_sugars_g";
    private static final String PROTEIN_G_KEY = "protein_g";
    private static final String VITAMIN_A_PERCENT_KEY = "vitamin_a_percent";
    private static final String VITAMIN_C_PERCENT_KEY = "vitamin_c_percent";
    private static final String CALCIUM_PERCENT_KEY = "calcium_percent";
    private static final String IRON_PERCENT_KEY = "iron_percent";
    private static final String MICRO_NUTRIENTS_KEY = "micro_nutrients";
    private static final String TIPS_KEY = "tips";

    private static final String BUILDING_ID_KEY = "building_id";
    private static final String BUILDING_CODE_KEY = "building_code";
    private static final String BUILDING_NAME_KEY = "building_name";
    private static final String ALTERNATE_NAMES_KEY = "alternate_names";
    private static final String BUILDING_SECTIONS_KEY = "building_sections";


    public static void parseJSON(Context context, Resource resourceType, JSONObject rootObject) throws JSONException {

        switch (resourceType) {
            case FOOD_MENU: {
                JSONObject dataObject = rootObject.getJSONObject(DATA_KEY);
                JSONObject dateObject = dataObject.getJSONObject(DATE_KEY);
                JSONArray outletArray = dataObject.getJSONArray(OUTLETS_KEY);
                for (int i = 0; i < outletArray.length(); i++) {
                    JSONObject outletObject = outletArray.getJSONObject(i);
                    JSONArray menuArray = outletObject.getJSONArray(MENU_KEY);
                    for (int j = 0; j < menuArray.length(); j++) {
                        JSONObject menuObject = menuArray.getJSONObject(j);
                        JSONObject mealsObject = menuObject.getJSONObject(MEALS_KEY);
                        JSONArray lunchArray = mealsObject.getJSONArray(LUNCH_KEY);
                        JSONArray dinnerArray = mealsObject.getJSONArray(DINNER_KEY);

                        Vector<ContentValues> cVVector = new Vector<>(lunchArray.length() +
                                dinnerArray.length());
                        for (int k = 0; k < lunchArray.length(); k++) {
                            JSONObject lunchObject = lunchArray.getJSONObject(k);
                            ContentValues values = new ContentValues();

                            values.put(MenuEntry.COLUMN_WEEK, dateObject.getInt(WEEK_KEY));
                            values.put(MenuEntry.COLUMN_YEAR, dateObject.getInt(YEAR_KEY));
                            values.put(MenuEntry.COLUMN_START_DATE, dateObject.getString(START_KEY));
                            values.put(MenuEntry.COLUMN_END_DATE, dateObject.getString(END_KEY));
                            values.put(MenuEntry.COLUMN_DATE, menuObject.getString(DATE_KEY));
                            values.put(MenuEntry.COLUMN_DAY, menuObject.getString(DAY_KEY));
                            values.put(MenuEntry.COLUMN_NOTES, menuObject.getString(NOTES_KEY));
                            values.put(MenuEntry.COLUMN_OUTLET_NAME, outletObject.getString(OUTLET_NAME_KEY));
                            values.put(MenuEntry.COLUMN_OUTLET_ID, outletObject.getInt(OUTLET_ID_KEY));
                            values.put(MenuEntry.COLUMN_PRODUCT_NAME, lunchObject.getString(PRODUCT_NAME_KEY));
                            values.put(MenuEntry.COLUMN_PRODUCT_ID, lunchObject.optInt(PRODUCT_ID_KEY));
                            values.put(MenuEntry.COLUMN_DIET_TYPE, lunchObject.getString(DIET_TYPE_KEY));
                            values.put(MenuEntry.COLUMN_MEAL_TYPE, LUNCH_KEY);
                            cVVector.add(values);
                        }

                        for (int l = 0; l < dinnerArray.length(); l++) {
                            JSONObject dinnerObject = dinnerArray.getJSONObject(l);
                            ContentValues values = new ContentValues();

                            values.put(MenuEntry.COLUMN_WEEK, dateObject.getInt(WEEK_KEY));
                            values.put(MenuEntry.COLUMN_YEAR, dateObject.getInt(YEAR_KEY));
                            values.put(MenuEntry.COLUMN_START_DATE, dateObject.getString(START_KEY));
                            values.put(MenuEntry.COLUMN_END_DATE, dateObject.getString(END_KEY));
                            values.put(MenuEntry.COLUMN_DATE, menuObject.getString(DATE_KEY));
                            values.put(MenuEntry.COLUMN_DAY, menuObject.getString(DAY_KEY));
                            values.put(MenuEntry.COLUMN_NOTES, menuObject.getString(NOTES_KEY));
                            values.put(MenuEntry.COLUMN_OUTLET_NAME, outletObject.getString(OUTLET_NAME_KEY));
                            values.put(MenuEntry.COLUMN_OUTLET_ID, outletObject.getInt(OUTLET_ID_KEY));
                            values.put(MenuEntry.COLUMN_PRODUCT_NAME, dinnerObject.getString(PRODUCT_NAME_KEY));
                            values.put(MenuEntry.COLUMN_PRODUCT_ID, dinnerObject.optInt(PRODUCT_ID_KEY));
                            values.put(MenuEntry.COLUMN_DIET_TYPE, dinnerObject.getString(DIET_TYPE_KEY));
                            values.put(MenuEntry.COLUMN_MEAL_TYPE, DINNER_KEY);
                            cVVector.add(values);
                        }
                        if (cVVector.size() > 0) {
                            context.getContentResolver().bulkInsert(MenuEntry.CONTENT_URI,
                                    cVVector.toArray(new ContentValues[cVVector.size()]));
                        }
                    }
                }
            }
            break;
            case FOOD_NOTES: {
                JSONArray dataArray = rootObject.getJSONArray(DATA_KEY);
                Vector<ContentValues> cVVector = new Vector<>(dataArray.length());
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    ContentValues values = new ContentValues();

                    values.put(NotesEntry.COLUMN_DATE, dataObject.getString(DATE_KEY));
                    values.put(NotesEntry.COLUMN_OUTLET_NAME, dataObject.getString(OUTLET_NAME_KEY));
                    values.put(NotesEntry.COLUMN_OUTLET_ID, dataObject.getInt(OUTLET_ID_KEY));
                    values.put(NotesEntry.COLUMN_NOTE, dataObject.getString(NOTE_KEY));
                    cVVector.add(values);
                }
                if (cVVector.size() > 0) {
                    context.getContentResolver().bulkInsert(NotesEntry.CONTENT_URI,
                            cVVector.toArray(new ContentValues[cVVector.size()]));
                }
            }
            break;
            case FOOD_DIETS: {
                JSONArray dataArray = rootObject.getJSONArray(DATA_KEY);
                Vector<ContentValues> cVVector = new Vector<>(dataArray.length());
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    ContentValues values = new ContentValues();

                    values.put(DietsEntry.COLUMN_DIET_ID, dataObject.getInt(DIET_ID_KEY));
                    values.put(DietsEntry.COLUMN_DIET_ID, dataObject.getString(DIET_TYPE_KEY));
                    cVVector.add(values);
                }
                if (cVVector.size() > 0) {
                    context.getContentResolver().bulkInsert(DietsEntry.CONTENT_URI,
                            cVVector.toArray(new ContentValues[cVVector.size()]));
                }
            }
            break;
            case FOOD_OUTLETS: {
                JSONArray dataArray = rootObject.getJSONArray(DATA_KEY);
                Vector<ContentValues> cVVector = new Vector<>(dataArray.length());
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    ContentValues values = new ContentValues();

                    values.put(OutletsEntry.COLUMN_OUTLET_ID, dataObject.getInt(OUTLET_ID_KEY));
                    values.put(OutletsEntry.COLUMN_OUTLET_NAME, dataObject.getString(OUTLET_NAME_KEY));
                    values.put(OutletsEntry.COLUMN_HAS_BREAKFAST, dataObject.getInt(HAS_BREAKFAST_KEY));
                    values.put(OutletsEntry.COLUMN_HAS_LUNCH, dataObject.getInt(HAS_LUNCH_KEY));
                    values.put(OutletsEntry.COLUMN_HAS_DINNER, dataObject.getInt(HAS_DINNER_KEY));
                    cVVector.add(values);
                }
                if (cVVector.size() > 0) {
                    context.getContentResolver().bulkInsert(OutletsEntry.CONTENT_URI,
                            cVVector.toArray(new ContentValues[cVVector.size()]));
                }
            }
            break;
            case FOOD_LOCATIONS: {
                JSONArray dataArray = rootObject.getJSONArray(DATA_KEY);
                ContentValues values = new ContentValues();
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    JSONArray datesClosedArray = dataObject.getJSONArray(DATES_CLOSED_KEY);

                    values.put(LocationsEntry.COLUMN_OUTLET_ID, dataObject.getInt(OUTLET_ID_KEY));
                    values.put(LocationsEntry.COLUMN_OUTLET_NAME, dataObject.getString(OUTLET_NAME_KEY));
                    values.put(LocationsEntry.COLUMN_BUILDING, dataObject.getString(BUILDING_KEY));
                    values.put(LocationsEntry.COLUMN_LOGO, dataObject.getString(LOGO_KEY));
                    values.put(LocationsEntry.COLUMN_LATITUDE, dataObject.getDouble(LATITUDE_KEY));
                    values.put(LocationsEntry.COLUMN_LONGITUDE, dataObject.getDouble(LONGITUDE_KEY));
                    values.put(LocationsEntry.COLUMN_DESCRIPTION, dataObject.getString(DESCRIPTION_KEY));
                    values.put(LocationsEntry.COLUMN_NOTICE, dataObject.getString(NOTICE_KEY));
                    values.put(LocationsEntry.COLUMN_IS_OPEN_NOW, dataObject.getBoolean(IS_OPEN_NOW_KEY) ? 1 : 0);
                    values.put(LocationsEntry.COLUMN_DATES_CLOSED, datesClosedArray.toString().getBytes());
                    long locationId = ContentUris.parseId(context.getContentResolver()
                            .insert(LocationsEntry.CONTENT_URI, values));
                    values.clear();

                    JSONArray specialHoursArray = dataObject.getJSONArray(SPECIAL_HOURS_KEY);
                    for (int j = 0; j < specialHoursArray.length(); j++) {
                        JSONObject specialHoursObject = specialHoursArray.getJSONObject(j);

                        values.put(LocationsEntry.SpecialHoursEntry.COLUMN_DATE, specialHoursObject.getString(DATE_KEY));
                        values.put(LocationsEntry.SpecialHoursEntry.COLUMN_OPENING_HOUR, specialHoursObject.getString(OPENING_HOUR_KEY));
                        values.put(LocationsEntry.SpecialHoursEntry.COLUMN_CLOSING_HOUR, specialHoursObject.getString(CLOSING_HOUR_KEY));
                        values.put(LocationsEntry.SpecialHoursEntry.COLUMN_LOC_KEY, locationId);
                        context.getContentResolver().insert(LocationsEntry.SpecialHoursEntry.CONTENT_URI, values);
                        values.clear();
                    }

                    JSONObject openingHoursObject = dataObject.getJSONObject(OPENING_HOURS_KEY);

                    JSONObject sundayObject = openingHoursObject.getJSONObject(SUNDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK, SUNDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR, sundayObject.getString(OPENING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR, sundayObject.getString(CLOSING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED, sundayObject.getBoolean(IS_CLOSED_KEY) ? 1 : 0);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, locationId);
                    context.getContentResolver().insert(LocationsEntry.OpeningHoursEntry.CONTENT_URI, values);
                    values.clear();

                    JSONObject mondayObject = openingHoursObject.getJSONObject(MONDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK, MONDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR, mondayObject.getString(OPENING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR, mondayObject.getString(CLOSING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED, mondayObject.getBoolean(IS_CLOSED_KEY) ? 1 : 0);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, locationId);
                    context.getContentResolver().insert(LocationsEntry.OpeningHoursEntry.CONTENT_URI, values);
                    values.clear();

                    JSONObject tuesdayObject = openingHoursObject.getJSONObject(TUESDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK, TUESDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR, tuesdayObject.getString(OPENING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR, tuesdayObject.getString(CLOSING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED, tuesdayObject.getBoolean(IS_CLOSED_KEY) ? 1 : 0);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, locationId);
                    context.getContentResolver().insert(LocationsEntry.OpeningHoursEntry.CONTENT_URI, values);
                    values.clear();

                    JSONObject wednesdayObject = openingHoursObject.getJSONObject(WEDNESDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK, WEDNESDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR, wednesdayObject.getString(OPENING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR, wednesdayObject.getString(CLOSING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED, wednesdayObject.getBoolean(IS_CLOSED_KEY) ? 1 : 0);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, locationId);
                    context.getContentResolver().insert(LocationsEntry.OpeningHoursEntry.CONTENT_URI, values);
                    values.clear();

                    JSONObject thursdayObject = openingHoursObject.getJSONObject(THURSDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK, THURSDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR, thursdayObject.getString(OPENING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR, thursdayObject.getString(CLOSING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED, thursdayObject.getBoolean(IS_CLOSED_KEY) ? 1 : 0);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, locationId);
                    context.getContentResolver().insert(LocationsEntry.OpeningHoursEntry.CONTENT_URI, values);
                    values.clear();

                    JSONObject fridayObject = openingHoursObject.getJSONObject(FRIDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK, FRIDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR, fridayObject.getString(OPENING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR, fridayObject.getString(CLOSING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED, fridayObject.getBoolean(IS_CLOSED_KEY) ? 1 : 0);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, locationId);
                    context.getContentResolver().insert(LocationsEntry.OpeningHoursEntry.CONTENT_URI, values);
                    values.clear();

                    JSONObject saturdayObject = openingHoursObject.getJSONObject(SATURDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK, SATURDAY_KEY);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR, saturdayObject.getString(OPENING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR, saturdayObject.getString(CLOSING_HOUR_KEY));
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED, saturdayObject.getBoolean(IS_CLOSED_KEY) ? 1 : 0);
                    values.put(LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, locationId);
                    context.getContentResolver().insert(LocationsEntry.OpeningHoursEntry.CONTENT_URI, values);
                    values.clear();
                }
            }
            break;
            case FOOD_WATCARD: {
                JSONArray dataArray = rootObject.getJSONArray(DATA_KEY);
                Vector<ContentValues> cVVector = new Vector<>(dataArray.length());
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    ContentValues values = new ContentValues();

                    values.put(WatCardEntry.COLUMN_VENDOR_ID, dataObject.getInt(VENDOR_ID_KEY));
                    values.put(WatCardEntry.COLUMN_VENDOR_NAME, dataObject.getString(VENDOR_NAME_KEY));
                    cVVector.add(values);
                }
                if (cVVector.size() > 0) {
                    context.getContentResolver().bulkInsert(WatCardEntry.CONTENT_URI,
                            cVVector.toArray(new ContentValues[cVVector.size()]));
                }
            }
            break;
            case FOOD_ANNOUNCEMENTS: {
                JSONArray dataArray = rootObject.getJSONArray(DATA_KEY);
                Vector<ContentValues> cVVector = new Vector<>(dataArray.length());
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    ContentValues values = new ContentValues();

                    values.put(AnnouncementsEntry.COLUMN_DATE, dataObject.getString(DATE_KEY));
                    values.put(AnnouncementsEntry.COLUMN_DATE, dataObject.getString(AD_TEXT_KEY));
                    cVVector.add(values);
                }
                if (cVVector.size() > 0) {
                    context.getContentResolver().bulkInsert(AnnouncementsEntry.CONTENT_URI,
                            cVVector.toArray(new ContentValues[cVVector.size()]));
                }
            }
            break;
            case FOOD_PRODUCTS: {
                JSONObject dataObject = rootObject.getJSONObject(DATA_KEY);
                ContentValues values = new ContentValues();

                values.put(ProductsEntry.COLUMN_PRODUCT_ID, dataObject.getInt(PRODUCT_ID_KEY));
                values.put(ProductsEntry.COLUMN_PRODUCT_NAME, dataObject.getString(PRODUCT_NAME_KEY));
                values.put(ProductsEntry.COLUMN_INGREDIENTS, dataObject.getString(INGREDIENTS_KEY));
                values.put(ProductsEntry.COLUMN_SERVING_SIZE, dataObject.getString(SERVING_SIZE_KEY));
                values.put(ProductsEntry.COLUMN_MICRO_NUTRIENTS, dataObject.getString(MICRO_NUTRIENTS_KEY));
                values.put(ProductsEntry.COLUMN_TIPS, dataObject.getString(TIPS_KEY));
                values.put(ProductsEntry.COLUMN_DIET_ID, dataObject.getInt(DIET_ID_KEY));
                values.put(ProductsEntry.COLUMN_DIET_TYPE, dataObject.getString(DIET_TYPE_KEY));
                values.put(ProductsEntry.COLUMN_CALORIES, dataObject.optInt(CALORIES_KEY));
                values.put(ProductsEntry.COLUMN_TOTAL_FAT_G, dataObject.optInt(TOTAL_FAT_G_KEY));
                values.put(ProductsEntry.COLUMN_TOTAL_FAT_PERCENT, dataObject.optInt(TOTAL_FAT_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_FAT_SATURATED_G, dataObject.optInt(FAT_SATURATED_G_KEY));
                values.put(ProductsEntry.COLUMN_FAT_SATURATED_PERCENT, dataObject.optInt(FAT_SATURATED_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_FAT_TRANS_G, dataObject.optInt(FAT_TRANS_G_KEY));
                values.put(ProductsEntry.COLUMN_FAT_TRANS_PERCENT, dataObject.optInt(FAT_TRANS_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_CHOLESTEROL_MG, dataObject.optInt(CHOLESTEROL_MG_KEY));
                values.put(ProductsEntry.COLUMN_SODIUM_MG, dataObject.optInt(SODIUM_MG_KEY));
                values.put(ProductsEntry.COLUMN_SODIUM_PERCENT, dataObject.optInt(SODIUM_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_CARBO_G, dataObject.optInt(CARBO_G_KEY));
                values.put(ProductsEntry.COLUMN_CARBO_PERCENT, dataObject.optInt(CARBO_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_FIBRE_G, dataObject.optInt(CARBO_FIBRE_G_KEY));
                values.put(ProductsEntry.COLUMN_FIBRE_PERCENT, dataObject.optInt(CARBO_FIBRE_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_CARBO_SUGARS_G, dataObject.optInt(CARBO_SUGARS_G_KEY));
                values.put(ProductsEntry.COLUMN_PROTEIN_G, dataObject.optInt(PROTEIN_G_KEY));
                values.put(ProductsEntry.COLUMN_VITAMIN_A_PERCENT, dataObject.optInt(VITAMIN_A_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_VITAMIN_C_PERCENT, dataObject.optInt(VITAMIN_C_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_CALCIUM_PERCENT, dataObject.optInt(CALCIUM_PERCENT_KEY));
                values.put(ProductsEntry.COLUMN_IRON_PERCENT, dataObject.optInt(IRON_PERCENT_KEY));
                context.getContentResolver().insert(ProductsEntry.CONTENT_URI, values);
                values.clear();
            }
            break;
            case BUILDINGS_LIST: {
                JSONArray dataArray = rootObject.getJSONArray(DATA_KEY);
                Vector<ContentValues> cVVector = new Vector<>(dataArray.length());
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataObject = dataArray.getJSONObject(i);
                    ContentValues values = new ContentValues();

                    values.put(BuildingsEntry.COLUMN_BUILDING_ID, dataObject.getString(BUILDING_ID_KEY));
                    values.put(BuildingsEntry.COLUMN_BUILDING_CODE, dataObject.getString(BUILDING_CODE_KEY));
                    values.put(BuildingsEntry.COLUMN_BUILDING_NAME, dataObject.getString(BUILDING_NAME_KEY));
                    values.put(BuildingsEntry.COLUMN_ALTERNATE_NAMES, dataObject.optJSONArray(ALTERNATE_NAMES_KEY)
                            .toString()
                            .getBytes());
                    values.put(BuildingsEntry.COLUMN_LATITUDE, dataObject.optDouble(LATITUDE_KEY));
                    values.put(BuildingsEntry.COLUMN_LONGITUDE, dataObject.optDouble(LONGITUDE_KEY));
                    values.put(BuildingsEntry.COLUMN_BUILDING_SECTIONS, dataObject.optJSONArray(BUILDING_SECTIONS_KEY)
                            .toString()
                            .getBytes());
                    cVVector.add(values);
                }
                if (cVVector.size() > 0) {
                    context.getContentResolver().bulkInsert(BuildingsEntry.CONTENT_URI,
                            cVVector.toArray(new ContentValues[cVVector.size()]));
                }
            }
            break;
        }
    }

    public static String getBuildingNameFromCode(Context context, String code) {
        Cursor cursor = context.getContentResolver().query(BuildingsEntry.CONTENT_URI,
                new String[]{BuildingsEntry.COLUMN_BUILDING_NAME},
               BuildingsEntry.COLUMN_BUILDING_CODE + " = " + "'" + code + "'", null, null);
        if (cursor.moveToFirst()) return cursor.getString(0);
        else return null;
    }

    public Uri buildResourceUri(Resource resource, String... params) {
        Uri.Builder uriBuilder = Uri.parse(BASE_URI).buildUpon();
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);


        uriBuilder.appendEncodedPath(resource.addParams(params).buildEndpoint());


        return uriBuilder.build();
    }
}
