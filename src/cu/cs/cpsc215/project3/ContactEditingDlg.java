package cu.cs.cpsc215.project3;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class ContactEditingDlg extends JDialog {
	private static final long serialVersionUID = 1934754311031699765L;
	private Integer contactID = -1;
	
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private Color defaultColor;
	private DataStore ds = DataStore.getInstance();
	
	public ContactEditingDlg() {
		setSize(291, 177);
		setTitle("Contacts");
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panelOuter = new JPanel();
		getContentPane().add(panelOuter);
		panelOuter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInner = new JPanel();
		panelOuter.add(panelInner);
		GridBagLayout gbl_panelInner = new GridBagLayout();
		gbl_panelInner.columnWidths = new int[]{87, 142, 0};
		gbl_panelInner.rowHeights = new int[]{1, 0, 0, 0, 0, 0};
		gbl_panelInner.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelInner.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInner.setLayout(gbl_panelInner);
		
		JLabel lblFirst = new JLabel("First:");
		GridBagConstraints gbc_lblFirst = new GridBagConstraints();
		gbc_lblFirst.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirst.fill = GridBagConstraints.BOTH;
		gbc_lblFirst.gridx = 0;
		gbc_lblFirst.gridy = 0;
		panelInner.add(lblFirst, gbc_lblFirst);
		lblFirst.setLabelFor(txtFirst);
		
		txtFirst = new JTextField();
		GridBagConstraints gbc_txtFirst = new GridBagConstraints();
		gbc_txtFirst.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirst.fill = GridBagConstraints.BOTH;
		gbc_txtFirst.gridx = 1;
		gbc_txtFirst.gridy = 0;
		panelInner.add(txtFirst, gbc_txtFirst);
		
		JLabel lblLast = new JLabel("Last:");
		GridBagConstraints gbc_lblLast = new GridBagConstraints();
		gbc_lblLast.insets = new Insets(0, 0, 5, 5);
		gbc_lblLast.fill = GridBagConstraints.BOTH;
		gbc_lblLast.gridx = 0;
		gbc_lblLast.gridy = 1;
		panelInner.add(lblLast, gbc_lblLast);
		lblLast.setLabelFor(txtLast);
		
		txtLast = new JTextField();
		GridBagConstraints gbc_txtLast = new GridBagConstraints();
		gbc_txtLast.insets = new Insets(0, 0, 5, 0);
		gbc_txtLast.fill = GridBagConstraints.BOTH;
		gbc_txtLast.gridx = 1;
		gbc_txtLast.gridy = 1;
		panelInner.add(txtLast, gbc_txtLast);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		panelInner.add(lblEmail, gbc_lblEmail);
		lblEmail.setLabelFor(txtEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 2;
		panelInner.add(txtEmail, gbc_txtEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.fill = GridBagConstraints.BOTH;
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 3;
		panelInner.add(lblAddress, gbc_lblAddress);
		
		txtAddress = new JTextField();
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddress.fill = GridBagConstraints.BOTH;
		gbc_txtAddress.gridx = 1;
		gbc_txtAddress.gridy = 3;
		panelInner.add(txtAddress, gbc_txtAddress);
		lblAddress.setLabelFor(txtAddress);
		
		JLabel lblPhone = new JLabel("Phone:");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhone.fill = GridBagConstraints.BOTH;
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 4;
		panelInner.add(lblPhone, gbc_lblPhone);
		
		txtPhone = new JTextField();
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.BOTH;
		gbc_txtPhone.gridx = 1;
		gbc_txtPhone.gridy = 4;
		panelInner.add(txtPhone, gbc_txtPhone);
		lblPhone.setLabelFor(txtPhone);
		
		defaultColor = txtFirst.getBackground();
		
		JButton btnSave = new JButton("Save");
		panelOuter.add(btnSave, BorderLayout.SOUTH);
		btnSave.addActionListener(new ActionListener() {
			CharSequence emailChars = "@";
			public void actionPerformed(ActionEvent e) {
				if (!txtEmail.getText().contains(emailChars)) {
					txtEmail.setBackground(UIManager.getColor("OptionPane.errorDialog.titlePane.background"));
					return;
				}
				txtEmail.setBackground(defaultColor);
				
				if (ContactEditingDlg.this.contactID > -1) {
					// Edit an existing contact
					Contact c = ds.getContact(ContactEditingDlg.this.contactID);
					c.setFirst(txtFirst.getText());
					c.setLast(txtLast.getText());
					c.setEmail(txtEmail.getText());
					c.setAddress(txtAddress.getText());
					c.setPhone(txtPhone.getText());
				} else {
					// Add a new contact
					ds.addContact(txtFirst.getText(), txtLast.getText(), txtEmail.getText(), txtAddress.getText(), txtPhone.getText());
				}
				MainFrame.getInstance().refreshData();
				ContactEditingDlg.this.setVisible(false);
			}
		});
	}
	
	public void fillFields(Integer row) {
		Contact c = DataStore.getInstance().getContact(row);
		txtFirst.setText(c.getFirst());
		txtLast.setText(c.getLast());
		txtEmail.setText(c.getEmail());
		txtAddress.setText(c.getAddress());
		txtPhone.setText(c.getPhone());
		txtFirst.requestFocus();
		contactID = row;
	}
	
	public void clearFields() {
		txtFirst.setText("");
		txtLast.setText("");
		txtEmail.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
		txtFirst.requestFocus();
		contactID = -1;
	}
}
