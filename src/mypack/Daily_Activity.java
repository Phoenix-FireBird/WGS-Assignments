package mypack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Daily_Activity {
	String Activity_Date;
	Runner Runner_Id;
	City City_Id;
	long Distance;
	
	public void Daily_Activity()
	{
		
	}
	public void Daily_Activity(String v1, Runner v2, City v3, long v4)
	{
		Activity_Date=v1;
		Runner_Id=v2;
		City_Id=v3;
		Distance=v4;
	}
	public String getActivity_Date() {
		return Activity_Date;
	}
	public void setActivity_Date(String activity_Date) {
		Activity_Date = activity_Date;
	}
	public Runner getRunner_Id() {
		return Runner_Id;
	}
	public void setRunner_Id(Runner runner_Id) {
		Runner_Id = runner_Id;
	}
	public City getCity_Id() {
		return City_Id;
	}
	public void setCity_Id(City city_Id) {
		City_Id = city_Id;
	}
	public long getDistance() {
		return Distance;
	}
	public void setDistance(long distance) {
		Distance = distance;
	}
	public void Daily_Activity_Runner()
	{
		try {
			Connection conn=null;
			Scanner sc=new Scanner(System.in);
			System.out.println("Please Enter Activity Date:");
			String Activity_Date=sc.next();
			System.out.println("Please Enter Runner Id:");
			int Runner_Id=sc.nextInt();
			System.out.println("Please Enter Distance:");
			long Distance=sc.nextLong();
			System.out.println("Please City id:");
			int City_Id=sc.nextInt();
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rushi123");
			String query = "SELECT Activity_Date,Runner_Id,Distance,City_Id FROM Daily_Activity";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery(query);
			rs.moveToInsertRow();
			rs.updateString(1,Activity_Date);
			rs.updateInt(2,Runner_Id);
			rs.updateLong(3,Distance);
			rs.updateInt(4,City_Id);
			rs.insertRow();
			
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Running_Activity()
	{
		try {
			Connection conn=null;
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rushi123");

			    String query = "INSERT INTO Daily_Activity (Activity_Date, Runner_Id, Distance, City_Id) VALUES (?, ?, ?, ?)";
			    PreparedStatement statement = conn.prepareStatement(query);

			    BufferedReader l1 = new BufferedReader(new FileReader("C:\\Users\\w127363\\OneDrive - Worldline\\Runner.csv"));
			    String lineText = null;

			    l1.readLine(); 
			    final int size = 20;
			    int count = 0;
			    while ((lineText = l1.readLine()) != null) {
			        Statement st = (Statement) new StringTokenizer(lineText, ",");

			        String Activity_Date = ((StringTokenizer) st).nextToken();
			        int Runner_Id = Integer.parseInt(((StringTokenizer) st).nextToken());
			        long Distance = Long.parseLong(((StringTokenizer) st).nextToken());
			        int City_Id = Integer.parseInt(((StringTokenizer) st).nextToken());

			        statement.setString(1, Activity_Date);
			        statement.setInt(2, Runner_Id);
			        statement.setLong(3, Distance);
			        statement.setInt(4, City_Id);
			        statement.addBatch();

			        if (count % size == 0) {
			            statement.executeBatch();
			        } 
			    }

			    l1.close();
			    statement.executeBatch();
			    conn.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Average_Runs()
	{
		try {
			double avgRun = 0;
			long cal = 0;
			int count = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter Date:");
			String activityDate = sc.next();

			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rushi123");
			PreparedStatement pstmt = conn.prepareStatement("Select * from daily_activity where activity_date=(?)");
			pstmt.setString(1, String.valueOf(activityDate));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {

					System.out.println("The Dates are:"+rs.getString(3));
					cal += rs.getLong(3); 
					count++;
			}
			System.out.println("calculation="+cal);
			System.out.println("count="+count);
			avgRun = cal / count;
			System.out.println("Average Run of Date: "+activityDate+" is: " + avgRun);
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
