import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListRunners {
	public  String ListRunners(){
		return null;
		
	}

	public void ListRun(Connection con) {
		
		try{PreparedStatement pt =  con.prepareStatement("SELECT id,name from RunnerApp");
		ResultSet rs = pt.executeQuery();
		if(rs!=null) {
			
				while(rs.next()) {
					System.out.print(rs.getString(1)+"    ");
				    System.out.print(rs.getString(2)+"      ");
				    System.out.print(rs.getString(3)+"     ");
				    System.out.println("\n");



				}                }}               catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}