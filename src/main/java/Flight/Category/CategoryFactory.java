package Flight.Category;

public class CategoryFactory {
	
	public static Category getInstance(String categoryName, int availableSeats, int price) {
		
		switch(categoryName) {
		
		case "Business":
			return new Business(availableSeats, price);
			
		case "Premium Economy":
			 return new PremiumEconomy(availableSeats, price);
			
		case "Economy":
			return new Economy(availableSeats, price);
		}
		
		return null;
	}

}
