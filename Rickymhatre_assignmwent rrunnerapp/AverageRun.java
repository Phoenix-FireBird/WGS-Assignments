import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AverageRun {
	
	public AverageRun() {
	}
	
      public void AverageRunsOnAnyDay(Connection con)  {
    	  
    	  try {
			Scanner s = new Scanner(System.in);
			  PreparedStatement pt = con.prepareStatement("SELECT AVG(distance)from DailyActivity where RDate=(?)");
			  System.out.println("Enter the date ");
			  String date=s.next();
			  pt.setString(1, date);
			  ResultSet rs = pt.executeQuery();
			  if (rs!= null) {
				  System.out.println("Average distance ran is");
				  while(rs.next()) {
					  System.out.println(rs.getString(1) + "");
					  System.out.println("\n");
				                   }
				                   
			  }con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
      }

    	  
    	
    	  
    	  
    	