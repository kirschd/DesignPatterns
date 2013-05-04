package org.designpatterns.DataAccessObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.sql.RowSet;

import org.designpatterns.DataObjects.Customer;
import org.designpatterns.constants.Constants;

public class MySQLCustomerDAO implements CustomerDAO {

	private Properties properties;

	public MySQLCustomerDAO() {
		// initialization
		properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("SQL.properties"));
		} catch (IOException e) {
		}
	}

	public boolean insertCustomer(Customer customer) {

		boolean registrationdetails = false;
		System.out.println("User Email Provided : " + customer.getEmail());
		String customerInsert = properties.getProperty("insertCustomer");
		PreparedStatement prepStmt;
		try {

			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					customerInsert);
			// prepStmt.setString(1, customer.getFirstname());
			prepStmt.setString(1, customer.getFirstname());
			prepStmt.setString(2, customer.getLastname());
			prepStmt.setString(3, customer.getEmail());

			int rs1 = prepStmt.executeUpdate();
			System.out.println("value of rs1: " + rs1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Customer not Inserted");
			return registrationdetails;
		}
		System.out.println("Customer Inserted");
		registrationdetails = true;
		return registrationdetails;
		// Implement insert customer here.
		// Return newly created customer number
		// or a -1 on error
	}

	public boolean deleteCustomer() {
		return false;
		// Implement delete customer here
		// Return true on success, false on failure
	}

	// Implement find a customer here using supplied
	// argument values as search criteria
	// Return a Transfer Object if found,
	// return null on error or if not found

	public boolean findCustomer(Customer customer) {

		String findcustomer = properties.getProperty("AuthenticateCustomer");
		System.out.println(findcustomer);
		System.out.println("User Email Provided : " + customer.getEmail());
		String useremail = null;
		boolean customerPresent = false;
		PreparedStatement prepStmt;
		try {

			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					findcustomer);

			prepStmt.setString(1, customer.getEmail());
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				useremail = rs.getString("email");
				System.out.println(useremail);
			} // end while
			if (useremail.equalsIgnoreCase(customer.getEmail())) {
				customerPresent = true;
			} else {
				customerPresent = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Customer not Found");

		}
		return customerPresent;

	}

	public boolean updateCustomer() {
		return false;
		// implement update record here using data
		// from the customerData Transfer Object
		// Return true on success, false on failure or
		// error
	}

	public ArrayList<Customer> selectCustomersRS(Customer customer) {
		
		String searchcustomer = properties.getProperty("AsynSearch");
		System.out.println(searchcustomer);
		System.out.println("User Name Provided : " + customer.getFirstname());
		String useremail = null;
		boolean customerPresent = false;
		ArrayList<Customer> results = null;
		PreparedStatement prepStmt;
		try {

			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					searchcustomer);

			prepStmt.setString(1, "%" +customer.getFirstname()+"%");
			prepStmt.setString(2, "%" +customer.getLastname()+"%");

			ResultSet rs = prepStmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columns = rsmd.getColumnCount();
			results = new ArrayList<Customer>();

			while (rs.next()) {
				Customer row = new Customer();
				row.setFirstname(rs.getString("firstname"));
				row.setLastname(rs.getString("lastname"));
				results.add(row);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Customer not Found");

		}
		
		return results;
		// implement search customers here using the
		// supplied criteria.
		// Return a RowSet.
	}

	public ArrayList<Customer> selectCustomersTO(Customer customer) {
		String searchcustomer = properties.getProperty("SearchCustomer");
		System.out.println(searchcustomer);
		System.out.println("User Email Provided : " + customer.getEmail());
		String useremail = null;
		boolean customerPresent = false;
		ArrayList<Customer> results = null;
		PreparedStatement prepStmt;
		try {

			prepStmt = MySQLDAOFactory.createConnection().prepareStatement(
					searchcustomer);

			prepStmt.setString(1, "%" +customer.getEmail()+"%");
			prepStmt.setString(2, "%" +customer.getFirstname()+"%");
			prepStmt.setString(3, "%" +customer.getLastname()+"%");

			ResultSet rs = prepStmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columns = rsmd.getColumnCount();
			results = new ArrayList<Customer>();

			while (rs.next()) {
				Customer row = new Customer();
				row.setFirstname(rs.getString("firstname"));
				row.setLastname(rs.getString("lastname"));
				row.setEmail(rs.getString("email"));
				results.add(row);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Customer not Found");

		}
		
		return results;
		// implement search customers here using the
		// supplied criteria.
		// Alternatively, implement to return a Collection
		// of Transfer Objects.
	}

}