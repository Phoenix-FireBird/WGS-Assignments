package com.runner.daily.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DailyActivity {

	String activityDate;
	Runner runnerId;
	long distance;
	City cityId;
	
	public DailyActivity() {
		// TODO Auto-generated constructor stub
	}
	
	public DailyActivity(String v1,Runner v2,long v3,City v4) {
		activityDate =v1;
		runnerId = v2;
		distance = v3;
		cityId = v4;
	}

	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}

	public Runner getRunnerId() {
		return runnerId;
	}

	public void setRunnerId(Runner runnerId) {
		this.runnerId = runnerId;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}
	
	public void dailyActivityRunner() {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter Date(dd/mm/yyyy):");
			String date = sc.next();
			System.out.println("Please Enter Runner_Id:");
			int runnerId = sc.nextInt();
			System.out.println("Please Enter Distance(in KM):");
			long distance = sc.nextLong();
			System.out.println("Please Enter City id:");
			int cityId = sc.nextInt();
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Sam#1234");
			String query = "SELECT activity_date,runner_id,distance,city_id FROM daily_activity";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery(query);
			rs.moveToInsertRow();
			rs.updateString(1, date);
			rs.updateInt(2,runnerId);
			rs.updateLong(3, distance);
			rs.updateInt(4,cityId);
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
	
	
	public void uploadCsv() {
			
		Connection conn = null;
			try {
				
				StringTokenizer st=null;
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Sam#1234");
				
//		            conn.setAutoCommit(false);
		 
		            String sql = "INSERT INTO daily_activity (activity_date, runner_id, distance, city_id) VALUES (?, ?, ?, ?)";
		            PreparedStatement statement = conn.prepareStatement(sql);
		 
		            BufferedReader lineReader = new BufferedReader(new FileReader("C:/Java_Aug/Runner-Daily-Activity-Demo/src/com/runner/daily/demo/Runner.csv"));
		            String lineText = null;
		 
		            lineReader.readLine(); // skip header line
		            final int batchSize = 20;
		            int count = 0;
		            while ((lineText = lineReader.readLine()) != null) {
		            	st = new StringTokenizer(lineText, ",");
		                //String[] data = lineText.split(",");
		                String activityDate = st.nextToken();
		                int runnerId = Integer.parseInt(st.nextToken());
		                long distance = Long.parseLong(st.nextToken());
		                int cityId = Integer.parseInt(st.nextToken());
		 
		                statement.setString(1, activityDate);
		             
		                statement.setInt(2, runnerId);
		 
		                statement.setLong(3, distance);
		 
		                statement.setInt(4, cityId);
		 
		                statement.addBatch();
		 
		                if (count % batchSize == 0) {
		                	statement.executeBatch();
		                }
		                
		            }
		 
		            lineReader.close();
		 
		            // execute the remaining queries
		            statement.executeBatch();
		 
//		            conn.commit();
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
	
	public void averageRun() {
		
		try {
			
					double avgRun = 0;
					long cal = 0;
					int count = 0;
					Scanner sc = new Scanner(System.in);
					System.out.println("Please Enter Date:");
					String activityDate = sc.next();
					
					Class.forName("oracle.jdbc.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Sam#1234");
					PreparedStatement pstmt = conn.prepareStatement("Select * from daily_activity where activity_date=(?)");
					pstmt.setString(1, String.valueOf(activityDate));
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						
							System.out.println("The Dates are:"+rs.getString(3));
							cal += rs.getLong(3); 
							count++;
					}
					System.out.println("calculation="+cal);
					System.out.println("count="+count);
					avgRun = cal / count;
					System.out.println("Average Run of Date: "+activityDate+" is: " + avgRun);
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
