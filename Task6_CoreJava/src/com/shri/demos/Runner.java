package com.shri.demos;

import java.io.BufferedReader;
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


public class Runner {
	int RId;
	String RName;
	City CId;
	
	public Runner() {
		// TODO Auto-generated constructor stub
	}
	public Runner(int v1, String v2, City v3) {
		RId=v1;
		RName=v2;
		CId=v3;
	}
	public int getRId() {
		return RId;
	}
	public void setRId(int rId) {
		RId = rId;
	}
	public String getRName() {
		return RName;
	}
	public void setRName(String rName) {
		RName = rName;
	}
	public City getCId() {
		return CId;
	}
	public void setCId(City cId) {
		CId = cId;
	}
	
	
	//1. Register a new runner
	
	public void Register() {		
		try {

			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Runner Id:");
			int a=sc.nextInt();
			System.out.println("Enter Runner Name:");
			String b=sc.next();
			System.out.println("Enter City id:");
			int c=sc.nextInt();
	            
	            Class.forName("oracle.jdbc.OracleDriver");
	            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
	            String query = "Select RId, RName, CId From Runner";
	            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	            
	            ResultSet rs = stmt.executeQuery(query);
	            rs.moveToInsertRow();
	            rs.updateInt(1,a);
				rs.updateString(2,b);
				rs.updateInt(3,c);
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
	
	
	//2. List all the runners in the database.
	
	public void List() {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
			String query = "Select * From Runner";
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			System.out.println("Id  Name  CId");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
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
	
	
	//3. Upload daily activity for a runner
	
	public void Activity() {
		
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Activity Date:");
			String w=sc.next();
			System.out.println("Enter Runner Id:");
			int x=sc.nextInt();
			System.out.println("Enter distance:");
			long y=sc.nextLong();
			System.out.println("Enter City Id: ");
			int z=sc.nextInt();
				
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
			String query = "Select ActivityDate, RId, distance, CId From Daily_Activity";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery(query);
			rs.moveToInsertRow();
			rs.updateString(1,w);
			rs.updateInt(2,x);
			rs.updateLong(3, y);
			rs.updateInt(4,z);
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
	
	
	
	//4.. Upload running activity in the database for duration (in days, using csv)
	
	public void bulk() {
	try {
        
        Connection conn=null;
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
        
            String query = "INSERT INTO Daily_Activity (ActivityDate, RId, distance, CId) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
 
            BufferedReader l1 = new BufferedReader(new FileReader("C:\\Users\\w127392\\OneDrive - Worldline\\Desktop\\Eclipse\\Task6_CoreJava\\src\\com\\shri\\demos\\Runner.xlsx"));
            String lineText = null;
 
            l1.readLine(); 
            final int size = 20;
            int count = 0;
            while ((lineText = l1.readLine()) != null) {
                Statement st = (Statement) new StringTokenizer(lineText, ",");
                
                String ActivityDate = ((StringTokenizer) st).nextToken();
                int RId = Integer.parseInt(((StringTokenizer) st).nextToken());
                long distance = Long.parseLong(((StringTokenizer) st).nextToken());
                int CId = Integer.parseInt(((StringTokenizer) st).nextToken());
 
                statement.setString(1, ActivityDate);
                statement.setInt(2, RId);
                statement.setLong(3, distance);
                statement.setInt(4, CId);
                statement.addBatch();
 
                if (count % size == 0) {
                    statement.executeBatch();
                } 
            }
 
            l1.close();
            statement.executeBatch();
            conn.close();
 
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
	}
   
    
	//5. find total runner per region, per city.
    
	public void display() {
		
		try {
			int c=0;
			Scanner sc=new Scanner(System.in);
			int ch;
		System.out.println("Select one option: \n"
				+ "1. Per region\n"
				+ "2. Per City");
//			System.out.println("Please Enter City Id");
			ch = sc.nextInt();
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
			
			PreparedStatement pt=conn.prepareStatement("Select * From Runner Where CId=(?)");
			pt.setInt(1, ch);
			ResultSet rs=pt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(3)==ch) {
					c++;
				}
			}
			System.out.println("Total Number of Count is: "+c);
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//6. Find average runs on any given day.
	
	public void Average() {
		
		try {
			int count = 0;
			long n=0; 
			float average=0, sum = 0;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter a Date in dd/mm/yyyy format for average: ");
			String xy=sc.next();
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
						
			PreparedStatement pt=conn.prepareStatement("Select * From Daily_Activity Where ActivityDate=(?)");
			pt.setString(1, xy);
			ResultSet rs=pt.executeQuery();
			
			while(rs.next()) {
				n=rs.getLong(3);
				sum +=n;
				count++;
			}
			average=sum/count;
			System.out.println("Average is : "+average);
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



