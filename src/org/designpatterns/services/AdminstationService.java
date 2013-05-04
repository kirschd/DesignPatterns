package org.designpatterns.services;

import java.util.Hashtable;

public class AdminstationService implements Service {

 /*	 Admin Service offers the following service features
  *	 Admin Update Details
  *	 Admin add new Admin
  *	 Admin View Sales Report
  *	 Admin View Inbox
  *	 Admin Decativate user
  */ 

	
	public Hashtable ResponseData = new Hashtable();
	private Search search = new Search();
	
	@Override
	public Hashtable ExecuteService(Hashtable RequestData) {
		// TODO Auto-generated method stub
		String ServiceName = (String) RequestData.get("feature");
		if(ServiceName.equalsIgnoreCase("updatedetails") || ServiceName == "updatedetails")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("addnewadmin") || ServiceName == "addnewadmin")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("viewsalesreport") || ServiceName == "viewsalesreport")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("viewinbox") || ServiceName == "viewinbox")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("deactivateuser") || ServiceName == "deactivateuser")
		{
			ResponseData = search.similaritems(RequestData);
		}
		return ResponseData;
	}

}
