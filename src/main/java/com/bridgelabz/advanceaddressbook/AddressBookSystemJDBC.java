package com.bridgelabz.advanceaddressbook;

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

}
