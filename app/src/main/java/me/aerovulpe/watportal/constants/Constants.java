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
    public static final String DIET_ID_KEY = "diet_id";
    public static final String DIET_TYPE_KEY = "diet_type";
    public static final String NOTES_KEY = "notes";

    public static final String NOTE_KEY = "note";

    public static final String HAS_BREAKFAST_KEY = "has_breakfast";
    public static final String HAS_LUNCH_KEY = "has_lunch";
    public static final String HAS_DINNER_KEY = "has_dinner";

    public static final String BUILDING_KEY = "building";
    public static final String LOGO_KEY = "logo";
    public static final String LATITUDE_KEY = "latitude";
    public static final String LONGITUDE_KEY = "longitude";
    public static final String DESCRIPTION_KEY = "description";
    public static final String NOTICE_KEY = "notice";
    public static final String IS_OPEN_NOW_KEY = "is_open_now";
    public static final String IS_CLOSED_KEY = "is_closed";
    public static final String OPENING_HOURS_KEY = "opening_hours";
    public static final String OPENING_HOUR_KEY = "opening_hour";
    public static final String CLOSING_HOUR_KEY = "closing_hour";
    public static final String SPECIAL_HOURS_KEY = "special_hours";
    public static final String DATES_CLOSED_KEY = "dates_closed";

    public static final String SUNDAY_KEY = "sunday";
    public static final String MONDAY_KEY = "monday";
    public static final String TUESDAY_KEY = "tuesday";
    public static final String WEDNESDAY_KEY = "wednesday";
    public static final String THURSDAY_KEY = "thursday";
    public static final String FRIDAY_KEY = "friday";
    public static final String SATURDAY_KEY = "saturday";

    public static final String VENDOR_ID_KEY = "vendor_id";
    public static final String VENDOR_NAME_KEY = "vendor_name";
    public static final String ADDRESS_KEY = "address";
    public static final String PHONE_NUMBER_KEY = "phone_number";

    private Constants() {
        // restrict instantiation
    }
}
