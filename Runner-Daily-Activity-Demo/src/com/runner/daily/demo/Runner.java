package com.runner.daily.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Runner{

	int runnerId;
	String runnerName;
	City cityId;
	
	public Runner() {
		// TODO Auto-generated constructor stub
	}
	
	public Runner(int v1,String v2,City v3) {
		runnerId = v1;
		runnerName = v2;
		cityId = v3;
	}

	public int getRunnerId() {
		return runnerId;
	}

	public void setRunnerId(int runnerId) {
		this.runnerId = runnerId;
	}

	public String getRunnerName() {
		return runnerName;
	}

	public void setRunnerName(String runnerName) {
		this.runnerName = runnerName;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}
	
	
	public void registerNewRunner() {
			
			try {
	
				Scanner sc = new Scanner(System.in);
				System.out.println("Please Enter id:");
				int id = sc.nextInt();
				System.out.println("Please Enter Name:");
				String name = sc.next();
				System.out.println("Please Enter City id:");
				int cityId = sc.nextInt();
				
				Class.forName("oracle.jdbc.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Sam#1234");
				String query = "SELECT runner_id,runner_name,city_id FROM runner";
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				ResultSet rs = stmt.executeQuery(query);
				rs.moveToInsertRow();
				rs.updateInt(1,id);
				rs.updateString(2, name);
				rs.updateInt(3,cityId);
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
	
	public void allRunnersList() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Sam#1234");
			String query = "Select * from runner";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Id  Name  City_Id");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"    "+rs.getInt(3));
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void totalRunnerPerCity() {
		
		try {
			
			int count = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter City id:");
			int cityId = sc.nextInt();
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Sam#1234");
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
