package com.rushi.citicreditanalyzer.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class Feature implements Parcelable{

	private String feature;
	private boolean selected;
	
	public Feature() {
		
	}
	public Feature(Parcel source) {
		feature = source.readString();
		selected = source.readByte() != 0;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(feature);
		dest.writeByte((byte) (selected ? 1 : 0));
	}
	
	@SuppressWarnings("rawtypes")
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
	    public Feature createFromParcel(Parcel in) {
	        return new Feature(in);
	    }

	    public Feature[] newArray(int size) {
	        return new Feature[size];
	    }
	};
	
	
}
