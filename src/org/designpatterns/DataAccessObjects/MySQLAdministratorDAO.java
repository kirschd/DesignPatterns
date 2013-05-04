package org.designpatterns.DataAccessObjects;

import java.util.Collection;

import javax.sql.RowSet;

import org.designpatterns.DataObjects.Customer;

public class MySQLAdministratorDAO implements AdministratorDAO {

	@Override
	public int insertAdministrator() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteAdministrator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findAdministrator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAdministrator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RowSet selectAdministratorsRS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection selectAdministratorsTO() {
		// TODO Auto-generated method stub
		return null;
	}

}
