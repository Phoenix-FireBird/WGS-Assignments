package abhishek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Daily {
	
public void dalact(Connection con) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Date (DD-MON-YYYY): ");
		String dt=sc.next();
		
		System.out.println("Enter Runner Id: ");
		int id=sc.nextInt();
		
		System.out.println("Enter Distance(KM): ");
		int dis=sc.nextInt();
		
		System.out.println("Enter City Id: ");
		int cid=sc.nextInt();
		
			try {
				PreparedStatement ps=con.prepareStatement("insert into DailyActivity values(?,?,?,?)");
				
				ps.setString(1, dt);
				ps.setInt(2, id);
				ps.setInt(3, dis);
				ps.setInt(4, cid);
				
				ps.executeQuery();
				
				System.out.println("Successfully Uploaded\n");
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
	}

}
