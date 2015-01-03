package me.aerovulpe.watportal.data;

import android.net.Uri;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aaron on 30/12/2014.
 */
public class ResourceContract {
    // The "Content authority" is a name for the entire content provider, similar to the
    // relationship between a domain name and its website.  A convenient string to use for the
    // content authority is the package name for the app, which is guaranteed to be unique on the
    // device.

    public static final String CONTENT_AUTHORITY = "me.aerovulpe.watportal";

    // Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
    // the content provider.

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Possible paths (appended to base content URI for possible URI's)
    // For instance, content://com.example.android.sunshine.app/weather/ is a valid path for
    // looking at weather data. content://com.example.android.sunshine.app/givemeroot/ will fail,
    // as the ContentProvider hasn't been given any information on what to do with "givemeroot".
    // At least, let's hope not.  Don't be that dev, reader.  Don't be that dev.

    public static final String PATH_ANNOUNCEMENTS = "announcements";
    public static final String PATH_DIETS = "diets";
    public static final String PATH_LOCATIONS = "locations";
    public static final String PATH_LOCATIONS_OPENING_HOURS = "opening_hours";
    public static final String PATH_LOCATIONS_SPECIAL_HOURS = "special_hours";
    public static final String PATH_MENU = "menu";
    public static final String PATH_NOTES = "notes";
    public static final String PATH_OUTLETS = "outlets";
    public static final String PATH_PRODUCTS = "products";
    public static final String PATH_WATCARDS = "watcards";
    public static final String PATH_BUILDINGS = "buildings";

    // Format used for storing dates in the database.  ALso used for converting those strings
    // back into date objects for comparison/processing.

    public static final String DATE_FORMAT = "yyyyMMdd";

    /**
     * Converts Date class to a string representation, used for easy comparison and database lookup.
     * @param date The input date
     * @return a DB-friendly representation of the date, using the format defined in DATE_FORMAT.
     */
    public static String getDbDateString(Date date){
        // Because the API returns a unix timestamp (measured in seconds),
        // it must be converted to milliseconds in order to be converted to valid date.
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    /**
     * Converts a dateText to a long Unix time representation
     *
     * @param dateText the input date string
     * @return the Date object
     */
    public static Date getDateFromDb(String dateText) {
        SimpleDateFormat dbDateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            return dbDateFormat.parse(dateText);
        } catch ( ParseException e ) {
            e.printStackTrace();
            return null;
        }
    }

}
