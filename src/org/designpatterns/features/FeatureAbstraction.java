package org.designpatterns.features;

import java.util.Hashtable;

public abstract class FeatureAbstraction {
	protected Feature feature;

	protected FeatureAbstraction(Feature feature) {
		this.feature = feature;
	}

	public abstract Hashtable callFeature(Hashtable requestdata); // low-level

	public abstract void connectFeature();

}
