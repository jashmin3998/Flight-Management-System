import static org.junit.Assert.*;

import org.junit.Test;

import Booking.Booking;
import Booking.BookingListImpl;
import Booking.BookingListIterator;
import Booking.BookingsList;

public class IteratorDesignPatternTestCase {

	@Test
	public void test() {
		
		BookingsList bookingList = BookingListImpl.getBookingListInstance();
		Booking b = new Booking("ABC123", "ABC", "Economy", 1, "1234567890123");
		bookingList.addBooking(b);
		
		BookingListIterator iterator= bookingList.createBookingListIterator();
		
		assertEquals(b, iterator.next());
		
	}
}
