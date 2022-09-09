package com.TeslaCoil196.Assignment_5;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;


public class Upload_activity {

	public Upload_activity() {
		// TODO Auto-generated constructor stub
	}
	
	public void upload_acti(Connection con) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter today's date (DD-MON-YYYY) example(9/JAN/2022):");
		String date = sc.next();
		System.out.println("Enter your id :");
		int id = sc.nextInt();
		System.out.println("Enter disance you ran in Km :");
		int distnce = sc.nextInt();
		System.out.println("Enter city ID :");
		int city_id = sc.nextInt();
		//////////////////////////// changes 
		System.out.println("Enter city Name :");
		String city_name = sc.next();
		
		System.out.println("Enter Region Name :");
		String region_name = sc.next();
		
		
		try {
			
			PreparedStatement ptt = con.prepareStatement("insert into Daily_activity_2 values(?,?,?,?,?,?)");
			
			ptt.setString(1, date);
			ptt.setInt(2, id);
			ptt.setInt(3, distnce);
			ptt.setInt(4, city_id);
			ptt.setString(5, city_name.toLowerCase());
			ptt.setString(6, region_name.toLowerCase());
			
			
			ptt.executeQuery();
			
			con.close();
			
		}catch(SQLException e) {e.printStackTrace();}
		
	}
	
}
