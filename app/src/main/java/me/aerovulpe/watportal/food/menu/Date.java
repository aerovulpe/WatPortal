
package me.aerovulpe.watportal.food.menu;

public class Date{
   	private String end;
   	private String start;
   	private int week;
   	private int year;

 	public String getEnd(){
		return this.end;
	}
	public void setEnd(String end){
		this.end = end;
	}
 	public String getStart(){
		return this.start;
	}
	public void setStart(String start){
		this.start = start;
	}
 	public int getWeek(){
		return this.week;
	}
	public void setWeek(int week){
		this.week = week;
	}
 	public int getYear(){
		return this.year;
	}
	public void setYear(int year){
		this.year = year;
	}

    @Override
    public String toString() {
        return "Date{" +
                "end='" + end + '\'' +
                ", start='" + start + '\'' +
                ", week=" + week +
                ", year=" + year +
                '}';
    }
}
