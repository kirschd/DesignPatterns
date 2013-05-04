package org.designpatterns.DataAccessObjects;

import java.util.ArrayList;

import org.designpatterns.DataObjects.Customer;

public interface ProductDAO {
	
	  public boolean insertProducts(Customer customer);
	  public boolean updateProduct();
	  public boolean findProduct(Customer customer);
	  public boolean deactivateProduct();
	  public ArrayList<Customer> searchProductsRS(Customer customer);

}
