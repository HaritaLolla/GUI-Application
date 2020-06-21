/**
 * 
 */
package org.pte.mik;

/**
 * @author HARITA LOLLA
 *
 */
public class HatchBackCars extends Cars {

	/**
	 * 
	 */
	public HatchBackCars(String name,int price,int doors,int maxSpeed,
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

	@Override
	public String toString() {
		return "HatchBackCars [getName()=" + getName() + ", getPrice()=" + getPrice() + ", getDoors()=" + getDoors()
				+ ", getMaxSpeed()=" + getMaxSpeed() + ", getFuelUsage()=" + getFuelUsage() + ", getMileage()="
				+ getMileage() + ", getReleaseYear()=" + getReleaseYear() + ", getCars()=" + getCars() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}	
	
}
