package interfaces;

import javax.swing.JFrame;

public class Insert {

	private JFrame frame;

	public Insert() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
	}

}
