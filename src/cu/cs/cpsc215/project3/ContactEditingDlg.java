package cu.cs.cpsc215.project3;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactEditingDlg extends JDialog {
	private static final long serialVersionUID = 1934754311031699765L;
	private static ContactEditingDlg instance = null;
	
	public static ContactEditingDlg getInstance() {
		if (instance == null)
			instance = new ContactEditingDlg();
		return instance;
	}
	
	JTextField txtFirst;
	JTextField txtLast;
	JTextField txtEmail;
	JTextField txtPhone;
	JTextField txtAddress;
	DataStore ds = DataStore.getInstance();
	
	public ContactEditingDlg() {
		setSize(300, 220);
		setTitle("Contacts");
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel(new SpringLayout());
		getContentPane().add(panel);
		
		JLabel lblFirst = new JLabel("First:");
		panel.add(lblFirst);
		
		txtFirst = new JTextField();
		panel.add(txtFirst);
		lblFirst.setLabelFor(txtFirst);
		
		JLabel lblLast = new JLabel("Last:");
		panel.add(lblLast);
		
		txtLast = new JTextField();
		panel.add(txtLast);
		lblLast.setLabelFor(txtLast);
		
		JLabel lblEmail = new JLabel("Email:");
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		panel.add(txtEmail);
		lblEmail.setLabelFor(txtEmail);
		
		JLabel lblPhone = new JLabel("Phone:");
		panel.add(lblPhone);
		
		txtPhone = new JTextField();
		panel.add(txtPhone);
		lblPhone.setLabelFor(txtPhone);
		
		JLabel lblAddress = new JLabel("Address:");
		panel.add(lblAddress);
		
		txtAddress = new JTextField();
		panel.add(txtAddress);
		lblAddress.setLabelFor(txtAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contact c = ds.findContact(txtFirst.getText(), txtLast.getText());
				if (c != null) {
					c.setEmail(txtEmail.getText());
					c.setAddress(txtAddress.getText());
					c.setPhone(txtPhone.getText());
					ContactEditingDlg.getInstance().setVisible(false);
				} else {
					ds.addContact(txtFirst.getText(), txtLast.getText(), txtEmail.getText(), txtAddress.getText(), txtPhone.getText());
					ContactEditingDlg.getInstance().setVisible(false);
				}
			}
		});
		getContentPane().add(btnSave);

		SpringUtilities.makeCompactGrid(panel, 5, 2, 10, 10, 10, 10);
	}
	
	public void fillFields(String first, String last, String email, String address,	String phone) {
		txtFirst.setText(first);
		txtLast.setText(last);
		txtEmail.setText(email);
		txtAddress.setText(address);
		txtPhone.setText(phone);
		txtFirst.setEnabled(false);
		txtLast.setEnabled(false);
	}
	
}
