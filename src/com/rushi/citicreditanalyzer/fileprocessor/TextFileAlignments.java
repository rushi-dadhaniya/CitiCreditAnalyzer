package com.rushi.citicreditanalyzer.fileprocessor;

public enum TextFileAlignments {

	SAME_LINE("same line"),
	NEXT_LINE("next line");
	
	private String alignment;
	
	private TextFileAlignments(String alignment) {
		
		this.setAlignment(alignment);
		
	}
	public String getAlignment() {
		return alignment;
	}
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}
	
}
