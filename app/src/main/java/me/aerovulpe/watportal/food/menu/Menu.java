
package me.aerovulpe.watportal.food.menu;

public class Menu{
   	private String date;
   	private String day;
   	private Meals meals;
   	private String notes;

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
 	public Meals getMeals(){
		return this.meals;
	}
	public void setMeals(Meals meals){
		this.meals = meals;
	}
 	public String getNotes(){
		return this.notes;
	}
	public void setNotes(String notes){
		this.notes = notes;
	}

    @Override
    public String toString() {
        return "Menu{" +
                "date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", meals=" + meals +
                ", notes='" + notes + '\'' +
                '}';
    }
}
