package com.rushi.citicreditanalyzer.screen;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.adapter.CheckBoxAdapter;
import com.rushi.citicreditanalyzer.citi.creditcard.CreditCardFeatures;
import com.rushi.citicreditanalyzer.vo.Feature;

public class FeatureListScreen extends Activity{

	private Feature[] features;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feature_list);
		
		
		setFeatures(getFeatureArray());
		CheckBoxAdapter checkBoxAdapter = getCheckBoxAdapter(getFeatures());
		
		ListView featureListView = getfeatureListView();
		featureListView.setAdapter(checkBoxAdapter);
		
		Button submitFeatureButton = getSubmitFeatureButton();
		handleButtonClick(submitFeatureButton);
	}

	private void handleButtonClick(Button submitFeatureButton) {
		submitFeatureButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<Feature> selectedFeatures = getSelectedFeatures();
			}

			
		});
	}

	private ArrayList<Feature> getSelectedFeatures() {

		Feature[] features = getFeatures();
		ArrayList<Feature> selectedFeatures = new ArrayList<Feature>();
		
		for(int featureIterator = 0 ; featureIterator < features.length ; featureIterator++) {
			Feature feature =  features[featureIterator];
			boolean isFeatureSelected = feature.isSelected();
			if(isFeatureSelected) {
				selectedFeatures.add(feature);
			}
		}
		return selectedFeatures;
	}
	
	private Button getSubmitFeatureButton() {
		Button submitFeaturesButton = (Button) findViewById(R.id.submitFeatureButton);
		return submitFeaturesButton;
	}

	private ListView getfeatureListView() {
		ListView featureListView = (ListView) findViewById(R.id.featureListView);
		return featureListView;
	}

	private CheckBoxAdapter getCheckBoxAdapter(Feature[] features) {
		CheckBoxAdapter checkBoxAdapter = new CheckBoxAdapter(this, R.layout.activity_checkboxed_list, features);
		return checkBoxAdapter;
	}

	private Feature[] getFeatureArray() {
		
		Feature features[] = new Feature[CreditCardFeatures.values().length];
		int featureCount = 0;
		for(CreditCardFeatures creditCardFeature : CreditCardFeatures.values()) {
			Feature feature = new Feature();
			feature.setFeature(creditCardFeature.getFeature());
			feature.setSelected(true);
			features[featureCount++] = feature;
		}
		return features;
	}

	public Feature[] getFeatures() {
		return features;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}
	
}
