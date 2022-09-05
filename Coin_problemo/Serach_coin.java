package com.TeslaCoil196.Assignment_3;

import java.util.List;
import java.util.*;

public class Serach_coin {
	
	public Serach_coin() {
		// TODO Auto-generated constructor stub
	}
	
	public void search(List<Coin> inputlist) {
		
		System.out.println("1. Country");

		System.out.println("2. Year of Minting");

		//System.out.println("3. Value (sorted)");
		
		Scanner s = new Scanner(System.in);
		
		int choise = s.nextInt();
		
		switch(choise) {
		case 1:
			System.out.println("Country:");
			String ss = s.next();
			inputlist.forEach((Coin i)->{
				//System.out.println("---------->"+i.getCountry());
				String temp = i.getCountry().toString();
				if(temp.equals(ss)) {
					i.all();
					System.out.println("Country: "+i.getCountry());
					System.out.println("Denomication: "+i.getValue());
					System.out.println("Type of currenct :"+i.getType_curr());
					System.out.println("Year of minting:"+i.getYear_of_mining());
					System.out.println("Current value :"+i.getCurr_value());
					System.out.println("Aquried date :"+i.getAquired_date());
				}
			});
			break;
			
		case 2:
			System.out.println("Year of minting:");
			String year_mint = s.next();
			
			inputlist.forEach((Coin i)->{
				String temp1 = i.getYear_of_mining().toString();
				if(temp1.equals(year_mint)) {
					
					i.all();

					System.out.println("Country: "+i.getCountry());
					System.out.println("Denomication: "+i.getValue());
					System.out.println("Type of currenct :"+i.getType_curr());
					System.out.println("Year of minting:"+i.getYear_of_mining());
					System.out.println("Current value :"+i.getCurr_value());
					System.out.println("Aquried date :"+i.getAquired_date());
				}
			});
			break;
		case 3:
			System.out.println("Sorted value : /////Doesn't work");
			break;
			
		case 4: 
			System.out.println("Enter Country:");
			String contry=s.next();
			System.out.println("Enter Denomination:");
			int Value =s.nextInt();
			System.out.println("Enter Year of Minting:");
			String year_mint_1=s.next();
			
			inputlist.forEach((Coin c) -> {
				if(c.getCountry().equalsIgnoreCase(contry) && c.getYear_of_mining()==year_mint_1 && c.getValue()==Value) 
				{

					System.out.println("Country: "+c.getCountry());
					System.out.println("Denomication: "+c.getValue());
					System.out.println("Type of currenct :"+c.getType_curr());
					System.out.println("Year of minting:"+c.getYear_of_mining());
					System.out.println("Current value :"+c.getCurr_value());
					System.out.println("Aquried date :"+c.getAquired_date());
				}
			});
			break;
		case 5: 
			System.out.println("Enter Aquired date:");
			String date=s.next();
			System.out.println("Enter Country:");
			String country_2 =s.next();
			
			inputlist.forEach((Coin c) -> {
				if(c.getCountry().equalsIgnoreCase(country_2) && c.getAquired_date().equals(date)) 
				{

					System.out.println("Country: "+c.getCountry());
					System.out.println("Denomication: "+c.getValue());
					System.out.println("Type of currenct :"+c.getType_curr());
					System.out.println("Year of minting:"+c.getYear_of_mining());
					System.out.println("Current value :"+c.getCurr_value());
					System.out.println("Aquried date :"+c.getAquired_date());
				}
			});
			break;
		}
		
	}

}
