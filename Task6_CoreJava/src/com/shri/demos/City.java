package com.shri.demos;

public class City {

	int CId;
	String CName;
	String Region;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	public City(int v1, String v2, String v3) {
		CId=v1;
		CName=v2;
		Region=v3;
	}
	public int getCId() {
		return CId;
	}
	public void setCId(int cId) {
		CId = cId;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	
}
