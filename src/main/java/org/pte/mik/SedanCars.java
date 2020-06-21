/**
 * 
 */
package org.pte.mik;

/**
 * @author HARITA LOLLA
 *
 */
public class SedanCars extends Cars {

	/**
	 * 
	 */
	public SedanCars(String name,int price,int doors,int maxSpeed,
			float fuelUsage,float mileage,int releaseYear) {
		super(name,price,doors,maxSpeed,fuelUsage,mileage,releaseYear);
	}

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
