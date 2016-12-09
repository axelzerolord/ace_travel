package interfaces;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import logic.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;


public class Reservation extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField userField;
	private JComboBox<String> destCombo;
	private ButtonGroup group;
	private JLabel namelbl;
	private JLabel lastlbl;
	private JLabel viplbl;
	private JLabel lblSexo;
	private JLabel sexolbl;
	private DefaultComboBoxModel destcombomodel;
	private Object[] fila;
	private DefaultTableModel tripTableModel;
	private JTable table;
	private JLabel idfield;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reservation dialog = new Reservation();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reservation() {
		setTitle("Reservations");
		setBounds(100, 100, 746, 478);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel.setBounds(10, 11, 317, 108);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		group = new ButtonGroup();
		
		JLabel lblClient = new JLabel("*Type in User's name or ID");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClient.setBounds(24, 13, 171, 14);
		panel.add(lblClient);
		
		
		
		userField = new JTextField();
		userField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
				String[] myString = userField.getText().split(":");
				if(myString.length>1)
				{
					Client cliente=Travel_Agency.getInstances().findbyID(Integer.valueOf(myString[1]));
					if(cliente!=null)
					{
						namelbl.setText(cliente.getName());
						lastlbl.setText(cliente.getLast_name());
						viplbl.setText(String.valueOf(cliente.getVip_lv_id()));
						idfield.setText(myString[1]);
						if(cliente.getSex().equalsIgnoreCase("M"))
						{
							sexolbl.setText("Masculino");
						}
						else
						{
							sexolbl.setText("Femenino");
						}
						namelbl.setVisible(true);
						lastlbl.setVisible(true);
						viplbl.setVisible(true);
						sexolbl.setVisible(true);
						idfield.setVisible(true);
					}	
				}
			}
		});
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				addUsertoTextField();
		}});
		userField.setColumns(5);
		userField.setBounds(66, 33, 238, 36);
		panel.add(userField);
		
		JLabel label_3 = new JLabel("User:");
		label_3.setBounds(24, 33, 44, 36);
		
		panel.add(label_3);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_1.setBounds(337, 11, 382, 385);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDestination.setBounds(99, 11, 83, 14);
		panel_1.add(lblDestination);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 106, 348, 266);
		panel_1.add(scrollPane);
		
			table = new JTable();
			scrollPane.setViewportView(table);
			String[] columnames = {"Trip ID","Bus ID","Leaving at"};
			tripTableModel = new DefaultTableModel();
			tripTableModel.setColumnIdentifiers(columnames);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(tripTableModel);
			table.getColumnModel().getColumn(0).setPreferredWidth(170);
			table.getColumnModel().getColumn(1).setPreferredWidth(170);
			table.getColumnModel().getColumn(2).setPreferredWidth(170);
			
			//loadTripsTable(Travel_Agency.getInstances().getTrips());
		
		destCombo = new JComboBox<String>();
		destCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				loadTripsTable(Travel_Agency.getInstances().getTrips());
			}
		});
		 loadDestStations();
		destCombo.setBounds(22, 36, 211, 32);
		panel_1.add(destCombo);
		
		JLabel lblTable = new JLabel("Available Trips");
		lblTable.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTable.setBounds(22, 79, 124, 14);
		panel_1.add(lblTable);
					
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBounds(10, 143, 317, 253);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUserInfo = new JLabel("User info");
		lblUserInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserInfo.setBounds(130, 11, 64, 14);
		panel_2.add(lblUserInfo);
		
		JLabel lblNombre = new JLabel("Name");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNombre.setBounds(10, 73, 74, 14);
		panel_2.add(lblNombre);
		
		JLabel lblVipLvl = new JLabel("VIP lvl.");
		lblVipLvl.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVipLvl.setBounds(10, 123, 74, 14);
		panel_2.add(lblVipLvl);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastName.setBounds(10, 98, 74, 14);
		panel_2.add(lblLastName);
		
		 namelbl = new JLabel("");
		 namelbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		namelbl.setBounds(142, 65, 74, 14);
		panel_2.add(namelbl);
		namelbl.setVisible(false);
		
		
		 lastlbl = new JLabel("");
		 lastlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lastlbl.setBounds(140, 92, 100, 14);
		panel_2.add(lastlbl);
		lastlbl.setVisible(false);
		
		 viplbl = new JLabel("");
		 viplbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		viplbl.setBounds(140, 117, 100, 14);
		panel_2.add(viplbl);
		viplbl.setVisible(false);
		
		 lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSexo.setBounds(10, 148, 46, 14);
		panel_2.add(lblSexo);
		lblSexo.setVisible(true);
		
		 sexolbl = new JLabel("");
		 sexolbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sexolbl.setBounds(140, 142, 100, 14);
		panel_2.add(sexolbl);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblId.setBounds(10, 44, 56, 16);
		panel_2.add(lblId);
		
		
		idfield = new JLabel("");
		idfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idfield.setBounds(142, 38, 56, 16);
		panel_2.add(idfield);
		idfield.setVisible(false);
		sexolbl.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						if((table.getSelectedRow()!=-1) && !idfield.getText().isEmpty() )
						{
							makeReservation();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void addUsertoTextField() 
	{		
		TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( userField );
		for(Client auxCliente: Travel_Agency.getInstances().getClients())
		{	
			textAutoAcompleter.addItem(auxCliente.getName()+" "+auxCliente.getLast_name()+" ID:"+auxCliente.getCliente_id());
		}
	}
	
	public void loadDestStations()
	{
		destcombomodel= new DefaultComboBoxModel();
		if(!Travel_Agency.getInstances().getStations().isEmpty())
		{
			for(Station auxStation:Travel_Agency.getInstances().getStations())
			{
				if(auxStation!=null)
				{
					destcombomodel.addElement(new String(auxStation.getName()+"  ID:"+auxStation.getStation_id()));
				}
			}
		}
		destcombomodel.insertElementAt(new String ("None"), 0);
		destCombo.setModel(destcombomodel);	
		//destCombo.setSelectedIndex(0);
	}
	
	public void loadTripsTable(ArrayList<Trip> trips)
	{
		tripTableModel.setRowCount(0);
		fila = new Object[tripTableModel.getColumnCount()];
		
			for(Trip auxTrip: Travel_Agency.getInstances().getTrips())
			{
				Route thisTripsRoute=Travel_Agency.getInstances().findRouteByID(auxTrip.getRoute_ID());
				String[] mySplittings=(destCombo.getSelectedItem().toString().split(":"));
				if(destCombo.getSelectedIndex()>0)
				{
					if(thisTripsRoute.getDestination_station()==Integer.valueOf(mySplittings[1]))
					{
						fila[0]=auxTrip.getTrip_ID();				
						fila[1]=auxTrip.getBus_ID();
						fila[2]=auxTrip.getExit_time();
						tripTableModel.addRow(fila);
					}
				}
			}
			table.setModel(tripTableModel);
	}
	
	public void makeReservation()
	{
		try {
		//reservacion id, cliente id, viaje_id, fecha reservacion, monto penalidad
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet myRS = myHandler.runQuery("Select count(reservacion_id) from reservaciones");
		myRS.next();
		int reservation_id,client_id,trip_id;
		reservation_id=myRS.getInt(1);
		
		//date managing
		myRS=myHandler.runQuery("Select sysdate from dual");
		myRS.next();
		Date current_date;
		current_date = myRS.getDate(1);
		String parsed_date="(select to_char(to_date('"+current_date+"', 'yyyy-mm-dd'), 'dd MON yyyy') from dual)";
		//date managed
		trip_id=Integer.valueOf(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
		client_id=Integer.valueOf(idfield.getText());
		Reservations newReservations = new Reservations(reservation_id, client_id, trip_id, current_date,null , 0);
		Travel_Agency.getInstances().getReservations().add(newReservations);
		String myUpdate="Insert into reservaciones (reservacion_id,cliente_id,viaje_id,fecha_reservacion,fecha_cancelacion,monto_penalidad)"
				+ "Values("+reservation_id+","+client_id+","+trip_id+","+parsed_date+",null,0)";
		System.out.println(myUpdate);
		myHandler.runUpdate(myUpdate);
		myHandler.closeConnection();
		
		
		//myHandler.runQuery("")
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean existsInUsers(String name)
	{
		for(Client auxClient: Travel_Agency.getInstances().getClients())
		{
			//&&(name.indexOf(Integer.toString(auxClient.getCliente_id())))!=-1
			if((name.indexOf(auxClient.getName())>0))
			{
				return true;
			}
		}
		return false;
	}
}
