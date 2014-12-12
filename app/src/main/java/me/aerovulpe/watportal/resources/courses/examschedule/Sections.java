
package me.aerovulpe.watportal.resources.courses.examschedule;

public class Sections{
   	private String date;
   	private String day;
   	private String end_time;
   	private String location;
   	private String notes;
   	private String section;
   	private String start_time;

 	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date = date;
	}
 	public String getDay(){
		return this.day;
	}
	public void setDay(String day){
		this.day = day;
	}
 	public String getEnd_time(){
		return this.end_time;
	}
	public void setEnd_time(String end_time){
		this.end_time = end_time;
	}
 	public String getLocation(){
		return this.location;
	}
	public void setLocation(String location){
		this.location = location;
	}
 	public String getNotes(){
		return this.notes;
	}
	public void setNotes(String notes){
		this.notes = notes;
	}
 	public String getSection(){
		return this.section;
	}
	public void setSection(String section){
		this.section = section;
	}
 	public String getStart_time(){
		return this.start_time;
	}
	public void setStart_time(String start_time){
		this.start_time = start_time;
	}
}
