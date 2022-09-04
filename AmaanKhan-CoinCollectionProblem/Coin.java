package coin.collection;

import java.util.List;

public class Coin {
	String Country;
	String Denomination;
	String YearOfMinting;
	String CurrentValue;
	String AcquiredDate;
	
	public Coin() {
		
	}
	
	public Coin(String v1,String v2, String v3,String v4,String v5) {
		this.Country=v1;
		this.Denomination=v2;
		this.YearOfMinting=v3;
		this.CurrentValue=v4;
		this.AcquiredDate=v5;
		
	}
	
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getDenomination() {
		return Denomination;
	}
	public void setDenomination(String denomination) {
		Denomination = denomination;
	}
	public String getYearOfMinting() {
		return YearOfMinting;
	}
	public void setYearOfMinting(String yearOfMinting) {
		YearOfMinting = yearOfMinting;
	}
	public String getCurrentValue() {
		return CurrentValue;
	}
	public void setCurrentValue(String currentValue) {
		CurrentValue = currentValue;
	}
	public String getAcquiredDate() {
		return AcquiredDate;
	}
	public void setAcquiredDate(String acquiredDate) {
		AcquiredDate = acquiredDate;
	}
	
	@Override 
	public String toString() {
		return this.Country+" "+this.Denomination+" "+this.YearOfMinting+" "+this.CurrentValue+" "+this.AcquiredDate;
	}
	
	}
	


