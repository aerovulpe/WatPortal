package me.aerovulpe.watportal.data.tables.food;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.aerovulpe.watportal.data.ResourceContract.BASE_CONTENT_URI;
import static me.aerovulpe.watportal.data.ResourceContract.CONTENT_AUTHORITY;
import static me.aerovulpe.watportal.data.ResourceContract.PATH_PRODUCTS;

/**
 * Created by Aaron on 30/12/2014.
 */
public class ProductsEntry implements BaseColumns {
    public static final String TABLE_NAME = "products";

    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_INGREDIENTS = "ingredients";
    public static final String COLUMN_SERVING_SIZE = "serving_size";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_TOTAL_FAT_G = "total_fat_g";
    public static final String COLUMN_TOTAL_FAT_PERCENT = "total_fat_percent";
    public static final String COLUMN_FAT_SATURATED_G = "fat_saturated_g";
    public static final String COLUMN_FAT_SATURATED_PERCENT = "fat_saturated_percent";
    public static final String COLUMN_FAT_TRANS_G = "fat_trans_g";
    public static final String COLUMN_FAT_TRANS_PERCENT = "fat_trans_percent";
    public static final String COLUMN_CHOLESTEROL_MG = "cholesterol_mg";
    public static final String COLUMN_SODIUM_MG = "sodium_mg";
    public static final String COLUMN_SODIUM_PERCENT = "sodium_percent";
    public static final String COLUMN_CARBO_G = "carbo_g";
    public static final String COLUMN_CARBO_PERCENT = "carbo_percent";
    public static final String COLUMN_FIBRE_G = "carbo_fibre_g";
    public static final String COLUMN_FIBRE_PERCENT = "carbo_fibre_percent";
    public static final String COLUMN_CARBO_SUGARS_G = "carbo_sugars_g";
    public static final String COLUMN_PROTEIN_G = "protein_g";
    public static final String COLUMN_VITAMIN_A_PERCENT = "vitamin_a_percent";
    public static final String COLUMN_VITAMIN_C_PERCENT = "vitamin_c_percent";
    public static final String COLUMN_CALCIUM_PERCENT = "calcium_percent";
    public static final String COLUMN_IRON_PERCENT = "iron_percent";
    public static final String COLUMN_MICRO_NUTRIENTS = "micro_nutrients";
    public static final String COLUMN_TIPS = "tips";
    public static final String COLUMN_DIET_ID = "diet_id";
    public static final String COLUMN_DIET_TYPE = "diet_type";

    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(PATH_PRODUCTS).build();

    public static final String CONTENT_TYPE =
            "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;
    public static final String CONTENT_ITEM_TYPE =
            "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

    public static Uri buildProductsUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }
}
