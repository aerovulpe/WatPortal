package me.aerovulpe.watportal.data.tables.food;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_ANNOUNCEMENTS;

public class AnnouncementsEntry implements BaseColumns{
    public static final String TABLE_NAME = "announcements";

    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_AD_TEXT = "ad_text";

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_ANNOUNCEMENTS).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_ANNOUNCEMENTS;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_ANNOUNCEMENTS;

    public static Uri buildAnnouncementsUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
