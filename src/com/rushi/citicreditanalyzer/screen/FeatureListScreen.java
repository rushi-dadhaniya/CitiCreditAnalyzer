package com.rushi.citicreditanalyzer.screen;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.citi.creditcard.CreditCardFeatures;

public class FeatureListScreen extends ActionBarActivity{

	private ArrayAdapter<String> simpleListAdapter;
	private ArrayList<String> featureList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature_list);
		featureList = getFeatureList();
		simpleListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,featureList);
		ListView featureListView = (ListView) findViewById(R.id.featureList);
		featureListView.setAdapter(simpleListAdapter);
	}
	public ArrayList<String> getFeatureList() {
		featureList = new ArrayList<String>();
		for(CreditCardFeatures creditCardFeature : CreditCardFeatures.values()) {
			featureList.add(creditCardFeature.getFeature());
		}
		return featureList;
	}
	
}
