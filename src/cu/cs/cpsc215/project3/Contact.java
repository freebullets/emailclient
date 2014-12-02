package cu.cs.cpsc215.project3;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 2890357998132010842L;
	private String first, last, email, address, phone;

	public Contact(String first, String last, String email, String address,	String phone) {
		this.first = first;
		this.last = last;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
