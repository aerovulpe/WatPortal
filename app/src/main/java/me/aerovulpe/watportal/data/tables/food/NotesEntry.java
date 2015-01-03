package me.aerovulpe.watportal.data.tables.food;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_NOTES;

/**
 * Created by Aaron on 30/12/2014.
 */
public class NotesEntry implements BaseColumns {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_OUTLET_NAME = "outlet_name";
    public static final String COLUMN_OUTLET_ID = "outlet_id";
    public static final String COLUMN_NOTE = "note";

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_NOTES).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_NOTES;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_NOTES;

    public static Uri buildNotesUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
