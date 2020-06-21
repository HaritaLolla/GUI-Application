package carsView;

import java.util.List;


import cars.domain.Car;
import carsDao.CarsDao;

/**
 * Controller design for MVC
 * 
 * @author HARITA LOLLA
 *
 */

public class CarController {
	
	/**
	 * DAO
	 */
	private CarsDao carDao;
	
	/**
	 * Form
	 */
	private CarWindow carWindow;
	
	/**
	 * Current car 
	 */
	private Car currentCar;
	
	/**
	 * All car list 
	 */
	private List<Car> all;
	
	/**
	 *  constructor
	 */
	
	public CarController  () {
		this.carDao=CarsDao.createCarsDao(); 
		this.carWindow=new CarWindow(this);
		first();
	}
	
	/**
	 * Getter for Carindow
	 * 
	 * @return CarWindow
	 */
	
	public CarWindow getCarWindow() {
		return this.carWindow;
	}
	
	/**
	 *  load the car list and select the first car if the list is not empty.
	 */

	private void first() {
		this.setCurrent(null);
		this.all=this.carDao.listOrderById();
		if (this.all.size()>0)
			setCurrent(this.all.get(0));
		updateGUI();
		
	}
	
	/**
	 *  select the previous car in the list if the list is not empty
	 */
	public void prev() {
		if (this.currentCar !=null && this.all.indexOf(this.currentCar)>0) {
			setCurrent(this.all.get(this.all.indexOf(this.currentCar)-1));
		
		updateGUI();
	   }
	}
	/**
	 *  select the next car in the list if the list is not empty
	 */
	public void next() {
		if (this.currentCar!=null && this.all.indexOf(this.currentCar)<this.all.size()-1) {
			setCurrent(this.all.get(this.all.indexOf(this.currentCar)+1));
		}	
		updateGUI();
	}
	
	/**
	 *  create a new car and insert it into the current list
	 */
	public void insert() {
		setCurrent(this.carWindow.getCarPanel().getData());
		Car car = new Car();
		
		car.setName(this.currentCar.getName());
		car.setPrice(this.currentCar.getPrice());
		car.setDoors(this.currentCar.getDoors());
		car.setMaxSpeed(this.currentCar.getMaxSpped());
		car.setMileage(this.currentCar.getMileage());
		car.setFuel(this.currentCar.getFuelUsage());
		car.setReleaseYear(this.currentCar.getReleaseYear());
		@SuppressWarnings("unused")
		Car car2 = this.carDao.insert(car);
		System.out.println(car.toString());
		
		updateGUI();
	}
	
	/**
	 *  update the current database
	 */
	public void update() {
		setCurrent(this.carWindow.getCarPanel().getData());
		if (this.currentCar.getId()==null) 
			setCurrent(this.carDao.insert(this.currentCar));
		/*
		else
			this.carDao.update(this.currentCar);
			*/
		Integer id = this.currentCar.getId();
		first();
		for(Car c:this.all) 
			if (c.getId().equals(id)) {
				setCurrent(c);
				updateGUI();
				break;
			}
	}

	/**
	 * delete the cars from the database
	 */
	public void delete() {
		try {
			this.carDao.delete(this.currentCar);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		first();
	}
	
	/**
	 *  close the car window
	 */
	public void close() {
		this.carWindow.setVisible(false);
	}
	
	public void shutdown() {
		this.carDao.shutdown();
	}
	
	/**
	 *  update the GUI
	 */
	private void updateGUI() {
		this.carWindow.btnInsert.setEnabled(this.currentCar!=null);
		this.carWindow.btnInsert.setEnabled(true);
		this.carWindow.btnDelete.setEnabled(this.currentCar!=null);
		this.carWindow.btnUpdate.setEnabled(this.currentCar!=null);
		int idx = this.all.indexOf(this.currentCar);
		this.carWindow.btnPrev.setEnabled(!this.all.isEmpty() && idx>0);
		this.carWindow.btnNext.setEnabled(!this.all.isEmpty() && idx<this.all.size()-1);
	
	}
	
	/**
	 *  set the current car
	 * @param c
	 */
	private void setCurrent(Car c) {
		this.currentCar=c;
		this.carWindow.getCarPanel().setData(c);;
		
	}
}
