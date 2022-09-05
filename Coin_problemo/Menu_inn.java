package com.TeslaCoil196.Assignment_3;

import java.util.*;

public class Menu_inn {

	public Menu_inn() {
		// TODO Auto-generated constructor stub
	}
	public int menu_selection() {
		Scanner s = new Scanner(System.in);
		System.out.println("1. Enter values manually? ");
		System.out.println("2. Enter by using CSV value? ");
		System.out.println("3. Show all coins in collection");
		System.out.println("7. Exit");
		int choise_in = s.nextInt();
		
		return (choise_in);
		
	}
	public int menu_outseletion() {

		Scanner s = new Scanner(System.in);

		System.out.println("What brings you here today");
		System.out.println("1. Add coins to collection");
		System.out.println("2. Search for specific coin");
		System.out.println("3. Exit this");
		int choise = s.nextInt();
		return (choise);
	}
	
}
