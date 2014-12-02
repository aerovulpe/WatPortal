package me.aerovulpe.watportal.resources.food.locations;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.aerovulpe.watportal.constants.WatObject;
import me.aerovulpe.watportal.resources.Meta;
import me.aerovulpe.watportal.resources.Resource;

import static me.aerovulpe.watportal.constants.Constants.BUILDING_KEY;
import static me.aerovulpe.watportal.constants.Constants.CLOSING_HOUR_KEY;
import static me.aerovulpe.watportal.constants.Constants.DATES_CLOSED_KEY;
import static me.aerovulpe.watportal.constants.Constants.DATE_FORMAT;
import static me.aerovulpe.watportal.constants.Constants.DATE_KEY;
import static me.aerovulpe.watportal.constants.Constants.DESCRIPTION_KEY;
import static me.aerovulpe.watportal.constants.Constants.FRIDAY_KEY;
import static me.aerovulpe.watportal.constants.Constants.IS_OPEN_NOW_KEY;
import static me.aerovulpe.watportal.constants.Constants.LATITUDE_KEY;
import static me.aerovulpe.watportal.constants.Constants.LOGO_KEY;
import static me.aerovulpe.watportal.constants.Constants.LONGITUDE_KEY;
import static me.aerovulpe.watportal.constants.Constants.MONDAY_KEY;
import static me.aerovulpe.watportal.constants.Constants.NOTICE_KEY;
import static me.aerovulpe.watportal.constants.Constants.OPENING_HOURS_KEY;
import static me.aerovulpe.watportal.constants.Constants.OPENING_HOUR_KEY;
import static me.aerovulpe.watportal.constants.Constants.OUTLET_ID_KEY;
import static me.aerovulpe.watportal.constants.Constants.OUTLET_NAME_KEY;
import static me.aerovulpe.watportal.constants.Constants.SATURDAY_KEY;
import static me.aerovulpe.watportal.constants.Constants.SPECIAL_HOURS_KEY;
import static me.aerovulpe.watportal.constants.Constants.SUNDAY_KEY;
import static me.aerovulpe.watportal.constants.Constants.THURSDAY_KEY;
import static me.aerovulpe.watportal.constants.Constants.TUESDAY_KEY;
import static me.aerovulpe.watportal.constants.Constants.WEDNESDAY_KEY;

public class WatLocation implements WatObject {
    private static final String LOG_TAG = WatLocation.class.getSimpleName();

    private List<Data> data;
    private Meta meta;

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

    @Override
    public Resource getResourceType() {
        return Resource.FOOD_LOCATIONS;
    }

    public static class Data {
        private String building;
        private List<Date> dates_closed;
        private String description;
        private boolean is_open_now;
        private double latitude;
        private String logo;
        private double longitude;
        private String notice;
        private Opening_hours opening_hours;
        private int outlet_id;
        private String outlet_name;
        private List<Special_hours> special_hours;


        public String getBuilding() {
            return this.building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public List<Date> getDates_closed() {
            return this.dates_closed;
        }

        public void setDates_closed(List<Date> dates_closed) {
            this.dates_closed = dates_closed;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean getIs_open_now() {
            return this.is_open_now;
        }

        public void setIs_open_now(boolean is_open_now) {
            this.is_open_now = is_open_now;
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

        public String getNotice() {
            return this.notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public Opening_hours getOpening_hours() {
            return this.opening_hours;
        }

        public void setOpening_hours(Opening_hours opening_hours) {
            this.opening_hours = opening_hours;
        }

        public int getOutlet_id() {
            return this.outlet_id;
        }

        public void setOutlet_id(int outlet_id) {
            this.outlet_id = outlet_id;
        }

        public String getOutlet_name() {
            return this.outlet_name;
        }

        public void setOutlet_name(String outlet_name) {
            this.outlet_name = outlet_name;
        }

        public List<Special_hours> getSpecial_hours() {
            return this.special_hours;
        }

        public void setSpecial_hours(List<Special_hours> special_hours) {
            this.special_hours = special_hours;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "building='" + building + '\'' +
                    ", dates_closed=" + dates_closed +
                    ", description='" + description + '\'' +
                    ", is_open_now=" + is_open_now +
                    ", latitude=" + latitude +
                    ", logo='" + logo + '\'' +
                    ", longitude=" + longitude +
                    ", notice='" + notice + '\'' +
                    ", opening_hours=" + opening_hours +
                    ", outlet_id=" + outlet_id +
                    ", outlet_name='" + outlet_name + '\'' +
                    ", special_hours=" + special_hours +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatLocation{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatLocation parse(Meta meta, JSONArray dataArray) throws JSONException {
        WatLocation watLocation = new WatLocation();
        List<Data> data = new ArrayList<Data>();

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            Data dataItem = new Data();

            JSONArray specialHoursArray = dataObject.getJSONArray(SPECIAL_HOURS_KEY);
            List<Special_hours> specialHoursList = new ArrayList<Special_hours>();
            for (int j = 0; j < specialHoursArray.length(); j++) {
                JSONObject specialHoursObject = specialHoursArray.getJSONObject(j);
                Special_hours specialHours = new Special_hours();
                specialHours.setDate(specialHoursObject.getString(DATE_KEY));
                specialHours.setOpening_hour(specialHoursObject.getString(OPENING_HOUR_KEY));
                specialHours.setClosing_hour(specialHoursObject.getString(CLOSING_HOUR_KEY));
                specialHoursList.add(specialHours);
            }

            JSONArray datesClosedArray = dataObject.getJSONArray(DATES_CLOSED_KEY);
            List<Date> dates = new ArrayList<Date>();
            for (int k = 0; k < datesClosedArray.length(); k++) {
                try {
                    dates.add(DATE_FORMAT.parse(datesClosedArray.getString(k)));
                } catch (ParseException e) {
                    Log.e(LOG_TAG, "Parsing date string failed!");
                }
            }

            JSONObject openingHoursObject = dataObject.getJSONObject(OPENING_HOURS_KEY);

            JSONObject sundayObject = openingHoursObject.getJSONObject(SUNDAY_KEY);
            Day sunday = new Day(DayName.SUNDAY);
            sunday.setFields(sundayObject);

            JSONObject mondayObject = openingHoursObject.getJSONObject(MONDAY_KEY);
            Day monday = new Day(DayName.MONDAY);
            monday.setFields(mondayObject);

            JSONObject tuesdayObject = openingHoursObject.getJSONObject(TUESDAY_KEY);
            Day tuesday = new Day(DayName.TUESDAY);
            tuesday.setFields(tuesdayObject);

            JSONObject wednesdayObject = openingHoursObject.getJSONObject(WEDNESDAY_KEY);
            Day wednesday = new Day(DayName.WEDNESDAY);
            wednesday.setFields(wednesdayObject);

            JSONObject thursdayObject = openingHoursObject.getJSONObject(THURSDAY_KEY);
            Day thursday = new Day(DayName.THURSDAY);
            thursday.setFields(thursdayObject);

            JSONObject fridayObject = openingHoursObject.getJSONObject(FRIDAY_KEY);
            Day friday = new Day(DayName.FRIDAY);
            friday.setFields(fridayObject);

            JSONObject saturdayObject = openingHoursObject.getJSONObject(SATURDAY_KEY);
            Day saturday = new Day(DayName.SATURDAY);
            saturday.setFields(saturdayObject);

            Opening_hours opening_hours = new Opening_hours(sunday, monday, tuesday, wednesday, thursday, friday, saturday);

            dataItem.setOutlet_id(dataObject.getInt(OUTLET_ID_KEY));
            dataItem.setOutlet_name(dataObject.getString(OUTLET_NAME_KEY));
            dataItem.setBuilding(dataObject.getString(BUILDING_KEY));
            dataItem.setLogo(dataObject.getString(LOGO_KEY));
            dataItem.setLatitude(dataObject.getDouble(LATITUDE_KEY));
            dataItem.setLongitude(dataObject.getDouble(LONGITUDE_KEY));
            dataItem.setDescription(dataObject.getString(DESCRIPTION_KEY));
            dataItem.setNotice(dataObject.getString(NOTICE_KEY));
            dataItem.setIs_open_now(dataObject.getBoolean(IS_OPEN_NOW_KEY));
            dataItem.setOpening_hours(opening_hours);
            dataItem.setSpecial_hours(specialHoursList);
            dataItem.setDates_closed(dates);
            data.add(dataItem);
        }

        watLocation.setMeta(meta);
        watLocation.setData(data);

        return watLocation;
    }
}
