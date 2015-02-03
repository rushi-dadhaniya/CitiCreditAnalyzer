package com.rushi.citicreditanalyzer.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.vo.Feature;

public class CheckBoxAdapter extends ArrayAdapter<Feature>{

	private Context contex;
	private Feature[] features;
	
	public CheckBoxAdapter(Context context, int resource, Feature[] features) {
		super(context, resource, features);
		this.contex = context;
		this.features = features;
	}

	@SuppressLint("InflateParams") @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ListViewHolder listViewHolder = null;
		if(convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(R.layout.activity_checkboxed_list, null);
			
			listViewHolder = new ListViewHolder();
			
			listViewHolder.featureTextView = (TextView) convertView.findViewById(R.id.featureTextView);
			listViewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.featureCheckBox);
			convertView.setTag(listViewHolder);
			
			
			
			listViewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					CheckBox checkBox = (CheckBox) v;
					Feature feature = (Feature) v.getTag();
					feature.setSelected(checkBox.isChecked());
					
				}
			});
		}
		else {
			listViewHolder = (ListViewHolder) convertView.getTag();
		}
		Feature feature = features[position];
		Boolean tmp = feature == null;
		Log.d("feature", tmp.toString());
		tmp = feature.getFeature() == null;
		Log.d("getfeature", tmp.toString());
		listViewHolder.featureTextView.setText(feature.getFeature());
		listViewHolder.checkBox.setChecked(feature.isSelected());
		listViewHolder.checkBox.setTag(feature);
		
		return convertView;
		
	}
	
}
