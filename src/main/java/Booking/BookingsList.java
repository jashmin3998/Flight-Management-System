package Booking;

public interface BookingsList {

	public BookingListIterator createBookingListIterator();
	
	public void addBooking(Booking booking);
}
