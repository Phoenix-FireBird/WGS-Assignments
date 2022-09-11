package com.assign3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Runner {

	int Runner_id;
	String Runner_name;
	City City_id;
	
	public Runner(){
		
		
	}
    public Runner(int a,String b,City c){
		 Runner_id=a;
		 Runner_name=b;
		 City_id=c;
	
		}
	public int getRunner_id() {
		return Runner_id;
	}
	public void setRunner_id(int runner_id) {
		Runner_id = runner_id;
	}
	public String getRunner_name() {
		return Runner_name;
	}
	public void setRunner_name(String runner_name) {
		Runner_name = runner_name;
	}
	public City getCity_id() {
		return City_id;
	}
	public void setCity_id(City city_id) {
		City_id = city_id;
	}
	 Connection conn=null;
	public void Insert_runner() {
		try {


			    Connection conn=null;
	           Scanner sc = new Scanner(System.in);
	            System.out.println("Please Enter Runner_id:");
	            int runner_id = sc.nextInt();
	            System.out.println("Please Enter Runner_Name:");
	            String runner_name = sc.next();
	            System.out.println("Please Enter City_id:");
	            int City_id = sc.nextInt();
	            
	            Class.forName("oracle.jdbc.OracleDriver");
	             conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kiran123");
	            
	            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	            
	            ResultSet rs = stmt.executeQuery( "SELECT runner_id,runner_name,City_id FROM runner");
	            rs.moveToInsertRow();
	            rs.updateInt(1,runner_id);
	            rs.updateString(2, runner_name);
	            rs.updateInt(3,City_id);
	            rs.insertRow();
	            
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
		public void Show_runnerlist() {
			try {
		          
		            Class.forName("oracle.jdbc.OracleDriver");
		            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kiran123");
		            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		            
		            ResultSet rset = stmt.executeQuery("SELECT * from Runner");
		            System.out.println("Runner_id  Runner_name  City_id ");
		            while(rset.next())
		    		{
		    			System.out.println(rset.getInt(1)+"            "+rset.getString(2)+"      "+rset.getInt(3)+"    ");
		    		}
		            conn.close();
		        } catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		}
			public void Show_runnercount() {
				try {
					
                     int count = 0;
		              
		               Scanner sc = new Scanner(System.in);
			            System.out.println("Please Enter City_id:");
			            int City_id = sc.nextInt();
			            
			            Class.forName("oracle.jdbc.OracleDriver");
			            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kiran123");
			          
			            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM runner Where City_id=(?)");
			            pstmt.setInt(1, City_id);
			           ResultSet rset = pstmt.executeQuery();
			            
			           while(rset.next()) {
			               if(rset.getInt(3)== City_id)
			                {
			                    count++;
			                }
			            }
			           System.out.println("Count is: " + count);
			            conn.close();
			        } catch (ClassNotFoundException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        } catch (SQLException e) {
			            // TODO Auto-generated catch block
			            e.printStackTrace();
			        }
}
}