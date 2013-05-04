package org.designpatterns.services;

import java.util.ArrayList;
import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataObjects.Customer;

public class Search {
	
	public Hashtable ResponseData = new Hashtable();
	private Customer customer = new Customer();
	private ArrayList<Customer> customers = null;
	private String ResponsePage;
	
	public Hashtable similaritems (Hashtable RequestData) {
		
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");
		
		if(service.equals("Outbound") || service == "Outbound")
		{
			customer.setEmail(searchterm);
			customer.setLastname(searchterm);
			customer.setFirstname(searchterm);
			customers = MySQLCustomerDAO.selectCustomersTO(customer);
			ResponsePage = "Search.jsp";
			ResponseData.put("searchcontent", customers);
			ResponseData.put("ResponsePage", ResponsePage);
			
		}
		return ResponseData;
	}
	
	public Hashtable asynchronoussearch (Hashtable RequestData) {
			
			DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
			CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();
	
			String searchterm = (String) RequestData.get("queryString");
			System.out.println(searchterm);
			String service = (String) RequestData.get("service");
			
			if(service.equals("Asynchronous") || service == "Asynchronous")
			{
				customer.setLastname(searchterm);
				customer.setFirstname(searchterm);
				customers = MySQLCustomerDAO.selectCustomersRS(customer);
				ResponsePage = "Search.jsp";
				ResponseData.put("searchcontent", customers);
				ResponseData.put("ResponsePage", ResponsePage);
				
			}
			return ResponseData;
		}
	

}
