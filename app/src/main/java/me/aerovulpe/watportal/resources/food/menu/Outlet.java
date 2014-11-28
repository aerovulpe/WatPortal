
package me.aerovulpe.watportal.resources.food.menu;

import java.util.List;

public class Outlet {
   	private List<Menu> menus;
   	private int outlet_id;
   	private String outlet_name;

 	public List<Menu> getMenus(){
		return this.menus;
	}
	public void setMenus(List<Menu> menus){
		this.menus = menus;
	}
 	public int getOutlet_id(){
		return this.outlet_id;
	}
	public void setOutlet_id(int outlet_id){
		this.outlet_id = outlet_id;
	}
 	public String getOutlet_name(){
		return this.outlet_name;
	}
	public void setOutlet_name(String outlet_name){
		this.outlet_name = outlet_name;
	}

    @Override
    public String toString() {
        return "Outlet{" +
                "menus=" + menus +
                ", outlet_id=" + outlet_id +
                ", outlet_name='" + outlet_name + '\'' +
                '}';
    }
}
