package Booking;

public class Booking {
	
	private String flightNumber;
	private String bookingName;
	private String categoryName;
	private int noOfSeats;
	private String cardNumber;
	
	public Booking(String flightNumber, String bookingName, String categoryName, int noOfSeats, String cardNumber) {
		
		this.flightNumber = flightNumber;
		this.bookingName = bookingName;
		this.categoryName = categoryName;
		this.noOfSeats = noOfSeats;
		this.cardNumber = cardNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getBookingName() {
		return bookingName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res = "";
		res += this.flightNumber + " ";
		res += this.bookingName + " ";
		res += this.categoryName + " ";
		res += this.noOfSeats + " ";
		res += this.cardNumber;
		
		return res;
	}
	

}
