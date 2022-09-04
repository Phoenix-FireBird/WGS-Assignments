package com.collection.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCoinCollection {
public static void OPtions() {
		
		Coin c1 = new Coin();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		while(flag!=true)
		{
			System.out.println("Enter your choice:\n"+
								"1.Add  coin\n"+
								"2.import file for coin\n"+
								"3.Search  \n"+
								"4.Display  \n"+
								"0.Exit");
			int ch;
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("Enter How many Coins You wants to Enter");
				Scanner s= new Scanner(System.in);
				int v=s.nextInt();
				int i=0;
				while(i<v)
				{
					c1.addCoin();	
					i++;
				}
				break;
			}
			case 2: {
					c1.importdata();
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
				flag=true;
				break;
			}
			default:
				System.out.println("Please Enter Valid Input");
			}
		}
	}
	public static void main(String[] args) {
		boolean found = false;
		
		while(found == false)
		
		{
			try {
				OPtions();
				found = true;
			} catch (InputMismatchException  e1) {
				System.out.println("Please provide Number Only...");
			}
			
		}
		
	}
}
