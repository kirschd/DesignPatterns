package org.designpatterns.services;

import java.util.Enumeration;
import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataObjects.Customer;

public class Authenticate {
	Customer cust = new Customer();
	public String ResponsePage = null;
	public Hashtable ResponseData = new Hashtable();
	public Authenticate() {

	}

	public Hashtable authenticateuser(Hashtable RequestData) {
		
		boolean UserPresence = false;
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		// Create a DAO
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String customerFirstName = (String) RequestData.get("username");
		String customerLastName = (String) RequestData.get("password");
		
		cust.setEmail(customerFirstName);
		cust.setLastname(customerLastName);
		
		UserPresence = MySQLCustomerDAO.findCustomer(cust);
		if(UserPresence == true )
		{
			ResponseData.put("Authentication", "success");
			ResponsePage = "WelcomeUser.jsp";
		}
		else{
			ResponseData.put("Authentication", "failure");
			ResponsePage = "ErrorPage.jsp";
		}
		ResponseData.put("username", customerFirstName);
		ResponseData.put("ResponsePage", ResponsePage);
		return ResponseData;
	}

}
