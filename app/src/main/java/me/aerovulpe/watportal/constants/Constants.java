package me.aerovulpe.watportal.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Aaron on 28/11/2014.
 */
public final class Constants {

    public static final String BASE_URI = "https://api.uwaterloo.ca/v2/";
    public static final String API_KEY_PARAM = "key";
    public static final String API_KEY = "759f046d712dc42cc5a5b65745d635c3";

    public static final String FOOD_RESOURCE = "foodservices";
    public static final String COURSES_RESOURCE = "courses";
    public static final String EVENTS_RESOURCE = "events";
    public static final String NEWS_RESOURCE = "news";
    public static final String WEATHER_RESOURCE = "weather";
    public static final String TERMS_RESOURCE = "terms";
    public static final String RESOURCES_RESOURCE = "resources";
    public static final String CODES_RESOURCE = "codes";
    public static final String BUILDINGS_RESOURCE = "buildings";

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static final String META_KEY = "meta";
    public static final String DATA_KEY = "data";

    public static final String REQUESTS_KEY = "requests";
    public static final String TIMESTAMP_KEY = "timestamp";
    public static final String STATUS_KEY = "status";
    public static final String MESSAGE_KEY = "message";
    public static final String METHOD_ID_KEY = "method_id";

    public static final String DATE_KEY = "date";
    public static final String DAY_KEY = "day";
    public static final String WEEK_KEY = "week";
    public static final String YEAR_KEY = "year";
    public static final String START_KEY = "start";
    public static final String END_KEY = "end";

    public static final String OUTLETS_KEY = "outlets";
    public static final String OUTLET_NAME_KEY = "outlet_name";
    public static final String OUTLET_ID_KEY = "outlet_id";
    public static final String MENU_KEY = "menu";
    public static final String MEALS_KEY = "meals";
    public static final String LUNCH_KEY = "lunch";
    public static final String DINNER_KEY = "dinner";

    public static final String PRODUCT_NAME_KEY = "product_name";
    public static final String PRODUCT_ID_KEY = "product_id";
    public static final String DIET_TYPE = "diet_type";
    public static final String NOTES_KEY = "notes";

    public static final String NOTE_KEY = "note";


    private Constants() {
        // restrict instantiation
    }
}
