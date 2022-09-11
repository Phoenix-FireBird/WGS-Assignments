package com.assign3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Daily_activity {
	String Activity_date;
	Runner Runner_id;
    long Distance;
    City City_id;

public Daily_activity(){
	
	
}
public Daily_activity(String a,Runner b, long c,City d){
	Activity_date=a;
	Runner_id=b;
	Distance=c;
	City_id=d;
	}
public String getActivity_date() {
	return Activity_date;
}
public void setActivity_date(String activity_date) {
	Activity_date = activity_date;
}
public Runner getRunner_id() {
	return Runner_id;
}
public void setRunner_id(Runner runner_id) {
	Runner_id = runner_id;
}
public long getDistance() {
	return Distance;
}
public void setDistance(long distance) {
	Distance = distance;
}
public City getCity_id() {
	return City_id;
}
public void setCity_id(City city_id) {
	City_id = city_id;
}
public void Insert_Dailyactivity() {
	try {


           Connection conn=null;
           Scanner sc = new Scanner(System.in);
            System.out.println("Please Enter Activity_date:");
            String Activity_date = sc.next();
            System.out.println("Please Enter runner_id:");
            int runner_id = sc.nextInt();
            System.out.println("Please Enter Distance:");
            long Distance = sc.nextLong();
            System.out.println("Please Enter City_id:");
            int City_id = sc.nextInt();
            
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kiran123");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rset = stmt.executeQuery("SELECT Activity_date,runner_id,Distance,City_id FROM Daily_activity");
            rset.moveToInsertRow();
            rset.updateString(1,Activity_date);
            rset.updateInt(2,runner_id);
            rset.updateLong(3,Distance);
            rset.updateInt(4,City_id);
            rset.insertRow();
            
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
	public void Average_distance() {
		try {
			
            int count = 0;
			long n = 0;
            float average,sum = 0;
             Connection conn=null;
              Scanner sc = new Scanner(System.in);
	            System.out.println("Please Enter Activity_date:");
	            String Activity_date = sc.next();
	            
	            Class.forName("oracle.jdbc.OracleDriver");
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kiran123");
	          
	            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Daily_activity Where Activity_date=(?)");
	            pstmt.setString(1, Activity_date);
	           ResultSet rset = pstmt.executeQuery();
	            
	           while(rset.next()) {
	              
	            	   n=rset.getLong(3);
	            	   sum +=n;
	                    count++;
	                
	            }
	           average=sum/count;
	           System.out.println("Average distance is: " + average);
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	public void bulkUpload() {
	try {
        
		Connection conn=null;
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","kiran123");
        
           
 
            String sql = "INSERT INTO daily_activity (activity_date, runner_id, distance, city_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
 
            BufferedReader lineReader = new BufferedReader(new FileReader("C:/Users/w127422/Documents/Book1.csv"));
            String lineText = null;
            
            lineReader.readLine(); 
            final int batchSize = 20;
            int count = 0;
            while ((lineText = lineReader.readLine()) != null) {
            	StringTokenizer st = new StringTokenizer(lineText, ",");
              
                String activity_Date = st.nextToken();
                int runner_Id = Integer.parseInt(st.nextToken());
                long distance = Long.parseLong(st.nextToken());
                int city_Id = Integer.parseInt(st.nextToken());
 
                statement.setString(1, activity_Date);
             
                statement.setInt(2, runner_Id);
 
                statement.setLong(3, distance);
 
                statement.setInt(4, city_Id);
 
                statement.addBatch();
 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
                
            }
 
            lineReader.close();
 
           
            statement.executeBatch();
 

            conn.close();
 
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}