import static org.junit.Assert.*;

import org.junit.Test;

import Flight.FlightService;

public class SingletonDesignPatternTestCase {

	@Test
	public void test() {
		
		FlightService flightService1 = FlightService.getFlightServiceObject();
		FlightService flightService2 = FlightService.getFlightServiceObject();
		
		assertEquals(true, flightService1.equals(flightService2));
		
	}

}
