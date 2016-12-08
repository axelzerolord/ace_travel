package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.*;

import javax.swing.JLabel;

public class RegisterModel extends JDialog {

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
	public RegisterModel() 
	{
		final JComboBox<String> modelComboBox = new JComboBox<String>();
		final JComboBox<String> brandComboBox = new JComboBox<String>();
		setTitle("Manage Models");
		setBounds(100, 100, 368, 234);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//brandComboBox
		brandComboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//load models;
				loadModelCBox(modelComboBox, brandComboBox);
			}
		});
		RegisterBrand.loadBrandCBox(brandComboBox);
		brandComboBox.setBounds(14, 43, 161, 22);
		contentPanel.add(brandComboBox);
		
		JLabel lblMarca = new JLabel("Brand");
		lblMarca.setBounds(14, 25, 56, 20);
		contentPanel.add(lblMarca);
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
			
		loadModelCBox(modelComboBox, brandComboBox);
		modelComboBox.setBounds(14, 86, 161, 20);
		contentPanel.add(modelComboBox);
				
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				updateModel(modelComboBox);
				int saved=modelComboBox.getSelectedIndex();
				loadModelCBox(modelComboBox, brandComboBox);
				modelComboBox.setSelectedIndex(saved);
			}
		});
		btnEdit.setBounds(187, 85, 63, 23);
		contentPanel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				deleteModel(modelComboBox,brandComboBox);
				loadModelCBox(modelComboBox, brandComboBox);
			}
		});
		btnDelete.setBounds(262, 85, 88, 23);
		contentPanel.add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(14, 119, 161, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener
		(
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					insertModel(brandComboBox);
					int saveindex = modelComboBox.getSelectedIndex();
					loadModelCBox(modelComboBox, brandComboBox);
					modelComboBox.setSelectedIndex(saveindex);
				}
			}
		);
		btnRegister.setBounds(187, 118, 163, 23);
		contentPanel.add(btnRegister);
		
		JLabel model_label = new JLabel("Model");
		model_label.setBounds(14, 67, 72, 16);
		contentPanel.add(model_label);
	}
	
	public static void loadModelCBox(JComboBox<String> modelComboBox, JComboBox<String> brandComboBox)
	{
		DatabaseHandler myHandler = new DatabaseHandler();
			ResultSet rs = myHandler.runQuery("select (count(modelo)) from marcas,modelos, marca_modelo where marcas.marca_ID=marca_modelo.marca_id and modelos.modelo_ID=marca_modelo.modelo_ID and nombre='"+brandComboBox.getSelectedItem()+"'");
			try 
			{
				rs.next();
				String myString[] = new String[rs.getInt(1)];
				rs = myHandler.runQuery("select modelo from marcas,modelos, marca_modelo where marcas.marca_ID=marca_modelo.marca_id and modelos.modelo_ID=marca_modelo.modelo_ID and nombre='"+brandComboBox.getSelectedItem()+"'");
				int i=0;
				while (rs.next()) 
				{
					myString[i]=rs.getString(1);
					i++;
				}
				if(i>0)
				{
					modelComboBox.setModel(new DefaultComboBoxModel<String>(myString));
				}
				else
				{
					modelComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"none"}));
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			myHandler.closeConnection();
	}
	
	
	public void insertModel(JComboBox<String> brandComboBox)
	{
			DatabaseHandler myHandler = new DatabaseHandler();
			myHandler.runUpdate("Insert into modelos "+ "VALUES ((select count(modelo_ID) from modelos),'"+textField.getText()+"')");
			myHandler.runUpdate("Insert into marca_modelo VALUES ((select marca_ID from marcas where nombre='"+brandComboBox.getSelectedItem()+"'),"
							+"((select count(modelo_ID) from modelos)-1))");
	}
	
	public void deleteModel(JComboBox<String> modelComboBox, JComboBox<String> brandComboBox)
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		//deletes from marca_modelo
		myHandler.runUpdate
		("delete from marca_modelo where "
				+ "marca_modelo.modelo_ID=(select modelos.modelo_ID from modelos where modelo='"+modelComboBox.getSelectedItem()+"') and " 
				+ "marca_modelo.marca_ID=(select marcas.marca_ID from marcas where nombre='"+brandComboBox.getSelectedItem()+"')"
		);
		//alter row from modelos (make value "deleted"
		myHandler.runUpdate("update modelos set modelo = 'deleted' where modelo_id=(select min(modelo_id) from ((select * from modelos where modelo!='deleted'	) minus (select modelos.modelo_id, modelos.modelo from marca_modelo,modelos where marca_modelo.modelo_ID=modelos.modelo_Id)))");
	}
	
	//
	
	public void updateModel(JComboBox<String> comboBox)
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		myHandler.runQuery("update modelos set modelo='"+textField.getText()+"' where modelo='"+comboBox.getSelectedItem()+"'");
	}
}

