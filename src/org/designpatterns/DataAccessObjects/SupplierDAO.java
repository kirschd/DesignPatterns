package org.designpatterns.DataAccessObjects;

import java.util.Collection;

import javax.sql.RowSet;

import org.designpatterns.DataObjects.Customer;

public interface SupplierDAO {
	 public int insertSupplier();
	  public boolean deleteSupplier();
	  public Customer findSupplier();
	  public boolean updateSupplier();
	  public RowSet selectSuppliersRS();
	  public Collection selectSuppliersTO();

}
