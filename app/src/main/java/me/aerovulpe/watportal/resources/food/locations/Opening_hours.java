
package me.aerovulpe.watportal.resources.food.locations;

public class Opening_hours{
    private Day sunday;
   	private Day monday;
    private Day tuesday;
    private Day wednesday;
   	private Day thursday;
    private Day friday;
    private Day saturday;

    public Opening_hours(Day sunday, Day monday, Day tuesday, Day wednesday, Day thursday, Day friday, Day saturday) {
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public Day getFriday(){
		return this.friday;
	}
	public void setFriday(Day friday){
		this.friday = friday;
	}
 	public Day getMonday(){
		return this.monday;
	}
	public void setMonday(Day monday){
		this.monday = monday;
	}
 	public Day getSaturday(){
		return this.saturday;
	}
	public void setSaturday(Day saturday){
		this.saturday = saturday;
	}
 	public Day getSunday(){
		return this.sunday;
	}
	public void setSunday(Day sunday){
		this.sunday = sunday;
	}
 	public Day getThursday(){
		return this.thursday;
	}
	public void setThursday(Day thursday){
		this.thursday = thursday;
	}
 	public Day getTuesday(){
		return this.tuesday;
	}
	public void setTuesday(Day tuesday){
		this.tuesday = tuesday;
	}
 	public Day getWednesday(){
		return this.wednesday;
	}
	public void setWednesday(Day wednesday){
		this.wednesday = wednesday;
	}

    @Override
    public String toString() {
        return "Opening_hours{" +
                "sunday=" + sunday +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                '}';
    }
}
