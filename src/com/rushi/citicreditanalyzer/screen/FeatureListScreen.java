package com.rushi.citicreditanalyzer.screen;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.adapter.CheckBoxAdapter;
import com.rushi.citicreditanalyzer.citi.creditcard.CreditCardFeatures;

public class FeatureListScreen extends Activity{

	private ArrayList<String> featureList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature_list);
		featureList = getFeatureList();
		Feature features[] = new Feature[featureList.size()];
		for(int i = 0 ; i < featureList.size() ; i++) {
			Feature feature = new Feature();
			feature.setFeature(featureList.get(i));
			feature.setSelected(true);
			features[i] = feature;
		}
		CheckBoxAdapter checkBoxAdapter = new CheckBoxAdapter(this, R.layout.activity_checkboxed_list, features);
		ListView featureListView = (ListView) findViewById(R.id.featureListView);
		featureListView.setAdapter(checkBoxAdapter);
	}
	
	

	public ArrayList<String> getFeatureList() {
		featureList = new ArrayList<String>();
		for(CreditCardFeatures creditCardFeature : CreditCardFeatures.values()) {
			featureList.add(creditCardFeature.getFeature());
		}
		return featureList;
	}
	
}
