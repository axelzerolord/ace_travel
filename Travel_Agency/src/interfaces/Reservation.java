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
	private JTextField ExpressName;
	private JTextField userField;
	private JSpinner qtyspn;
	private JRadioButton registeredRadio;
	private JRadioButton expressRadio;
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
		panel.setBounds(10, 11, 317, 178);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		ExpressName = new JTextField();
		ExpressName.setEnabled(false);
		ExpressName.setColumns(10);
		ExpressName.setBounds(62, 124, 190, 20);
		panel.add(ExpressName);
		
		
		
		JLabel lblAnonymousFields = new JLabel("Anonymous Fields");
		lblAnonymousFields.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnonymousFields.setBounds(99, 99, 131, 14);
		panel.add(lblAnonymousFields);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(10, 127, 46, 14);
		panel.add(label_1);
		
		expressRadio = new JRadioButton("Anonymous");
		expressRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpressName.setEnabled(true);
				userField.setEnabled(false);
			}
		});
		expressRadio.setBounds(6, 58, 95, 23);
		panel.add(expressRadio);
		
		registeredRadio = new JRadioButton("Registered");
		registeredRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExpressName.setEnabled(false);
				userField.setEnabled(true);
				
			}
		});
		registeredRadio.setBounds(6, 32, 95, 23);
		panel.add(registeredRadio);
		
		group = new ButtonGroup();
		group.add(expressRadio);
		group.add(registeredRadio);
		
		JLabel label_2 = new JLabel("Type of client");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(121, 11, 83, 14);
		panel.add(label_2);
		
		
		
		userField = new JTextField();
		userField.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String[] myString = userField.getText().split(":");
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
		});
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				addUsertoTextField();
		}});
		userField.setEnabled(false);
		userField.setColumns(10);
		userField.setBounds(166, 33, 138, 20);
		panel.add(userField);
		
		JLabel label_3 = new JLabel("User:");
		label_3.setBounds(121, 36, 35, 14);
		
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
		destCombo.setBounds(22, 36, 220, 20);
		panel_1.add(destCombo);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQty.setBounds(307, 11, 39, 14);
		panel_1.add(lblQty);
		
		qtyspn = new JSpinner();
		qtyspn.setBounds(297, 36, 49, 20);
		panel_1.add(qtyspn);
		
		JLabel lblTable = new JLabel("Table");
		lblTable.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTable.setBounds(184, 74, 49, 14);
		panel_1.add(lblTable);
					
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panel_2.setBounds(10, 200, 317, 196);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUserInfo = new JLabel("User info");
		lblUserInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserInfo.setBounds(130, 11, 64, 14);
		panel_2.add(lblUserInfo);
		
		JLabel lblNombre = new JLabel("Name");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 73, 74, 14);
		panel_2.add(lblNombre);
		
		JLabel lblVipLvl = new JLabel("VIP lvl.");
		lblVipLvl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVipLvl.setBounds(10, 123, 74, 14);
		panel_2.add(lblVipLvl);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(10, 98, 74, 14);
		panel_2.add(lblLastName);
		
		 namelbl = new JLabel("namelbl");
		namelbl.setBounds(96, 71, 74, 14);
		panel_2.add(namelbl);
		namelbl.setVisible(false);
		
		
		 lastlbl = new JLabel("lastlbl");
		lastlbl.setBounds(94, 98, 100, 14);
		panel_2.add(lastlbl);
		lastlbl.setVisible(false);
		
		 viplbl = new JLabel("viplbl");
		viplbl.setBounds(94, 123, 100, 14);
		panel_2.add(viplbl);
		viplbl.setVisible(false);
		
		 lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setBounds(10, 148, 46, 14);
		panel_2.add(lblSexo);
		lblSexo.setVisible(true);
		
		 sexolbl = new JLabel("sexolbl");
		sexolbl.setBounds(94, 148, 100, 14);
		panel_2.add(sexolbl);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(10, 44, 56, 16);
		panel_2.add(lblId);
		
		
		idfield = new JLabel("idlbl");
		idfield.setBounds(96, 44, 56, 16);
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
						makeReservation();
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
					destcombomodel.addElement(new String(auxStation.getName()+" ID:"+auxStation.getStation_id()));
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
}
