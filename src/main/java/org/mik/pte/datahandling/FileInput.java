package org.mik.pte.datahandling;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.pte.mik.Cars;
import org.pte.mik.HatchBackCars;
import org.pte.mik.RacingCars;
import org.pte.mik.SedanCars;
import org.pte.mik.SuvCars;
/**
 * File reader class. 
 * It reads cars from files existing  
 * @author Harita Lolla
 *
 */

public class FileInput implements DataInput {
	/**
	 * selector to to cars file
	 */
	
	public final static int CARS = 1;
	
	/**
	 * it is important if there are not only English characters in data file
	 */
	private final static String CHAR_SET="UTF-8"; //$NON-NLS-1$
	
	/**
	 * Delimiter field in file (CSV) 
	 */
	private final static String DELIMITER = ";"; //$NON-NLS-1$
	
	private String pathOfCars;
	
	private List<Cars> cars = new ArrayList<>();
	
	public FileInput(String pathOfCars) {
		this.pathOfCars=pathOfCars;
		
	}
	
	/**
	 * try to read cars from file
	 * @return list of cars or empty list
	 */

	@Override
	public List<Cars> carsInput() throws Exception {
		try(InputStream ins=getClass().getResourceAsStream(this.pathOfCars)) {
			fromFile(ins, CARS);
		return this.cars;
	}

}

	private void fromFile(InputStream ins, int what) throws Exception {
		try (Scanner fileScanner = new Scanner(ins, CHAR_SET)) {
			String line;
			while(fileScanner.hasNextLine()) {
				line = fileScanner.nextLine();
				splitLine(line, what);
			}
		}
	}
	
	/**
	 * split a line and creates a new car object
	 * @param line input line from file
	 * @throws Exception if any error
	 */

	private void splitLine(String line, int what) throws Exception {
		String temps[] = line.split(DELIMITER);
		String name=temps[0];
		int price, doors, maxSpeed,releaseYear;
		Float fuelUsage,mileage;
		price= Integer.parseInt(temps[1]);
		doors= Integer.parseInt(temps[2]);
		maxSpeed= Integer.parseInt(temps[3]);
		releaseYear= Integer.parseInt(temps[6]);
		fuelUsage = Float.parseFloat(temps[4]);
		mileage = Float.parseFloat(temps[5]);
		
		if(Integer.parseInt(temps[7])==01) {
			mileage=45.3f;
			
			this.cars.add(new RacingCars(name, price, doors, maxSpeed, fuelUsage, mileage, releaseYear));
			return;
		}
		if(Integer.parseInt(temps[7])==02) {
			mileage=30f;
			
			this.cars.add(new HatchBackCars(name, price, doors, maxSpeed, fuelUsage, mileage, releaseYear));
			return;
		}
		if(Integer.parseInt(temps[7])==03) {
			mileage=36.9f;
			
			this.cars.add(new SedanCars(name, price, doors, maxSpeed, fuelUsage, mileage, releaseYear));
			return;
		}
		if(Integer.parseInt(temps[7])==04) {
			mileage=28.3f;
			
			this.cars.add(new SuvCars(name, price, doors, maxSpeed, fuelUsage, mileage, releaseYear));
			return;
		}
		
	
		return;
	}
	
	/**
	 * creates a date object from year,month and day fields
	 * @param year 
	 * @param month
	 * @param day
	 * @return a Date object
	 */
	
}
