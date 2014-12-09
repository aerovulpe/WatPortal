package me.aerovulpe.watportal.resources.food.watcard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.aerovulpe.watportal.resources.WatObject;
import me.aerovulpe.watportal.resources.Meta;
import me.aerovulpe.watportal.resources.Resource;

import static me.aerovulpe.watportal.Constants.ADDRESS_KEY;
import static me.aerovulpe.watportal.Constants.LATITUDE_KEY;
import static me.aerovulpe.watportal.Constants.LOGO_KEY;
import static me.aerovulpe.watportal.Constants.LONGITUDE_KEY;
import static me.aerovulpe.watportal.Constants.PHONE_NUMBER_KEY;
import static me.aerovulpe.watportal.Constants.VENDOR_ID_KEY;
import static me.aerovulpe.watportal.Constants.VENDOR_NAME_KEY;

public class WatCard extends WatObject {
    private List<Data> data;
    private Meta meta;

    public WatCard() {
        super(Resource.FOOD_WATCARD);
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Data {
        private String address;
        private double latitude;
        private String logo;
        private double longitude;
        private String phone_number;
        private int vendor_id;
        private String vendor_name;

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getLogo() {
            return this.logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getPhone_number() {
            return this.phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public int getVendor_id() {
            return this.vendor_id;
        }

        public void setVendor_id(int vendor_id) {
            this.vendor_id = vendor_id;
        }

        public String getVendor_name() {
            return this.vendor_name;
        }

        public void setVendor_name(String vendor_name) {
            this.vendor_name = vendor_name;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "address='" + address + '\'' +
                    ", latitude=" + latitude +
                    ", logo='" + logo + '\'' +
                    ", longitude=" + longitude +
                    ", phone_number='" + phone_number + '\'' +
                    ", vendor_id=" + vendor_id +
                    ", vendor_name='" + vendor_name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatCard{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatCard parse(Meta meta, JSONArray dataArray) throws JSONException {
        WatCard watcard = new WatCard();

        List<Data> data = new ArrayList<Data>();

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            Data dataItem = new Data();

            dataItem.setVendor_id(dataObject.getInt(VENDOR_ID_KEY));
            dataItem.setVendor_name(dataObject.getString(VENDOR_NAME_KEY));

            try {
                dataItem.setLatitude(dataObject.getDouble(LATITUDE_KEY));
                dataItem.setLongitude(dataObject.getDouble(LONGITUDE_KEY));
                dataItem.setAddress(dataObject.getString(ADDRESS_KEY));
                dataItem.setPhone_number(dataObject.getString(PHONE_NUMBER_KEY));
                dataItem.setLogo(dataObject.getString(LOGO_KEY));
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                data.add(dataItem);
            }
        }

        watcard.setMeta(meta);
        watcard.setData(data);

        return watcard;
    }
}
