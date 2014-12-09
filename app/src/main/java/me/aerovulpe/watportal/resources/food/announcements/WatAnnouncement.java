package me.aerovulpe.watportal.resources.food.announcements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.aerovulpe.watportal.resources.WatObject;
import me.aerovulpe.watportal.resources.Meta;
import me.aerovulpe.watportal.resources.Resource;

import static me.aerovulpe.watportal.Constants.AD_TEXT_KEY;
import static me.aerovulpe.watportal.Constants.DATE_FORMAT;
import static me.aerovulpe.watportal.Constants.DATE_KEY;

public class WatAnnouncement extends WatObject {
    private List<Data> data;
    private Meta meta;

    public WatAnnouncement(){
        super(Resource.FOOD_ANNOUNCEMENTS);
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
        private String ad_text;
        private Date date;

        public String getAd_text() {
            return this.ad_text;
        }

        public void setAd_text(String ad_text) {
            this.ad_text = ad_text;
        }

        public Date getDate() {
            return this.date;
        }

        public void setDate(String date) {
            try {
                this.date = DATE_FORMAT.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Data{" +
                    "ad_text='" + ad_text + '\'' +
                    ", date=" + date +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatAnnouncement{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatAnnouncement parse(Meta meta, JSONArray dataArray) throws JSONException {
        WatAnnouncement watAnnouncement = new WatAnnouncement();

        List<Data> data = new ArrayList<>();
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            Data dataItem = new Data();

            dataItem.setDate(dataObject.getString(DATE_KEY));
            dataItem.setAd_text(dataObject.getString(AD_TEXT_KEY));

            data.add(dataItem);
        }

        watAnnouncement.setMeta(meta);
        watAnnouncement.setData(data);

        return watAnnouncement;
    }
}
