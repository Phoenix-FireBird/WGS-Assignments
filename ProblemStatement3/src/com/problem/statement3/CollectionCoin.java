package com.problem.statement3;

import java.util.*;

public class CollectionCoin {
	
	String country_of_origin;
	int value_of_coin;
	String denomination;
	String year_of_coin;
	String current_coin_value;
	String aquire_date;

	public CollectionCoin(String country_of_origin01, int value_of_coin01, String denomination01, String year_of_coin01,String current_coin_value01, String aquire_date01) {
		// TODO Auto-generated constructor stub
		this.country_of_origin= country_of_origin01;
		this.value_of_coin = value_of_coin01;
		this. denomination =  denomination01;
		this.year_of_coin = year_of_coin01;
		this.current_coin_value = current_coin_value01;
		this.aquire_date = aquire_date01;
	}

	public String Display() {
		
        return ("Country Of Origin:"+this.getCountry_of_origin()+" \nValue Of Coin : "+ this.getValue_of_coin() +" \nDenomination : "+ this.getDenomination() +" \n"
        		+ "Year Of Coin : " + this.getYear_of_coin()+"\nCurrent Coin Value: "+this.getCurrent_coin_value()+"\nAquire Date : "+this.getAquire_date()+"    ");
   }

	public String getCountry_of_origin() {
		return country_of_origin;
	}

	public void setCountry_of_origin(String country_of_origin) {
		this.country_of_origin = country_of_origin;
	}

	public int getValue_of_coin() {
		return value_of_coin;
	}

	public void setValue_of_coin(int value_of_coin) {
		this.value_of_coin = value_of_coin;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getYear_of_coin() {
		return year_of_coin;
	}

	public void setYear_of_coin(int year_of_coin) {
		this.year_of_coin = year_of_coin;
	}

	public int getCurrent_coin_value() {
		return current_coin_value;
	}

	public void setCurrent_coin_value(int current_coin_value) {
		this.current_coin_value = current_coin_value;
	}

	public int getAquire_date() {
		return aquire_date;
	}

	public void setAquire_date(int aquire_date) {
		this.aquire_date = aquire_date;
	}

	public static Iterator<CollectionCoin> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void add(CollectionCoin collectionCoin) {
		// TODO Auto-generated method stub
		
	}

    
    
}
		
