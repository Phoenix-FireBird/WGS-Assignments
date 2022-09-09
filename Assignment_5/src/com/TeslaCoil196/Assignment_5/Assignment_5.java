package com.TeslaCoil196.Assignment_5;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;


public class Assignment_5 {
	
	public static void main(String[] args) {
		
		try {
			

			FileInputStream fin = new FileInputStream("C:\\java-trial\\Java_Day-9_JDBC-ODBC\\src\\com\\TeslaCoil196\\config.txt");
			Scanner s = new Scanner(fin);
			String driver = s.next();
			Class.forName(driver);
			System.out.println("<-----Connecting to db XE----->");
			String url = s.next();
			String usr = s.next();
			String pass = s.next();
			Connection con=DriverManager.getConnection(url,usr,pass);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Why are you here today");
			System.out.println("1. Register a new user");
			System.out.println("2. List all the runners from db");
			System.out.println("3. Upload daily activity of runner");
			System.out.println("4. Upload running activity of runner from csv");
			System.out.println("5. find total runners per region or per city");
			System.out.println("6. Average runs on a day ");
			int choise = sc.nextInt();
			
			Me_n_u m = new Me_n_u();
			
			switch(choise) {
			case 1:
				insert_runner i = new insert_runner();
				i.add_runner(con);
				choise = m.menu();
			case 2:
				List_runners L = new List_runners();
				L.list_runners(con);
				choise = m.menu();
			case 3:
				Upload_activity u = new Upload_activity();
				u.upload_acti(con);
				choise = m.menu();
			case 4:
				//System.out.println("NOT IMPLIMENTED");
				Upload_run_csv uc = new Upload_run_csv();
				uc.from_csv(con);
				con.close();
				choise = m.menu();
			case 5:
				Runners_per_X x = new Runners_per_X();
				x.total_runners_per(con);
				choise = m.menu();
			case 6:
				Avg_runs_on_xday a = new Avg_runs_on_xday();
				a.avg_runs(con);
				choise = m.menu();
			case 7:
				con.close();
				break;
			}
		}catch(SQLException | FileNotFoundException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
