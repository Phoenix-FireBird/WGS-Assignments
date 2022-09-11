package abhishek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Connection con;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			
			Scanner sc = new Scanner(System.in);
			
			Register rg=new Register();
			Display ds=new Display();
			Daily dl=new Daily();
			UploadCsv uc=new UploadCsv();
			Totalrun tr=new Totalrun();
			Avgrun ar=new Avgrun();
			
			while(true) 
			 { 
			 System.out.println("Choose your Option:");
			 System.out.println("1. Register a new runner");
			 System.out.println("2. List all the runners in the database");
			 System.out.println("3. Upload daily activity for a runner");
			 System.out.println("4. Upload running activity in the database for duration (in days, using csv)");
			 System.out.println("5. Find total runner per region, per city");
			 System.out.println("6. Find average runs on any given day");
			 
			 int ch=sc.nextInt();
			 
				switch(ch)
				{
				case 1:
					   rg.newrunner(con);
					   break;
				case 2:
					   ds.listallrunner(con);
					   break;
				case 3:
					   dl.dalact(con);
					   break;
				case 4:
					  uc.uploadcsv(con);
					   break;
				case 5:
					  tr.totrun(con);
					   break;
				case 6:
					   ar.avg_run(con);
					   break;
				default:
					System.out.println("Invalid Input: " + ch);
			     }

             }
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
}	
}
