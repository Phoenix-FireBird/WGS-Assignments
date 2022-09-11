package abhishek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
	
	public void newrunner(Connection con) 
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Runner Id: ");
		int id=sc.nextInt();
		
		System.out.println("Enter Name: ");
		String name=sc.next();
		
		System.out.println("Enter City: ");
		String city=sc.next();
		
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into runner values(?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);
			
			ps.executeQuery();
			
			System.out.println("Register New Runner SuccessFully\n ");
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
