package com.rushi.citicreditanalyzer.vo;

public class PointsSummaryVO {

	private Long pointsEarnedSoFar;
	private Long pointsEarnedThisMonth;
	private Long pointsRedeemedThisMonth;
	private Long pointsAvailableForRedemption;
	
	public Long getPointsEarnedSoFar() {
		return pointsEarnedSoFar;
	}
	public void setPointsEarnedSoFar(Long pointsEarnedSoFar) {
		this.pointsEarnedSoFar = pointsEarnedSoFar;
	}
	public Long getPointsEarnedThisMonth() {
		return pointsEarnedThisMonth;
	}
	public void setPointsEarnedThisMonth(Long pointsEarnedThisMonth) {
		this.pointsEarnedThisMonth = pointsEarnedThisMonth;
	}
	public Long getPointsRedeemedThisMonth() {
		return pointsRedeemedThisMonth;
	}
	public void setPointsRedeemedThisMonth(Long pointsRedeemedThisMonth) {
		this.pointsRedeemedThisMonth = pointsRedeemedThisMonth;
	}
	public Long getPointsAvailableForRedemption() {
		return pointsAvailableForRedemption;
	}
	public void setPointsAvailableForRedemption(Long pointsAvailableForRedemption) {
		this.pointsAvailableForRedemption = pointsAvailableForRedemption;
	}
	
}
