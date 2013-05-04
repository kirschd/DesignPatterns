package org.designpatterns.DataAccessObjects;

import javax.sql.RowSet;

import org.designpatterns.DataObjects.Customer;

public interface InventoryDAO {
	  public int insertInventory();
	  public boolean deleteInventory();
	  public Customer findInventory();
	  public boolean updateInventory();
	  public RowSet selectInventoryRS();

}
