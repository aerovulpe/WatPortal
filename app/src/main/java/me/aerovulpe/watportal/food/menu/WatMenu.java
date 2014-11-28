
package me.aerovulpe.watportal.food.menu;

import java.util.List;

import me.aerovulpe.watportal.Meta;
import me.aerovulpe.watportal.WatObject;

public class WatMenu implements WatObject{
   	private Data data;
   	private Meta meta;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
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
           private List<Outlet> outlets;

         public Date getDate(){
            return this.date;
        }
        public void setDate(Date date){
            this.date = date;
        }
         public List<Outlet> getOutlets(){
            return this.outlets;
        }
        public void setOutlets(List<Outlet> outlets){
            this.outlets = outlets;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "date=" + date +
                    ", outlets=" + outlets +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WatMenu{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }
}
