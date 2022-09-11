import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public  class RunnersPerRegion {
	
	public RunnersPerRegion() {
		
	}
	
	public  void TotalRunnersPerRegion(Connection con ) {
		
		try {
			Scanner s = new Scanner(System.in);
			
			PreparedStatement pt=con.prepareStatement("select count(distinct(runnerid)) from DailyActivity where cityid=(select id from city where name=(?))");
			PreparedStatement pt1=con.prepareStatement("select count(distinct(runnerid)) from DailyActivity where cityid=(select id from city where region=(?))");
			System.out.println("1.Search by the city name");
			System.out.println("2.Search by the Region Name");
			int ch = s.nextInt();
			switch(ch)
			{
			case 1 : 
				System.out.println("1.Enter the  name of City");
			    String city_name=s.next();
			    pt1.setString(1, city_name.toLowerCase());
			    ResultSet rs = pt1.executeQuery();
			    if (rs!=null) {
			    	while(rs.next()) {
			    		System.out.println(rs.getString(1) + "");
			    		System.out.println("\n");
			    	}break;
			    }
			    
			    
			case 2:System.out.println("Enter the Name of Region ");
			String region_name=s.next();
			pt1.setString(2, region_name);
			ResultSet rs1 = pt1.executeQuery();
			if(rs1!=null) {
				while(rs1.next()) {
					System.out.println(rs1.getString(2)+"");
					System.out.println("\n");
				}
			}break;
			
			}con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
