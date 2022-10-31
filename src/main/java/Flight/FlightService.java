package Flight;

import java.util.HashMap;
import java.util.Map;
import Flight.Category.Category;
import Flight.Category.CategoryFactory;

public class FlightService {
	
	private static FlightService flightService = new FlightService();
	private static Map<String, Flight> flightsMap = new HashMap<>();
	
	private FlightService() {
		
	}
	
	public static FlightService getFlightServiceObject() {
		return flightService;
	}
	
	public void addFlight(String flightNumber, String arrivalCity, String departureCity, String categoryName, int availableSeats, int price ) {
		
		Category category = CategoryFactory.getInstance(categoryName, availableSeats, price);
		
		if(!flightsMap.containsKey(flightNumber)) {
			flightsMap.put(flightNumber, new Flight(flightNumber, arrivalCity, departureCity, category));
		}
		else {
			flightsMap.get(flightNumber).addCategory(category);;
			
		}
		
	}
	
	public Flight getFlight(String flightNumber) {
		
		if(flightsMap.containsKey(flightNumber)) {
			return flightsMap.get(flightNumber);
		}
		return null;
		
	}
	
}
