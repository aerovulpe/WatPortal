
package me.aerovulpe.watportal.food.diets;

import java.util.List;

import me.aerovulpe.watportal.Meta;
import me.aerovulpe.watportal.WatObject;

public class WatDiet implements WatObject{
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
    }
}
