package com.connection.mysqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RunnerInfo {
	int id;
	String name;
	CityInfo cityid;

	public RunnerInfo() {
		// TODO Auto-generated constructor stub
	}

	public RunnerInfo(int v1, String v2, CityInfo v3) {
		id = v1;
		name = v2;
		cityid = v3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityInfo getCityid() {
		return cityid;
	}

	public void setCityid(CityInfo cityid) {
		this.cityid = cityid;
	}

	public void newRegister() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/runnerinfo", "root", "root");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Runner Id:");
			int a = sc.nextInt();
			System.out.println("Enter Runner Name:");
			String b = sc.next();
			System.out.println("Enter City id:");
			int c = sc.nextInt();

			ResultSet rs = stmt.executeQuery("select RId,RName,CId from runner");
			rs.moveToInsertRow();
			rs.updateInt(1, a);
			rs.updateString(2, b);
			rs.updateInt(3, c);
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

	public void listRunner() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/runnerinfo", "root", "root");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String query = "select * from runner";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("RId RName CId");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
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

	public void getRunnerCity() {
		try {
			int count = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("please enter roll_number");
			int rollno = sc.nextInt();

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wgs", "root", "root");
			PreparedStatement pstmt = conn.prepareStatement("select * from students where roll_number='?'");
			ResultSet rs = pstmt.executeQuery();
			pstmt.setInt(1, rollno);

			while (rs.next()) {
				if (rs.getInt(1) == rollno) {
					count++;
				}
			}
			System.out.println("Total Runners in this City: " + count);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
