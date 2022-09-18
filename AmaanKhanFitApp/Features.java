package com.amaan.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Features {
	static final String db_url="jdbc:mysql://localhost/fitapp";
	static final String username="root";
	static final String password="Aa@12345678";
	
	
	
	public boolean checkrecord(int id) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(db_url,username,password);
			String query="SELECT 1 from city where id=?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void RegisterNewUser() {
		try(Connection conn=DriverManager.getConnection(db_url,username,password)) {
			Statement stmt =conn.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("Adding a new Runner!!!");
			System.out.println("Enter the runner id integer value: ");
			int runnerid=sc.nextInt();
			System.out.println("Enter the runner name: ");
			String runnername=sc.next();
			System.out.println("Enter the runner's city to register: ");
			String cityregistered=sc.next();
			System.out.println("Enter the city id: ");
			int cityid=sc.nextInt();
			System.out.println("Enter the city region: ");
			String region=sc.next();
			
			
			boolean flag=checkrecord(cityid);
			if (flag==false) {
				String query1="INSERT INTO city(id,name,region) VALUES(?,?,?)";
				PreparedStatement pstmt=conn.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS );
				pstmt.setInt(1,cityid);
				pstmt.setString(2,cityregistered);
				pstmt.setString(3,region);
				pstmt.executeUpdate();
				pstmt.close();
			}
			String query2="INSERT INTO runner(id,name,cityregistered) VALUES(?,?,?)";
			PreparedStatement pstmt1=conn.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS );
			pstmt1.setInt(1,runnerid);
			pstmt1.setString(2,runnername);
			pstmt1.setString(3,cityregistered);
			pstmt1.executeUpdate();
			pstmt1.close();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("The user is Successfully Registered!!!");
		
	}
	
	public void listAllTheRunners() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(db_url,username,password);
			String query="SELECT name from runner";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void UploadDailyActivityForRunner() {
		try(Connection conn=DriverManager.getConnection(db_url,username,password)) {
			Statement stmt =conn.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("Uploading Runner Daily Activity!!!");
			System.out.println("Date of Uploading:  ");
			String uploadingdate=sc.next();
			System.out.println("Enter the runner id: ");
			int runnerid=sc.nextInt();
			System.out.println("Enter the runner's distance: ");
			float distance=sc.nextFloat();
			System.out.println("Enter the city id: ");
			int cityid=sc.nextInt();
//			boolean flag=checkrecord(cityid);
//			if (flag==false) {
//				String query1="INSERT INTO city(id,name,region) VALUES(?,?,?)";
//				PreparedStatement pstmt=conn.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS );
//				pstmt.setInt(1,cityid);
//				pstmt.setString(2,cityregistered);
//				pstmt.setString(3,region);
//				pstmt.executeUpdate();
//				pstmt.close();
//			}
			String query2="INSERT INTO dailyactivity(date,runnerid,distance,cityid) VALUES(?,?,?,?)";
			PreparedStatement pstmt1=conn.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS );
			pstmt1.setString(1,uploadingdate);
			pstmt1.setInt(2,runnerid);
			pstmt1.setFloat(3,distance);
			pstmt1.setInt(4,cityid);
			pstmt1.executeUpdate();
			pstmt1.close();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("Daily Activity Data is Successfully Uploaded!!!");
	
	}
	
	public void UploadRunnerActivityUsingCsv() {
		String filepath="C:\\Users\\w127281\\OneDrive - Worldline\\Desktop\\dailyActivity.csv";
		
		try {
			Connection conn=DriverManager.getConnection(db_url,username,password);
			String query= "INSERT INTO dailyactivity(date,runnerid,distance,cityid) values(?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(query);
			BufferedReader lineReader=new BufferedReader(new FileReader(filepath));
			String lineText=null;
			
			while((lineText=lineReader.readLine())!=null) {
				String[] data=lineText.split(",");
				String date=data[0];
				int runnerid=Integer.parseInt(data[1]);
				float distance=Float.parseFloat(data[2]);
				int cityid=Integer.parseInt(data[3]);
				
				pstmt.setString(1,date);
				pstmt.setInt(2,runnerid);
				pstmt.setFloat(3,distance);
				pstmt.setInt(4,cityid);
				pstmt.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Data Uploaded Successfully!!!!");
		
		
	}
	
	public void TotalRunnerPerRegionAndPerCity() {
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(db_url,username,password);
			Statement stmt=conn.createStatement();
			String query1="SELECT COUNT(*), cityregistered from runner group by(cityregistered)";
			ResultSet rs=stmt.executeQuery(query1);
			while(rs.next()) {
				System.out.println(rs.getString("count(*)")+" "+rs.getString("cityregistered"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void AverageRunsOnGivenDay() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(db_url,username,password);
			Statement stmt=conn.createStatement();
			String query1="SELECT COUNT(*), date from dailyactivity group by(date)";
			ResultSet rs=stmt.executeQuery(query1);
			while(rs.next()) {
				System.out.println("count  date");
				System.out.println(rs.getString("count(*)")+" "+rs.getString("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}