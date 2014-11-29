package me.aerovulpe.watportal.resources.food.notes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.aerovulpe.watportal.constants.WatObject;
import me.aerovulpe.watportal.resources.Meta;

import static me.aerovulpe.watportal.constants.Constants.DATE_FORMAT;
import static me.aerovulpe.watportal.constants.Constants.DATE_KEY;
import static me.aerovulpe.watportal.constants.Constants.NOTE_KEY;
import static me.aerovulpe.watportal.constants.Constants.OUTLET_ID_KEY;
import static me.aerovulpe.watportal.constants.Constants.OUTLET_NAME_KEY;

public class WatNote implements WatObject{
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

    public static class Data {
        private Date date;
        private String note;
        private int outlet_id;
        private String outlet_name;

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

        public String getNote() {
            return this.note;
        }

        public void setNote(String note) {
            this.note = note;
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

        @Override
        public String toString() {
            return "Data{" +
                    "date=" + date +
                    ", note='" + note + '\'' +
                    ", outlet_id=" + outlet_id +
                    ", outlet_name='" + outlet_name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatNote{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatNote parse(Meta meta, JSONArray dataArray) throws JSONException {
        WatNote watNote = new WatNote();

        List<Data> data = new ArrayList<Data>();
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            Data dataItem = new Data();

            dataItem.setDate(dataObject.getString(DATE_KEY));
            dataItem.setOutlet_name(dataObject.getString(OUTLET_NAME_KEY));
            dataItem.setOutlet_id(dataObject.getInt(OUTLET_ID_KEY));
            dataItem.setNote(dataObject.getString(NOTE_KEY));
            data.add(dataItem);
        }

        watNote.setMeta(meta);
        watNote.setData(data);

        return watNote;
    }
}
