package com.bridgelabz.advanceaddressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            System.out.println(id + " " + firstName + " " + lastName + " " + address + " " + city + " " + state + " "
                    + zip + " " + email + " " + phoneNumber + " " + name + " " + type);
        }
        System.out.println("Retrieve all the data from the addressbook table");
    }

    public void updateContactInformation(int id) throws SQLException {
        connection = setUpDatabase();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM addressbook WHERE id=?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            // Retrieve the current information from the database
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            String zip = resultSet.getString("zip");
            String email = resultSet.getString("email");
            String phoneNumber = resultSet.getString("phonenumber");

            // Display the current information to the user and ask for new information
            System.out.println("Current Information:");
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Address: " + address);
            System.out.println("City: " + city);
            System.out.println("State: " + state);
            System.out.println("Zip: " + zip);
            System.out.println("Email: " + email);
            System.out.println("Phone Number: " + phoneNumber);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the ID of the contact you want to update:");
            int contactId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new First Name: ");
            String newFirstName = scanner.nextLine();

            System.out.print("Enter new Last Name: ");
            String newLastName = scanner.nextLine();

            System.out.print("Enter new Address: ");
            String newAddress = scanner.nextLine();

            System.out.print("Enter new City: ");
            String newCity = scanner.nextLine();

            System.out.print("Enter new State: ");
            String newState = scanner.nextLine();

            System.out.print("Enter new Zip: ");
            String newZip = scanner.nextLine();

            System.out.print("Enter new Email: ");
            String newEmail = scanner.nextLine();

            System.out.print("Enter new Phone Number: ");
            String newPhoneNumber = scanner.nextLine();

            // Update the contact information in the database
            PreparedStatement updateStatement = connection.prepareStatement(
                    "UPDATE addressbook SET first_name=?, last_name=?, address=?, city=?, state=?, zip=?, email=?, phonenumber=? WHERE id=?");
            updateStatement.setString(1, newFirstName);
            updateStatement.setString(2, newLastName);
            updateStatement.setString(3, newAddress);
            updateStatement.setString(4, newCity);
            updateStatement.setString(5, newState);
            updateStatement.setString(6, newZip);
            updateStatement.setString(7, newEmail);
            updateStatement.setString(8, newPhoneNumber);
            updateStatement.setInt(9, contactId);
            int rowsAffected = updateStatement.executeUpdate();
            if (rowsAffected >0 ) {
                System.out.println("Contact information updated successfully!");
            } else {
                System.out.println("Contact information update failed.");
            }
        } else {
            System.out.println("No contact found with ID " + id);
        }
        connection.close();
    }
}
