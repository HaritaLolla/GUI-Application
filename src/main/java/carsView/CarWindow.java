package carsView;
/**
 * @author HARITA LOLLA
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CarWindow extends JFrame {

	/**
	 * Default id 
	 */
	private static final long serialVersionUID = 1L;
	
	private CarPanel carView;
	/**
	 * previous button
	 */
	protected JButton btnPrev;
	/**
	 * insert button
	 */
	protected JButton btnInsert;
	/**
	 * update button
	 */
	protected JButton btnUpdate;
	/**
	 * delete button
	 */
	protected JButton btnDelete;
	/**
	 * next button
	 */
	protected JButton btnNext;
	/**
	 * close form button
	 */
	protected JButton btnClose;
	/**
	 * Controller
	 */
	protected CarController controller;
	
	/**
	 * Constructor
	 * 
	 * @param controller
	 */
	public CarWindow(CarController controller) {
		super();
		setLayout(new BorderLayout());
		this.controller = controller;
		createGUI();
		pack();
	
	}
	
	/**
	 *  getter for the car view
	 * @return
	 */
	public CarPanel getCarPanel() {
		return this.carView;
	}
	
	/**
	 *  getter for the previous button
	 * @return
	 */
	public JButton getPrevButton() {
		return this.btnPrev;
	}
	
	/**
	 *  getter for the insert button
	 * @return
	 */
	public JButton getInsertButton() {
		return this.btnInsert;
	}
	
	/**
	 *  getter for the update button
	 * @return
	 */
	public JButton getUpdateButton() {
		return this.btnUpdate;
	}
	
	/**
	 *  getter for the delete button
	 * @return
	 */
	public JButton getDeleteButton() {
		return this.btnDelete;
	}
	
	/**
	 *  getter for the next button
	 * @return
	 */
	public JButton getNextButton() {
		return this.btnNext;
	}
	
	/**
	 *  create the GUI
	 */
	private void createGUI() {
		this.carView = new CarPanel();
		add(this.carView, BorderLayout.CENTER);
		add(createButtons(), BorderLayout.SOUTH);
		
	}
	
	/**
	 * Create buttons
	 * 
	 * @return
	 */
	private JPanel createButtons() {
		
			JPanel result = new JPanel();
			result.setLayout(new FlowLayout());
			
			this.btnPrev = new JButton("Prev"); //$NON-NLS-1$
			this.btnPrev.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					CarWindow.this.carView.readInitialStatus();
					CarWindow.this.controller.prev();
				}
			});
			result.add(this.btnPrev);
			
			this.btnInsert = new JButton("Insert"); //$NON-NLS-1$
			this.btnInsert.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					CarWindow.this.carView.readInitialStatus();
					CarWindow.this.controller.insert();
				}
			});
			result.add(this.btnInsert);
			
			this.btnUpdate=new JButton("Update"); //$NON-NLS-1$
			this.btnUpdate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					CarWindow.this.carView.readInitialStatus();
					CarWindow.this.controller.update();
				}
			});
			result.add(this.btnUpdate);
			
			this.btnDelete = new JButton("Delete"); //$NON-NLS-1$
			this.btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					CarWindow.this.carView.readInitialStatus();
					CarWindow.this.controller.delete();
				}
			});
			result.add(this.btnDelete);
			
			this.btnNext = new JButton("Next"); //$NON-NLS-1$
			this.btnNext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					CarWindow.this.carView.readInitialStatus();
					CarWindow.this.controller.next();
				}
			});
			result.add(this.btnNext);
			
			this.btnClose = new JButton("Close"); //$NON-NLS-1$
			this.btnClose.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					CarWindow.this.controller.close();
				}
			});
			result.add(this.btnClose);
			
			return result;
		}
	

	}



