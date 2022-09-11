package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Runner{
	int Runner_Id;
	String Runner_Name;
	City City_Id;
	
	public void Runner()
	{
		
	}
	public void Runner(int v1, String v2, City v3)
	{
		Runner_Id=v1;
		Runner_Name=v2;
		City_Id=v3;
	}
	public int getRunner_Id() {
		return Runner_Id;
	}
	public void setRunner_Id(int runner_Id) {
		Runner_Id = runner_Id;
	}
	public String getRunner_Name() {
		return Runner_Name;
	}
	public void setRunner_Name(String runner_Name) {
		Runner_Name = runner_Name;
	}
	public City getCity_Id() {
		return City_Id;
	}
	public void setCity_Id(City city_Id) {
		City_Id = city_Id;
	}
	public void Insert_Runner()
	{
		try {
			Connection conn=null;
			Scanner sc=new Scanner(System.in);
			System.out.println("Please Enter id:");
			int Runner_Id=sc.nextInt();
			System.out.println("Please Enter Name:");
			String Runner_Name=sc.next();
			System.out.println("Please City id:");
			int City_Id=sc.nextInt();
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rushi123");
			String query = "SELECT Runner_Id,Runner_Name,City_Id FROM Runner";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(query);
            rs.moveToInsertRow();
            rs.updateInt(1,Runner_Id);
            rs.updateString(2,Runner_Name);
            rs.updateInt(3,City_Id);
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
	public void List_Of_Runners()
	{
		try {
			Connection conn=null;
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rushi123");
			String query = "SELECT * FROM Runner";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Id    Name    CId");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Total_Runner()
	{
		try {
			int count=0;
			
	
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter City id:");
			int cityId = sc.nextInt();

			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rushi123");
			PreparedStatement pstmt = conn.prepareStatement("Select * from runner where city_id=(?)");
			pstmt.setInt(1, cityId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt(3)==cityId)
				{
					count++;
				}
			}
			System.out.println("Total Runners in this City: " + count);
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
