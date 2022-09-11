package abhishek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Avgrun {
	
public void avg_run(Connection con) {
		
		try {
			Scanner sc=new Scanner(System.in);
			
			PreparedStatement ps=con.prepareStatement("select AVG(distance) from DailyActivity where RunDate=(?)");
			
			System.out.println("Enter Date (DD-MON-YYYY): ");
			String date=sc.next();
			
			ps.setString(1, date);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs!=null) 
			{
				System.out.println("Average distance runs: ");
				while(rs.next()) {
					System.out.print(rs.getString(1)+"km\n\n");
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}


