package com.bridgelabz.advanceaddressbook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.List;

public class Base {

	private static final LocalDate startDate = null;
	public static Connection connection;

	public static void main(String[] args) throws SQLException {

		listOfDrivers();
		setUpDatabase();

		AddressBookSystemJDBC addressBookSystemJdbc = new AddressBookSystemJDBC();
		addressBookSystemJdbc.retrieveData(); // UC16
//        addressBookSystemJdbc.updateContactInformation(8);  //UC17
		LocalDate startDate = LocalDate.of(2021, 05, 01);
		LocalDate endDate = LocalDate.of(2022, 12, 31);
		addressBookSystemJdbc.retrieveData(startDate, endDate);

		addressBookSystemJdbc.getContactsCountByCityOrState("Mumbai"); // UC19
        addressBookSystemJdbc.addContact("Rashid", "Khan", "Jamia Masjid" , "Srinagar", "Kashmir", "Rashid123khan@gmail.com", "8858863271", "768520", "My Friend", "Rashid", endDate);  //UC20
	}

	public static Connection setUpDatabase() {
		String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service";
		String username = "root";
		String password = "Superman@123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			throw new IllegalStateException("Cannot load the driver successfully" + e);
		}

		try {
			System.out.println("Databases connected to the database: " + jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connection established successfully" + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void listOfDrivers() {
		Enumeration<Driver> enumeration = DriverManager.getDrivers();
		while (enumeration.hasMoreElements()) {
			Driver driver = (Driver) enumeration.nextElement();
			System.out.println("  " + driver.getClass().getName());
		}
	}

}
