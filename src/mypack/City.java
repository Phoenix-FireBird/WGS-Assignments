package mypack;

public class City {
	int City_Id;
	String City_Name;
	String City_Region;
	
	public void City()
	{
		
	}
	public void City(int v1, String v2, String v3)
	{
		City_Id=v1;
		City_Name=v2;
		City_Region=v3;
	}
	public int getCity_Id() {
		return City_Id;
	}
	public void setCity_Id(int city_Id) {
		City_Id = city_Id;
	}
	public String getCity_Name() {
		return City_Name;
	}
	public void setCity_Name(String city_Name) {
		City_Name = city_Name;
	}
	public String getCity_Region() {
		return City_Region;
	}
	public void setCity_Region(String city_Region) {
		City_Region = city_Region;
	}
	

}
