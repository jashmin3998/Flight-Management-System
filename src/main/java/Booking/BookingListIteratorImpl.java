package Booking;

import java.util.List;

public class BookingListIteratorImpl implements BookingListIterator{
	
	private List<Booking> bookingList;
	private int current;
	private int max;
	
	public BookingListIteratorImpl(List<Booking> bookingList) {
		// TODO Auto-generated constructor stub
		this.bookingList = bookingList;
		this.current = 0;
		this.max = bookingList.size();
	}

	@Override
	public Booking next() {
		// TODO Auto-generated method stub
		
		if(hasNext()) {
			Booking b = bookingList.get(current);
			current++;
			return b;
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return current < max;
	}

}
