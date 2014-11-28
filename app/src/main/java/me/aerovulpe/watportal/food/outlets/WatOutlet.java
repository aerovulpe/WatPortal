
package me.aerovulpe.watportal.food.outlets;

import java.util.List;

import me.aerovulpe.watportal.Meta;

public class WatOutlet{
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
    }
}
