package org.mik.pte.datahandling;

import java.util.List;

import org.pte.mik.Cars;

/**
 * Data input interface
 * There should be input data from file or database
 * @author Harita Lolla
 *
 */
public interface DataInput {
	
	/**
	 * reads cars 
	 * @return a list of cars or null
	 * @throws Exception if any error
	 */
	List<Cars> carsInput() throws Exception;
}
