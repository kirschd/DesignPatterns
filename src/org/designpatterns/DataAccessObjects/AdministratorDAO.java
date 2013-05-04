package org.designpatterns.DataAccessObjects;

import java.util.Collection;

import javax.sql.RowSet;

import org.designpatterns.DataObjects.Customer;

public interface AdministratorDAO {
	 public int insertAdministrator();
	  public boolean deleteAdministrator();
	  public Customer findAdministrator();
	  public boolean updateAdministrator();
	  public RowSet selectAdministratorsRS();
	  public Collection selectAdministratorsTO();

}
