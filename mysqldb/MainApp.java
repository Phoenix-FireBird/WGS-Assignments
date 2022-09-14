package com.connection.mysqldb;

import java.util.Scanner;

public class MainApp {

	public static void getchoice() {
		int choice = 0;
		boolean flag = false;
		RunnerInfo r1 = new RunnerInfo();
		Scanner sc = new Scanner(System.in);
		while (flag != true) {
			System.out.println("Enter your choice\n" + "1.newRegister\n" + "2.Exit\n"
		+"3.Daily activity for a runner\n"+"4.Exit\n");
			int userinput = sc.nextInt();
			switch (userinput) {
			case 1: {
				r1.newRegister();
				break;
			}
			
			case 2:{
				r1.listRunner();
				break;
			}
			
			case 3:{
				r1.getRunnerCity();
				break;
			}

			case 4: {
				System.out.println("Thank you");
				flag = true;
				break;
			}
			}

		}
	}

	public static void main(String[] args) {
		getchoice();
	}

}
