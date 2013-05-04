package org.designpatterns.DataAccessObjects;

import javax.sql.RowSet;

import org.designpatterns.DataObjects.Customer;

public class MySQLInventoryDAO implements InventoryDAO {

	@Override
	public int insertInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteInventory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInventory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RowSet selectInventoryRS() {
		// TODO Auto-generated method stub
		return null;
	}

}
