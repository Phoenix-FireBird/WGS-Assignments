import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterRunner {

	public String RegisterRunner() {
		// TODO Auto-generated method stub
		return null;
	}
    public void Reg_Runner(Connection con)
    {
    	try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter your id");
			int id = s.nextInt();
			System.out.println("Enter your Name");
			String Name=s.next();
			System.out.println("Enter your City ");
			String City=s.next();
			PreparedStatement pt = con.prepareStatement("INSERT into  RunnerApp(?,?,?)");
			pt.setInt(1,id);
			pt.setString(2, Name);
			pt.setString(3, City);
			pt.executeQuery();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
   
        
        
        		
    }
}
