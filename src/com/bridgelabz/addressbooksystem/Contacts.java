package com.bridgelabz.addressbooksystem;

import java.util.Comparator;
import java.util.Objects;

public class Contacts {
	// Method to compare two Contacts objects by their first name
	public static Comparator<Contacts> FirstNameComparator = new Comparator<Contacts>() {
		public int compare(Contacts c1, Contacts c2) {
			String firstName1 = c1.getFirstName().toUpperCase();
			String firstName2 = c2.getFirstName().toUpperCase();

			// Ascending order
			return firstName1.compareTo(firstName2);
		}
	};
	private String firstName, lastName, address, city, state, email;
	private int zip;
	private long phoneNumber;

	public Contacts() {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	@Override
	public String toString() {
		return "Contacts Details :" + "\n" + "Firstname :" + firstName + "," + "Lastname :" + lastName + ','
				+ "Address :" + address + ',' + "City :" + city + ',' + "State :" + state + ',' + "Zip :" + zip + ','
				+ "PhoneNumber :" + phoneNumber + ',' + "Email :" + email;
	}

}