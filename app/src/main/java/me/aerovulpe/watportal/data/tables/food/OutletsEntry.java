package me.aerovulpe.watportal.data.tables.food;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_OUTLETS;

/**
 * Created by Aaron on 30/12/2014.
 */
public class OutletsEntry implements BaseColumns{
    public static final String TABLE_NAME = "outlets";

    public static final String COLUMN_OUTLET_ID = "outlet_id";
    public static final String COLUMN_OUTLET_NAME = "outlet_name";
    public static final String COLUMN_HAS_BREAKFAST = "has_breakfast";
    public static final String COLUMN_HAS_LUNCH = "has_lunch";
    public static final String COLUMN_HAS_DINNER = "has_dinner";

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_OUTLETS).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_OUTLETS;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_OUTLETS;

    public static Uri buildOutletsUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
