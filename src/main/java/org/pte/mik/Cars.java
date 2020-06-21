package org.pte.mik;

import java.util.ArrayList;
import java.util.List;
/**
 * @author HARITA LOLLA
 * Abstract Car Class
 *
 */
public abstract class Cars
{
	private String name;
	private int price;
	private int doors;
	private int maxSpeed;
	private float fuelUsage;
	private float mileage;
	private int releaseYear;
	private List<Cars> cars=new ArrayList<>();

	public Cars(String name,int price,int doors,int maxSpeed,
			float fuelUsage,float mileage,int releaseYear ) 
	{
		this.name=name;		
		this.price=price;
		this.doors=doors;
		this.maxSpeed=maxSpeed;
		this.fuelUsage=fuelUsage;
		this.mileage=mileage;
		this.releaseYear=releaseYear;
	}
	
	/**
	 * @return String
	 */
	abstract public float fuelUsage();
	abstract public float mileage();
	/**
	 * Set values
	 */
	public void setName(String newVar) {
		this.name=newVar;
	}
	public void setPrice(int newVar) {
		this.price=newVar;
	}
	public void setDoors(int newVar) {
		this.doors=newVar;
	}
	public void setMaxSpeed(int newVar) {
		this.maxSpeed=newVar;
	}
	public void setFuelUsage(int newVar) {
		this.fuelUsage=newVar;
	}
	public void setMileage(int newVar) {
		this.mileage=newVar;
	}
	public void setReleaseDate(int newVar) {
		this.releaseYear=newVar;
	}
	/**
	 * 
	 * @return all the values 
	 */
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public int getDoors() {
		return this.doors;
	}
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	public float getFuelUsage() {
		return this.fuelUsage;
	}
	public float getMileage() {
		return this.mileage;
	}
	public int getReleaseYear() {
		return this.releaseYear;
	}
	
	/**
	 * getting the list of cars
	 * @return cars
	 */

	public List<Cars> getCars(){
		return this.cars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + doors;
		result = prime * result + Float.floatToIntBits(fuelUsage);
		result = prime * result + maxSpeed;
		result = prime * result + Float.floatToIntBits(mileage);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + releaseYear;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cars other = (Cars) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (doors != other.doors)
			return false;
		if (Float.floatToIntBits(fuelUsage) != Float.floatToIntBits(other.fuelUsage))
			return false;
		if (maxSpeed != other.maxSpeed)
			return false;
		if (Float.floatToIntBits(mileage) != Float.floatToIntBits(other.mileage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cars [name=" + name + ", price=" + price + ", doors=" + doors + ", maxSpeed=" + maxSpeed
				+ ", fuelUsage=" + fuelUsage + ", mileage=" + mileage + ", releaseYear=" + releaseYear + ", cars="
				+ cars + "]";
	}
	

}
