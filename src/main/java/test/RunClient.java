package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Booking.Booking;
import Booking.BookingListImpl;
import Booking.BookingListIterator;
import Booking.BookingsList;
import Flight.Flight;
import Flight.FlightService;
import Flight.Category.Category;
import Output.OutputWriter;
import Output.OutputWriterFactory;


public class RunClient {
	
	private static FlightService flightService;
	private static BookingsList bookingList;
	private static List<String> outputResult;
	private static List<String> outputError;
	
	public static void main(String[] args) throws IOException {
		
		flightService = FlightService.getFlightServiceObject();
		bookingList = BookingListImpl.getBookingListInstance();
		
		outputResult = new ArrayList<>();
		outputError = new ArrayList<>();
		
		BufferedReader flightsReader = new BufferedReader(new FileReader(args[1]));
		BufferedReader bookingReader = new BufferedReader(new FileReader(args[0]));
		
		flightsReader.readLine();
		bookingReader.readLine();
		
		String line = "";

		while((line = flightsReader.readLine()) != null) {
			String[] temp = line.split(",");
			addFlight(temp);
		}
		
		while((line = bookingReader.readLine()) != null) {
			String[] temp = line.split(",");
			addBooking(temp);
		}
		
		BookingListIterator iterator = bookingList.createBookingListIterator();
		
		while(iterator.hasNext()) {
			Booking b = iterator.next();
			validateBooking(b);
		}

		String columnName = "Booking Name, Flight Number, Category, Number of Seats, Total Price \n";
		
		OutputWriter outputWriter = OutputWriterFactory.getOutputWriter(args[2], columnName, outputResult);
		outputWriter.write();
		
		outputWriter = OutputWriterFactory.getOutputWriter(args[3], "", outputError);
		outputWriter.write();
		
		flightsReader.close();
		bookingReader.close();
		
	}
	
	private static void addFlight(String[] temp) {
		
		String categoryName = temp[0];
		String flightNumber = temp[1];
		int availableSeats = Integer.parseInt(temp[2]);
		int price = Integer.parseInt(temp[3]);
		String arrivalCity = temp[4];
		String departureCity = temp[5];
		
		flightService.addFlight(flightNumber, arrivalCity, departureCity, categoryName, availableSeats, price);
		
	}
	
	private static void addBooking(String[] temp) {
		
		String bookingName = temp[0];
		String flightNumber = temp[1];
		String categoryName = temp[2];
		int noOfSeats = Integer.parseInt(temp[3]);
		String cardNumber = temp[4];
		
		bookingList.addBooking(new Booking(flightNumber, bookingName, categoryName, noOfSeats, cardNumber));
			
	}
	
	private static void validateBooking(Booking b){
		
		String flightNumber = b.getFlightNumber();
		Flight f = flightService.getFlight(flightNumber);
		
		if(f==null) {
			outputError.add("Please Enter correct Booking Details for " + b.getBookingName() +": invalid Flight Number \n");
			return;
		}
		if(!f.getCategoryMap().containsKey(b.getCategoryName())) {
			outputError.add("Please Enter correct Booking Details for " + b.getBookingName() +": invalid Category Name \n");
			return;
		}
		
		Category c =  f.getCategoryMap().get(b.getCategoryName());
		
		boolean validCard = false;
		
		if(c.getAvaiableSeats() >= b.getNoOfSeats()) {
			
			String cardNumber = b.getCardNumber();
			if(cardNumber.length() == 15) {
				
				if(cardNumber.startsWith("3")) {
					if(cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7' ) {		
						validCard = true;
					}
				}
			}
			if(cardNumber.length()== 13 || cardNumber.length() == 16) {
				if(cardNumber.startsWith("4")) {
					validCard = true;
				}	
			}
			if(cardNumber.length() == 16) {
				
				if(cardNumber.startsWith("4")) {
					validCard = true;
				}
				if(cardNumber.startsWith("5")) {
					if(cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5') {
						validCard = true;
					}
				}
				if(cardNumber.startsWith("6011")) {
					validCard = true;
				}	
			}
			if(validCard) {
				String row = b.getBookingName() + "," + b.getFlightNumber() + "," + b.getCategoryName() + "," + String.valueOf(b.getNoOfSeats()) + "," + String.valueOf(b.getNoOfSeats()*c.getPrice() +"\n");
				outputResult.add(row);
				c.setAvaiableSeats(c.getAvaiableSeats() - b.getNoOfSeats());
			}
			else {
				outputError.add("Please Enter correct booking details for "+ b.getBookingName() + ": invalid card number \n");
			}
		}
		else {
			outputError.add("Please Enter correct booking details for "+ b.getBookingName() + ": No Empty Seats \n");
		}
		
	}
	
}
