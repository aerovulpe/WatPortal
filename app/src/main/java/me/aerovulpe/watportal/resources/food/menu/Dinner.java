
package me.aerovulpe.watportal.resources.food.menu;

public class Dinner{
   	private String diet_type;
   	private int product_id;
   	private String product_name;

 	public String getDiet_type(){
		return this.diet_type;
	}
	public void setDiet_type(String diet_type){
		this.diet_type = diet_type;
	}
 	public int getProduct_id(){
		return this.product_id;
	}
    public void setProduct_id(Integer product_id) {
        if (product_id != null)
            this.product_id = product_id;
    }
 	public String getProduct_name(){
		return this.product_name;
	}
	public void setProduct_name(String product_name){
		this.product_name = product_name;
	}

    @Override
    public String toString() {
        return "Dinner{" +
                "diet_type='" + diet_type + '\'' +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}
