import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UploadActivity {
	
	public String UploadActivity(){
		return null;
		
	}

	public void Upl_Activity(Connection con) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Runnerid");
		int id = s.nextInt();
		System.out.println("Enter the date");
		String date=s.next();
		System.out.println("Enter Distance Coveerd");
		String distance=s.next();
		System.out.println("Enter your Cityid ");
		int Cityid=s.nextInt();
		System.out.println("Enter the city name");
		String City_name= s.next();
		System.out.println("Enter the region name");
		String Region_name=s.next();
		
		try {
			PreparedStatement pt = con.prepareStatement("INSERT into  DailyActivity(?,?,?,?,?,?)");
			pt.setInt(1,id);
			pt.setString(2, date);
			pt.setString(3, distance);
			pt.setInt(4, Cityid);
			pt.setString(5, City_name);
			pt.setString(6, Region_name);
			
			pt.executeQuery();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
