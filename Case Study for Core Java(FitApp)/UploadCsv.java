package abhishek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class UploadCsv {
	
	String date;
	int id;
	int distance;
	int cid;
	
	public UploadCsv() {
		
	}
	
	public UploadCsv(String v1, int v2, int v3, int v4) {
		this.date =v1;
		this.id =v2;
		this.distance = v3;
		this.cid =v4;
	
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id>0)
		{
		this.id = id;
		}
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		if(distance>0)
		{
		this.distance = distance;
		}
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		if(cid>0)
		{
		this.cid = cid;
		}
	}

	public void uploadcsv(Connection con) {
		
		Set<UploadCsv> l=new HashSet<>();
		
		try {
		     StringTokenizer st=null;
		     FileReader ir = new FileReader("C:/Users/w127278/Downloads/run.csv");
			 BufferedReader br = new BufferedReader(ir);
			 String inLine = null;
			 try {
                 while((inLine=br.readLine())!=null){
						st = new StringTokenizer(inLine, ",");
						l.add(new UploadCsv(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
					    }}    
			 catch (IOException e) 
			 {
				e.printStackTrace();
			}
			}catch (FileNotFoundException e)
			    { 
			      System.out.println("File not found.");
			    }
				
		       System.out.println("Uploaded CSV Data \n");
		 
					try {
						PreparedStatement ps=con.prepareStatement("insert into DailyActivity values(?,?,?,?)");
						
						ps.setString(1, date);
						ps.setInt(2, id);
						ps.setInt(3, distance);
						ps.setInt(4, cid);
						
						ps.executeQuery();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}		
}
}
