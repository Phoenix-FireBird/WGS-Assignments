package com.FitApp.Data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Database {
	public static void insertRunner() {
		try {
			FileInputStream fin = new FileInputStream("ConnectionDB.txt");
			Scanner sc = new Scanner(fin);
			String Driver = sc.nextLine();
			Class.forName(Driver);
			Connection con = null;
			String c = sc.nextLine();
			String user = sc.nextLine();
			String pass = sc.nextLine();
			con = DriverManager.getConnection(c, user, pass);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from Runner";
			ResultSet rs = s.executeQuery(query);

			// Inserting a row in Runner
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the Runner Id: \n");
			int v1 = input.nextInt();
			rs.moveToInsertRow();
			rs.updateInt(1, v1);
			System.out.println("Enter the Runner Name: \n");
			String v2 = input.next();
			rs.updateString(2, v2);
			System.out.println("Enter the Runner City: \n");
			String v3 = input.next();
			rs.updateString(3, v3);
			rs.insertRow();
			con.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertCity() {
		try {
			FileInputStream fin = new FileInputStream("ConnectionDB.txt");
			Scanner sc = new Scanner(fin);
			String Driver = sc.nextLine();
			Class.forName(Driver);
			Connection con = null;
			String c = sc.nextLine();
			String user = sc.nextLine();
			String pass = sc.nextLine();
			con = DriverManager.getConnection(c, user, pass);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			System.out.println("Plaese Provide the City Details  same as you provided in the Runner\n");
			Scanner input = new Scanner(System.in);
			ResultSet rs = s.executeQuery("Select * from City");
			// Inserting a row in City
			System.out.println("Enter the City Id: \t");
			int v4 = input.nextInt();
			rs.moveToInsertRow();
			rs.updateInt(1, v4);
			System.out.println("Enter the City Name: \t");
			String v5 = input.next();
			rs.updateString(2, v5);
			System.out.println("Enter the  City Region: \t");
			String v6 = input.next();
			rs.updateString(3, v6);
			rs.insertRow();
			con.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertDailyActivity() {
		try {
			FileInputStream fin = new FileInputStream("ConnectionDB.txt");
			Scanner sc = new Scanner(fin);
			String Driver = sc.nextLine();
			Class.forName(Driver);
			Connection con = null;
			String c = sc.nextLine();
			String user = sc.nextLine();
			String pass = sc.nextLine();
			con = DriverManager.getConnection(c, user, pass);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			System.out.println("Plaese Provide the Rid and Cid as you enter while Registering  \n");
			Scanner input = new Scanner(System.in);
			ResultSet rs = s.executeQuery("Select * from DailyActivity");
			System.out.println("Plaese Enter the same RID and Cid ");
			// Inserting a row in City
			rs.moveToInsertRow();
			System.out.println("Enter the  R_id: \t");
			int v1 = input.nextInt();
			rs.updateInt(1, v1);
			System.out.println("Enter the  C_id: \t");
			int v2 = input.nextInt();
			rs.updateInt(2, v2);
			System.out.println("Enter the Distance: \t");
			int v4 = input.nextInt();
			rs.updateInt(3, v4);
			System.out.println("Enter the  D_id: \t");
			int v6 = input.nextInt();
			rs.updateInt(4, v6);
			System.out.println("Enter the Date: \t");
			String v5 = input.next();
			rs.updateString(5, v5);
			System.out.println("Enter Duration :\t");
			int v7 = input.nextInt();
			rs.updateInt(6, v7);
			rs.insertRow();
			con.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void DisplayRunner() {
		try {
			FileInputStream fin = new FileInputStream("ConnectionDB.txt");
			Scanner sc = new Scanner(fin);
			String Driver = sc.nextLine();
			Class.forName(Driver);
			Connection con = null;
			String c = sc.nextLine();
			String user = sc.nextLine();
			String pass = sc.nextLine();
			con = DriverManager.getConnection(c, user, pass);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "select * from runner where R_City  in\r\n" + "(select C_name from City )";
			ResultSet rs = s.executeQuery(query);

			// Displaying the database
			System.out.println("Displaying the Record......");
//		System.out.println("Runner Id" + "  "+"Runner Name" +"  "+"Runner City");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  \t" + rs.getString(2) + "  \t" + rs.getString(3));
			}

			con.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void TotalRunner() {

		try {
			FileInputStream fin = new FileInputStream("ConnectionDB.txt");
			Scanner sc = new Scanner(fin);
			String Driver = sc.nextLine();
			Class.forName(Driver);
			Connection con = null;
			String c = sc.nextLine();
			String user = sc.nextLine();
			String pass = sc.nextLine();
			con = DriverManager.getConnection(c, user, pass);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("1.Total Runner per City\n" + "2.Total Runner per Region\n"
					+ "3.Total Runner per City,per Region\n");
			Scanner scn = new Scanner(System.in);
			int val = scn.nextInt();
			String q = null;
			if (val == 1) {

				q = "select R_City,count(R_id)\r\n" + "from runner\r\n" + "group by R_City";
				ResultSet rs = s.executeQuery(q);
				while (rs.next()) {
					System.out.println(rs.getString(1) + "   " + rs.getString(2));
				}
			} else if (val == 2) {
				q = "select C_Region,count(C_region) as Total_Runner_Region\r\n" + "from city\r\n"
						+ "group by C_region";
				ResultSet rs = s.executeQuery(q);
				while (rs.next()) {
					System.out.println(rs.getString(1) + "   " + rs.getString(2));
				}
			} else if (val == 3) {
				q = "SELECT R_city,count(r_id) as Total_NO_Of_Runner,C_Region,count(C_Region) as Total_NO_Of_Runner\r\n"
						+ " from runner,city\r\n" + " where R_City=C_name\r\n" + " group by R_City,C_Region";

				ResultSet rs = s.executeQuery(q);
				while (rs.next()) {
					System.out.println(rs.getString(1) + "    " + rs.getString(2) + "   " + rs.getString(3) + "   "
							+ rs.getString(4));
				}
			}

			con.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ImportData() {

		FileReader fi;
		StringTokenizer st = null;
		try {
//		BOMInputStream bis = new BOMInputStream(fi.getInputStream()); 
			fi = new FileReader("C:\\JAVA_WGS_Trainiing\\FitApp\\Running_Duration.csv");
			BufferedReader in1 = new BufferedReader(fi);
			String str = null;
			FileInputStream fin = new FileInputStream("ConnectionDB.txt");
			Scanner sc = new Scanner(fin);
			String Driver = sc.nextLine();
			Class.forName(Driver);
			Connection con = null;
			String c = sc.nextLine();
			String user = sc.nextLine();
			String pass = sc.nextLine();
			con = DriverManager.getConnection(c, user, pass);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = s.executeQuery("Select * from Runner");
			rs.moveToInsertRow();
			while ((str = in1.readLine()) != null) {
				st = new StringTokenizer(str, ",");
//				System.out.println( st.nextToken());
				try {

					rs.updateInt(1, Integer.parseInt(st.nextToken()));
					rs.updateString(2, st.nextToken());
					rs.updateString(3, st.nextToken());
					rs.updateInt(4, Integer.parseInt(st.nextToken()));
					rs.insertRow();
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				}

			}
			con.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void AvgRun() {
		try {
			FileInputStream fin = new FileInputStream("ConnectionDB.txt");
			Scanner sc = new Scanner(fin);
			String Driver = sc.nextLine();
			Class.forName(Driver);
			Connection con = null;
			String c = sc.nextLine();
			String user = sc.nextLine();
			String pass = sc.nextLine();
			con = DriverManager.getConnection(c, user, pass);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "select R_id,R_name,R_City,avg(duration_In_days) as Average\r\n" + "from runner;";
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getString(4));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

} // class ends here
