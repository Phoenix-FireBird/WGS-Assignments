package com.TeslaCoil196.Assignment_5;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Avg_runs_on_xday {
	
	public Avg_runs_on_xday() {
		// TODO Auto-generated constructor stub
	}
	
	public void avg_runs(Connection con) {
		
		try {
			Scanner sc = new Scanner(System.in);
			
			PreparedStatement pww = con.prepareStatement("select AVG(Distance_km) from Daily_activity_2 where DDate = (?)");
			
			System.out.println("Enter date in fromat DD/MON/YYYY ex 09/JAN/2022");
			String date = sc.next();
			
			pww.setString(1, date);
			//ppc.executeQuery();
			
			ResultSet rs_r = pww.executeQuery();
			if(rs_r!=null) {
				System.out.println("Average distance ran : ");
				while(rs_r.next()) {
					System.out.print(rs_r.getString(1)+"  km");
                    //System.out.print(rs_r.getString(2)+" ");
                    //System.out.print(rs_r.getString(3)+" ");
                    System.out.println("\n");
                
                
				}
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
