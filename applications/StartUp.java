package applications;
/**
 * @author HARITA LOLLA
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartUp extends JPanel implements ActionListener {

	/**
	 * Default Serial Id
	 */
	private static final long serialVersionUID = 1L;
	protected JButton b1;
	protected SecondWindow secondWindow;
	JComponent buttonPane = createButton();

	
	public StartUp() {
		super(new GridLayout(3,1));
		JLabel label1;
	
		JComponent buttonPane = createButton();

		label1 = new JLabel("Press on next to proceed");
				        
		add(buttonPane);
		
		add(label1);
	}
	protected JComponent createButton() {
		
	JPanel p = new JPanel(new GridLayout(0, 1));
	
	JButton nextButton =new JButton("Next");
	
        nextButton.setActionCommand("next");
        
        nextButton.addActionListener(this);
        
        nextButton.setToolTipText("Click this button to go to the next page."); //$NON-NLS-1$
        
        p.add(nextButton);
        
        return p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("next".equals(e.getActionCommand())) {
			
		// creating the next second frame
			JFrame frame1 = new JFrame("Choose Your Car");
			// setting up the content pane
			JComponent component1 = new Main();
			component1.setOpaque(true);
			frame1.getContentPane().add(new SecondWindow(),
			       BorderLayout.CENTER);
			
			frame1.pack();
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			frame1.setSize(400,600);		
		}
	}
}
