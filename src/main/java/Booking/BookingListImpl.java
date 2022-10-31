package Booking;

import java.util.*;

public class BookingListImpl implements BookingsList{
	
	private List<Booking> bookingList = new ArrayList<>();
	private static BookingListImpl bookingListImpl = new BookingListImpl();
	
	private BookingListImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static BookingListImpl getBookingListInstance() {
		return bookingListImpl;
	}
	
	
	@Override
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingList.add(booking);
		
	}
	

	@Override
	public BookingListIterator createBookingListIterator() {
		// TODO Auto-generated method stub
		return new BookingListIteratorImpl(bookingList);
	}



}
