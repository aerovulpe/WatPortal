
package me.aerovulpe.watportal.resources.food.diets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import me.aerovulpe.watportal.resources.Meta;
import me.aerovulpe.watportal.resources.WatObject;
import me.aerovulpe.watportal.resources.Resource;

import static me.aerovulpe.watportal.Constants.*;

public class WatDiet extends WatObject{
   	private List<Data> data;
   	private Meta meta;

    public WatDiet(){
       super(Resource.FOOD_DIETS);
    }

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
           private int diet_id;
           private String diet_type;

         public int getDiet_id(){
            return this.diet_id;
        }
        public void setDiet_id(int diet_id){
            this.diet_id = diet_id;
        }
         public String getDiet_type(){
            return this.diet_type;
        }
        public void setDiet_type(String diet_type){
            this.diet_type = diet_type;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "diet_id=" + diet_id +
                    ", diet_type='" + diet_type + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatDiet{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static WatDiet parse(Meta meta, JSONArray dataArray) throws JSONException{
        WatDiet watDiet = new WatDiet();

        List<WatDiet.Data> data = new ArrayList<WatDiet.Data>();
        for (int i = 0; i < dataArray.length(); i++){
            JSONObject dataObject = dataArray.getJSONObject(i);
            WatDiet.Data dataItem = new Data();
            dataItem.setDiet_id(dataObject.getInt(DIET_ID_KEY));
            dataItem.setDiet_type(dataObject.getString(DIET_TYPE_KEY));
            data.add(dataItem);
        }

        watDiet.setMeta(meta);
        watDiet.setData(data);

        return watDiet;
    }
}
