package com.shri.demos;

public class Daily_Activity {
	
	String ActivityDate;
	Runner RId;
	long distance;
	City CId;
	
	public Daily_Activity() {
		// TODO Auto-generated constructor stub
	}
	public Daily_Activity(String v1, Runner v2, long v3, City v4) {
		ActivityDate=v1;
		RId=v2;
		distance=v3;
		CId=v4;
	}
	public String getActivityDate() {
		return ActivityDate;
	}
	public void setActivityDate(String activityDate) {
		ActivityDate = activityDate;
	}
	public Runner getRId() {
		return RId;
	}
	public void setRId(Runner rId) {
		RId = rId;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
	}
	public City getCId() {
		return CId;
	}
	public void setCId(City cId) {
		CId = cId;
	}
	

}
