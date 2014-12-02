package cu.cs.cpsc215.project3;

import javax.swing.JDialog;

public class ConfigurationDlg extends JDialog {
	private static ConfigurationDlg instance = null;
	
	public static ConfigurationDlg getInstance() {
		if (instance == null)
			instance = new ConfigurationDlg();
		return instance;
	}
	
	public ConfigurationDlg() {
		setTitle("System Configuration");
		setModalityType(ModalityType.APPLICATION_MODAL);
	}
	
	private static final long serialVersionUID = -4496578696147097963L;

}
