package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {

	private JFrame mainFrame;
	private Insert myInsert;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setFont(
				new Font("Times New Roman", Font.PLAIN, 13));
		mainFrame.getContentPane().setBackground(SystemColor.controlHighlight);
		mainFrame.getContentPane().setForeground(Color.WHITE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,
				16));
		mainFrame.setTitle("Ace Travel Agency");
		mainFrame.setBackground(SystemColor.activeCaption);
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 775, 563);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		JMenu mnReservations = new JMenu("Reservations");
		menuBar.add(mnReservations);
		JMenuItem mntmReserve = new JMenuItem("Reserve");
		mntmReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMyInsert(new Insert());
			}
		});
		mnReservations.add(mntmReserve);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mnHelp.add(mntmAboutUs);
	}

	public Insert getMyInsert() {
		return myInsert;
	}

	public void setMyInsert(Insert myInsert) {
		this.myInsert = myInsert;
	}
}
