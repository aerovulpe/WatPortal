package me.aerovulpe.watportal.data.tables.food;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_DIETS;

/**
 * Created by Aaron on 30/12/2014.
 */
public class DietsEntry implements BaseColumns {
    public static final String TABLE_NAME = "diets";

    public static final String COLUMN_DIET_ID = "diet_id";
    public static final String COLUMN_DIET_TYPE = "diet_type";

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_DIETS).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_DIETS;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_DIETS;

    public static Uri buildDietsUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
