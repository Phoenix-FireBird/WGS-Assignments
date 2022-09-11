package com.runner.daily.demo;

public class City {

	int cityId;
	String name;
	String region;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	public City(int v1,String v2,String v3) {
		cityId = v1;
		name = v2;
		region = v3;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
