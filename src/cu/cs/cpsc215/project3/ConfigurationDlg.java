package cu.cs.cpsc215.project3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ConfigurationDlg extends JDialog {
	private static final long serialVersionUID = -4496578696147097963L;
	private JTextField txtSmtpHost;
	private JTextField txtSmtpPort;
	private JCheckBox chkStartTLS;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private Color defaultColor;
	
	public ConfigurationDlg() {
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("System Configuration");
		setSize(334, 186);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelMain = new JPanel();
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[]{116, 0, 0};
		gbl_panelMain.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelMain.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel lblHost = new JLabel("SMTP Host");
		GridBagConstraints gbc_lblHost = new GridBagConstraints();
		gbc_lblHost.anchor = GridBagConstraints.WEST;
		gbc_lblHost.insets = new Insets(0, 0, 5, 5);
		gbc_lblHost.gridx = 0;
		gbc_lblHost.gridy = 0;
		panelMain.add(lblHost, gbc_lblHost);
		
		txtSmtpHost = new JTextField();
		GridBagConstraints gbc_txtSmtpHost = new GridBagConstraints();
		gbc_txtSmtpHost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSmtpHost.anchor = GridBagConstraints.WEST;
		gbc_txtSmtpHost.insets = new Insets(0, 0, 5, 0);
		gbc_txtSmtpHost.gridx = 1;
		gbc_txtSmtpHost.gridy = 0;
		panelMain.add(txtSmtpHost, gbc_txtSmtpHost);
		txtSmtpHost.setText("smtp.gmail.com");
		txtSmtpHost.setColumns(20);
		
		JLabel lblSmtpPort = new JLabel("SMTP Port");
		GridBagConstraints gbc_lblSmtpPort = new GridBagConstraints();
		gbc_lblSmtpPort.anchor = GridBagConstraints.WEST;
		gbc_lblSmtpPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblSmtpPort.gridx = 0;
		gbc_lblSmtpPort.gridy = 1;
		panelMain.add(lblSmtpPort, gbc_lblSmtpPort);
		
		txtSmtpPort = new JTextField();
		GridBagConstraints gbc_txtSmtpPort = new GridBagConstraints();
		gbc_txtSmtpPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSmtpPort.anchor = GridBagConstraints.WEST;
		gbc_txtSmtpPort.insets = new Insets(0, 0, 5, 0);
		gbc_txtSmtpPort.gridx = 1;
		gbc_txtSmtpPort.gridy = 1;
		panelMain.add(txtSmtpPort, gbc_txtSmtpPort);
		txtSmtpPort.setText("587");
		txtSmtpPort.setColumns(20);
		
		chkStartTLS = new JCheckBox("StartTLS");
		GridBagConstraints gbc_chkStartTLS = new GridBagConstraints();
		gbc_chkStartTLS.anchor = GridBagConstraints.WEST;
		gbc_chkStartTLS.insets = new Insets(0, 0, 5, 0);
		gbc_chkStartTLS.gridx = 1;
		gbc_chkStartTLS.gridy = 2;
		panelMain.add(chkStartTLS, gbc_chkStartTLS);
		chkStartTLS.setSelected(true);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 3;
		panelMain.add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.anchor = GridBagConstraints.WEST;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 3;
		panelMain.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(20);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		panelMain.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		panelMain.add(passwordField, gbc_passwordField);
		getContentPane().add(panelMain, BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigurationDlg.this.save();
			}
		});
		panelButtons.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigurationDlg.this.setVisible(false);
			}
		});
		panelButtons.add(btnCancel);
		
		defaultColor = txtSmtpPort.getBackground();
		fillFields();
	}
	
	@SuppressWarnings("deprecation")
	private void save() {
		Integer smtpPort;
		try {
			smtpPort = Integer.parseInt(txtSmtpPort.getText());
		} catch (NumberFormatException e) {
			txtSmtpPort.setBackground(UIManager.getColor("OptionPane.errorDialog.titlePane.background"));
			return;
		}
		txtSmtpPort.setBackground(defaultColor);
		
		// Host can be an IP address, hostname, etc. Just check that it's filled.
		if (txtSmtpHost.getText().length() <= 0) {
			txtSmtpHost.setBackground(UIManager.getColor("OptionPane.errorDialog.titlePane.background"));
			return;
		}
		txtSmtpHost.setBackground(defaultColor);
		
		DataStore.getInstance().setSmtpServer(txtSmtpHost.getText());
		DataStore.getInstance().setSmtpPort(smtpPort);
		DataStore.getInstance().setSecure(chkStartTLS.isSelected());
		DataStore.getInstance().setEmail(txtUsername.getText());
		DataStore.getInstance().setPassword(passwordField.getText());
		
		setVisible(false);
	}
	
	private void fillFields() {
		txtSmtpHost.setText(DataStore.getInstance().getSmtpServer());
		txtSmtpPort.setText(DataStore.getInstance().getSmtpPort().toString());
		chkStartTLS.setSelected(DataStore.getInstance().getSecure());
		txtUsername.setText(DataStore.getInstance().getEmail());
		passwordField.setText(DataStore.getInstance().getPassword());
	}
}
