package abhishek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Display {
	
	public void listallrunner(Connection con) 
	{
		String query;
		
	try {
		
		query="select id,name,city from runner";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		
		if(rs!=null)
		{
			System.out.println("List all the runners in the database: ");
			
		while(rs.next())
		{
			System.out.println("ID: " + rs.getInt(1));
			System.out.println("Name: " + rs.getString(2));
			System.out.println("City: " + rs.getString(3)+"\n");
		}
		}
	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

}
}