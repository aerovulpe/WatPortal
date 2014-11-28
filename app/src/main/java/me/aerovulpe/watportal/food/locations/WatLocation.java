
package me.aerovulpe.watportal.food.locations;

import java.util.Date;
import java.util.List;

import me.aerovulpe.watportal.rawdata.Meta;
import me.aerovulpe.watportal.constants.WatObject;

public class WatLocation implements WatObject{
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
           private Additional additional;
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

         public Additional getAdditional(){
            return this.additional;
        }
        public void setAdditional(Additional additional){
            this.additional = additional;
        }
         public String getBuilding(){
            return this.building;
        }
        public void setBuilding(String building){
            this.building = building;
        }
         public List<Date> getDates_closed(){
            return this.dates_closed;
        }
        public void setDates_closed(List<Date> dates_closed){
            this.dates_closed = dates_closed;
        }
         public String getDescription(){
            return this.description;
        }
        public void setDescription(String description){
            this.description = description;
        }
         public boolean getIs_open_now(){
            return this.is_open_now;
        }
        public void setIs_open_now(boolean is_open_now){
            this.is_open_now = is_open_now;
        }
         public double getLatitude(){
            return this.latitude;
        }
        public void setLatitude(double latitude){
            this.latitude = latitude;
        }
         public String getLogo(){
            return this.logo;
        }
        public void setLogo(String logo){
            this.logo = logo;
        }
         public double getLongitude(){
            return this.longitude;
        }
        public void setLongitude(double longitude){
            this.longitude = longitude;
        }
         public String getNotice(){
            return this.notice;
        }
        public void setNotice(String notice){
            this.notice = notice;
        }
         public Opening_hours getOpening_hours(){
            return this.opening_hours;
        }
        public void setOpening_hours(Opening_hours opening_hours){
            this.opening_hours = opening_hours;
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
         public List<Special_hours> getSpecial_hours(){
            return this.special_hours;
        }
        public void setSpecial_hours(List<Special_hours> special_hours){
            this.special_hours = special_hours;
        }
    }
}
