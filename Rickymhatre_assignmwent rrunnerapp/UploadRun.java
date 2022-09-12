import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public final class UploadRun {
	int cityid;
	int distance;
	int id;
	String date;

	public UploadRun(int i, int j, int k, String string) {
		// TODO Auto-generated constructor stub
	}

	public UploadRun() {
		// TODO Auto-generated constructor stub
	}

	public void UploadRun(int v1,int v2,int v3,String v4)
	{
		
		this.distance = v2;
		this.cityid =v1;
		this.date =v4;
		this.id =v3;
		
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
public void UploadRun(Connection con) {
		
		Set<UploadRun> l=new HashSet<>();
		
		try {
		     StringTokenizer st=null;
		     FileReader ir = new FileReader("C:\\Users\\w127375\\OneDrive - Worldline\\Documents\\Runnersdata.csv");
			 BufferedReader br = new BufferedReader(ir);
			 
			 try {
                 String inLine;
				while((inLine=br.readLine())!=null){
						st = new StringTokenizer(inLine, ",");
						l.add(new UploadRun(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.toString()));
					    }}    
			 catch (IOException e) 
			 {
				e.printStackTrace();
			}
			}catch (FileNotFoundException e)
			    { 
			      System.out.println("File Doesnt Exists");
			    }
				
		       System.out.println("the csv data has been uploaded\n");
		 
					try {
						PreparedStatement pt=con.prepareStatement("insert into DailyActivity values(?,?,?,?)");
						
						pt.setInt(1, cityid);
						pt.setInt(2, distance);
						pt.setInt(3, id);
					   pt.setString(4, date);
					 pt.executeQuery();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}		
		
		
	}
	
}