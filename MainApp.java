import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



public class MainApp {
   public static void main(String args[])
{
	
	try {
		
		
		FileInputStream fin=new FileInputStream("C:\\Users\\w127375\\eclipse-workspace\\RunnerApp\\config.txt");
    	Scanner s = new Scanner(System.in);
		String driver = s.nextLine();
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con;
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");

		   System.out.println("menu");
			System.out.println("1.Register a new Runner");
			System.out.println("2.List all the runners in the database.");
			System.out.println("3.Upload daily activity for a runner");
			System.out.println("4.Upload running activity in the database for duration");
			System.out.println("5.Enter total runner per region, per city.");
			System.out.println("6.Find average runs on any given day");
			
			int choice= s.nextInt();
			
			switch(choice){
				case 1:RegisterRunner rs = new RegisterRunner();
				rs.Reg_Runner(con);
				break;
				case 2:ListRunners lr = new ListRunners();
				lr.ListRun(con);
				break;
				case 3:UploadActivity ua = new UploadActivity();
				ua.Upl_Activity(con);
				break;
				case 4:UploadRun ur = new UploadRun();
				ur.UploadRun(con);
					break;
				case 5:RunnersPerRegion rpr = new RunnersPerRegion();
				rpr.TotalRunnersPerRegion(con);
				case 6: AverageRun ar = new AverageRun();
				ar.AverageRunsOnAnyDay(con);
;
				
				
				default:System.out.println("Invalid Input");
			}System.out.println("\n");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}

