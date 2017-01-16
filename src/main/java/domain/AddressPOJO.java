package domain;


import java.io.Serializable;

public class AddressPOJO implements Serializable {

	private String street;
	private String number;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public AddressPOJO(String street, String number) {
		this.street = street;
		this.number = number;
	}

}
