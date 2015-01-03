package me.aerovulpe.watportal.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
 * Created by Aaron on 30/12/2014.
 */
public class ResourceDbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "resource.db";

    public ResourceDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_ANNOUNCEMENTS_TABLE = "CREATE TABLE " + AnnouncementsEntry.TABLE_NAME + " ( " +
                AnnouncementsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                AnnouncementsEntry.COLUMN_DATE + " TEXT, " +
                AnnouncementsEntry.COLUMN_AD_TEXT + " TEXT, " +
                " UNIQUE (" + AnnouncementsEntry.COLUMN_DATE + " , " +
                AnnouncementsEntry.COLUMN_AD_TEXT +
                ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_DIETS_TABLE = "CREATE TABLE " + DietsEntry.TABLE_NAME + " (" +
                DietsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                DietsEntry.COLUMN_DIET_ID + " INTEGER, " +
                DietsEntry.COLUMN_DIET_TYPE + " TEXT, " +
                " UNIQUE (" + DietsEntry.COLUMN_DIET_ID + " , " +
                DietsEntry.COLUMN_DIET_TYPE +
                ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_LOCATIONS_TABLE = "CREATE TABLE " + LocationsEntry.TABLE_NAME + " (" +
                LocationsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                LocationsEntry.COLUMN_OUTLET_ID + " INTEGER, " +
                LocationsEntry.COLUMN_OUTLET_NAME + " TEXT, " +
                LocationsEntry.COLUMN_BUILDING + " TEXT, " +
                LocationsEntry.COLUMN_LOGO + " TEXT, " +
                LocationsEntry.COLUMN_LATITUDE + " REAL, " +
                LocationsEntry.COLUMN_LONGITUDE + " REAL, " +
                LocationsEntry.COLUMN_DESCRIPTION + " TEXT, " +
                LocationsEntry.COLUMN_NOTICE + " TEXT, " +
                LocationsEntry.COLUMN_IS_OPEN_NOW + " INTEGER, " +
                LocationsEntry.COLUMN_DATES_CLOSED + " BLOB, " +
                " UNIQUE (" + LocationsEntry.COLUMN_OUTLET_NAME + " , " +
                LocationsEntry.COLUMN_BUILDING +
                ") ON CONFLICT REPLACE);";
        final String SQL_CREATE_OPENING_HOURS_TABLE = "CREATE TABLE " + LocationsEntry.OpeningHoursEntry.TABLE_NAME + " (" +
                LocationsEntry.OpeningHoursEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK + " TEXT, " +
                LocationsEntry.OpeningHoursEntry.COLUMN_OPENING_HOUR + " TEXT, " +
                LocationsEntry.OpeningHoursEntry.COLUMN_CLOSING_HOUR + " TEXT, " +
                LocationsEntry.OpeningHoursEntry.COLUMN_IS_CLOSED + " INTEGER, " +
                LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY + " INTEGER, " +

                " FOREIGN KEY (" + LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY + ") REFERENCES " +
                LocationsEntry.TABLE_NAME + " (" + LocationsEntry._ID + "), " +

                " UNIQUE (" + LocationsEntry.OpeningHoursEntry.COLUMN_DAY_OF_THE_WEEK + ", " +
                LocationsEntry.OpeningHoursEntry.COLUMN_LOC_KEY + ") ON CONFLICT REPLACE);";
        final String SQL_CREATE_SPECIAL_HOURS_TABLE = "CREATE TABLE " + LocationsEntry.SpecialHoursEntry.TABLE_NAME + " (" +
                LocationsEntry.SpecialHoursEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                LocationsEntry.SpecialHoursEntry.COLUMN_DATE + " TEXT, " +
                LocationsEntry.SpecialHoursEntry.COLUMN_OPENING_HOUR + " TEXT, " +
                LocationsEntry.SpecialHoursEntry.COLUMN_CLOSING_HOUR + " TEXT, " +
                LocationsEntry.SpecialHoursEntry.COLUMN_LOC_KEY + " INTEGER, " +

                " FOREIGN KEY (" + LocationsEntry.SpecialHoursEntry.COLUMN_LOC_KEY + ") REFERENCES " +
                LocationsEntry.TABLE_NAME + " (" + LocationsEntry._ID + "), " +

                " UNIQUE (" + LocationsEntry.SpecialHoursEntry.COLUMN_DATE + ", " +
                LocationsEntry.SpecialHoursEntry.COLUMN_LOC_KEY + ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_MENU_TABLE = "CREATE TABLE " + MenuEntry.TABLE_NAME + " (" +
                MenuEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                MenuEntry.COLUMN_OUTLET_NAME + " TEXT, " +
                MenuEntry.COLUMN_OUTLET_ID + " INTEGER, " +
                MenuEntry.COLUMN_DATE + " TEXT, " +
                MenuEntry.COLUMN_WEEK + " INTEGER, " +
                MenuEntry.COLUMN_YEAR + " INTEGER, " +
                MenuEntry.COLUMN_START_DATE + " TEXT, " +
                MenuEntry.COLUMN_END_DATE + " TEXT, " +
                MenuEntry.COLUMN_DAY + " TEXT, " +
                MenuEntry.COLUMN_MEAL_TYPE + " TEXT, " +
                MenuEntry.COLUMN_PRODUCT_NAME + " TEXT, " +
                MenuEntry.COLUMN_PRODUCT_ID + " INTEGER, " +
                MenuEntry.COLUMN_DIET_TYPE + " TEXT, " +
                MenuEntry.COLUMN_NOTES + " TEXT, " +
                " UNIQUE (" + MenuEntry.COLUMN_PRODUCT_NAME + " , " + MenuEntry.COLUMN_OUTLET_NAME +
                " , " + MenuEntry.COLUMN_DATE +
                ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " + NotesEntry.TABLE_NAME + " (" +
                NotesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                NotesEntry.COLUMN_DATE + " TEXT, " +
                NotesEntry.COLUMN_OUTLET_NAME + " TEXT, " +
                NotesEntry.COLUMN_OUTLET_ID + " INTEGER, " +
                NotesEntry.COLUMN_NOTE + " TEXT, " +
                " UNIQUE (" + NotesEntry.COLUMN_DATE + " , " + NotesEntry.COLUMN_OUTLET_NAME +
                ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_OUTLETS_TABLE = "CREATE TABLE " + OutletsEntry.TABLE_NAME + " (" +
                OutletsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                OutletsEntry.COLUMN_OUTLET_ID + " INTEGER, " +
                OutletsEntry.COLUMN_OUTLET_NAME + " TEXT, " +
                OutletsEntry.COLUMN_HAS_BREAKFAST + " INTEGER, " +
                OutletsEntry.COLUMN_HAS_LUNCH + " INTEGER, " +
                OutletsEntry.COLUMN_HAS_DINNER + " INTEGER, " +
                " UNIQUE (" + OutletsEntry.COLUMN_OUTLET_NAME +
                ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_PRODUCTS_TABLE = "CREATE TABLE " + ProductsEntry.TABLE_NAME + " (" +
                ProductsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                ProductsEntry.COLUMN_PRODUCT_ID + " INTEGER, " +
                ProductsEntry.COLUMN_PRODUCT_NAME + " TEXT, " +
                ProductsEntry.COLUMN_INGREDIENTS + " TEXT, " +
                ProductsEntry.COLUMN_SERVING_SIZE + " TEXT, " +
                ProductsEntry.COLUMN_CALORIES + " INTEGER, " +
                ProductsEntry.COLUMN_TOTAL_FAT_G + " INTEGER, " +
                ProductsEntry.COLUMN_TOTAL_FAT_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_FAT_SATURATED_G + " INTEGER, " +
                ProductsEntry.COLUMN_FAT_SATURATED_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_FAT_TRANS_G + " INTEGER, " +
                ProductsEntry.COLUMN_FAT_TRANS_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_CHOLESTEROL_MG + " INTEGER, " +
                ProductsEntry.COLUMN_SODIUM_MG + " INTEGER, " +
                ProductsEntry.COLUMN_SODIUM_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_CARBO_G + " INTEGER, " +
                ProductsEntry.COLUMN_CARBO_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_FIBRE_G + " INTEGER, " +
                ProductsEntry.COLUMN_FIBRE_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_CARBO_SUGARS_G + " INTEGER, " +
                ProductsEntry.COLUMN_PROTEIN_G + " INTEGER, " +
                ProductsEntry.COLUMN_VITAMIN_A_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_VITAMIN_C_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_CALCIUM_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_IRON_PERCENT + " INTEGER, " +
                ProductsEntry.COLUMN_MICRO_NUTRIENTS + " INTEGER, " +
                ProductsEntry.COLUMN_TIPS + " INTEGER, " +
                ProductsEntry.COLUMN_DIET_ID + " INTEGER, " +
                ProductsEntry.COLUMN_DIET_TYPE + " INTEGER, " +
                " UNIQUE (" + ProductsEntry.COLUMN_PRODUCT_ID +
                ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_WATCARD_TABLE = "CREATE TABLE " + WatCardEntry.TABLE_NAME + " (" +
                WatCardEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                WatCardEntry.COLUMN_VENDOR_ID + " INTEGER, " +
                WatCardEntry.COLUMN_VENDOR_NAME + " TEXT, " +
                " UNIQUE (" + WatCardEntry.COLUMN_VENDOR_ID + " , " +
                WatCardEntry.COLUMN_VENDOR_NAME +
                ") ON CONFLICT REPLACE);";

        final String SQL_CREATE_BUILDINGS_TABLE = "CREATE TABLE " + BuildingsEntry.TABLE_NAME + " (" +
                BuildingsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                BuildingsEntry.COLUMN_BUILDING_ID + " TEXT, " +
                BuildingsEntry.COLUMN_BUILDING_CODE + " TEXT, " +
                BuildingsEntry.COLUMN_BUILDING_NAME + " TEXT, " +
                BuildingsEntry.COLUMN_ALTERNATE_NAMES + " BLOB, " +
                BuildingsEntry.COLUMN_LATITUDE + " REAL, " +
                BuildingsEntry.COLUMN_LONGITUDE + " REAL, " +
                BuildingsEntry.COLUMN_BUILDING_SECTIONS + " BLOB, " +
                " UNIQUE (" + BuildingsEntry.COLUMN_BUILDING_CODE +
                ") ON CONFLICT REPLACE);";

        db.execSQL(SQL_CREATE_ANNOUNCEMENTS_TABLE);
        db.execSQL(SQL_CREATE_DIETS_TABLE);
        db.execSQL(SQL_CREATE_LOCATIONS_TABLE);
        db.execSQL(SQL_CREATE_OPENING_HOURS_TABLE);
        db.execSQL(SQL_CREATE_SPECIAL_HOURS_TABLE);
        db.execSQL(SQL_CREATE_MENU_TABLE);
        db.execSQL(SQL_CREATE_NOTES_TABLE);
        db.execSQL(SQL_CREATE_OUTLETS_TABLE);
        db.execSQL(SQL_CREATE_PRODUCTS_TABLE);
        db.execSQL(SQL_CREATE_WATCARD_TABLE);
        db.execSQL(SQL_CREATE_BUILDINGS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AnnouncementsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DietsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LocationsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LocationsEntry.OpeningHoursEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LocationsEntry.SpecialHoursEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MenuEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + NotesEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + OutletsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ProductsEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + WatCardEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BuildingsEntry.TABLE_NAME);

        onCreate(db);
    }
}
