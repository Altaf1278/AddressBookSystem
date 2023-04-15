package com.bridgelabz.addressbooksystem;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem extends Contacts {

	Contacts contacts = new Contacts();
	Scanner scanner = new Scanner(System.in);
	List<Contacts> Contacts = new ArrayList<Contacts>();
	Map<String, List<Contacts>> addressBooks = new HashMap<>();

	public void addAddressBook() {
		System.out.println("Enter the name of the new address book:");
		String name = scanner.nextLine();
		addressBooks.put(name, new ArrayList<Contacts>());
		System.out.println("Address book '" + name + "' added successfully.");
	}

	public void displayAddressBooks() {
		if (addressBooks.isEmpty()) {
			System.out.println("No address books found.");
			return;
		}
		System.out.println("List of address books:");
		for (String name : addressBooks.keySet()) {
			System.out.println(name);
		}
	}

	public void openAddressBook() {
		System.out.println("Enter the name of the address book you want to open:");
		String name = scanner.nextLine();
		List<Contacts> addressBook = addressBooks.get(name);
		if (addressBook == null) {
			System.out.println("No address book found with the given name.");
			return;
		}
	}

	public void addContacts() {
	    boolean addingContacts = true;
	    while (addingContacts) {
	        Contacts contacts = new Contacts();
	        System.out.println("Enter First Name : ");
	        String firstName = scanner.nextLine();
	        contacts.setFirstName(firstName);

	        System.out.println("Enter Last Name : ");
	        String lastName = scanner.nextLine();
	        contacts.setLastName(lastName);

	        // Check if a contact with the same first name and last name already exists
	        boolean contactExists = false;
	        for (Contacts c : Contacts) {
	            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
	                contactExists = true;
	                System.out.println("Contact with the same first name and last name already exists:");
	                System.out.println(c);
	                System.out.println("Do you want to update this contact? (Y/N)");
	                String choice = scanner.nextLine();
	                if (choice.equalsIgnoreCase("Y")) {
	                    // Update existing contact
	                    c.setAddress(contacts.getAddress());
	                    c.setCity(contacts.getCity());
	                    c.setState(contacts.getState());
	                    c.setEmail(contacts.getEmail());
	                    c.setZip(contacts.getZip());
	                    c.setPhoneNumber(contacts.getPhoneNumber());
	                    System.out.println("Contact updated successfully.");
	                }
	                break;
	            }
	        }

	        // If contact does not exist, add it to the Address Book
	        if (!contactExists) {
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
	            scanner.nextLine(); // consume the newline character
	            contacts.setZip(zip);

	            System.out.println("Enter Phone Number");
	            long phoneNumber = scanner.nextLong();
	            scanner.nextLine(); // consume the newline character
	            contacts.setPhoneNumber(phoneNumber);

	            Contacts.add(contacts);
	            System.out.println("Person Information has been added successfully");
	        }

	        System.out.println("Do you want to add another person? (Y/N)");
	        String choice = scanner.nextLine();
	        if (choice.equalsIgnoreCase("N")) {
	            addingContacts = false;
	        }
	    }
	}
	public void searchContactsByCityOrState() {
	    System.out.println("Enter City or State to search contacts: ");
	    String cityOrState = scanner.nextLine();
	    List<Contacts> matchingContacts = new ArrayList<>();
	    for (Contacts c : Contacts) {
	        if (c.getCity().equalsIgnoreCase(cityOrState) || c.getState().equalsIgnoreCase(cityOrState)) {
	            matchingContacts.add(c);
	        }
	    }
	    if (matchingContacts.isEmpty()) {
	        System.out.println("No contacts found in " + cityOrState);
	    } else {
	        System.out.println("Contacts found in " + cityOrState + ":");
	        for (Contacts c : matchingContacts) {
	            System.out.println(c);
	        }
	    }
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
			System.out.println("Person contact deleted successfully.");
		} else {
			System.out.println("Person contact not found.");
		}
	}

}
	