
package me.aerovulpe.watportal.resources.food.menu;

import java.util.List;

public class Meals{
   	private List<Dinner> dinners;
   	private List<Lunch> lunches;

 	public List<Dinner> getDinners(){
		return this.dinners;
	}
	public void setDinners(List<Dinner> dinners){
		this.dinners = dinners;
	}
 	public List<Lunch> getLunches(){
		return this.lunches;
	}
	public void setLunches(List<Lunch> lunches){
		this.lunches = lunches;
	}

    @Override
    public String toString() {
        return "Meals{" +
                "dinners=" + dinners +
                ", lunches=" + lunches +
                '}';
    }
}
