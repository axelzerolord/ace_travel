package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class RegisterBus extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
	 */
	public RegisterBus() {
		setTitle("Register Bus");
		setBounds(100, 100, 311, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 295, 202);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblMarca = new JLabel("Brand");
		lblMarca.setBounds(20, 46, 46, 14);
		contentPanel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Model");
		lblModelo.setBounds(20, 71, 46, 14);
		contentPanel.add(lblModelo);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(20, 96, 46, 14);
		contentPanel.add(lblYear);
		
		JLabel lblAdquisitionDate = new JLabel("Adquisition date");
		lblAdquisitionDate.setBounds(20, 121, 83, 14);
		contentPanel.add(lblAdquisitionDate);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(20, 146, 46, 14);
		contentPanel.add(lblCapacity);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(111, 43, 158, 20);
		contentPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(111, 68, 158, 20);
		contentPanel.add(comboBox_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(111, 93, 59, 20);
		contentPanel.add(spinner);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(110, 118, 104, 20);
		contentPanel.add(formattedTextField);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(110, 143, 60, 20);
		contentPanel.add(spinner_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setBounds(0, 228, 295, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
