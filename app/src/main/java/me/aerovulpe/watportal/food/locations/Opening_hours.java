
package me.aerovulpe.watportal.food.locations;

import java.util.List;

public class Opening_hours{
   	private Friday friday;
   	private Monday monday;
   	private Saturday saturday;
   	private Sunday sunday;
   	private Thursday thursday;
   	private Tuesday tuesday;
   	private Wednesday wednesday;

 	public Friday getFriday(){
		return this.friday;
	}
	public void setFriday(Friday friday){
		this.friday = friday;
	}
 	public Monday getMonday(){
		return this.monday;
	}
	public void setMonday(Monday monday){
		this.monday = monday;
	}
 	public Saturday getSaturday(){
		return this.saturday;
	}
	public void setSaturday(Saturday saturday){
		this.saturday = saturday;
	}
 	public Sunday getSunday(){
		return this.sunday;
	}
	public void setSunday(Sunday sunday){
		this.sunday = sunday;
	}
 	public Thursday getThursday(){
		return this.thursday;
	}
	public void setThursday(Thursday thursday){
		this.thursday = thursday;
	}
 	public Tuesday getTuesday(){
		return this.tuesday;
	}
	public void setTuesday(Tuesday tuesday){
		this.tuesday = tuesday;
	}
 	public Wednesday getWednesday(){
		return this.wednesday;
	}
	public void setWednesday(Wednesday wednesday){
		this.wednesday = wednesday;
	}
}
