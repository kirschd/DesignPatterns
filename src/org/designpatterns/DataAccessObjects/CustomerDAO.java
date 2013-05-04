package org.designpatterns.DataAccessObjects;

import java.util.ArrayList;




import org.designpatterns.DataObjects.Customer;

public interface CustomerDAO {
	  
	  public boolean deleteCustomer();
	  public boolean findCustomer(Customer customer);
	  public boolean updateCustomer();
	  public ArrayList<Customer> selectCustomersRS(Customer customer);
	  public ArrayList<Customer> selectCustomersTO(Customer customer);
	  public boolean insertCustomer(Customer customer);
	  
	}