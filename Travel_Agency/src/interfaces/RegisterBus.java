package interfaces;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import logic.*;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SpinnerNumberModel;

@SuppressWarnings("unused")
public class RegisterBus extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JSpinner year_spinner;
	private JSpinner capacity_spinner;
	private JComboBox<String> modelComboBox;
	private JComboBox<String> brandComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterBus dialog = new RegisterBus();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public RegisterBus() throws ParseException 
	{
		
		modelComboBox = new JComboBox<String>();
		brandComboBox = new JComboBox<String>();
		setTitle("Register Bus");
		setBounds(100, 100, 380, 298);
		getContentPane().setLayout(null);
		contentPanel.setBounds(12, 13, 339, 222);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblMarca = new JLabel("Brand");
		lblMarca.setBounds(20, 46, 46, 14);
		contentPanel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Model");
		lblModelo.setBounds(20, 71, 65, 14);
		contentPanel.add(lblModelo);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(20, 96, 46, 14);
		contentPanel.add(lblYear);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(20, 123, 95, 14);
		contentPanel.add(lblCapacity);
		
		brandComboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				RegisterModel.loadModelCBox(modelComboBox, brandComboBox);
			}
		});
		RegisterBrand.loadBrandCBox(brandComboBox);
		brandComboBox.setBounds(166, 46, 158, 20);
		contentPanel.add(brandComboBox);
		
		RegisterModel.loadModelCBox(modelComboBox, brandComboBox);
		modelComboBox.setBounds(166, 71, 158, 20);
		contentPanel.add(modelComboBox);
		
		year_spinner = new JSpinner();
		capacity_spinner = new JSpinner();
		year_spinner.setModel(new SpinnerNumberModel(1990, 1900, 2016, 1));
		year_spinner.setBounds(166, 96, 59, 20);
		contentPanel.add(year_spinner);

		
		capacity_spinner.setModel(new SpinnerNumberModel(30, 30, 50, 4));
		capacity_spinner.setBounds(166, 120, 60, 20);
		contentPanel.add(capacity_spinner);
		
		JLabel lblBusData = new JLabel("Bus data");
		lblBusData.setFont(new Font("Arial", Font.PLAIN, 13));
		lblBusData.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusData.setBounds(20, 13, 113, 16);
		contentPanel.add(lblBusData);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				insertBus();
			}
		});
		btnNewButton.setBounds(163, 153, 161, 32);
		contentPanel.add(btnNewButton);
	}
	public void insertBus () 
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		System.out.print("Insert into autobuses (autobus_id,marca_id,modelo_id,capacidad,fecha) "
				+ "VALUES ("
				+ "(select count(autobus_id) from autobuses),"
				+ "(select marca_id from marcas where nombre='"+brandComboBox.getSelectedItem()+"'),"
				+ "(select modelo_id from modelos where modelo_id=(select modelo_id from marca_modelo where marca_id=(select marca_id from marcas where nombre='"+brandComboBox.getSelectedItem()+"') and modelo_id=(select modelo_id from marca_modelo where modelo_id=(select modelo_id from modelos where modelo='"+modelComboBox.getSelectedItem()+"') ))),"
				+ capacity_spinner.getValue()+","
				+ year_spinner.getValue()+")");
		myHandler.runUpdate("Insert into autobuses (autobus_id,marca_id,modelo_id,capacidad,fecha) "
				+ "VALUES ("
				+ "(select count(autobus_id) from autobuses),"
				+ "(select marca_id from marcas where nombre='"+brandComboBox.getSelectedItem()+"'),"
				+ "(select modelo_id from modelos where modelo_id=(select modelo_id from marca_modelo where marca_id=(select marca_id from marcas where nombre='"+brandComboBox.getSelectedItem()+"') and modelo_id=(select modelo_id from marca_modelo where modelo_id=(select modelo_id from modelos where modelo='"+modelComboBox.getSelectedItem()+"') ))),"
				+ capacity_spinner.getValue()+","
				+ year_spinner.getValue()+")");
		myHandler.closeConnection();
	}
	/* 
	 * jodido.
	 select marca_id from marcas where nombre='Toyota';
	 
select modelo_id from modelos where modelo_id=(select modelo_id from marca_modelo where marca_id=(select marca_id from marcas where nombre='Toyota') and modelo_id=(select modelo_id=(select modelo_id from modelos where modelo='Volga') ); 
	 
Insert into autobuses (autobus_id,marca_id,modelo_id,capacidad,fecha) VALUES ((select count(autobus_id) from autobuses),(select marca_id from marcas where nombre='Toyota'),
(
	select modelo_id from modelos where 
		modelo_id=(select modelo_id from marca_modelo where marca_id=(select marca_id from marcas where nombre='Toyota') and 
		modelo_id=(select modelo_id from marca_modelo where modelo_id=(select modelo_id from modelos where modelo='Volga') ))),30,1994
)
	 

	 */
}
