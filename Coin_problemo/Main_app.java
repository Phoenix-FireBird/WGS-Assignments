package com.TeslaCoil196.Assignment_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_app {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<Coin> coins = new ArrayList<Coin>();

		Iterator <Coin> itr = coins.iterator();
		

		Menu_inn n = new Menu_inn();
		
		coins.add(new Coin("India", 10, "Rupee", "1971", "30 Rupees", "2001"));
		coins.add(new Coin("India", 20, "Rupee", "1971", "40 Rupees", "Today"));
		coins.add(new Coin("Bosnia", 50, "Euro", "1400", "1000 euro", "2001"));
		
		Scanner s = new Scanner(System.in);
		System.out.println("What brings you here today");
		System.out.println("1. Add coins to collection");
		System.out.println("2. Search for specific coin");
		System.out.println("3. Exit this");
		int choise = s.nextInt();
		
		do {
		
			switch (choise){
			case 1:
				System.out.println("1. Enter values manually? ");
				System.out.println("2. Enter by using CSV value? ");
				System.out.println("3. Show all coins in collection");
				System.out.println("7. Exit");
				int choise_in = s.nextInt();
				choise = n.menu_outseletion();
				
				do {
					
					switch(choise_in) {
					case 1:
						//Scanner s = new Scanner(System.in);
						System.out.println("Enter Country of origin :");
						String country_1 = s.next();
						System.out.println("Enter Intended value of Coin : ");
						int value_1 = s.nextInt();
						System.out.println("Enter Type of currency : ");
						String type_curr_1 = s.next();
						System.out.println("Enter Year of minting");
						String year_of_mining_1 = s.next();
						System.out.println("Current value : ");
						String Curr_value_1 = s.next();
						System.out.println("Aquried Date : ");
						String Aquired_date_1 = s.next();
						coins.add(new Coin(country_1, value_1, type_curr_1, year_of_mining_1, Curr_value_1, Aquired_date_1));
						
						choise_in = n.menu_selection();
						//break;
					case 2:
						try {
							List<String> inputList = new ArrayList<String>();
							File inputF = new File("C:\\java-trial\\Assignment_3_v1.0\\src\\com\\TeslaCoil196\\Assignment_3\\Coins.csv");
							InputStream inputfs = new FileInputStream(inputF);
							BufferedReader br = new BufferedReader(new InputStreamReader(inputfs));
							inputList = br.lines().skip(0).map(line -> line.split(" , ")).flatMap(Arrays::stream).collect(Collectors.toList());
							//System.out.println("Input list ----------->"+inputList);
							//System.out.println("Size of input lit ::: "+inputList.size());
							for(int i = 0; i<=inputList.size()-1; i++) {
								
								//System.out.println("Value of i-------------->"+i);
								String temp4 = inputList.get(i);
								//System.out.println("Temp4-------------->"+temp4);
								String[] temp5 = temp4.split(",");
								//System.out.println("Temp5-------------->"+temp5);
								for(String str : temp5) {
									System.out.println(str+"");	
								}						
								int z = 0;
								do{	
									coins.add(new Coin(temp5[z], Integer.parseInt(temp5[z+1]), temp5[z+2], temp5[z+3], temp5[z+4], temp5[z+5]));
									z = z +1 ;
								}while(z==0);
								
							}
													
						}
						catch (IOException e) 
						{
							System.out.println("ladfa in IO csv : "+e);
						}
						
						choise_in = n.menu_selection();
						//break;
					case 3:
						coins.forEach((Coin i)->{System.out.println(i.all());;});
						System.out.println("Size of coin collection: "+coins.size());
						choise_in = n.menu_selection();
						//break;
					
					case 4:
						System.out.println("CASE 4 of inner sxitch");
						break;
						
					}
				}while(choise_in !=7);// DO while end for choise_in
					
				
			case 2:
				Serach_coin sc = new Serach_coin();
				sc.search(coins);
				System.out.println("Hope fully this is 2nd case of outer mune");
				choise = n.menu_outseletion();
				
				break;
			}
		}while(choise!=3);// Do while end for choice
		

		
	}
}
