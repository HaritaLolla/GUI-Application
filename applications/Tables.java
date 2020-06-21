package applications;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tables extends JPanel {

	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;
	private final static boolean DEBUG = true;
	
	public Tables() {
		super(new GridLayout(1,0));
		
		
		String[] columnNames = {"Name","Price (£)",
								"Mileage","Max Speed (mph)", "Release Year"};
		
		Object[][] data= {
				{"Swift", new Integer(25000), new Float(19.991), new Integer(60), new Integer(2004)},
				{"Mazada", new Integer(19000), new Float(15.269), new Integer(20), new Integer(2006)},
				{"Ford", new Integer(32000), new Float(28.556), new Integer(80), new Integer(2012)},
				{"Ferrari GTB", new Integer(160000), new Float(197.418), new Integer(30), new Integer(2015)},
				{"Maserati MC12", new Integer(120000), new Float(200.0), new Integer(25), new Integer(2006)},
				{"Tesla S P85D", new Integer(220000), new Float(300.100), new Integer(25), new Integer(2012)},
				{"McLaren 580s", new Integer(150000), new Float(200.0000), new Integer(24), new Integer(2015)},
				{"Land Rover", new Integer(150000), new Float(97.418), new Integer(200), new Integer(2010)},
				{"Porsche Cayenne S", new Integer(350000), new Float(150.0000), new Integer(200), new Integer(2015)},
				{"Mercedez", new Integer(45000), new Float(55.418), new Integer(210), new Integer(2016)},
				{"Audi", new Integer(40000), new Float(53.0000), new Integer(200), new Integer(2016)},
				{"BMW", new Integer(39000), new Float(49.100), new Integer(200), new Integer(2016)},
	
			
		
		};
		final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
            	@Override
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
            
        }
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
		}
	
		protected static void printDebugData(JTable table) {
			int numRows = table.getRowCount();
	        int numCols = table.getColumnCount();
	        javax.swing.table.TableModel model = table.getModel();

	        System.out.println("Value of data: "); //$NON-NLS-1$
	        for (int i=0; i < numRows; i++) {
	            System.out.print("    row " + i + ":"); //$NON-NLS-1$ //$NON-NLS-2$
	            for (int j=0; j < numCols; j++) {
	                System.out.print("  " + model.getValueAt(i, j)); //$NON-NLS-1$
	            }
	            System.out.println();
	        }
	        System.out.println("--------------------------");
		}
}
