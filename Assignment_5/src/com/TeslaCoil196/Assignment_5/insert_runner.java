package com.TeslaCoil196.Assignment_5;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;


public class insert_runner {

	public insert_runner() {
		// TODO Auto-generated constructor stub
	}
	public void add_runner(Connection con) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID number");
		int id = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter City");
		String city = sc.next();
		
		try {
			
			PreparedStatement pst = con.prepareStatement("insert into Runner values(?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, city);
			System.out.println(pst);
			pst.executeQuery();
			
			con.close();
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
}
