package abhishek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Totalrun {

public void totrun(Connection con) {
		
		try {
			
			Scanner sc=new Scanner(System.in);
			
			PreparedStatement psc=con.prepareStatement("select count(distinct(runnerid)) from DailyActivity where cityid=(select id from city where name=(?))");
														
			PreparedStatement psr=con.prepareStatement("select count(distinct(runnerid)) from DailyActivity where cityid=(select id from city where region=(?))");
			
			System.out.println("Search by city or region");
			System.out.println("1. Search by city ");
			System.out.println("2. Search by region");
			
			int ch=sc.nextInt();
			
			switch(ch) {
			
			case 1:
				
				System.out.println("Enter City: ");
				String city=sc.next();
				
				psc.setString(1,city.toLowerCase());
				psc.executeUpdate();
				
				ResultSet rsc=psc.executeQuery();
				
				if(rsc!=null) 
				{
					while(rsc.next()) 
					{
						System.out.println("Total runner per city= "+rsc.getString(1)+"\n");
					}
					break;
				}
			
			case 2:
			
				System.out.println("Enter Region: ");
				String region=sc.next();
				
				psr.setString(1,region.toLowerCase());
				psr.executeUpdate();
				
				ResultSet rsr = psr.executeQuery();
				if(rsr!=null) 
				{
					while(rsr.next()) 
					{
						System.out.println("Total runner per region= "+rsr.getString(1)+"\n");
					}
				}
				break;
			default:
				System.out.println("Invalid Input: " + ch);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
