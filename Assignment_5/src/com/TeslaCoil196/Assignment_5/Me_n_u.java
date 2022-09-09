package com.TeslaCoil196.Assignment_5;

import java.util.Scanner;

public class Me_n_u {
	
	public Me_n_u() {
		// TODO Auto-generated constructor stub
	}
	
	public int menu() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Why are you here today");
		System.out.println("1. Register a new user");
		System.out.println("2. List all the runners from db");
		System.out.println("3. Upload daily activity of runner");
		System.out.println("4. Upload running activity of runner from csv");
		System.out.println("5. find total runners per region or per city");
		System.out.println("6. Average runs on a day ");
		int choise = s.nextInt();
		
		return choise;
	}

}
