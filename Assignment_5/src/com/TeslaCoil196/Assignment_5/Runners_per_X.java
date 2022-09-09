package com.TeslaCoil196.Assignment_5;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Runners_per_X {
	
	public Runners_per_X() {
		// TODO Auto-generated constructor stub
	}
	
	public void total_runners_per(Connection con) {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			PreparedStatement ppc = con.prepareStatement("select count(distinct(runner_id)) from Daily_activity_2 where city_name=(?)");
														
			PreparedStatement ppr = con.prepareStatement("select count(distinct(runner_id)) from Daily_activity_2 where region_name=(?)");
			
			System.out.println("Search by city or region");
			System.out.println("1. Search by city ");
			System.out.println("2. Search by region");
			
			int choise = sc.nextInt();
			
			switch(choise) {
			
			case 1:
				System.out.println("Enter name of city");
				String city_name = sc.next();
				
				ppc.setString(1, city_name.toLowerCase());
				//ppc.executeQuery();
				
				ResultSet rs = ppc.executeQuery();
				if(rs!=null) {
					while(rs.next()) {
						System.out.print(rs.getString(1)+" ");
	                    System.out.println("\n");
	                
	                
					}
					break;
				}
			
			case 2:
			
				System.out.println("Enter name of city");
				String region_name = sc.next();
				
				ppr.setString(1, region_name);
				//ppc.executeQuery();
				
				ResultSet rs_r = ppr.executeQuery();
				if(rs_r!=null) {
					while(rs_r.next()) {
						System.out.print(rs_r.getString(1)+" ");
	                    System.out.println("\n");
	                
	                
					}
				}
				break;
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
