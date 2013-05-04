package org.designpatterns.services;

import java.util.Hashtable;

public class AuthenticationService implements Service 
{
	public Authenticate authenticate = new Authenticate();
	public Registration register = new Registration();
	public Hashtable ResponseData = new Hashtable();
	
	
	@Override
	public Hashtable ExecuteService(Hashtable RequestData) {
		// TODO Auto-generated method stub
		String ServiceName = (String) RequestData.get("feature");
		if(ServiceName.equalsIgnoreCase("Authenticate") || ServiceName == "Authenticate")
		{
			ResponseData = authenticate.authenticateuser(RequestData);
		}
		else if(ServiceName.equalsIgnoreCase("Register") || ServiceName == "Register")
		{
			ResponseData = register.registeruser(RequestData);
		}
		return ResponseData;
	}

}
