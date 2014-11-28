
package me.aerovulpe.watportal.food.watcard;

import java.util.List;

import me.aerovulpe.watportal.rawdata.Meta;

public class WatCard{
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
           private String address;
           private double latitude;
           private String logo;
           private double longitude;
           private String phone_number;
           private int vendor_id;
           private String vendor_name;

         public String getAddress(){
            return this.address;
        }
        public void setAddress(String address){
            this.address = address;
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
         public String getPhone_number(){
            return this.phone_number;
        }
        public void setPhone_number(String phone_number){
            this.phone_number = phone_number;
        }
         public int getVendor_id(){
            return this.vendor_id;
        }
        public void setVendor_id(int vendor_id){
            this.vendor_id = vendor_id;
        }
         public String getVendor_name(){
            return this.vendor_name;
        }
        public void setVendor_name(String vendor_name){
            this.vendor_name = vendor_name;
        }
    }
}
