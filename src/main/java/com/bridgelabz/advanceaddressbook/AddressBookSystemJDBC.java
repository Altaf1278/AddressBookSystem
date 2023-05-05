package com.bridgelabz.advanceaddressbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class AddressBookSystemJDBC extends Base {

	public void retrieveData() throws SQLException {
		connection = setUpDatabase();
		Statement statement = connection.createStatement();
		String query = "SELECT * FROM addressbook";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
			String zip = resultSet.getString("zip");
			String email = resultSet.getString("email");
			String phoneNumber = resultSet.getString("phonenumber");
			String name = resultSet.getString("name");
			String type = resultSet.getString("type");
			String date_joining = resultSet.getString("date_joining");
			System.out.println(id + " " + firstName + " " + lastName + " " + address + " " + city + " " + state + " "
					+ zip + " " + email + " " + phoneNumber + " " + name + " " + type + " " + date_joining);
		}
		System.out.println("Retrieve all the data from the addressbook table");
	}

	public void retrieveData(LocalDate startDate, LocalDate endDate) throws SQLException {
		connection = setUpDatabase();
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT * FROM addressbook WHERE date_joining BETWEEN ? AND ?");
		preparedStatement.setDate(1, Date.valueOf(startDate));
		preparedStatement.setDate(2, Date.valueOf(endDate));
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			String state = resultSet.getString("state");
			String zip = resultSet.getString("zip");
			String email = resultSet.getString("email");
			String phoneNumber = resultSet.getString("phonenumber");
			String name = resultSet.getString("name");
			String type = resultSet.getString("type");
			String date_joining = resultSet.getString("date_joining");
			System.out.println(id + " " + firstName + " " + lastName + " " + address + " " + city + " " + state + " "
					+ zip + " " + email + " " + phoneNumber + " " + name + " " + type + " " + date_joining);
		}
		System.out.println("Retrieved data from the addressbook table for the date range between "
				+ startDate.toString() + " and " + endDate.toString());
	}

	public int getContactsCountByCityOrState(String cityOrState) throws SQLException {
		connection = setUpDatabase();
		String query = "select count(*) from addressbook where city=? OR state=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, cityOrState);
		preparedStatement.setString(2, cityOrState);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int count = resultSet.getInt(1);
		System.out.println("Number of contacts in " + cityOrState + ": " + count);
		return count;
	}

	public void addContactJS(String firstName, String lastName, String address, String city, String state, String email,
			String phoneNumber, String zip, String type, String name, LocalDate dateJoining) throws SQLException {
		connection = setUpDatabase();
		String query = "INSERT INTO addressbook (first_name, last_name, address, city, state, email, phonenumber, zip, type, name, date_joining) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, city);
		preparedStatement.setString(5, state);
		preparedStatement.setString(6, email);
		preparedStatement.setString(7, phoneNumber);
		preparedStatement.setString(8, zip);
		preparedStatement.setString(9, type);
		preparedStatement.setString(10, name);
		preparedStatement.setDate(11, Date.valueOf(dateJoining));
		preparedStatement.executeUpdate();
		System.out.println("New contact added successfully");
		System.out.println("Contact added successfully:");
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("Address: " + address);
		System.out.println("City: " + city);
		System.out.println("State: " + state);
		System.out.println("Zip: " + zip);
		System.out.println("Phone number: " + phoneNumber);
		System.out.println("Email: " + email);
		System.out.println("Name: " + name);
		System.out.println("Type: " + type);
	}
	 private static final String SERVER_URL = "jdbc:mysql://localhost:3306/address_book_service";

	    private static final ObjectMapper objectMapper = new ObjectMapper();

	    public static List<Contacts> readContacts() throws IOException {
	        URL url = new URL(SERVER_URL);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");

	        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, Contacts.class);
	            return objectMapper.readValue(con.getInputStream(), listType);
	        } else {
	            throw new RuntimeException("Failed to retrieve contacts from server: " + con.getResponseMessage());
	        }
	    }

	    public static void writeContacts(List<Contacts> contacts) throws IOException {
	        URL url = new URL(SERVER_URL);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("POST");
	        con.setRequestProperty("Content-Type", "application/json");
	        con.setDoOutput(true);

	        objectMapper.writeValue(con.getOutputStream(), contacts);

	        if (con.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
	            throw new RuntimeException("Failed to write contacts to server: " + con.getResponseMessage());
	        }
	    }
}
