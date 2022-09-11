package com.shri.demos;

import java.util.Scanner;


public class MainApp {

	public static void getchoice() {
		int choice=0;
		boolean flag=false;
		Runner r1= new Runner();
		Scanner sc = new Scanner(System.in);
		while(flag!=true) {
			System.out.println("1. Register a new runner\r\n"
					+ "2. List all the runners in the database.\r\n"
					+ "3. Upload daily activity for a runner\r\n"
					+ "4. Upload running activity in the database for duration (in days, using csv)\r\n"
					+ "5. find total runner per region, per city.\r\n"
					+ "6. Find average runs on any given day.\r\n"
					+ "Exit");
			choice=sc.nextInt();
			switch (choice) {
			case 1: {
				
				r1.Register();
				break;
			}
			case 2:{
				r1.List();
				break;
			}
			case 3:{
				r1.Activity();
				break;
			}
			case 4:{
				r1.bulk();
				break;
			}
			case 5:{
				r1.display();
				break;
			}
			case 6:{
				r1.Average();
				break;
			}
			case 0:{
				flag=true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
	
	public static void main(String[] args) {
		getchoice();
	}

}
