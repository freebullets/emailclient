package cu.cs.cpsc215.project3;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class SystemInformationDlg extends JDialog {
	private static SystemInformationDlg instance = null;
	
	public static SystemInformationDlg getInstance() {
		if (instance == null)
			instance = new SystemInformationDlg();
		return instance;
	}
	
	public SystemInformationDlg() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("System Information");
		setSize(400, 200);
		JLabel lblEmailClient = new JLabel("Email Client 1.0 by Jesse Kennedy");
		lblEmailClient.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEmailClient, BorderLayout.CENTER);
	}
	
	private static final long serialVersionUID = -5034921950713479684L;

}
