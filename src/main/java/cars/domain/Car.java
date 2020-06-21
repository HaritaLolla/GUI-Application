package cars.domain;
/**
 * @author HARITA LOLLA
 * 
 * car domain
 * inherits the id from the abstract domain
 */

import java.sql.ResultSet;

public class Car extends AbstractDomain {

	/**
	 * Default id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Name of each columns in database
	 *  
	 */

	public static final String COL_NAME = "name";
	public static final String COL_TYPE = "typeOfCar";
	public static final String COL_PRICE = "price";
	public static final String COL_DOORS = "doors";
	public static final String COL_MAX_SPEED = "max_speed";
	public static final String COL_Fuel_USAGE = "fuel_usage";
	public static final String COL_MILEAGE = "mileage";
	public static final String COL_RELEASE_YEAR = "release_year";
	
	/**
	 *  name of the car
	 */
	private String name;
	
	/**
	 *  price of the car
	 */
	private int price;
	
	/**
	 * the number of doors
	 */
	private int doors;
	
	/**
	 * the maximum speed of the car
	 */
	private int maxSpeed;
	
	/**
	 *  the fuel consumption of the car
	 */
	private int fuelUsage;
	
	/**
	 * the mileage of the car
	 */
	private int milege;
	
	/**
	 *  the release year of the car
	 */
	private int releaseYear;

	/**
	 * Default constructor (empty car)
	 */
	public Car() {
	}
	
	/**
	 * Constructor from database resultset.
	 * 
	 * @param rs
	 */
	public Car(ResultSet rs) {
		super(rs);
		try {
			this.name=rs.getString(rs.findColumn(COL_NAME));
			this.price=rs.getInt(rs.findColumn(COL_PRICE));
			this.doors=rs.getInt(rs.findColumn(COL_DOORS));
			this.maxSpeed=rs.getInt(rs.findColumn(COL_MAX_SPEED));
			this.fuelUsage=rs.getInt(rs.findColumn(COL_Fuel_USAGE));
			this.milege=rs.getInt(rs.findColumn(COL_MILEAGE));
			this.releaseYear=rs.getInt(rs.findColumn(COL_RELEASE_YEAR));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * getter for the name, price,maxSpeed,doors,Mileage,
	 *  fuelUsage and the release Year
	 * @return name
	 * @return price
	 * @return doors
	 * @return maxSpeed
	 * @return mileage
	 * @return fuelUsage
	 */
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	public int getDoors() {
		return doors;
	}
	public int getMaxSpped() {
		return maxSpeed;
	}
	public int getFuelUsage() {
		return fuelUsage;
	}
	public int getMileage() {
		return milege;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	
	/**
	 * Setter for name
	 * @param name
	 */
	
	public void setName(String name) {
		this.name=name;
	}
	
	/**
	 * Setter for price
	 * @param price
	 */
	public void setPrice(int price) {
		this.price=price;
	}
	
	/**
	 * Setter for doors
	 * @param doors
	 */
	public void setDoors(int doors) {
		this.doors=doors;
	}
	
	/**
	 * Setter for maxSpeed
	 * @param maxSpeed
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed=maxSpeed;
	}
	
	/**
	 * Setter for fuelUsage
	 * @param fuelUsage
	 */
	public void setFuel(int f) {
		this.fuelUsage=f;
	}
	
	/**
	 * Setter for mileage
	 * @param mileage
	 */
	public void setMileage(int mileage) {
		this.milege=mileage;
	}
	
	/**
	 * Setter for releaseYear
	 * @param releaseYear
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear=releaseYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + doors;
		result = prime * result + Float.floatToIntBits(fuelUsage);
		result = prime * result + maxSpeed;
		result = prime * result + Float.floatToIntBits(milege);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + releaseYear;
	//	result = prime * result + typeOfCar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (doors != other.doors)
			return false;
		if (Float.floatToIntBits(fuelUsage) != Float.floatToIntBits(other.fuelUsage))
			return false;
		if (maxSpeed != other.maxSpeed)
			return false;
		if (Float.floatToIntBits(milege) != Float.floatToIntBits(other.milege))
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
		return new StringBuffer("Car ") //$NON-NLS-1$
				.append(", name:").append(getName()) //$NON-NLS-1$
				.append(", price:").append(getPrice()) //$NON-NLS-1$
				.append(", doors:").append(getDoors()) //$NON-NLS-1$
				.append(", max Speed:").append(getMaxSpped()) //$NON-NLS-1$
				.append(", fuel Usage:").append(getFuelUsage()) //$NON-NLS-1$
				.append(", mileage:").append(getMileage()) //$NON-NLS-1$
				.append(", release Year:").append(getReleaseYear()) //$NON-NLS-1$
				.toString(); 
	}
	
	

}
