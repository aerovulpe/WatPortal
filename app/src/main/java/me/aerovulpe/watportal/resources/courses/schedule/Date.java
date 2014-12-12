
package me.aerovulpe.watportal.resources.courses.schedule;

public class Date{
   	private String end_date;
   	private String end_time;
   	private boolean is_cancelled;
   	private boolean is_closed;
   	private boolean is_tba;
   	private String start_date;
   	private String start_time;
   	private String weekdays;

 	public String getEnd_date(){
		return this.end_date;
	}
	public void setEnd_date(String end_date){
		this.end_date = end_date;
	}
 	public String getEnd_time(){
		return this.end_time;
	}
	public void setEnd_time(String end_time){
		this.end_time = end_time;
	}
 	public boolean getIs_cancelled(){
		return this.is_cancelled;
	}
	public void setIs_cancelled(boolean is_cancelled){
		this.is_cancelled = is_cancelled;
	}
 	public boolean getIs_closed(){
		return this.is_closed;
	}
	public void setIs_closed(boolean is_closed){
		this.is_closed = is_closed;
	}
 	public boolean getIs_tba(){
		return this.is_tba;
	}
	public void setIs_tba(boolean is_tba){
		this.is_tba = is_tba;
	}
 	public String getStart_date(){
		return this.start_date;
	}
	public void setStart_date(String start_date){
		this.start_date = start_date;
	}
 	public String getStart_time(){
		return this.start_time;
	}
	public void setStart_time(String start_time){
		this.start_time = start_time;
	}
 	public String getWeekdays(){
		return this.weekdays;
	}
	public void setWeekdays(String weekdays){
		this.weekdays = weekdays;
	}
}
