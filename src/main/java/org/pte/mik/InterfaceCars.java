package org.pte.mik;
import java.util.List;
/**
 * Characteristics of the cars
 * @author Harita Lolla
 *
 */

public interface InterfaceCars {
	
	/**
	 * @category of the cars
	 * @param cars
	 */
	boolean isSuv();
	
	boolean isSedan();
	
	boolean isRacing();
	
	boolean isHatchBack();
	
	/**
	 * get the amount of fuel consumed
	 * @return fuelUsage
	 */
	float getFuelUsage();
	
	/**
	 * get the mileage of the car
	 * @return mileage
	 */
	float getMileage();
	
	/**
	 * get the name of car
	 * @return name
	 */
	String getName();
	
	/**
	 * get the price of car
	 * @return price
	 */
	float getPrice();
	
	/**
	 * get the number of doors for the car
	 * @return doors
	 */
	int getDoors();
	
	/**
	 * get the 4WD
	 * @return 4WD
	 */
	boolean is4WD();
	
	/**
	 * get the cars list
	 * @return the cars
	 */
	List<Cars> getCars();
}
