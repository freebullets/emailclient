package cu.cs.cpsc215.project3;

import java.io.Serializable;

public class Configuration implements Serializable {
	private static final long serialVersionUID = 404084985614717941L;
	private String email, smtpServer;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

}
