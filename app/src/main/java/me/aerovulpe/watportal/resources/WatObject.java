package me.aerovulpe.watportal.resources;

import org.json.JSONException;
import org.json.JSONObject;

import me.aerovulpe.watportal.resources.food.announcements.WatAnnouncement;
import me.aerovulpe.watportal.resources.food.diets.WatDiet;
import me.aerovulpe.watportal.resources.food.locations.WatLocation;
import me.aerovulpe.watportal.resources.food.menu.WatMenu;
import me.aerovulpe.watportal.resources.food.notes.WatNote;
import me.aerovulpe.watportal.resources.food.outlets.WatOutlet;
import me.aerovulpe.watportal.resources.food.products.WatProduct;
import me.aerovulpe.watportal.resources.food.watcard.WatCard;

import static me.aerovulpe.watportal.Constants.DATA_KEY;
import static me.aerovulpe.watportal.Constants.MESSAGE_KEY;
import static me.aerovulpe.watportal.Constants.META_KEY;
import static me.aerovulpe.watportal.Constants.METHOD_ID_KEY;
import static me.aerovulpe.watportal.Constants.REQUESTS_KEY;
import static me.aerovulpe.watportal.Constants.STATUS_KEY;
import static me.aerovulpe.watportal.Constants.TIMESTAMP_KEY;

/**
 * Created by Aaron on 26/11/2014.
 */
public abstract class WatObject {
    private static Resource sResourceType;

    protected WatObject(Resource resourceType){
        setResourceType(resourceType);
    }

    public Resource getResourceType(){
        return sResourceType;
    }

    protected static void setResourceType(Resource resourceType){
        sResourceType = resourceType;
    }

    public static WatObject parse(Resource resourceType, JSONObject rootObject) throws JSONException{
        WatObject watObject = null;

        JSONObject metaObject = rootObject.getJSONObject(META_KEY);
        Meta meta = new Meta();
        meta.setRequests(metaObject.getInt(REQUESTS_KEY));
        meta.setTimestamp(metaObject.getInt(TIMESTAMP_KEY));
        meta.setStatus(metaObject.getInt(STATUS_KEY));
        meta.setMessage(metaObject.getString(MESSAGE_KEY));
        meta.setMethod_id(metaObject.getInt(METHOD_ID_KEY));

        switch (resourceType) {
            case FOOD_MENU:
                watObject = WatMenu.parse(meta, rootObject.getJSONObject(DATA_KEY));
                break;
            case FOOD_NOTES:
                watObject = WatNote.parse(meta, rootObject.getJSONArray(DATA_KEY));
                break;
            case FOOD_DIETS:
                watObject = WatDiet.parse(meta, rootObject.getJSONArray(DATA_KEY));
                break;
            case FOOD_OUTLETS:
                watObject = WatOutlet.parse(meta, rootObject.getJSONArray(DATA_KEY));
                break;
            case FOOD_LOCATIONS:
                watObject = WatLocation.parse(meta, rootObject.getJSONArray(DATA_KEY));
                break;
            case FOOD_WATCARD:
                watObject = WatCard.parse(meta, rootObject.getJSONArray(DATA_KEY));
                break;
            case FOOD_ANNOUNCEMENTS:
                watObject = WatAnnouncement.parse(meta, rootObject.getJSONArray(DATA_KEY));
                break;
            case FOOD_PRODUCTS:
                watObject = WatProduct.parse(meta, rootObject.getJSONObject(DATA_KEY));
                break;
        }

        return watObject;
    }
}
