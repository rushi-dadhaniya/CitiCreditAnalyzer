package com.rushi.citicreditanalyzer.citi.creditcard;

import com.rushi.citicreditanalyzer.fileprocessor.TextFileAlignments;

public enum CreditCardFeatures {

	Card_NUmber("card number", TextFileAlignments.SAME_LINE),
	PERIOD("statement period", TextFileAlignments.SAME_LINE),
	TOTAL_AMOUNT_DUE("Total amount due", TextFileAlignments.NEXT_LINE),
	MINIMUM_AMOUNT_DUE("Minimum amount due", TextFileAlignments.NEXT_LINE),
	DUE_DATE("Due date", TextFileAlignments.NEXT_LINE),
	CREDIT_LIMIT("Credit limit", TextFileAlignments.NEXT_LINE),
	AVAILABLE_CREDIT_LIMIT("Available credit limit", TextFileAlignments.NEXT_LINE),
	AVAILABLE_CASH_LIMIT("Available cash limit", TextFileAlignments.NEXT_LINE),
	PREVIOUS_BALANCE("Previous balance", TextFileAlignments.NEXT_LINE),
	CURRENT_PURCHASE_OTHER_CHARGES("Current purchases and other charges", TextFileAlignments.NEXT_LINE),
	CURRENT_CASH_ADVANCE("Current cash advance", TextFileAlignments.NEXT_LINE),
	LAST_PAYMENT_RECEIVED("Last payment received", TextFileAlignments.NEXT_LINE),
	POINTS_EARNED("Points earned", TextFileAlignments.NEXT_LINE),
	DETAILED_STATEMENT("Detailed statement", TextFileAlignments.NEXT_LINE),
	REWARD_POINTS_SUMMARY("Reward point summary", TextFileAlignments.NEXT_LINE);
	
	private String feature;
	private TextFileAlignments alignment;
	
	private CreditCardFeatures(String feature, TextFileAlignments alignment) {
		
		this.setFeature(feature);
		this.setAlignment(alignment);
		
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public TextFileAlignments getAlignment() {
		return alignment;
	}

	public void setAlignment(TextFileAlignments alignment) {
		this.alignment = alignment;
	}
	
}
