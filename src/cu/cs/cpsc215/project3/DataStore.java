package cu.cs.cpsc215.project3;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataStore {
	private static DataStore instance = null;
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	private Configuration cfg = new Configuration();
	
	private DataStore() {
		// Cobwebs
	}
	
	public static DataStore getInstance() {
		if (instance == null)
			instance = new DataStore();
		return instance;
	}
	
	public void save() {
		try {
			FileOutputStream fout = new FileOutputStream("AddressBook.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(cfg);
			oos.writeObject(contacts);
			oos.close();
			fout.close();
		} catch(Exception ex) {
		   	ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")  // For casting ArrayList
	public void load() {
		try {
			FileInputStream fin = new FileInputStream("AddressBook.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			cfg = (Configuration) ois.readObject();
			contacts = (ArrayList<Contact>) ois.readObject();
			ois.close();
			fin.close();
		} catch(Exception ex) {
		   	ex.printStackTrace();
		}
	}
	
	public void addContact(String first, String last, String email, String address,	String phone) {
		contacts.add(new Contact(first, last, email, address, phone));
	}
	
	public void addContact(Contact c) {
		contacts.add(c);
	}
	
	public void removeContact(int index) {
		contacts.remove(index);
	}
	
	public int getContactCount() {
		return contacts.size();
	}
	
	public Contact getContact(int index) {
		return contacts.get(index);
	}
	
	public String getEmail() {
		return cfg.getEmail();
	}
	public void setEmail(String email) {
		cfg.setEmail(email);
	}
	public String getPassword() {
		return cfg.getPassword();
	}
	public void setPassword(String password) {
		cfg.setPassword(password);
	}
	public String getSmtpServer() {
		return cfg.getSmtpServer();
	}
	public void setSmtpServer(String smtpServer) {
		cfg.setSmtpServer(smtpServer);
	}
	public Integer getSmtpPort() {
		return cfg.getSmtpPort();
	}
	public void setSmtpPort(Integer smtpPort) {
		cfg.setSmtpPort(smtpPort);
	}
	public Boolean getSecure() {
		return cfg.getSecure();
	}
	public void setSecure(Boolean secure) {
		cfg.setSecure(secure);
	}

}
