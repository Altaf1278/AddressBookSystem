package com.bridgelabz.advanceaddressbook;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem extends Contacts{

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

	public void viewPersonByCity() {
		System.out.println("Enter City name to view persons: ");
		String city = scanner.nextLine();
		List<Contacts> matchingContacts = new ArrayList<>();
		for (Contacts c : Contacts) {
			if (c.getCity().equalsIgnoreCase(city)) {
				matchingContacts.add(c);
			}
		}
		if (matchingContacts.isEmpty()) {
			System.out.println("No persons found in " + city);
		} else {
			System.out.println("Persons found in " + city + ":");
			for (Contacts c : matchingContacts) {
				System.out.println(c.getFirstName() + " " + c.getLastName());
			}
		}
	}

	public void viewContactsByState() {
		System.out.println("Enter State to view contacts: ");
		String state = scanner.nextLine();
		boolean foundContacts = false;
		for (Contacts c : Contacts) {
			if (c.getState().equalsIgnoreCase(state)) {
				System.out.println(c);
				foundContacts = true;
			}
		}
		if (!foundContacts) {
			System.out.println("No contacts found in " + state);
		}
	}

	public void searchContactNumbersByCityOrState() {
		System.out.println("Enter City or State to search contacts: ");
		String cityOrState = scanner.nextLine();

		int countByCity = 0;
		int countByState = 0;

		for (Contacts c : Contacts) {
			if (c.getCity().equalsIgnoreCase(cityOrState)) {
				countByCity++;
			}
			if (c.getState().equalsIgnoreCase(cityOrState)) {
				countByState++;
			}
		}

		if (countByCity == 0 && countByState == 0) {
			System.out.println("No contacts found in " + cityOrState);
		} else {
			if (countByCity > 0) {
				System.out.println("Number of contacts found in " + cityOrState + " city: " + countByCity);
			}
			if (countByState > 0) {
				System.out.println("Number of contacts found in " + cityOrState + " state: " + countByState);
			}
		}
	}

	public void sortContactsByName() {
		Contacts.stream().sorted(FirstNameComparator).forEach(System.out::println);
	}

	public void sortContactsByCity() {
		Collections.sort(Contacts, new Comparator<Contacts>() {
			public int compare(Contacts c1, Contacts c2) {
				return c1.getCity().compareTo(c2.getCity());
			}
		});
		for (Contacts c : Contacts) {
			System.out.println(c);
		}
	}

	public void sortContactsByState() {
		Collections.sort(Contacts, new Comparator<Contacts>() {
			public int compare(Contacts c1, Contacts c2) {
				return c1.getState().compareTo(c2.getState());
			}
		});
		for (Contacts c : Contacts) {
			System.out.println(c);
		}
	}

	public void sortContactsByZip() {
		Contacts.sort((c1, c2) -> Integer.compare(c1.getZip(), c2.getZip()));
		Contacts.forEach(System.out::println);
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

	public void writeToFile(String filename) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			for (Contacts person : Contacts) {
				writer.println(person.getFirstName() + "\n" + person.getLastName() + "\n" + person.getAddress() + "\n"
						+ person.getCity() + "\n" + person.getState() + "\n" + person.getZip() + " \n "
						+ person.getPhoneNumber() + "\n" + person.getEmail());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile(String filename) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");
				if (tokens.length == 7) {
					String firstName = tokens[0];
					String lastName = tokens[1];
					String email = tokens[2];
					String address = tokens[3];
					long phoneNumber = Long.parseLong(tokens[4]);
					int zip = Integer.parseInt(tokens[5]);
					String city = tokens[6];

					Contacts person = new Contacts();
					addContacts();

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final String delimiter = ",";

	public static void read(String csvFile) {
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				for (String tempStr : tempArr) {
					System.out.print(tempStr + " ");
				}
				System.out.println();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void write(String csvFile, String[][] data) {
		try {
			File file = new File(csvFile);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (String[] row : data) {
				StringBuilder sb = new StringBuilder();
				for (String cell : row) {
					sb.append(cell);
					sb.append(delimiter);
				}
				sb.setLength(sb.length() - 1); // remove the last delimiter
				bw.write(sb.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
