package Flight;

import java.util.*;

import Flight.Category.Category;

public class Flight {

	String flightNumber;
	String arrivalCity;
	String departureCity;
	Map<String, Category> category = null;
	
	public Flight(String flightNumber, String arrivalCity, String departureCity, Category category) {
		// TODO Auto-generated constructor stub
		
		this.flightNumber = flightNumber;
		this.arrivalCity = arrivalCity;
		this.departureCity = departureCity;
		if(this.category == null) {
			this.category = new HashMap<>();
		}
		if(!this.category.containsKey(category.getCategoryName())) {
			this.category.put(category.getCategoryName(), category);
		}
	}
	
	public void addCategory(Category category) {
		
		if(category != null) {
			if(!this.category.containsKey(category.getCategoryName())) {
				this.category.put(category.getCategoryName(), category);
			}
		}
	}
	
	public Map<String, Category> getCategoryMap(){
		return this.category;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res = "";
		res += arrivalCity + " ";
		res += departureCity + " ";
		
		for(Map.Entry<String, Category> map : category.entrySet()) {
			
			Category c  = map.getValue();
			res += c.getCategoryName() + " " + c.getAvaiableSeats() + " " + c.getPrice();
		}
		
		return res;
	}
	
	
}
