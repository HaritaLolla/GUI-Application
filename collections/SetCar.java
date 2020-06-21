package collections;

import java.util.HashSet;
import java.util.Set;

public class SetCar {
	
	private Set<Car> cars = new HashSet<>();
	
	public void fill() {
		this.cars.add(new Car("Porsche Cayenne S","Racing",2005463,2017));
		this.cars.add(new Car("Ferrari 599 GTB","Racing",205463,2015));
		this.cars.add(new Car("Land Rover","Suv",2005464,2016));
		this.cars.add(new Car("Swift","HatchBack",20054636,2010));
		this.cars.add(new Car("Tesla","Racing",20054634,2018));
		this.cars.add(new Car("McLaren","Racing",200543,2017));
		this.cars.add(new Car("Ford","HatchBack",200563,2016));
		this.cars.add(new Car("Mercedes","Sedan",20054463,2012));
		this.cars.add(new Car("Mazada","HatchBack",20085463,2015));
		this.cars.add(new Car("BMW","Sedan",200546336,2013));
		this.cars.add(new Car("Maserati","Racing",205463,2014));
		this.cars.add(new Car("Audi","Sedan",20054637,2011));
	}
	
	public boolean remove(Car cars) {
		return this.cars.remove(cars);
	}
	
	public void list() {
		int order=0;
		for(Car cars : this.cars) {
			System.out.println(String.format("%2d.%s",Integer.valueOf(++order),cars));
		}
	}
	
	public boolean contains (Car cars) {
		return this.cars.contains(cars);
	}
}
