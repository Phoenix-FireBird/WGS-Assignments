package com.coincollection;

class Coin
{
	String country;
	String denomination;
	String yearOfMining;
	double currentValue;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getYearOfMining() {
		return yearOfMining;
	}
	public void setYearOfMining(String yearOfMining) {
		this.yearOfMining = yearOfMining;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	public String getAcquiredDate() {
		return acquiredDate;
	}
	public void setAcquiredDate(String acquiredDate) {
		this.acquiredDate = acquiredDate;
	}
	String acquiredDate;
}

