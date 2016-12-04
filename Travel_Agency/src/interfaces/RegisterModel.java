package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegisterModel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterModel dialog = new RegisterModel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterModel() {
		setTitle("Manage Models");
		setBounds(100, 100, 368, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		loadModelCBox(comboBox);
		comboBox.setBounds(10, 30, 161, 20);
		contentPanel.add(comboBox);
				
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updateModel(comboBox);
				int saved=comboBox.getSelectedIndex();
				loadModelCBox(comboBox);
				comboBox.setSelectedIndex(saved);
			}
		});
		btnEdit.setBounds(181, 29, 63, 23);
		contentPanel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				deleteModel(comboBox);
				loadModelCBox(comboBox);
			}
		});
		btnDelete.setBounds(254, 29, 88, 23);
		contentPanel.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(10, 97, 198, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener
		(
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					insertModel();
					int saveindex = comboBox.getSelectedIndex();
					loadModelCBox(comboBox);
					comboBox.setSelectedIndex(saveindex);
				}
			}
		);
		btnRegister.setBounds(218, 96, 124, 23);
		contentPanel.add(btnRegister);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Done");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public void loadModelCBox(JComboBox<String> comboBox)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");					
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mrwhite","IamZero1995");
			Statement st = con.createStatement();
			String sql = "select (count(modelo)) from modelos";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			String myString[] = new String[rs.getInt(1)];
			
			sql = "select modelo from modelos";
			rs = st.executeQuery(sql);
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
				comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ninguno"}));
			}
				con.close();
		}
		catch (Exception ex) 
		{
			System.out.println(ex);
		}
	}
	public void insertModel()
	{
			//String query = "select modelo from modelos";
			//runQuery(query);
			// Insert
			String insert = "Insert into modelos "+ "VALUES ((select count(modelo_ID) from modelos),'"+textField.getText()+"')";
			runUpdate(insert);
	}
	public void deleteModel(JComboBox<String> comboBox)
	{
			String delete = ("Delete from modelos where modelo='"+comboBox.getSelectedItem()+"'");
			runUpdate(delete);
	}
	public void updateModel(JComboBox<String> comboBox)
	{
			String update = ("update modelos set modelo='"+textField.getText()+"' where modelo='"+comboBox.getSelectedItem()+"'");
			runUpdate(update);
	}
	public int runUpdate(String SQL_to_run)
	{
		int rs=-1;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");					
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mrwhite","IamZero1995");
			Statement st = con.createStatement();
			// DELETE
			 rs = st.executeUpdate(SQL_to_run);
			con.close();
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return rs;
	}
	public ResultSet runQuery(String SQL_to_run)
	{
		ResultSet rs= null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");					
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mrwhite","IamZero1995");
			Statement st = con.createStatement();
			 rs = st.executeQuery(SQL_to_run);
			con.close();
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return rs;
	}
}

