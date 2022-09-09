package com.TeslaCoil196.Assignment_5;

public class Runner_csv {

	String date;
	int id;
	int distance;
	int city_id;
	String city_name;
	String region_name;
	
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	
	public Runner_csv(String date, int id, int distance, int city_id, String city_name, String region_name) {
		// TODO Auto-generated constructor stub

		this.date =date;
		this.id = id;
		this.distance = distance;
		this.city_id = city_id;
		this.city_name = city_name;
		this.region_name = region_name;
		
	}
	
	public String all() {
		
        return ("DATE:"+this.getDate()+
                    " \n Runner ID : "+ this.getId() +
                    " \n Distance: "+ this.getDistance() +
                    " \n City ID : " + this.getCity_id()+
                    " \n City name : "+this.getCity_name()+
                    " \n Region name : "+this.getRegion_name()+
                    "\n\n");
   }
}
