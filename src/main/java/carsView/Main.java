package carsView;

/**
 * @author HARITA LOLLA
 */

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Main {
	
	public final static int MAIN_WIDTH=400;
	public final static int MAIN_HEIGHT=400;
	
	protected JFrame mainFrame;
	private CarController carController;
	
	/**
	 * empty main class
	 */
	public Main() {
	}

	/**
	 * creating an image icon
	 * @param path
	 * @return
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Main.class.getResource(path);
		if(imgURL != null)
		return new ImageIcon(imgURL);
		
		System.err.println("couldn't find the title: "+ path);
		return null;
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Main().init();
			}
		});
		
	}

	protected void init() {
		this.carController = new CarController();
		createGUI();
		
	}
	/**
	 * creating a GUI
	 */
	private void createGUI() {
		this.mainFrame = new JFrame("Cars Info point"); //$NON-NLS-1$
		this.mainFrame.setSize(MAIN_WIDTH, MAIN_HEIGHT);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setJMenuBar(createMenubar());		
		this.mainFrame.setVisible(true);
		
	}
	
	protected void openCarsForm() {
		this.carController.getCarWindow().setVisible(true);
	}
	
/**
 * creating a menu bar
 * @return
 */
	private JMenuBar createMenubar() {
		JMenuBar menubar = new JMenuBar();
		JMenu file=new JMenu("File"); //$NON-NLS-1$
		JMenuItem cars = new JMenuItem("Cars"); //$NON-NLS-1$
		JMenuItem exit=new JMenuItem("Exit"); //$NON-NLS-1$
		cars.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openCarsForm();
				
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				carController.shutdown();
				WindowEvent wev = new WindowEvent(Main.this.mainFrame, WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
				Main.this.mainFrame.dispatchEvent(wev);
				Main.this.mainFrame.setVisible(false);
				Main.this.mainFrame.dispose();
				System.exit(0);
			}
		});
		file.add(cars);
		file.addSeparator();
		file.add(exit);
		menubar.add(file);
		return menubar;
	}

}
