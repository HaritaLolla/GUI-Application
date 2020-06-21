package applications;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * the second window that pops after the startup 
 * contains radio buttons 
 * 
 * @author HARITA LOLLA
 *
 */
public class SecondWindow extends JPanel implements ActionListener {
	
	/**
	 * Default serial id 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton b1;

	
	JComponent buttonPane = createButton();
	
	public final static String hatchBackString = "HatchBack";
	public final static String racingString = "Racing";
	public final static String sedanString = "Sedan";
	public final static String suvString = "SUV";

	JLabel picture;
	
	 public SecondWindow() {
	        super(new GridLayout(3,1));
	        
	        // to create the next button 
			JComponent buttonPane = createButton();		
			add(buttonPane);
			
	        //Create the radio buttons.
	        JRadioButton hatchButton = new JRadioButton(hatchBackString);
	        hatchButton.setMnemonic(KeyEvent.VK_B);
	        hatchButton.setActionCommand(hatchBackString);
	        
	        hatchButton.setSelected(true);

	        JRadioButton racingButton = new JRadioButton(racingString);
	        racingButton.setMnemonic(KeyEvent.VK_C);
	        racingButton.setActionCommand(racingString);

	        JRadioButton sedanButton = new JRadioButton(sedanString);
	        sedanButton.setMnemonic(KeyEvent.VK_D);
	        sedanButton.setActionCommand(sedanString);

	        JRadioButton suvButton = new JRadioButton(suvString);
	        suvButton.setMnemonic(KeyEvent.VK_R);
	        suvButton.setActionCommand(suvString);


	        //Group the radio buttons.
	        ButtonGroup group = new ButtonGroup();
	        group.add(hatchButton);
	        group.add(racingButton);
	        group.add(sedanButton);
	        group.add(suvButton);

	        //Register a listener for the radio buttons.
	        hatchButton.addActionListener(this);
	        racingButton.addActionListener(this);
	        sedanButton.addActionListener(this);
	        suvButton.addActionListener(this);
	        
	        //Set up the picture label.
	        this.picture = new JLabel(createImageIcon("/images/" //$NON-NLS-1$
	                                             + hatchBackString
	                                             + ".jpg")); //$NON-NLS-1$

	        //The preferred size is hard-coded to be the width of the
	        //widest image and the height of the tallest image.
	        //A real program would compute this.
	        this.picture.setPreferredSize(new Dimension(200, 200));


	        //Put the radio buttons in a column in a panel.
	        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	        radioPanel.add(hatchButton);
	        radioPanel.add(racingButton);
	        radioPanel.add(sedanButton);
	        radioPanel.add(suvButton);

	        add(radioPanel, BorderLayout.LINE_START);
	        add(this.picture, BorderLayout.CENTER);
	        
	    }

		private JComponent createButton() {
			JPanel p = new JPanel(new GridLayout(2, 4));
			JButton nextButton =new JButton("Next");
			
		        nextButton.setActionCommand("next");
		        
		        nextButton.addActionListener(this);
		        
		        nextButton.setToolTipText("Click this button to go to the next page."); //$NON-NLS-1$
				
		        
		        p.add(nextButton);
		        
		        return p;
		
	}

		private Icon createImageIcon(String path) {
	        java.net.URL imgURL = SecondWindow.class.getResource(path);
	        if (imgURL != null) 
	            return new ImageIcon(imgURL);
	        
			//System.err.println("Couldn't find file: " + path); //$NON-NLS-1$
			return null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		
		if("next".equals(e.getActionCommand())) {

			// creating the next table
			JFrame frame = new JFrame();
			
			//setting up the table pane 
			JComponent component2 = new Main();
			frame.getContentPane().add(new Tables(),BorderLayout.CENTER);
			component2.setOpaque(true);
			
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setSize(500,300);
		}
		
		this.picture.setIcon(createImageIcon("/images/" //$NON-NLS-1$
	               + (e.getActionCommand())
	              + ".jpg"));
	}
}
