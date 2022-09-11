package com.assign3;

public class City {

	int City_id;
	String Name;
	String Region;
	
	public City(){
		
		
	}
    public City(int a,String b,String c){
		City_id=a;
		Name=b;
		Region=c;
		}
	public int getCity_id() {
		return City_id;
	}
	public void setCity_id(int city_id) {
		City_id = city_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
}