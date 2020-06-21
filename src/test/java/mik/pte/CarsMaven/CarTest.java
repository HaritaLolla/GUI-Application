package mik.pte.CarsMaven;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import cars.domain.Car;

/**
 * Unit test.
 */
public class CarTest 
    
{
	private final static String CARNAME = "Ferrari 599 GTB"; //$NON-NLS-1$s
	private final static int PRICE = 197418;//$NON-NLS-1$
	private final static int DOORS = 2;
	private final static int MAXSPEED = 330;
	private final static int FUEL_USAGE = 9;
	private final static int RELEASE_YEAR  =2015;
	private Object cars;
	
	   
	@Test
	public void test() {
	
		//car1 = ((Object) cars).get(0);

		assertNotNull(this.cars);
		assertTrue(((Car) cars).getPrice() == PRICE);
		assertTrue(((Car) cars).getDoors() == DOORS);
		assertTrue(((Car) cars).getMaxSpped() == MAXSPEED);
		assertTrue(((Car) cars).getFuelUsage() == FUEL_USAGE);
		assertTrue(((Car) cars).getReleaseYear() == RELEASE_YEAR);
		assertTrue(CARNAME.compareTo(((Car) cars).getName()) == 0);
	
	}

}
