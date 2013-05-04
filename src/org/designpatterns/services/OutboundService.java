package org.designpatterns.services;

import java.util.Hashtable;

public class OutboundService implements Service {
	
/*	Outbound Service offers the following Service Features
 *  Customer Update Details
 *  Customer Product Search
 *	Customer Cart
 *	Customer Order
 * 	Customer Review & Ratings
 *	Customer view Purchase History
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
		if(ServiceName.equalsIgnoreCase("searchproducts") || ServiceName == "searchproducts")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("addproductstocart") || ServiceName == "addproductstocart")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("orderproducts") || ServiceName == "orderproducts")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("productreview") || ServiceName == "productreview")
		{
			ResponseData = search.similaritems(RequestData);
		}
		if(ServiceName.equalsIgnoreCase("productratings") || ServiceName == "productratings")
		{
			ResponseData = search.similaritems(RequestData);
		}
		return ResponseData;
	}

}
