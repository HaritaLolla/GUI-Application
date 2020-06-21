package collections;

public class Car {
	
	private String name;
	private String category;
	private int price;
	private int realeaseYear;
	
	public Car(String name, String category,int price,int releaseYear) {
		this.name=name;
		this.category=category;
		this.price=price;
		this.realeaseYear=releaseYear;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category=category;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public int getReleaseYear() {
		return this.realeaseYear;
	}
	
	public void setReleaseYear(int releaseYear) {
		this.realeaseYear=releaseYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + realeaseYear;
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
		Car other = (Car) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (realeaseYear != other.realeaseYear)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuffer("Cars:").append(this.name).append("; ")
				.append("Category:").append(this.category).append("; ")
				.append("Price:").append(this.price).append("€").append("; ")
				.append("Year:").append(this.realeaseYear).toString();
	}
	
	

}
