
package me.aerovulpe.watportal.resources.food.outlets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.aerovulpe.watportal.constants.WatObject;
import me.aerovulpe.watportal.resources.Meta;
import static me.aerovulpe.watportal.constants.Constants.*;

public class WatOutlet implements WatObject{
   	private List<Data> data;
   	private Meta meta;

 	public List<Data> getData(){
		return this.data;
	}
	public void setData(List<Data> data){
		this.data = data;
	}
 	public Meta getMeta(){
		return this.meta;
	}
	public void setMeta(Meta meta){
		this.meta = meta;
	}

    public static class Data{
           private boolean has_breakfast;
           private boolean has_dinner;
           private boolean has_lunch;
           private int outlet_id;
           private String outlet_name;

         public boolean getHas_breakfast(){
            return this.has_breakfast;
        }
        public void setHas_breakfast(boolean has_breakfast){
            this.has_breakfast = has_breakfast;
        }
         public boolean getHas_dinner(){
            return this.has_dinner;
        }
        public void setHas_dinner(boolean has_dinner){
            this.has_dinner = has_dinner;
        }
         public boolean getHas_lunch(){
            return this.has_lunch;
        }
        public void setHas_lunch(boolean has_lunch){
            this.has_lunch = has_lunch;
        }
         public int getOutlet_id(){
            return this.outlet_id;
        }
        public void setOutlet_id(int outlet_id){
            this.outlet_id = outlet_id;
        }
         public String getOutlet_name(){
            return this.outlet_name;
        }
        public void setOutlet_name(String outlet_name){
            this.outlet_name = outlet_name;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "has_breakfast=" + has_breakfast +
                    ", has_dinner=" + has_dinner +
                    ", has_lunch=" + has_lunch +
                    ", outlet_id=" + outlet_id +
                    ", outlet_name='" + outlet_name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatOutlet{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatOutlet parse(Meta meta, JSONArray dataArray) throws JSONException{
        WatOutlet watOutlet = new WatOutlet();

        List<Data> data = new ArrayList<Data>();
        for (int i = 0; i < dataArray.length(); i++){
            JSONObject dataObject = dataArray.getJSONObject(i);
            Data dataItem = new Data();
            dataItem.setOutlet_id(dataObject.getInt(OUTLET_ID_KEY));
            dataItem.setOutlet_name(dataObject.getString(OUTLET_NAME_KEY));
            dataItem.setHas_breakfast((dataObject.getInt(HAS_BREAKFAST_KEY) == 1) ? true : false);
            dataItem.setHas_lunch((dataObject.getInt(HAS_LUNCH_KEY) == 1) ? true : false);
            dataItem.setHas_dinner((dataObject.getInt(HAS_DINNER_KEY) == 1) ? true : false);
            data.add(dataItem);
        }

        watOutlet.setMeta(meta);
        watOutlet.setData(data);

        return watOutlet;
    }
}
