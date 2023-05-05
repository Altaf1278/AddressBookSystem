package com.bridgelabz.advanceaddressbook;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Date;
import java.time.LocalDate;
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
	private LocalDate date_joining;

	public Contacts(String firstName, String lastName, String address, String city, String state, String email, int zip,
			long phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.date_joining = date_joining;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public Contacts() {
		// TODO Auto-generated constructor stub
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

	public LocalDate getDate_joining() {
		return date_joining;
	}

	public void setDate_joining(LocalDate date_joining) {
		this.date_joining = date_joining;
	}

	@Override
	public String toString() {
		return "Contacts [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", email=" + email + ", zip=" + zip + ", phoneNumber=" + phoneNumber
				+ ", date_joining=" + date_joining + "]";
	}

	public void setId(int int1) {
		// TODO Auto-generated method stub

	}
	
}
