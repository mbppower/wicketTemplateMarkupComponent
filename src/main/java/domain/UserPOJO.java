package domain;

import java.io.Serializable;
import java.util.Date;

public class UserPOJO implements Serializable {

	private String name;
	private String lastname;
	private Date creationDate;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	private AddressPOJO address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public AddressPOJO getAddress() {
		return address;
	}

	public void setAddress(AddressPOJO address) {
		this.address = address;
	}

	public UserPOJO(String name, String lastname, Date creationDate, AddressPOJO address) {
		this.name = name;
		this.lastname = lastname;
		this.creationDate = creationDate;
		this.address = address;
	}
}
