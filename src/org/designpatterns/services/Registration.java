package org.designpatterns.services;

import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataObjects.Customer;

public class Registration {
	Customer cust = new Customer();
	public String ResponsePage = null;
	public Hashtable ResponseData = new Hashtable();
	public Registration() {

	}

	public Hashtable registeruser(Hashtable RequestData) {
		
		boolean UserPresence = false;
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		// Create a DAO
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String customerFirstName = (String) RequestData.get("firstname");
		String customerLastName = (String) RequestData.get("lastname");
		String customerEmail = (String) RequestData.get("email");
		
		cust.setFirstname(customerFirstName);
		cust.setLastname(customerLastName);
		cust.setEmail(customerEmail);
		
		UserPresence = MySQLCustomerDAO.insertCustomer(cust);
		if(UserPresence == true )
		{
			ResponsePage = "WelcomeUser.jsp";
		}
		else{
			ResponsePage = "ErrorPage.jsp";
		}
		ResponseData.put("username", customerFirstName);
		ResponseData.put("ResponsePage", ResponsePage);
		return ResponseData;
	}

}
