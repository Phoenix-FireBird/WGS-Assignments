package com.connection.mysqldb;

public class CityInfo {
	int id; 
	String cityName;
	String region;
	
	public CityInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public CityInfo(int v1,String v2,String v3) {
		id=v1;
		cityName=v2;
		region=v3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
