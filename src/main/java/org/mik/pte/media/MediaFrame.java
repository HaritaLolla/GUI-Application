package org.mik.pte.media;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.pte.mik.Cars;

public class MediaFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private String title;
	private JTable table;
	private TableModel tableModel;
	

	public MediaFrame(String title, int width, int height) {
		super();
		this.title=title;
		this.width=width;
		this.height=height;
		initGUI();
	}

	private void initGUI() {
		setSize(this.width,this.height);
		setTitle(this.title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

	public void fillTable(List<Cars> cars, String[] columnNames) {
		// this part contains the data of the table
		String[][] data = new String[cars.size()][columnNames.length];
		int rowIndex = 0;
		for(Cars np:cars) {
			data[rowIndex][0]=np.getName();
			data[rowIndex][1]=np.getClass().getSimpleName();
			data[rowIndex][2]=String.valueOf(np.getPrice());
			data[rowIndex][3]=String.valueOf(np.getDoors());
			data[rowIndex][4]=String.valueOf(np.getMaxSpeed());
			data[rowIndex][5]=String.valueOf(np.getFuelUsage());
			data[rowIndex][6]=String.valueOf(np.getMileage());
			data[rowIndex][7]=String.valueOf(np.getReleaseYear());
			rowIndex++;
		}
		//Filling the table model
		this.tableModel=new DefaultTableModel(data,columnNames);
		//Based on the table model the surface of the table is done
		this.table=new JTable(this.tableModel);
		//Adding the scrolling function to the table
		JScrollPane scrollPane=new JScrollPane(this.table);
		add(scrollPane);
		// redraw the frame
		revalidate();
	}

}
