package com.connection.mysqldb;

public class DailyActivity {
	String date;
	RunnerInfo runnerid; 
	long distance; 
	CityInfo cityid;
	
	public DailyActivity() {
		// TODO Auto-generated constructor stub
	}
	
	public DailyActivity(String v1,RunnerInfo v2,long v3,CityInfo v4) {
		date=v1;
		runnerid=v2;
		distance=v3;
		cityid=v4;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public RunnerInfo getRunnerid() {
		return runnerid;
	}

	public void setRunnerid(RunnerInfo runnerid) {
		this.runnerid = runnerid;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public CityInfo getCityid() {
		return cityid;
	}

	public void setCityid(CityInfo cityid) {
		this.cityid = cityid;
	}
	
}
