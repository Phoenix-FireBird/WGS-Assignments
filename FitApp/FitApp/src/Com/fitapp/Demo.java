package Com.fitapp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo {
	int idRun;
	String nameRunner;
	String city;
	String date;
	int distance;
	String region;
	
	
	public Demo()
	{
		
	}
	
	
	public Demo(int idRun, String nameRunner,String city,String date ,int distance,String region)
	{
		this.idRun=idRun;
		this.nameRunner=nameRunner;
		this.city=city;
		this.date=date;
		this.distance=distance;
		this.region=region;
		
	}
	
	

	
	public int getIdRun() {
		return idRun;
	}
	public void setIdRun(int idRun) {
		this.idRun = idRun;
	}
	public String getNameRunner() {
		return nameRunner;
	}
	public void setNameRunner(String nameRunner) {
		this.nameRunner = nameRunner;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}


	public static String Class = "com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/fit";
	public static String username="root";
	public static String password="Vijay@2411";
	
	public static Connection con = null;
	
	
	
	//1.register a new runner
	
	public void runner() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter idRun:");
		int idRun = sc.nextInt();
		System.out.println("Enter nameRunner:");
		String nameRunner = sc.next();
		System.out.println("Enter city:");
		String city = sc.next();
		
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pt = con.prepareStatement("insert into runner values(?,?,?)");
		pt.setInt(1,idRun);
		pt.setString(2, nameRunner);
		pt.setString(3,city);
		int count = pt.executeUpdate();
		if(count>0)
		{
		System.out.println("Successfully inserted...");
		}
		con.close();
		
	}
	
	//2.List all runners in the database
	
	public void listAllRunner() throws Exception
	{
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pt = con.prepareStatement("select idRun ,nameRunner from runner");
		ResultSet rs = pt.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" ");
			System.out.println(rs.getString(2));
		}
		con.close();
		
		
	}
	
	
	//3.Upload dailyActivity for a runner
	
	public void dailyActivityRunner() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter runnerId:");
		int runnerId = sc.nextInt();
		System.out.println("Enter date:");
		String date= sc.next();
		System.out.println("Enter distance:");
		int distance = sc.nextInt();
		System.out.println("Enter cityId:");
		int cityId = sc.nextInt();
		
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pt = con.prepareStatement("insert into dailyactivity values(?,?,?,?)");
		pt.setInt(1,runnerId);
		pt.setString(2,date);
		pt.setInt(3,distance);
		pt.setInt(4,cityId);
		pt.executeUpdate();
		System.out.println("Successfully inserted...");
		
		con.close();
		
	}
	
	//4.Upload running activity in db for duration(in days,using csv)
	
	public void runningDuration() throws Exception
	{

		FileReader inputFileReader = new FileReader("C:\FitApp\FitApp\src\Com\fitapp\Runnerdetails.xlsx");
		BufferedReader inputStream = new BufferedReader(inputFileReader);
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pt = con.prepareStatement("insert into dailyactivity values(?,?,?,?,?,?)");
		pt.setInt(1, idRun);
		pt.setString(2, nameRunner);
		pt.setString(3,city);
		pt.setString(4, date);
		pt.setInt(5,distance);
		pt.setString(6,region);
		
		pt.executeUpdate();
		System.out.println("Success...");
			
	}
	
	
	//5.Find total runner per region per city
	
	public void totalRunner() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter per region:");
		String region = sc.next();
		System.out.println("Enter per city:");
		String city = sc.next();
		
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement pt = con.prepareStatement("select count(distinct(runnerId)) from dailyactivity where city=(?)");
		PreparedStatement pt1 = con.prepareStatement("select count(distinct(runnerId)) from dailyactivity where region=(?)");
		
		System.out.println("Enter city and Region:");
		System.out.println("Enter city:");
		System.out.println("Enter Region:");
		int a = sc.nextInt();
		switch(a)
		{
		case 1:
		{
			pt.setString(1,city);
			ResultSet rs = pt.executeQuery();
			while(rs.next())
			{
			System.out.println(rs.getString(1) + " ");
			}
			break;
		}
		case 2:
		{
			pt1.setString(2, region);
			ResultSet rs = pt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" ");
			}
			break;
		}
		}
		
		}
	
		//6.Find avg runs on any given day
		
		public void avgRunner() throws Exception
		{
			Scanner sc = new Scanner(System.in);
			String date = sc.next();
			System.out.println("Enter Date:");
			PreparedStatement pt = con.prepareStatement("select AVG(distance) from dailyactivity where date=(?)");
			ResultSet rs = pt.executeQuery();
			pt.setString(1,date);
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"km ");
				System.out.println(rs.getString(2)+ "km ");
				System.out.println(rs.getString(3)+" km");
				
			}
			
		}
		
		//main method
		
		
		public static void main(String[] args) throws Exception
		{
			Demo d = new Demo();
			Demo d1 = new Demo();
			Demo d2= new Demo();
			Demo d3= new Demo();
			Demo d4= new Demo();
			Demo d5= new Demo();
			d.runner();
			d1.listAllRunner();
			d2.dailyActivityRunner();
			d3.runningDuration();
			d4.totalRunner();
			d5.avgRunner();
			
			boolean exit=false;
			
			Scanner sc = new Scanner(System.in);


			while (!exit)
			{
				System.out.println("1.Register the new runner");
				System.out.println("2.List all the runner");
				System.out.println("3.Upload daily activity of the runner");
				System.out.println("4.Upload running in db using csv");
				System.out.println("5.Find the total runner per region,per city");
				System.out.println("6.Find average runs on any given day");
				int a = sc.nextInt();
				switch(a)
				{
				case 1:
				{
				d.runner();
				break;
				}
				case 2:
				{
				d1.listAllRunner();
				break;
				}
				case 3:
				{
				d2.dailyActivityRunner();
				break;
				}
				case 4:
				{
				d3.runningDuration();
				break;
				}
				case 5:
				{
				d4.totalRunner();
				break;
				}
				case 6:
				{
				d5.avgRunner();
				break;
				}
				default:{
				System.out.println("Invalid case option");
						}
							
				}
			
			
			
			
			
			
		}
		}
}
		
		 
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	

