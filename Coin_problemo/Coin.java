package com.TeslaCoil196.Assignment_3;

import java.util.*;

public class Coin {
	
	String country; // Country of origin
	int value;
	String type_curr; // Denomination
	String year_of_mining;
	String curr_value;
	String aquired_date;
	
	
	
	

	public Coin(String country, int value, String type_curr, String year_of_mining, String curr_value, String aquired_date) {
		// TODO Auto-generated constructor stub
		this.country = country;
		this.value = value;
		this.type_curr = type_curr;
		this.year_of_mining = year_of_mining;
		this.curr_value = curr_value;
		this.aquired_date = aquired_date;
		
		
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getType_curr() {
		return type_curr;
	}
	public void setType_curr(String type_curr) {
		this.type_curr = type_curr;
	}
	public String getYear_of_mining() {
		return year_of_mining;
	}
	public void setYear_of_mining(String year_of_mining) {
		this.year_of_mining = year_of_mining;
	}
	public String getCurr_value() {
		return curr_value;
	}
	public void setCurr_value(String curr_value) {
		this.curr_value = curr_value;
	}
	public String getAquired_date() {
		return aquired_date;
	}
	public void setAquired_date(String aquired_date) {
		this.aquired_date = aquired_date;
	}
	
	
	public String all() {
		
	        return ("Country Name:"+this.getCountry()+
	                    " \nValue : "+ this.getValue() +
	                    " \nType of currency : "+ this.getType_curr() +
	                    " \nYear : " + this.getYear_of_mining()+
	                    "\nCurrent value : "+this.getCurr_value()+
	                    "\nAuqr date : "+this.getAquired_date()+
	                    "\n\n\n");
	   }
	
}

