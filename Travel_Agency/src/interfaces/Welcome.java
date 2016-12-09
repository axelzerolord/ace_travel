package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logic.Travel_Agency;

public class Welcome {

	private JFrame mainFrame;
	private Reservation myReservation;
	private  Travel_Agency myAgency;

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
		myAgency.getInstances().LoadEverything();
		
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
		mainFrame.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC,16));
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
				myReservation=new Reservation();
				myReservation.setVisible(true);
			}
		});
		mnReservations.add(mntmReserve);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mnHelp.add(mntmAboutUs);
	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

}
