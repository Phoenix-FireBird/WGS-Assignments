package com.TeslaCoil196.Assignment_5;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;


public class Upload_run_csv {

	public Upload_run_csv() {
		// TODO Auto-generated constructor stub
	}
	
	public void from_csv(Connection con) {
		try {
			List<Runner_csv> Runner_csv_S = new ArrayList<Runner_csv>(); 
			
			List<String> inputList = new ArrayList<String>();
			File inputF = new File("Dummy_data.csv");
			InputStream inputfs;
			inputfs = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputfs));
			inputList = br.lines().skip(0).map(line -> line.split(" , ")).flatMap(Arrays::stream).collect(Collectors.toList());
			//System.out.println("Input list ----------->"+inputList);
			//System.out.println("Size of input lit ::: "+inputList.size());
			for(int i = 0; i<=inputList.size()-1; i++) {
				
				//System.out.println("Value of i-------------->"+i);
				String temp4 = inputList.get(i);
				//System.out.println("Temp4-------------->"+temp4);
				String[] temp5 = temp4.split(",");
				//System.out.println("Temp5-------------->"+temp5);
				for(String str : temp5) {
					System.out.println(str+"");	
				}						
				int z = 0;
				do{	
					Runner_csv_S.add(new Runner_csv(temp5[z], Integer.parseInt(temp5[z+1]), Integer.parseInt(temp5[z+2]), Integer.parseInt(temp5[z+3]),temp5[z+4].toLowerCase(),temp5[z+5].toLowerCase()));
					z = z +1 ;
				}while(z==0);
				
			Runner_csv_S.forEach((Runner_csv R)->{
				System.out.println(R.all());
				
				try {
					
					PreparedStatement ptt = con.prepareStatement("insert into Daily_activity_2 values(?,?,?,?,?,?)");
					
					String date = R.getDate();
					int id = R.getId();
					int distance = R.getDistance();
					int city_id = R.getCity_id();
					String city_name = R.getCity_name();
					String region_name = R.getRegion_name();
					
					ptt.setString(1, date);
					ptt.setInt(2, id);
					ptt.setInt(3, distance);
					ptt.setInt(4, city_id);
					ptt.setString(5, city_name.toLowerCase());
					ptt.setString(6, region_name.toLowerCase());
					
					ptt.executeQuery();
					
					
					
				}catch(SQLException sd) {sd.printStackTrace();}
				;});	
		}
	}catch(FileNotFoundException e) { e.printStackTrace();}	
}
}
