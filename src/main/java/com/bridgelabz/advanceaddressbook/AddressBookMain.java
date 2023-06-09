package com.bridgelabz.advanceaddressbook;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) throws IOException {

		AddressBookSystem addressBook = new AddressBookSystem();
		Scanner scanner = new Scanner(System.in);

		addressBook.addAddressBook();
		addressBook.addContacts();

		// Writing the address book to a file
		addressBook.writeToFile("address_book.txt");

		// Reading the address book from a file
		addressBook.readFromFile("address_book.txt");

		// csv file to read
		String csvFile = "C:\\Users\\altaf\\eclipse-workspace\\AdvanceAddressBook\\src\\main\\java\\com\\bridgelabz\\advanceaddressbook\\AddBookCSV.csv";
		addressBook.read(csvFile);

		// csv file to write
		String csvFileToWrite = "C:\\Users\\altaf\\eclipse-workspace\\AdvanceAddressBook\\src\\main\\java\\com\\bridgelabz\\advanceaddressbook\\AddBookCSV.csv";

		String[][] dataToWrite = {
				{ "Altaf", "Khan", "Panvel", "Mumbai", "Maharashtra", "410222", "9665566324", "ak123@example.com", },
				{ "Tanya", "Mehta", "Mumbra", "Thane", "Maharashtra", "423520", "8554976574", "Tanya434@example.com" },
				{ "Aman", "Sayyed", "Pimpri", "Pune", "Maharashtra", "450662", "8520396310","Rajusmith@example.com" } };
		addressBook.write(csvFileToWrite, dataToWrite);

		while (true) {
			System.out.println("Enter 1 to add Address Book");
			System.out.println("Enter 2 to display Address Books");
			System.out.println("Enter 3 to open Address Book");
			System.out.println("Enter 4 to add contact");
			System.out.println("Enter 5 to search contacts by city or state");
			System.out.println("Enter 6 to view contacts by city");
			System.out.println("Enter 7 to view contacts by state");
			System.out.println("Enter 8 to search contact numbers in a city or state");
			System.out.println("Enter 9 to sort contacts by name");
			System.out.println("Enter 10 to sort contacts by city");
			System.out.println("Enter 11 to sort contacts by state");
			System.out.println("Enter 12 to sort contacts by zip");
			System.out.println("Enter 13 to display all contacts");
			System.out.println("Enter 14 to edit a contact");
			System.out.println("Enter 15 to delete a contact");
			System.out.println("Enter 17 to exit Address Book");

			System.out.println("Enter 0 to exit");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 0:
				System.out.println("Exiting Address Book");
				System.exit(0);
			case 1:
				addressBook.addAddressBook();
				break;
			case 2:
				addressBook.displayAddressBooks();
				break;
			case 3:
				addressBook.openAddressBook();
				break;
			case 4:
				addressBook.addContacts();
				break;
			case 5:
				addressBook.searchContactsByCityOrState();
				break;
			case 6:
				addressBook.viewPersonByCity();
				break;
			case 7:
				addressBook.viewContactsByState();
				break;
			case 8:
				addressBook.searchContactNumbersByCityOrState();
				break;
			case 9:
				addressBook.sortContactsByName();
				break;
			case 10:
				addressBook.sortContactsByCity();
				break;
			case 11:
				addressBook.sortContactsByState();
				break;
			case 12:
				addressBook.sortContactsByZip();
				break;
			case 13:
				addressBook.displayContacts();
				break;
			case 14:
				System.out.println("Enter the first name of the contact to edit:");
				String firstName = scanner.nextLine();
				System.out.println("Enter the last name of the contact to edit:");
				String lastName = scanner.nextLine();
				addressBook.editContact(firstName, lastName);
				break;
			case 15:
				System.out.println("Enter the first name of the contact to delete:");
				String firstName1 = scanner.nextLine();
				System.out.println("Enter the last name of the contact to delete:");
				String lastName1 = scanner.nextLine();
				addressBook.deleteContact(firstName1, lastName1);
				break;
			case 16:
				System.exit(0);
			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
}
