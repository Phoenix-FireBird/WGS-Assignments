package com.TeslaCoil196.Assignment_5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


public class List_runners {
	
	public List_runners() {
		// TODO Auto-generated constructor stub
	}

	public void list_runners(Connection con) {
		
		try {
			
			PreparedStatement pss = con.prepareStatement("select id,name from Runner");
			
			ResultSet rs = pss.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					System.out.print(rs.getString(1)+" ");
                    System.out.print(rs.getString(2)+" ");
                    System.out.println("-------------------------------");
                
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();	
		}
		
	}
	
}
