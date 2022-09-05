package com.problem.statement3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AppMain {
	

	public static void main(String[] args) throws FileNotFoundException {
		
		List<CollectionCoin> CollectionCoin = new ArrayList<CollectionCoin>();


		CollectionCoin.add(new CollectionCoin("India", 1, "Rupee", "1919", "1000 Rupees", "2001"));
		CollectionCoin.add(new CollectionCoin("USA", 100 , "Dollar", "1400", "$1,645.98", "Today"));
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter Country Of Origin:");
		String country_of_origin01 = sc.nextLine();
		System.out.println(" Enter Value Of Coin: ");
		int value_of_coin01 = sc.nextInt();
		System.out.println(" Enter Denomination: ");
		String denomination01 = sc.next();
		System.out.println(" Enter Year Of Coin");
		String year_of_coin01 = sc.next();
		System.out.println(" Enter Current Coin Value: ");
		String current_coin_value01 = sc.next();
		System.out.println(" Enter Aquire Date: ");
		String aquire_date01 = sc.next();
		CollectionCoin.add(new CollectionCoin(country_of_origin01,value_of_coin01, denomination01,  year_of_coin01, current_coin_value01, aquire_date01));
		
		
	
}
}