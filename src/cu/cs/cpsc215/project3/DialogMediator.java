package cu.cs.cpsc215.project3;

public class DialogMediator {
	// Shorthand singleton voodoo dance
	private static DialogMediator instance = new DialogMediator();
	
	private DialogMediator() {
	}
	
	public static DialogMediator getInstance() {
		return instance;
	}
	
	private ConfigurationDlg cfgDlg = new ConfigurationDlg();
	private ContactEditingDlg contactDlg = new ContactEditingDlg();
	private EmailTransmissionDlg transDlg = new EmailTransmissionDlg();
	private SystemInformationDlg sysDlg = new SystemInformationDlg();

	public ConfigurationDlg getCfgDlg() {
		return cfgDlg;
	}

	public ContactEditingDlg getContactDlg() {
		return contactDlg;
	}

	public EmailTransmissionDlg getTransDlg() {
		return transDlg;
	}

	public SystemInformationDlg getSysDlg() {
		return sysDlg;
	}
}
