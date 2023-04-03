package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem extends Contacts {

	Contacts contacts = new Contacts();
	Scanner scanner = new Scanner(System.in);
	List<Contacts> Contacts = new ArrayList<Contacts>();

	public void addContacts() {

		System.out.println("Enter First Name : ");
		String firstName = scanner.nextLine();
		contacts.setFirstName(firstName);

		System.out.println("Enter Last Name : ");
		String lastName = scanner.nextLine();
		contacts.setLastName(lastName);

		System.out.println("Enter Address :");
		String address = scanner.nextLine();
		contacts.setAddress(address);

		System.out.println("Enter City : ");
		String city = scanner.nextLine();
		contacts.setCity(city);

		System.out.println("Enter State : ");
		String state = scanner.nextLine();
		contacts.setState(state);

		System.out.println("Enter Email : ");
		String email = scanner.nextLine();
		contacts.setEmail(email);

		System.out.println("Enter ZIP : ");
		int zip = scanner.nextInt();
		contacts.setZip(zip);

		System.out.println("Enter Phone Number");
		long phoneNumber = scanner.nextLong();
		contacts.setPhoneNumber(phoneNumber);

		Contacts.add(contacts);
		System.out.println("Person Information has created sucessfully");

	}

	public void displayContacts() {

		if (Contacts.isEmpty()) {
			System.out.println("Address Book Is Empty");
		}
		System.out.println("Address book");
		for (Contacts contacts : Contacts) {

			System.out.println(contacts.getFirstName());
			System.out.println(contacts.getLastName());
			System.out.println(contacts.getAddress());
			System.out.println(contacts.getCity());
			System.out.println(contacts.getState());
			System.out.println(contacts.getEmail());
			System.out.println(contacts.getZip());
			System.out.println(contacts.getPhoneNumber());
		}

	}

	public void editContact(String firstName, String lastName) {

		for (Contacts contact : Contacts) {
			if (contact.getFirstName().equals(firstName) || contact.getLastName().equals(lastName)) {
				System.out.println("Enter new First Name:");
				String firstNameString = scanner.nextLine();
				contact.setFirstName(firstName);

				System.out.println("Enter new Last Name:");
				String lastNameString = scanner.nextLine();
				contact.setLastName(lastName);

				System.out.println("Enter new Address:");
				String address = scanner.nextLine();
				contact.setAddress(address);

				System.out.println("Enter new City:");
				String city = scanner.nextLine();
				contact.setCity(city);

				System.out.println("Enter new State:");
				String state = scanner.nextLine();
				contact.setState(state);

				System.out.println("Enter new Email:");
				String email = scanner.nextLine();
				contact.setEmail(email);

				System.out.println("Enter new ZIP:");
				int zip = scanner.nextInt();
				contact.setZip(zip);

				System.out.println("Enter new Phone Number:");
				long phoneNumber = scanner.nextLong();
				contact.setPhoneNumber(phoneNumber);

				System.out.println("Contact updated successfully");

			}
		}
		System.out.println("Contact not found");
	}

	public void deleteContact(String firstName, String lastName) {
	    int index = -1;
	    for (int i = 0; i < Contacts.size(); i++) {
	        Contacts contact = Contacts.get(i);
	        if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
	            index = i;
	            break;
	        }
	    }

	    if (index >= 0) {
	        Contacts.remove(index);
	        System.out.println("Person deleted successfully.");
	    } else {
	        System.out.println("Person not found.");
	    }
	}

}
