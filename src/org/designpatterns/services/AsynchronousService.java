package org.designpatterns.services;

import java.util.Hashtable;

public class AsynchronousService implements Service {

	private Hashtable ResponseData = new Hashtable();
	private Search search = new Search();
	@Override
	public Hashtable ExecuteService(Hashtable RequestData) {
		String featurenameName = (String) RequestData.get("feature");
		if(featurenameName.equalsIgnoreCase("searchproducts") || featurenameName == "searchproducts")
		{
			ResponseData = search.asynchronoussearch(RequestData);
		}
		return ResponseData;
	}

}
