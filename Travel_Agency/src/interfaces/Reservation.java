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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import com.mxrck.autocompleter.TextAutoCompleter;


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
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				addUsertoTextField();
				if(e.getKeyChar()<'0' |e.getKeyChar()>'9')
				{
					e.consume();
				}
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
		
		destCombo = new JComboBox<String>();
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
		lblNombre.setBounds(10, 40, 74, 14);
		panel_2.add(lblNombre);
		
		JLabel lblVipLvl = new JLabel("VIP lvl.");
		lblVipLvl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVipLvl.setBounds(10, 90, 74, 14);
		panel_2.add(lblVipLvl);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(10, 65, 74, 14);
		panel_2.add(lblLastName);
		
		JLabel namelbl = new JLabel("namelbl");
		namelbl.setBounds(94, 40, 100, 14);
		panel_2.add(namelbl);
		namelbl.setVisible(false);
		
		
		JLabel lastlbl = new JLabel("lastlbl");
		lastlbl.setBounds(94, 65, 100, 14);
		panel_2.add(lastlbl);
		lastlbl.setVisible(false);
		
		JLabel viplbl = new JLabel("viplbl");
		viplbl.setBounds(94, 90, 100, 14);
		panel_2.add(viplbl);
		viplbl.setVisible(false);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexo.setBounds(10, 115, 46, 14);
		panel_2.add(lblSexo);
		lblSexo.setVisible(false);
		
		JLabel sexolbl = new JLabel("sexolbl");
		sexolbl.setBounds(94, 115, 56, 14);
		panel_2.add(sexolbl);
		sexolbl.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
		for(Client clientes: )
		{	
			//textAutoAcompleter.addItem(worker.getId());
		}
	}
}
