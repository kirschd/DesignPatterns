package org.designpatterns.businessobjects;

import java.util.ArrayList;
import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataObjects.Customer;

public class CustomerOperations implements BusinessObjects {

	private Customer customer;
	private ArrayList<Customer> customers = null;
	String ResponsePage;
	Hashtable ResponseData = new Hashtable();

	@Override
	public Hashtable apply(Hashtable requestdata) {

		// TODO Auto-generated method stub

		String Operation = (String) requestdata.get("operation");
		if (Operation.equalsIgnoreCase("updatedetails")
				|| Operation == "updatedetails") {
			ResponseData = updatedetails(requestdata);
		}
		if (Operation.equalsIgnoreCase("searchproducts")
				|| Operation == "searchproducts") {
			ResponseData = searchproducts(requestdata);
		}
		if (Operation.equalsIgnoreCase("addproductstocart")
				|| Operation == "addproductstocart") {
			ResponseData = addproductstocart(requestdata);
		}
		if (Operation.equalsIgnoreCase("orderproducts")
				|| Operation == "orderproducts") {
			ResponseData = orderproducts(requestdata);
		}
		if (Operation.equalsIgnoreCase("productreview")
				|| Operation == "productreview") {
			ResponseData = productreview(requestdata);
		}
		if (Operation.equalsIgnoreCase("productratings")
				|| Operation == "productratings") {
			ResponseData = productratings(requestdata);
		}
		return ResponseData;
	}

	public Hashtable searchproducts(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");

		if (service.equals("Inbound") || service == "Inbound") {
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

	public Hashtable updatedetails(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");

		if (service.equals("Inbound") || service == "Inbound") {
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

	public Hashtable addproductstocart(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");

		if (service.equals("Inbound") || service == "Inbound") {
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

	public Hashtable orderproducts(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");

		if (service.equals("Inbound") || service == "Inbound") {
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

	public Hashtable productreview(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");

		if (service.equals("Inbound") || service == "Inbound") {
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

	public Hashtable productratings(Hashtable RequestData) {

		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");

		if (service.equals("Inbound") || service == "Inbound") {
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

}
