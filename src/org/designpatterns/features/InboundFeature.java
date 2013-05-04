

package org.designpatterns.features;

import java.util.ArrayList;
import java.util.Hashtable;

import org.designpatterns.DataAccessObjects.CustomerDAO;
import org.designpatterns.DataAccessObjects.DAOFactory;
import org.designpatterns.DataObjects.Customer;
import org.designpatterns.businessobjects.BusinessObjectFactory;
import org.designpatterns.businessobjects.BusinessObjects;
import org.designpatterns.constants.Constants;

public class InboundFeature implements Feature {

	private Customer customer = new Customer();
	private ArrayList<Customer> customers = null;
	public Hashtable ResponseData = new Hashtable();
	private String ResponsePage;
	private BusinessObjects BO;
	@Override
	public Hashtable ExecuteFeature(Hashtable requestdata) {
		// TODO Auto-generated method stub
		
		
//		if(ServiceName.equalsIgnoreCase("updatedetails") || ServiceName == "updatedetails")
//			{
//				ResponseData = search.similaritems(RequestData);
//			}
//			if(ServiceName.equalsIgnoreCase("updateproductdetails") || ServiceName == "updateproductdetails")
//			{
//				ResponseData = search.similaritems(RequestData);
//			}
//			if(ServiceName.equalsIgnoreCase("addnewproduct") || ServiceName == "addnewproduct")
//			{
//				ResponseData = search.similaritems(RequestData);
//			}
//			if(ServiceName.equalsIgnoreCase("viewsales") || ServiceName == "viewsales")
//			{
//				ResponseData = search.similaritems(RequestData);
//			}
		//InboundFeature IF = new InboundFeature();
		String Featurename = (String) requestdata.get("featurename");
		String operationname = (String) requestdata.get("operation");
		
		BO = BusinessObjectFactory.getServicebyTyprNameHighConcurrentVersion(Featurename);
		ResponseData = BO.apply(requestdata);
		//ResponseData = similaritems(requestdata);
		return ResponseData;
	}
	public  Hashtable similaritems (Hashtable RequestData) {
			
			DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
			CustomerDAO MySQLCustomerDAO = MySQLFactory.getCustomerDAO();
	
			String searchterm = (String) RequestData.get("inputString");
			String service = (String) RequestData.get("service");
			
			if(service.equals("Inbound") || service == "Inbound")
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

}
