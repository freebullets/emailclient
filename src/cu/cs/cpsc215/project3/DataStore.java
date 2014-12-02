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
	
	public Contact findContact(String first, String last) {
		for (Contact i : contacts) {
			if (i.getFirst() == first && i.getLast() == last)
				return i;
		}
		return null;
	}
	
	public String getEmail() {
		return cfg.getEmail();
	}

	public void setEmail(String email) {
		cfg.setEmail(email);
	}

	public String getSmtpServer() {
		return cfg.getSmtpServer();
	}

	public void setSmtpServer(String smtpServer) {
		cfg.setSmtpServer(smtpServer);
	}

}
