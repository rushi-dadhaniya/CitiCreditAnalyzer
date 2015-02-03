package com.rushi.citicreditanalyzer.activity;


import java.util.ArrayList;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.vo.Feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ProcessingScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_processing);
		
		Intent featureListIntent = getIntent();
		ArrayList<Feature> selectedFeatures = getSelecetdFeatureFromIntent(featureListIntent);
		for(int i = 0 ; i < selectedFeatures.size() ; i++) {
			Log.d("feature", " "+i+" "+selectedFeatures.get(i).getFeature() + " "+ selectedFeatures.get(i).isSelected());
		}
	}

	private ArrayList<Feature> getSelecetdFeatureFromIntent(Intent featureListIntent) {
		ArrayList<Feature> selectedFeatures = null;
		if(featureListIntent != null) {
			selectedFeatures = featureListIntent.getParcelableArrayListExtra("Selected Features");
		}
		return selectedFeatures;
	}

	
}
