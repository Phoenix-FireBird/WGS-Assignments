package com.FitApp.Data;

import java.util.Scanner;

public class mainApp extends Database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\t\tWelcome to FitApp\t\t\t\t\t\t");

		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		while (flag != true) {
			try {
				System.out.println("1.Register a new runner.\n" + "2.List all the runners in the database.\n"
						+ "3.Upload daily activity for a runner\n"
						+ "4.Upload running activity in the database for duration (in days, using csv)\n"
						+ "5.find total runner per region, per city\n" + "6.Find average runs on any given day.\n"
								+ "0.Exit()");
				int v = sc.nextInt();
				switch (v) {
				case 1: {
					// Register the Runner
					 insertRunner();
					 insertCity();
					break;
				}
				case 2: {
					// displaying the database of Runner
					 DisplayRunner();
					break;

				}
				case 3: {
					// upload Daily Activity for a Runner
					 insertDailyActivity();
					break;

				}
				case 4: {
					// import Running Acticity
					// import data
						ImportData();
					break;

				}
				case 5: {

					// Total Runner per city per region
					TotalRunner();
					break;
				}
				case 6: {
					// Find average runs on any given day
					 AvgRun();
					break;
				}
				case 0: {
					flag = true;
					break;
				}
				default: {
					System.out.println("Please Enter Correct No");
				}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
