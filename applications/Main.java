package applications;
/**
 * @author HARITA LOLLA
 */

import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main extends JPanel {
	
	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		super(new GridLayout(1,1));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("/images/cars1.jpg");
		
		tabbedPane.addTab(null,icon, new StartUp(), "Start");
		
		add(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
	}
	
	protected static JComponent makeTextPanel(String text) {
		JPanel panel=new JPanel(false);
		JLabel filler =new JLabel(text);
		filler.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new GridLayout(1,1));
		panel.add(filler);
		return panel;	
	}
	
	/**Returns an image icon or null if the given path is invalid*/
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Main.class.getResource(path);
		if(imgURL != null)
		return new ImageIcon(imgURL);
		
		System.err.println("couldn't find the title: "+ path);
		return null;
		
	}
	
	/**
	 * create the GUI and display it. Thread safety
	 * this method should be invoked from the event dispatch thread
	 * 
	 */

	protected static void createAndShowGUI() {
		// create and set the window.
		JFrame frame = new JFrame("Cars Information point");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//create and set up the content pane.
		JComponent newContentPane = new Main();
		newContentPane.setOpaque(true);
		frame.getContentPane().add(new Main(),BorderLayout.CENTER);
		
		
		// Display the window 
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// Turn off the metal's use of bold fonts
		UIManager.put("swing.boldMetal",Boolean.FALSE);
		
		// displaying the GUI for the application.
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createAndShowGUI();
				
			}
			
		});
	}
}
