
package me.aerovulpe.watportal.food.announcements;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import me.aerovulpe.watportal.rawdata.Meta;
import me.aerovulpe.watportal.constants.WatObject;

import static me.aerovulpe.watportal.constants.Constants.DATE_FORMAT;

public class WatAnnouncement implements WatObject{
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
           private String ad_text;
           private Date date;

         public String getAd_text(){
            return this.ad_text;
        }
        public void setAd_text(String ad_text){
            this.ad_text = ad_text;
        }
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
    }
}
