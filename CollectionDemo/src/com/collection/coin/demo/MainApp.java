package com.collection.coin.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

	public static void getChoice() throws DataInvalidException,InputMismatchException{
		
		Coin c1 = new Coin();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		while(flag!=true)
		{
			System.out.println("Enter your choice:\n"+
								"1.Add a single coin\n"+
								"2.Bulk upload for coin\n"+
								"3.Search a coin \n"+
								"4.Display list on basis of Criteria \n"+
								"0.Exit");
			int ch;
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				c1.addition();	
				break;
			}
			case 2: {
					c1.bulkUpload();
					break;
			}
			case 3: {
				c1.search();
				break;
			}
			case 4: {
				c1.display();
				break;
			}
			case 0: {
				System.out.println("Thank You......");
				flag=true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
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
