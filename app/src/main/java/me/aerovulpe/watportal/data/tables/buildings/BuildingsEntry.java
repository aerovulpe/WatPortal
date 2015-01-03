package me.aerovulpe.watportal.data.tables.buildings;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_BUILDINGS;

/**
 * Created by Aaron on 03/01/2015.
 */
public class BuildingsEntry implements BaseColumns{
    public static final String TABLE_NAME = "buildings";

    public static final String COLUMN_BUILDING_ID = "building_id";
    public static final String COLUMN_BUILDING_CODE = "building_code";
    public static final String COLUMN_BUILDING_NAME = "building_name";
    public static final String COLUMN_ALTERNATE_NAMES = "alternate_names";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_BUILDING_SECTIONS = "building_sections";

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_BUILDINGS).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_BUILDINGS;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_BUILDINGS;

    public static Uri buildBuildingsUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
