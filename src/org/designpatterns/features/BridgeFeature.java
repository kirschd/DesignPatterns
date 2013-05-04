package org.designpatterns.features;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

public class BridgeFeature extends FeatureAbstraction {

	protected Hashtable requestdata = new Hashtable();
	protected Hashtable responsedata = new Hashtable();
	protected Properties properties = new Properties();

	public BridgeFeature(Feature feature, Hashtable requestdata) {
		super(feature);
		this.requestdata = requestdata;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Hashtable callFeature(Hashtable requestdata) {
		// TODO Auto-generated method stub
		responsedata = feature.ExecuteFeature(requestdata);
		return responsedata;

	}

	@Override
	public void connectFeature() {
		// TODO Auto-generated method stub
		try {
			properties.load(getClass().getResourceAsStream(
					"bridgeconnection.properties"));
		} catch (IOException e) {
			System.out.println("Bridge Connection Properties not found");
		}
		String featurename = properties.getProperty((String) requestdata
				.get("service"));
		String operation = (String) requestdata.get("feature");
		requestdata.put("featurename", featurename);
		requestdata.put("operation", operation);
		
	}

}
