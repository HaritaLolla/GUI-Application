package org.mik.pte.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mik.pte.datahandling.DataInput;
import org.mik.pte.datahandling.FileInput;
import org.pte.mik.Cars;

/**
 * controlling the cars
 * @author HARITA LOLLA
 *
 */
public class Controller {
	
	private final static Logger LOG = Logger.getLogger(Controller.class.getName()); //$NON-NLS-1$
	private final static String PATH_OF_CARS_FILE = "/org/mik/pte/data/cars.txt"; //$NON-NLS-1$
	
	private List<Cars> cars=new ArrayList<>();
	private Random random;
	
	/**
	 * Start
	 */
	public void Start() {
		try {
			input(); 
			simulation();
			graphicalOutput();
		}
		catch(Exception e) {
			LOG.log(Level.SEVERE, "Error:", e); //$NON-NLS-1$
		}

	}
	
	/**
	 * Input the cars from the file
	 * @throws Exception
	 */
	private void input() throws Exception {
		DataInput dataInput = new FileInput(PATH_OF_CARS_FILE);
		this.cars = dataInput.carsInput();
		
	}
	/**
	 * Simulating the working of the cars 
	 */
	private void simulation() {
		int limit = 100;
		this .random=null;
		if("Pointer".equals(random)) {
		int randomlyMany = this.random.nextInt(limit);
		int randomCarIndex;
		Cars cars;
		
		for(int i=0;i<=randomlyMany;i++) {
			randomCarIndex=this.random.nextInt(this.cars.size());
			cars=this.cars.get(randomCarIndex);
			cars.getCars();
			
			
		}
		
		//randomlyMany=this.random.nextInt(limit);
		//for(int i=0;i>randomlyMany;i++) {
			//randomCarIndex=this.random.nextInt(this.cars.size());
		//}
		}
		
	}
	private void graphicalOutput() {
		MediaFrame mediaFrame = new MediaFrame("Cars", 900, 300);
		mediaFrame.setVisible(true);
		String[] columnNames = {" Name of the Car","Category","Price (�)","Doors","Max Speed (mph)","Fuel Usage","Mileage","Year of Release"};
		mediaFrame.fillTable(this.cars,columnNames);
	}



}
