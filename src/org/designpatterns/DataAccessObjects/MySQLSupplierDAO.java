package org.designpatterns.DataAccessObjects;

import java.util.Collection;

import javax.sql.RowSet;

import org.designpatterns.DataObjects.Customer;

public class MySQLSupplierDAO implements SupplierDAO {

	@Override
	public int insertSupplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteSupplier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSupplier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RowSet selectSuppliersRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectSuppliersTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
