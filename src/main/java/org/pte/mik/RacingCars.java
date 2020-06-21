/**
 * 
 */
package org.pte.mik;

/**
 * @author HARITA LOLLA
 *
 */
public class RacingCars extends Cars {

	/**
	 * 
	 */
	public RacingCars(String name,int price,int doors,int maxSpeed,
			float fuelUsage,float mileage,int releaseYear) {
		super(name,price,doors,maxSpeed,fuelUsage,mileage,releaseYear);
	}

	/**
	 * @param args
	 */
	@Override
	public float fuelUsage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float mileage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
