package com.bridgelabz.addressbooksystem;

public class Contacts {

	private String firstName, lastName, address, city, state, email;
	private int zip;
	private long phoneNumber;

	public void Contacts(String firstName, String lastName, String address, String city, String state, int zip,
			long phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void show() {
		System.out.println(this.firstName + "" + this.lastName + "" + this.address + "" + this.city + "" + this.state
				+ "" + this.email + "" + this.zip + "" + this.phoneNumber);

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {

		this.phoneNumber = phoneNumber;
	}
}
