package interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.DatabaseHandler;

public class RegisterBrand extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterBrand dialog = new RegisterBrand();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterBrand() 
	{
		setTitle("Manage Brands");
		setBounds(100, 100, 368, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 30, 161, 20);
		contentPanel.add(comboBox);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updateBrand(comboBox);
				int saved=comboBox.getSelectedIndex();
				loadBrandCBox(comboBox);
				comboBox.setSelectedIndex(saved);
			}
		});
		btnEdit.setBounds(181, 29, 63, 23);
		contentPanel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				deleteBrand(comboBox);
				loadBrandCBox(comboBox);
			}
		});
		btnDelete.setBounds(254, 29, 88, 23);
		contentPanel.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(10, 97, 198, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				insertBrand();
				int saveindex = comboBox.getSelectedIndex();
				loadBrandCBox(comboBox);
				comboBox.setSelectedIndex(saveindex);
			}
		});
		btnRegister.setBounds(218, 96, 124, 23);
		contentPanel.add(btnRegister);
		
		JButton doneButton = new JButton("Done");
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		doneButton.setBounds(228, 144, 114, 32);
		contentPanel.add(doneButton);
	}
	public static void loadBrandCBox(JComboBox<String> comboBox)
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet rs = myHandler.runQuery("select (count(nombre)) from marcas");
		try 
		{
			rs.next();
			String myString[] = new String[rs.getInt(1)];
			rs = myHandler.runQuery("select nombre from marcas");
			int i=0;
			while (rs.next()) 
			{
				myString[i]=rs.getString(1);
				i++;
			}
			if(i>0)
			{
				comboBox.setModel(new DefaultComboBoxModel<String>(myString));
			}
			else
			{
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"none"}));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		myHandler.closeConnection();
	}
	
	public void insertBrand()
	{
			DatabaseHandler myHandler = new DatabaseHandler();
			myHandler.runUpdate("Insert into marcas "+ "VALUES ((select count(marca_ID) from marcas),'"+textField.getText()+"')");
	}
	public void deleteBrand(JComboBox<String> comboBox)
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		myHandler.runQuery("Delete from marcas where nombre='"+comboBox.getSelectedItem()+"'");
	}
	public void updateBrand(JComboBox<String> comboBox)
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		myHandler.runQuery("update marcas set nombre='"+textField.getText()+"' where nombre='"+comboBox.getSelectedItem()+"'");
	}
}
