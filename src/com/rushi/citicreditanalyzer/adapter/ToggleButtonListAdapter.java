package com.rushi.citicreditanalyzer.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.citicreditanalyzer.R;
import com.rushi.citicreditanalyzer.screen.Item;

public class ToggleButtonListAdapter extends ArrayAdapter<Item>{

	private Context context;
	private Item[] features;
	public ToggleButtonListAdapter(Context context, int resource, int textview1, Item[] items) {
		super(context, resource, textview1, items);
		this.context = context;
		this.features = items;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressLint("ViewHolder") @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = layoutInflater.inflate(R.layout.activity_featurelist_toggle, parent, false);
		TextView featureTextView = (TextView) rowView.findViewById(R.id.textView1);
//		ToggleButton featureToggleButton = (ToggleButton) rowView.findViewById(R.id.toggleButton);
		featureTextView.setText(features[position].getFeature());
		return rowView;
	}

}
