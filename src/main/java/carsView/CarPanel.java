package carsView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cars.domain.Car;

/**
 * Contains the panel properties
 * 
 * @author HARITA LOLLA
 *
 */

public class CarPanel extends JPanel {

	/**
	 * Default id
	 */
	private static final long serialVersionUID = 1L;
	
	protected JTextField tfName;
	protected JSpinner spPrice;
	protected JSpinner spDoors;
	protected JSpinner spMaxSpeed;
	protected JSpinner spFuelUsage;
	protected JSpinner spMileage;
	protected JSpinner spReleaseYear;
	protected Car car;
	
	/**
	 *  create the panel
	 */
	public CarPanel() {
		super();
		createGUI();
		
	}
	
	/**
	 *  create the GUI
	 */
	private void createGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		/**
		 * Layout is GridbagLayout. 
		 */
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		
		// If you need more rows, you can add a 0 to rowHeights array
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		/**
		 * name label
		 */
		JLabel lbName = new JLabel(" Car Name"); //$NON-NLS-1$
		GridBagConstraints gbc_lbName = new GridBagConstraints();
		gbc_lbName.insets=new Insets(10, 5, 5, 5);
		gbc_lbName.anchor = GridBagConstraints.EAST;
		gbc_lbName.insets = new Insets(0, 0, 5, 5);
		gbc_lbName.gridx = 0;							// column index
		gbc_lbName.gridy = 0;							// row index
		add(lbName, gbc_lbName);
		
		/**
		 *  name text field
		 */
				this.tfName = new JTextField();
				GridBagConstraints gbc_tfName = new GridBagConstraints();
				gbc_tfName.insets = new Insets(10, 0, 5, 5);
				gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfName.gridx = 2;							// column index
				gbc_tfName.gridy = 0;							// row index
				add(this.tfName, gbc_tfName);
				this.tfName.setColumns(40);
				this.tfName.addFocusListener(new FocusListener() {
				
					@Override
					public void focusLost(FocusEvent e) {
						if (CarPanel.this.car!=null) 
							CarPanel.this.car.setName(CarPanel.this.tfName.getText());
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						
					}
				});
				
				/**
				 *  label for price
				 */
				JLabel lbPrice = new JLabel("Price (1000 USD)"); //$NON-NLS-1$
				GridBagConstraints gbc_lbPrice = new GridBagConstraints();
				gbc_lbPrice.anchor = GridBagConstraints.EAST;
				gbc_lbPrice.insets = new Insets(0, 0, 5, 5);
				gbc_lbPrice.gridx = 0;						// column index
				gbc_lbPrice.gridy = 2;						// row index
				add(lbPrice, gbc_lbPrice);
				
				//TODO price spinner 
				this.spPrice = new JSpinner();
				// model for spinner first 0 is the current value, second 0 is the minimum value, third is the maximum value, 1 is the step
				this.spPrice.setModel(new SpinnerNumberModel(0, 0, 500000, 1));		
				GridBagConstraints gbc_spPrice = new GridBagConstraints();
				gbc_spPrice.anchor = GridBagConstraints.WEST;
				gbc_spPrice.fill = GridBagConstraints.HORIZONTAL;
				gbc_spPrice.insets = new Insets(0, 0, 5, 5);
				gbc_spPrice.gridx = 2;						// column index
				gbc_spPrice.gridy = 2;						// row index
				this.spPrice.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if (CarPanel.this.car!=null)
							CarPanel.this.car.setPrice(((Number)CarPanel.this.spPrice.getValue()).intValue());
					}
				});
				add(this.spPrice, gbc_spPrice);
				
				/**
				 *  label for doors
				 */
				JLabel lbDoors = new JLabel("NO.OF DOORS"); //$NON-NLS-1$
				GridBagConstraints gbc_lbDoors = new GridBagConstraints();
				gbc_lbDoors.anchor = GridBagConstraints.EAST;
				gbc_lbDoors.insets = new Insets(0, 0, 5, 5);
				gbc_lbDoors.gridx = 0;						// column index
				gbc_lbDoors.gridy = 3;						// row index
				add(lbDoors, gbc_lbDoors);
				
				/**
				 * doors spinner 
				 */
				this.spDoors = new JSpinner();
				// model for spinner first 0 is the current value, second is the minimum value, third is the maximum value, 1 is the step
				this.spDoors.setModel(new SpinnerNumberModel(0, 0, 6, 1));		
				GridBagConstraints gbc_spDoors = new GridBagConstraints();
				gbc_spDoors.anchor = GridBagConstraints.WEST;
				gbc_spDoors.fill = GridBagConstraints.HORIZONTAL;
				gbc_spDoors.insets = new Insets(0, 0, 5, 5);
				gbc_spDoors.gridx = 2;						// column index
				gbc_spDoors.gridy = 3;						// row index
				this.spDoors.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if (CarPanel.this.car!=null)
							CarPanel.this.car.setDoors(((Number)CarPanel.this.spDoors.getValue()).intValue());
					}
				});
				add(this.spDoors, gbc_spDoors);
				
				/**
				 *  label for maximum speed
				 */
				JLabel lbMaxSpeed = new JLabel("MaxSpeed (KM/H)"); //$NON-NLS-1$
				GridBagConstraints gbc_lbMaxSpeed = new GridBagConstraints();
				gbc_lbMaxSpeed.anchor = GridBagConstraints.EAST;
				gbc_lbMaxSpeed.insets = new Insets(0, 0, 5, 5);
				gbc_lbMaxSpeed.gridx = 0;						// column index
				gbc_lbMaxSpeed.gridy = 4;						// row index
				add(lbMaxSpeed, gbc_lbMaxSpeed);
				
				/**
				 * max speed spinner 
				 */
				this.spMaxSpeed = new JSpinner();
				// model for spinner first 0 is the current value, second 0 is the minimum value, 500 is the maximum value, 1 is the step
				this.spMaxSpeed.setModel(new SpinnerNumberModel(0, 0, 500, 1));		
				GridBagConstraints gbc_spMaxSpeed = new GridBagConstraints();
				gbc_spMaxSpeed.anchor = GridBagConstraints.WEST;
				gbc_spMaxSpeed.fill = GridBagConstraints.HORIZONTAL;
				gbc_spMaxSpeed.insets = new Insets(0, 0, 5, 5);
				gbc_spMaxSpeed.gridx = 2;						// column index
				gbc_spMaxSpeed.gridy = 4;						// row index
				this.spMaxSpeed.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if (CarPanel.this.car!=null)
							CarPanel.this.car.setMaxSpeed(((Number)CarPanel.this.spMaxSpeed.getValue()).intValue());
					}
				});
				add(this.spMaxSpeed, gbc_spMaxSpeed);
				
				/**
				 *  label for fuel usage
				 */
				JLabel lbFuelUsage = new JLabel("FuelUsage (LITERS)"); //$NON-NLS-1$
				GridBagConstraints gbc_lbFuelUsage = new GridBagConstraints();
				gbc_lbFuelUsage.anchor = GridBagConstraints.EAST;
				gbc_lbFuelUsage.insets = new Insets(0, 0, 5, 5);
				gbc_lbFuelUsage.gridx = 0;						// column index
				gbc_lbFuelUsage.gridy = 5;						// row index
				add(lbFuelUsage, gbc_lbFuelUsage);
				
				/**
				 * fuel usage spinner 
				 */
				this.spFuelUsage = new JSpinner();
				// model for spinner first 0 is the current value, second 0 is the minimum value, 128 is the maximum value, 1 is the step
				this.spFuelUsage.setModel(new SpinnerNumberModel(0, 0, 128, 1));		
				GridBagConstraints gbc_spFuelUsage = new GridBagConstraints();
				gbc_spFuelUsage.anchor = GridBagConstraints.WEST;
				gbc_spFuelUsage.fill = GridBagConstraints.HORIZONTAL;
				gbc_spFuelUsage.insets = new Insets(0, 0, 5, 5);
				gbc_spFuelUsage.gridx = 2;						// column index
				gbc_spFuelUsage.gridy = 5;						// row index
				this.spFuelUsage.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if (CarPanel.this.car!=null)
							CarPanel.this.car.setFuel(((Number)CarPanel.this.spFuelUsage.getValue()).intValue());
					}
				});
				add(this.spFuelUsage, gbc_spFuelUsage);
				
				/**
				 *  label for mileage
				 */
				JLabel lbMileage = new JLabel("Mileage (M/H)"); //$NON-NLS-1$
				GridBagConstraints gbc_lbMileage = new GridBagConstraints();
				gbc_lbMileage.anchor = GridBagConstraints.EAST;
				gbc_lbMileage.insets = new Insets(0, 0, 5, 5);
				gbc_lbMileage.gridx = 0;						// column index
				gbc_lbMileage.gridy = 6;						// row index
				add(lbMileage, gbc_lbMileage);
				
				/**
				 * mileage spinner 
				 */
				this.spMileage = new JSpinner();
				// model for spinner first 0 is the current value, second 0 is the minimum value, 128 is the maximum value, 1 is the step
				this.spMileage.setModel(new SpinnerNumberModel(0, 0, 128, 1));		
				GridBagConstraints gbc_spMileage = new GridBagConstraints();
				gbc_spMileage.anchor = GridBagConstraints.WEST;
				gbc_spMileage.fill = GridBagConstraints.HORIZONTAL;
				gbc_spMileage.insets = new Insets(0, 0, 5, 5);
				gbc_spMileage.gridx = 2;						// column index
				gbc_spMileage.gridy = 6;						// row index
				this.spMileage.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if (CarPanel.this.car!=null)
							CarPanel.this.car.setMileage(((Number)CarPanel.this.spMileage.getValue()).intValue());
					}
				});
				add(this.spMileage, gbc_spMileage);
				
				/**
				 *  label for year of release
				 */
				JLabel lbYear = new JLabel("Release Year"); //$NON-NLS-1$
				GridBagConstraints gbc_lbYear = new GridBagConstraints();
				gbc_lbYear.anchor = GridBagConstraints.EAST;
				gbc_lbYear.insets = new Insets(0, 0, 5, 5);
				gbc_lbYear.gridx = 0;						// column index
				gbc_lbYear.gridy = 7;						// row index
				add(lbYear, gbc_lbYear);
				
				/**
				 * release year spinner 
				 */
				this.spReleaseYear = new JSpinner();
				// model for spinner first 0 is the current value, second 0 is the minimum value, 128 is the maximum value, 1 is the step
				this.spReleaseYear.setModel(new SpinnerNumberModel(1970, 1970, 2017, 1));		
				GridBagConstraints gbc_spReleaseYear = new GridBagConstraints();
				gbc_spReleaseYear.anchor = GridBagConstraints.WEST;
				gbc_spReleaseYear.fill = GridBagConstraints.HORIZONTAL;
				gbc_spReleaseYear.insets = new Insets(0, 0, 5, 5);
				gbc_spReleaseYear.gridx = 2;						// column index
				gbc_spReleaseYear.gridy = 7;						// row index
				this.spReleaseYear.addChangeListener(new ChangeListener() {
					
					@Override
					public void stateChanged(ChangeEvent e) {
						if (CarPanel.this.car!=null)
							CarPanel.this.car.setReleaseYear(((Number)CarPanel.this.spReleaseYear.getValue()).intValue());
					}
				});
				add(this.spReleaseYear, gbc_spReleaseYear);
			}
	/**
	 * Set the current car data
	 * 
	 * @param car the current data
	 */
	public void setData(Car car) {
		this.car = car;
		if (this.car!=null) {
			this.tfName.setText(car.getName());
			this.spPrice.setValue(Integer.valueOf(car.getPrice()));
			this.spDoors.setValue(Integer.valueOf(car.getDoors()));
			this.spMaxSpeed.setValue(Integer.valueOf(car.getMaxSpped()));
			this.spFuelUsage.setValue(Integer.valueOf(car.getFuelUsage()));
			this.spMileage.setValue(Integer.valueOf(car.getMileage()));
			this.spReleaseYear.setValue(Integer.valueOf(car.getReleaseYear()));
			
			return;
		}
		
		this.tfName.setText(null); 
		this.spPrice.setValue(Integer.valueOf(25000));
		this.spDoors.setValue(Integer.valueOf(1));
		this.spMaxSpeed.setValue(Integer.valueOf(100));
		this.spFuelUsage.setValue(Float.valueOf(20));
		this.spMileage.setValue(Float.valueOf(20));
		this.spReleaseYear.setValue(Integer.valueOf(1900));
		
	
	}
				/**
				 * returns the current data object
				 * @return the current data
				 */
				
				public Car getData() {
					return this.car;
				}

	 public void readInitialStatus() {
					if(this.car== null)
					this.car= new Car();
					
					this.car.setName(this.tfName.getText());
					this.car.setPrice((int) this.spPrice.getValue());
					this.car.setDoors((int) this.spDoors.getValue());
					this.car.setMaxSpeed((int)(this.spMaxSpeed.getValue()));
					this.car.setFuel((int)(this.spFuelUsage.getValue()));
					this.car.setMileage((int)(this.spMileage.getValue()));
					this.car.setReleaseYear((int)(this.spReleaseYear.getValue()));
					
				}
}


