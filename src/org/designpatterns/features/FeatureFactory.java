package org.designpatterns.features;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.lang.reflect.*;
import org.designpatterns.constants.Constants;
import org.designpatterns.services.Service;


public class FeatureFactory {
	private static Map<String, Feature> Features = new HashMap<String, Feature>();
	private static Feature IFeature;
	
	
	private FeatureFactory(String FeatureName) {
    }
	
	public static Feature getFeaturebyTyprNameHighConcurrentVersion(String FeatureName) {
        if (!Features.containsKey(FeatureName)) {
                synchronized (Features) {
                        // Check again, after having acquired the lock to make sure
                        // the instance was not created meanwhile by another thread
                        if (!Features.containsKey(FeatureName)) {
                                // Lazy initialisation
                        	try {
								IFeature = (Feature) Class.forName(
										Constants.FEATUREPACKAGE + FeatureName
												+ Constants.FEATURE).newInstance();
//								Constructor constructor =
//										 Class.forName(
//												Constants.FEATUREPACKAGE + FeatureName
//														+ Constants.FEATURE).getConstructor(new Class[]{Feature.class,Hashtable.class});
								//IFeature = constructor.newInstance(initargs);
								
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								System.out
								.println("Feature could not be instantiated inside Feature Factory");
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out
								.println("Feature could not be accessed inside Feature Factory");
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								System.out
								.println("Feature not Found during inside Feature Factory");
							}
                        	Features.put(FeatureName, IFeature);
                        }
                }
        }

        return Features.get(FeatureName);
	}

}
