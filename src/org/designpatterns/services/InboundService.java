package org.designpatterns.services;

import java.util.Hashtable;
/*
 * Inbound Service is for the Suppliers
 * services offered:
 * Supplier Update Details
 * Supplier Update Products Details
 * Supplier Add New Product
 * Supplier view Sales History
 */

import org.designpatterns.constants.Constants;
import org.designpatterns.features.BridgeFeature;
import org.designpatterns.features.Feature;
import org.designpatterns.features.FeatureFactory;

public class InboundService implements Service {

	public Hashtable ResponseData = new Hashtable();
	private Search search = new Search();
	private BridgeFeature bridgefeature;
	
	private Feature IFeature;
	@Override
	public Hashtable ExecuteService(Hashtable RequestData) {
		// TODO Auto-generated method stub
		String FeatureName = (String) RequestData.get("service");
		IFeature = FeatureFactory
				.getFeaturebyTyprNameHighConcurrentVersion(FeatureName);
		bridgefeature = new BridgeFeature(IFeature,RequestData);
		bridgefeature.connectFeature();
		ResponseData = bridgefeature.callFeature(RequestData);
		
		return ResponseData;
	}

}
