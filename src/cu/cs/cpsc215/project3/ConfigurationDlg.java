package cu.cs.cpsc215.project3;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class ConfigurationDlg extends JDialog {
	private static ConfigurationDlg instance = null;
	private static final long serialVersionUID = -4496578696147097963L;
	private JTextField textField;
	
	public static ConfigurationDlg getInstance() {
		if (instance == null)
			instance = new ConfigurationDlg();
		return instance;
	}
	
	public ConfigurationDlg() {
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("System Configuration");
		setSize(400, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnSave = new JButton("Save");
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
	}
	

}
