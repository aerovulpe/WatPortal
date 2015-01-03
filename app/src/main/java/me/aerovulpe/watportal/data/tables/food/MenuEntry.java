package me.aerovulpe.watportal.data.tables.food;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_MENU;

/**
 * Created by Aaron on 30/12/2014.
 */
public class MenuEntry implements BaseColumns{
    public static final String TABLE_NAME = "menu";

    public static final String COLUMN_OUTLET_NAME = "outlet_name";
    public static final String COLUMN_OUTLET_ID = "outlet_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_WEEK = "week";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_START_DATE = "start";
    public static final String COLUMN_END_DATE = "end";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_MEAL_TYPE = "meal_type";
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_DIET_TYPE = "diet_type";
    public static final String COLUMN_NOTES = "notes";


    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_MENU).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_MENU;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_MENU;

    public static Uri buildMenuUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
