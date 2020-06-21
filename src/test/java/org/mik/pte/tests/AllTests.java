package org.mik.pte.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mik.pte.datahandling.DataInput;
import org.mik.pte.datahandling.FileInput;
import org.pte.mik.Cars;

public class AllTests {

	private List<Cars> cars = new ArrayList<>();


	private final static String CARNAME = "Ferrari 599 GTB"; //$NON-NLS-1$s
	private final static int PRICE = 197418;//$NON-NLS-1$
	private final static int DOORS = 2;
	private final static int MAXSPEED = 330;
	private final static int FUEL_USAGE = 9;
	private final static int RELEASE_YEAR  =2015;
	

	private final static String PATH_OF_CARS_FILE = "/org/mik/pte/data/cars.txt"; //$NON-NLS-1$

	@Before
	public void createCar() throws Exception {
		DataInput dataInput = new FileInput(PATH_OF_CARS_FILE);
		this.cars = dataInput.carsInput();
	}

	@Test
	public void test() {
		Cars car1;
		car1 = cars.get(0);

		assertNotNull(this.cars);
		assertTrue(car1.getPrice() == PRICE);
		assertTrue(car1.getDoors() == DOORS);
		assertTrue(car1.getMaxSpeed() == MAXSPEED);
		assertTrue(car1.getFuelUsage() == FUEL_USAGE);
		assertTrue(car1.getReleaseYear() == RELEASE_YEAR);
		assertTrue(CARNAME.compareTo(car1.getName()) == 0);
	
	}

}
