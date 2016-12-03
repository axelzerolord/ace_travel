package interfaces;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Insert {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert window = new Insert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Insert() {
		initialize();
		this.frame.setVisible(true);
	}
	
	public void test(){
		System.out.println("Hello World");
	}
	
	
	
	public void jaja(){
		String feo = "jajaja";
		System.out.println(feo);
		//comment
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
	}

}
