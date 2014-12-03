package cu.cs.cpsc215.project3;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class SystemInformationDlg extends JDialog {
	private static final long serialVersionUID = -5034921950713479684L;
	
	public SystemInformationDlg() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("System Information");
		setSize(485, 176);
		setLocationByPlatform(true);
		JLabel lblEmailClient = new JLabel("Email Client 1.0 by Jesse Kennedy and Omar Mayar");
		lblEmailClient.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEmailClient, BorderLayout.CENTER);
	}

}
