package cu.cs.cpsc215.project3;

import javax.swing.JDialog;

public class EmailTransmissionDlg extends JDialog {
	private static EmailTransmissionDlg instance = null;
	
	public static EmailTransmissionDlg getInstance() {
		if (instance == null)
			instance = new EmailTransmissionDlg();
		return instance;
	}
	
	public EmailTransmissionDlg() {
		setTitle("Email Composer");
		setModalityType(ModalityType.APPLICATION_MODAL);
	}
	
	private static final long serialVersionUID = 4104111623221324151L;

}
