
package me.aerovulpe.watportal.resources.food.notes;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import me.aerovulpe.watportal.resources.Meta;

import static me.aerovulpe.watportal.constants.Constants.DATE_FORMAT;

public class WatNote{
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
           private Date date;
           private String note;
           private int outlet_id;
           private String outlet_name;

         public Date getDate(){
            return this.date;
        }
        public void setDate(String date){
            try {
                this.date = DATE_FORMAT.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
         public String getNote(){
            return this.note;
        }
        public void setNote(String note){
            this.note = note;
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
