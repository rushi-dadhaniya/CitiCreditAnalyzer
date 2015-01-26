package com.rushi.citicreditanalyzer.citi.creditcard;

import java.util.Date;

public class StatementVO {

	private Date transactionDate;
	private Long transactionNumber;
	private String transactionDetail;
	private Double transactionAmount;
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Long getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getTransactionDetail() {
		return transactionDetail;
	}
	public void setTransactionDetail(String transactionDetail) {
		this.transactionDetail = transactionDetail;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
}
