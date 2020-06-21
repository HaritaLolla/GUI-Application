package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListCar {

	private List<Car> cars=new ArrayList<>();
	
	public void fill() {
		this.cars.add(new Car("Porsche Cayenne S", "Racing", 2005463, 2017));
		this.cars.add(new Car("Ferrari 599 GTB", "Racing", 29658453, 2015));
		this.cars.add(new Car("Land Rover", "Suv", 2095623, 2016));
		this.cars.add(new Car("Swift", "HatchBack", 194636, 2010));
		this.cars.add(new Car("Tesla", "Racing", 2568634, 2018));
		this.cars.add(new Car("McLaren", "Racing", 2960543, 2017));
		this.cars.add(new Car("Ford", "HatchBack", 20563, 2016));
		this.cars.add(new Car("Mercedes", "Sedan", 7054463, 2012));
		this.cars.add(new Car("Mazada", "HatchBack", 1585463, 2015));
		this.cars.add(new Car("BMW", "Sedan", 3036336, 2013));
		this.cars.add(new Car("Maserati", "Racing", 12056462, 2014));
		this.cars.add(new Car("Audi", "Sedan", 202637, 2011));
	}
	
	public void sortByName() {
		Collections.sort(this.cars,new Comparator<Car>(){

			@Override
			public int compare(Car c1, Car c2) {
				
				return c1.getName().compareTo(c2.getName());
			}
			
		});
	}
		
		public void sortByCategory() {
			Collections.sort(this.cars, new Comparator<Car>() {

				@Override
				public int compare(Car c1, Car c2) {
				
					return c1.getCategory().compareTo(c2.getCategory());
				}
		});
	}
	
		public Car get(int index) {
			return this.cars.get(index);	
		}
		
		public boolean contains(Car cars) {
			return this.cars.contains(cars);
		}
		public Car remove(int index) {
			return this.cars.remove(index);
		}
		public void list() {
			int order=0;
			for(Car cars : this.cars) {
				System.out.println(String.format("%2d.%s",Integer.valueOf(++order), cars));
			}
		}
}
