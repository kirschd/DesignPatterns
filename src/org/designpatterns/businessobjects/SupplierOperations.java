package org.designpatterns.businessobjects;

import java.util.ArrayList;
import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataObjects.Customer;
import org.designpatterns.DataObjects.Supplier;

public class SupplierOperations implements BusinessObjects {
	
	private Supplier supplier;
	private ArrayList<Supplier> suppliers = null;
	String ResponsePage;
	Hashtable ResponseData = new Hashtable();

	@Override
	public Hashtable apply(Hashtable requestdata) {
		// TODO Auto-generated method stub
		
//		if(ServiceName.equalsIgnoreCase("updatedetails") || ServiceName == "updatedetails")
//		{
//			ResponseData = search.similaritems(RequestData);
//		}
//		if(ServiceName.equalsIgnoreCase("updateproductdetails") || ServiceName == "updateproductdetails")
//		{
//			ResponseData = search.similaritems(RequestData);
//		}
//		if(ServiceName.equalsIgnoreCase("addnewproduct") || ServiceName == "addnewproduct")
//		{
//			ResponseData = search.similaritems(RequestData);
//		}
//		if(ServiceName.equalsIgnoreCase("viewsales") || ServiceName == "viewsales")
//		{
//			ResponseData = search.similaritems(RequestData);
//		}
		return null;
	}
	
public  Hashtable updatedetails (Hashtable RequestData) {
		
		DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
		CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();

		String searchterm = (String) RequestData.get("inputString");
		String service = (String) RequestData.get("service");
		
		if(service.equals("Inbound") || service == "Inbound")
		{
			supplier.setEmail(searchterm);
			supplier.setLastname(searchterm);
			supplier.setFirstname(searchterm);
			suppliers = MySQLCustomerDAO.selectCustomersTO(supplier);
			ResponsePage = "Search.jsp";
			ResponseData.put("searchcontent", suppliers);
			ResponseData.put("ResponsePage", ResponsePage);
			
		}
		return ResponseData;
	}
	public  Hashtable updateproductdetails (Hashtable RequestData) {
			
			DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
			CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();
	
			String searchterm = (String) RequestData.get("inputString");
			String service = (String) RequestData.get("service");
			
			if(service.equals("Inbound") || service == "Inbound")
			{
				supplier.setEmail(searchterm);
				supplier.setLastname(searchterm);
				supplier.setFirstname(searchterm);
				suppliers = MySQLCustomerDAO.selectCustomersTO(supplier);
				ResponsePage = "Search.jsp";
				ResponseData.put("searchcontent", suppliers);
				ResponseData.put("ResponsePage", ResponsePage);
				
			}
			return ResponseData;
		}
		public  Hashtable addnewproduct (Hashtable RequestData) {
			
			DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
			CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();
	
			String searchterm = (String) RequestData.get("inputString");
			String service = (String) RequestData.get("service");
			
			if(service.equals("Inbound") || service == "Inbound")
			{
				supplier.setEmail(searchterm);
				supplier.setLastname(searchterm);
				supplier.setFirstname(searchterm);
				suppliers = MySQLCustomerDAO.selectCustomersTO(supplier);
				ResponsePage = "Search.jsp";
				ResponseData.put("searchcontent", suppliers);
				ResponseData.put("ResponsePage", ResponsePage);
				
			}
			return ResponseData;
		}
		public  Hashtable viewsales (Hashtable RequestData) {
					
					DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
					CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();
			
					String searchterm = (String) RequestData.get("inputString");
					String service = (String) RequestData.get("service");
					
					if(service.equals("Inbound") || service == "Inbound")
					{
						supplier.setEmail(searchterm);
						supplier.setLastname(searchterm);
						supplier.setFirstname(searchterm);
						suppliers = MySQLCustomerDAO.selectCustomersTO(supplier);
						ResponsePage = "Search.jsp";
						ResponseData.put("searchcontent", suppliers);
						ResponseData.put("ResponsePage", ResponsePage);
						
					}
					return ResponseData;
		}
		
	
	

}
