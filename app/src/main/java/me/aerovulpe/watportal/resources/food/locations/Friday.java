
package me.aerovulpe.watportal.resources.food.locations;

public class Friday{
   	private String closing_hour;
   	private boolean is_closed;
   	private String opening_hour;

 	public String getClosing_hour(){
		return this.closing_hour;
	}
	public void setClosing_hour(String closing_hour){
		this.closing_hour = closing_hour;
	}
 	public boolean getIs_closed(){
		return this.is_closed;
	}
	public void setIs_closed(boolean is_closed){
		this.is_closed = is_closed;
	}
 	public String getOpening_hour(){
		return this.opening_hour;
	}
	public void setOpening_hour(String opening_hour){
		this.opening_hour = opening_hour;
	}
}
