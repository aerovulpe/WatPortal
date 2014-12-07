
package me.aerovulpe.watportal.resources.courses.schedule;

import java.util.List;

public class Classes{
   	private Date date;
   	private List<Instructors> instructors;
   	private Location location;

 	public Date getDate(){
		return this.date;
	}
	public void setDate(Date date){
		this.date = date;
	}
 	public List<Instructors> getInstructors(){
		return this.instructors;
	}
	public void setInstructors(List<Instructors> instructors){
		this.instructors = instructors;
	}
 	public Location getLocation(){
		return this.location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
}
