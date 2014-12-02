package cu.cs.cpsc215.project3;

import java.io.Serializable;

public class Configuration implements Serializable {
	private static final long serialVersionUID = 404084985614717941L;
	private String email, password, smtpServer;
	private Integer smtpPort;
	private Boolean secure;
	
	public Configuration() {
		email = "";
		password = "";
		smtpServer = "";
		
		smtpPort = new Integer(25);
		secure = new Boolean(true);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSmtpServer() {
		return smtpServer;
	}
	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}
	public Integer getSmtpPort() {
		return smtpPort;
	}
	public void setSmtpPort(Integer smtpPort) {
		if (smtpPort == null) this.smtpPort = new Integer(25);
		this.smtpPort = smtpPort;
	}
	public Boolean getSecure() {
		return secure;
	}
	public void setSecure(Boolean secure) {
		this.secure = secure;
	}

}
