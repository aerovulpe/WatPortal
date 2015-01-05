package me.aerovulpe.watportal.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

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
 * Created by Aaron on 31/12/2014.
 */
public class ResourceProvider extends ContentProvider {

    // The URI Matcher used by this content provider.
    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private ResourceDbHelper mOpenHelper;

    private static final int ANNOUNCEMENTS = 100;
    private static final int DIETS = 110;
    private static final int LOCATIONS = 120;
    private static final int LOCATION_OPENING_HOURS = 121;
    private static final int LOCATIONS_WITH_HOURS = 123;
    private static final int MENUS = 130;
    private static final int NOTES = 140;
    private static final int OUTLETS = 150;
    private static final int PRODUCTS = 160;
    private static final int WATCARD = 170;
    private static final int BUILDINGS = 600;

    private static final SQLiteQueryBuilder sLocationWithHoursQueryBuilder;

    static {
        sLocationWithHoursQueryBuilder = new SQLiteQueryBuilder();
        sLocationWithHoursQueryBuilder.setTables(
                LocationsEntry.TABLE_NAME + " JOIN " +
                        LocationsEntry.OpeningHoursEntry.TABLE_NAME +
                        " ON " + LocationsEntry.TABLE_NAME +
                        "." + LocationsEntry._ID +
                        " = " + LocationsEntry.OpeningHoursEntry.TABLE_NAME +
                        "." + LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY);
    }

    private static UriMatcher buildUriMatcher() {
        // I know what you're thinking.  Why create a UriMatcher when you can use regular
        // expressions instead?  Because you're not crazy, that's why.

        // All paths added to the UriMatcher have a corresponding code to return when a match is
        // found.  The code passed into the constructor represents the code to return for the root
        // URI.  It's common to use NO_MATCH as the code for this case.
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ResourceContract.CONTENT_AUTHORITY;

        // For each type of URI you want to add, create a corresponding code.
        matcher.addURI(authority, ResourceContract.PATH_ANNOUNCEMENTS, ANNOUNCEMENTS);
        matcher.addURI(authority, ResourceContract.PATH_DIETS, DIETS);
        matcher.addURI(authority, ResourceContract.PATH_LOCATIONS, LOCATIONS);
        matcher.addURI(authority, ResourceContract.PATH_LOCATIONS_OPENING_HOURS, LOCATION_OPENING_HOURS);
        matcher.addURI(authority, ResourceContract.PATH_LOCATIONS_WITH_HOURS, LOCATIONS_WITH_HOURS);
        matcher.addURI(authority, ResourceContract.PATH_MENU, MENUS);
        matcher.addURI(authority, ResourceContract.PATH_NOTES, NOTES);
        matcher.addURI(authority, ResourceContract.PATH_OUTLETS, OUTLETS);
        matcher.addURI(authority, ResourceContract.PATH_PRODUCTS, PRODUCTS);
        matcher.addURI(authority, ResourceContract.PATH_WATCARDS, WATCARD);
        matcher.addURI(authority, ResourceContract.PATH_BUILDINGS, BUILDINGS);

        return matcher;
    }


    @Override
    public boolean onCreate() {
        mOpenHelper = new ResourceDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor;
        switch (sUriMatcher.match(uri)) {
            case ANNOUNCEMENTS:
                cursor = mOpenHelper.getReadableDatabase().query(
                        AnnouncementsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case DIETS:
                cursor = mOpenHelper.getReadableDatabase().query(
                        DietsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case LOCATIONS:
                cursor = mOpenHelper.getReadableDatabase().query(
                        LocationsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case LOCATIONS_WITH_HOURS:
                cursor = sLocationWithHoursQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case MENUS:
                cursor = mOpenHelper.getReadableDatabase().query(
                        MenuEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case NOTES:
                cursor = mOpenHelper.getReadableDatabase().query(
                        NotesEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case OUTLETS:
                cursor = mOpenHelper.getReadableDatabase().query(
                        OutletsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case PRODUCTS:
                cursor = mOpenHelper.getReadableDatabase().query(
                        ProductsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case WATCARD:
                cursor = mOpenHelper.getReadableDatabase().query(
                        WatCardEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case BUILDINGS:
                cursor = mOpenHelper.getReadableDatabase().query(
                        BuildingsEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {

        switch (sUriMatcher.match(uri)) {
            case ANNOUNCEMENTS:
                return AnnouncementsEntry.CONTENT_TYPE;
            case DIETS:
                return DietsEntry.CONTENT_TYPE;
            case LOCATIONS:
                return LocationsEntry.CONTENT_TYPE;
            case LOCATION_OPENING_HOURS:
                return LocationsEntry.OpeningHoursEntry.CONTENT_TYPE;
            case MENUS:
                return MenuEntry.CONTENT_TYPE;
            case NOTES:
                return NotesEntry.CONTENT_TYPE;
            case OUTLETS:
                return OutletsEntry.CONTENT_TYPE;
            case PRODUCTS:
                return ProductsEntry.CONTENT_TYPE;
            case WATCARD:
                return WatCardEntry.CONTENT_TYPE;
            case BUILDINGS:
                return BuildingsEntry.CONTENT_TYPE;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        Uri returnUri;

        switch (sUriMatcher.match(uri)) {
            case ANNOUNCEMENTS: {
                long _id = db.insert(AnnouncementsEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = AnnouncementsEntry.buildAnnouncementsUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case DIETS: {
                long _id = db.insert(DietsEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = DietsEntry.buildDietsUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case LOCATIONS: {
                long _id = db.insert(LocationsEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = LocationsEntry.buildLocationsUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case LOCATION_OPENING_HOURS: {
                long _id = db.insert(LocationsEntry.OpeningHoursEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = LocationsEntry.OpeningHoursEntry.buildOpeningHoursUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case MENUS: {
                long _id = db.insert(MenuEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = MenuEntry.buildMenuUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case NOTES: {
                long _id = db.insert(NotesEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = NotesEntry.buildNotesUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case OUTLETS: {
                long _id = db.insert(OutletsEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = OutletsEntry.buildOutletsUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case PRODUCTS: {
                long _id = db.insert(ProductsEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = ProductsEntry.buildProductsUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case WATCARD: {
                long _id = db.insert(WatCardEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = WatCardEntry.buildWatCardUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case BUILDINGS: {
                long _id = db.insert(BuildingsEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BuildingsEntry.buildBuildingsUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int rowsDeleted;
        switch (sUriMatcher.match(uri)) {
            case ANNOUNCEMENTS:
                rowsDeleted = db.delete(
                        AnnouncementsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case DIETS:
                rowsDeleted = db.delete(
                        DietsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case LOCATIONS:
                rowsDeleted = db.delete(
                        LocationsEntry.TABLE_NAME, selection, selectionArgs);
                db.delete(LocationsEntry.OpeningHoursEntry.TABLE_NAME, ContentUris.parseId(uri) +
                        " = " + LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY, null);
                break;
            case MENUS:
                rowsDeleted = db.delete(
                        MenuEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case NOTES:
                rowsDeleted = db.delete(
                        NotesEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case OUTLETS:
                rowsDeleted = db.delete(
                        OutletsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case PRODUCTS:
                rowsDeleted = db.delete(
                        ProductsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case WATCARD:
                rowsDeleted = db.delete(
                        WatCardEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case BUILDINGS:
                rowsDeleted = db.delete(
                        BuildingsEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        // Because a null deletes all rows
        if (selection == null || rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsUpgraded;
        switch (match) {
            case ANNOUNCEMENTS:
                rowsUpgraded = db.update(
                        AnnouncementsEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case DIETS:
                rowsUpgraded = db.update(
                        DietsEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case LOCATIONS:
                rowsUpgraded = db.update(
                        LocationsEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case LOCATION_OPENING_HOURS:
                rowsUpgraded = db.update(
                        LocationsEntry.OpeningHoursEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case MENUS:
                rowsUpgraded = db.update(
                        MenuEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case NOTES:
                rowsUpgraded = db.update(
                        NotesEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case OUTLETS:
                rowsUpgraded = db.update(
                        OutletsEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case PRODUCTS:
                rowsUpgraded = db.update(
                        ProductsEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case WATCARD:
                rowsUpgraded = db.update(
                        WatCardEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case BUILDINGS:
                rowsUpgraded = db.update(
                        BuildingsEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (rowsUpgraded != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsUpgraded;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            case ANNOUNCEMENTS: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(AnnouncementsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case DIETS: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(DietsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case LOCATIONS: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(LocationsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case LOCATION_OPENING_HOURS: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(LocationsEntry.OpeningHoursEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case MENUS: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(MenuEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case NOTES: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(NotesEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case OUTLETS: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(OutletsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case WATCARD: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(WatCardEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            case BUILDINGS: {
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(BuildingsEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            }
            default:
                return super.bulkInsert(uri, values);
        }
    }
}
