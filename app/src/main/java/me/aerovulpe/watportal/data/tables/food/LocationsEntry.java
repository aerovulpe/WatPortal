package me.aerovulpe.watportal.data.tables.food;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_LOCATIONS;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_LOCATIONS_OPENING_HOURS;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_LOCATIONS_WITH_HOURS;

/**
 * Created by Aaron on 30/12/2014.
 */
public class LocationsEntry implements BaseColumns {
    public static final String TABLE_NAME = "locations";

    public static final String COLUMN_OUTLET_ID = "outlet_id";
    public static final String COLUMN_OUTLET_NAME = "outlet_type";
    public static final String COLUMN_BUILDING = "building";
    public static final String COLUMN_LOGO = "logo";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_NOTICE = "notice";
    public static final String COLUMN_IS_OPEN_NOW = "is_open_now";
    public static final String COLUMN_DATES_CLOSED = "dates_closed";


    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATIONS).build();

    public static final Uri CONTENT_WITH_HOURS_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATIONS_WITH_HOURS).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_LOCATIONS;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_LOCATIONS;

    public static Uri buildLocationsUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }


    public static class OpeningHoursEntry implements BaseColumns{
        public static final String TABLE_NAME = "opening_hours";

        public static final String COLUMN_DAY_OF_THE_WEEK = "day_of_the_week";
        public static final String COLUMN_OPENING_HOUR = "opening_hour";
        public static final String COLUMN_CLOSING_HOUR = "closing_hour";
        public static final String COLUMN_IS_CLOSED = "is_closed";
        public static final String COLUMN_LOC_KEY = "location_id";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_LOCATIONS_OPENING_HOURS).build();

        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_LOCATIONS_OPENING_HOURS;
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_LOCATIONS_OPENING_HOURS;

        public static Uri buildOpeningHoursUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
