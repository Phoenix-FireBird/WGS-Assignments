package com.amaan.application;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class CreateDb {
	
	public void createDatabases() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String mysqlUrl="jdbc:mysql://localhost/";
		try {
			Connection con=DriverManager.getConnection(mysqlUrl,"root","Aa@12345678");
			Statement stmt=con.createStatement();
			String query="CREATE database fitapp";
			stmt.execute(query);
			System.out.println("Database Created");
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void creatingTables() {
//		try {
//			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/fitapp","root","Aa@12345678");
//			Statement stmt=conn.createStatement();
//			String query="Create Table City "
//					+ "(id integer not null, "
//					+ "name varchar(50), "
//					+ "region varchar(50), "
//					+ "PRIMARY KEY(id));";
//			stmt.execute(query);
//			query="CREATE Table Runner "
//					+ "(id integer not null, "
//					+ "name varchar(50) not null, "
//					+ "cityRegistered varchar(50), "
//					+ "PRIMARY KEY(id), "
//					+ "FOREIGN KEY (cityRegistered) REFERENCES City(id));";
//			stmt.execute(query);
//			query="CREATE Table DailyActivity "
//					+ "(date DATE, "
//					+ "runnerId integer not null, "
//					+ "distance float, "
//					+ "cityid int not null, "
//					+ "FOREIGN KEY(runnerid) REFERENCES Runner(id), "
//					+ "FOREIGN KEY(cityid) REFERENCES City(id));";
//			stmt.execute(query);
//			conn.close();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
