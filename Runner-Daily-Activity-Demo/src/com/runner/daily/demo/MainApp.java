package com.runner.daily.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

public static void getChoice() throws DataInvalidException,InputMismatchException{
		
		int choice = 0;
		boolean flag = false;
		Runner r1 = new Runner();
		DailyActivity d1 = new DailyActivity();
		Scanner sc = new Scanner(System.in);
		
		while(flag!=true) {
			
			System.out.println("Enter your choice:\n\n1. Register a new runner\r\n"
					+ "\r\n"
					+ "2. List all the runners in the database.\r\n"
					+ "\r\n"
					+ "3. Upload daily activity for a runner\r\n"
					+ "\r\n"
					+ "4. Upload running activity in the database for duration (in days, using csv)\r\n"
					+ "\r\n"
					+ "5. find total runner per region, per city.\r\n"
					+ "\r\n"
					+ "6. Find average runs on any given day.\n\n0.Exit");
			choice = sc.nextInt();
			
			switch (choice) {
			
			case 1: {
				r1.registerNewRunner();
				break;
			}
			case 2: {
				r1.allRunnersList();
				break;
			}
			case 3: {
				d1.dailyActivityRunner();
				break;
			}
			case 4: {
				d1.uploadCsv();
				break;
			}
			case 5: {
				r1.totalRunnerPerCity();
				break;
			}
			case 6: {
				d1.averageRun();
				break;
			}
			case 0: {
				System.out.println("Thank You!!!!");
				flag = true;
				break;
			}
			default:
				System.out.println("Unexpected value: " + choice);
			}
		}
		
	}

	
	public static void main(String[] args) {

		try {
			getChoice();
		} catch (InputMismatchException | DataInvalidException e1) {
			System.out.println("Please Enter Number Only...");
		}
	}

}
