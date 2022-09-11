package com.assign3;

import java.util.Scanner;

public class Main {

	public static void getchoice() {
		
		int choice= 0;
		
		Runner r1=new Runner();
		Daily_activity d1=new Daily_activity();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		
		while(flag!=true)
		{
			System.out.println("Enter your choice:\n"+
								"1.Register a new runner\n"+
								"2.List all the runners in the database\n"+
								"3.Upload daily activity for a runner \n"+
								"4.Upload running activity in the database for duration\n"+
								"5.Find total number per region, per city\n"+
								"6.Find average runs on any given day\n"+
								"0.Exit");
			
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
					r1.Insert_runner();
				break;
			}
		case 2: {
			r1.Show_runnerlist();
			    break;
		}
			case 3: {
				d1.Insert_Dailyactivity();
				break;
			}
			case 4: {
				d1.bulkUpload();
				break;
			}
			case 5: {
				r1.Show_runnercount();
				break;
			}
			case 6: {
				d1.Average_distance();
				break;
			}
			case 0: {
				System.out.println("Application Closed");
				flag=true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
	
public static void main(String[]args) {		
		
			getchoice();
		} 
}