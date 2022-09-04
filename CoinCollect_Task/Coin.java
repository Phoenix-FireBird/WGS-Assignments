package com.task.com;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Coin {
	
	String country;
	String demonition;
	int yearofmint;
	int currentValue;
	String acquireDate;
	
	public Coin() {
		// TODO Auto-generated constructor stub
	}
	
	public Coin(String v1, String v2, int v3, int v4, String v5) {
		country=v1;
		demonition=v2;
		yearofmint=v3;
		currentValue=v4;
		acquireDate=v5;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDemonition() {
		return demonition;
	}

	public void setDemonition(String demonition) {
		this.demonition = demonition;
	}

	public int getYearofmint() {
		return yearofmint;
	}

	public void setYearofmint(int yearofmint) {
		this.yearofmint = yearofmint;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public String getAcquireDate() {
		return acquireDate;
	}

	public void setAcquireDate(String acquireDate) {
		this.acquireDate = acquireDate;
	}
	
	//Search Method
	
	public void search() {
		
		Set<Coin> coins = new HashSet();
		//SimpleDateFormat s1 = new SimpleDateFormat("dd/mm/yyyy");
		Scanner sc = new Scanner(System.in);
		
		//for adding
		
		System.out.println("Enter how many coin you want to add");
		int coinAdd = sc.nextInt();
		if(coinAdd==1) {
			coins.add(new Coin(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next()));
		}else {
			System.out.println("You want to bulk upload Y/N");
			String flag = sc.next();
			 for(int i=0; i<coinAdd; i++) {
			if(flag.equals("y") || flag.equals("Y")) {
				coins.add(new Coin(sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next())); 
			}
		}
			
	}
	
		//for getting values
		
		System.out.println("Want to see your stored coin (Y/N)");
		String flag1 = sc.next();
		if(flag1.equals("y") || flag1.equals("Y")) {
			coins.forEach(c ->{
				
				System.out.println(c.getCountry());
				System.out.println(c.getDemonition());
				System.out.println(c.getYearofmint());
				System.out.println(c.getCurrentValue());
				System.out.println(c.getAcquireDate());
			});
		}else {
			// no code here...
		}

		// Searching 
		Scanner sc3= new Scanner(System.in);
		
		System.out.println("You want to search coin with one parameter or multiple parameter...\n");
		System.out.println("Press 1 : If you want to search coin using only one parameter\nPress 2:If you want to search coin using multiple parameter ");
		int press = sc3.nextInt();
		
		if (press==1) {
			//For 1st Searching
			
			Scanner sc2= new Scanner(System.in);
			System.out.println("You Can Search Your coin using\n 1.By Country Name\n 2.Using Year of Minting\n 3.Using Current Value");
			int choice1 = sc2.nextInt();
			switch (choice1) {
			
			case 1: {
				System.out.println("Enter Country Name:");
	            String country1=sc.next();
	            coins.forEach(d -> {
	            if(d.getCountry().equalsIgnoreCase(country1))
	             {
	   
	                 System.out.println(d.getCountry());
	                 System.out.println(d.getDemonition());
	                 System.out.println(d.getYearofmint());
	                 System.out.println(d.getCurrentValue());
	                 System.out.println(d.getAcquireDate());
	             }
	         });
	         break;
			}
			
			case 2: {
				System.out.println("Enter Year of Minting:");
	            int minting1=sc.nextInt();
	            coins.forEach(d -> {
	                if(d.getCountry().equalsIgnoreCase(country) &&
	                        d.getYearofmint()==minting1)
	                {
	      
	                    System.out.println(d.getCountry());
	                    System.out.println(d.getDemonition());
	                    System.out.println(d.getYearofmint());
	                    System.out.println(d.getCurrentValue());
	                    System.out.println(d.getAcquireDate());
	                }
	            });
	         break;
			}
			
			case 3: {
				System.out.println("Enter Current Value:");
	            int currentvalue1=sc.nextInt();
	            coins.forEach(d -> {
	                if(d.getCurrentValue()==currentvalue1)
	                {
	                    System.out.println(d.getCountry());
	                    System.out.println(d.getDemonition());
	                    System.out.println(d.getYearofmint());
	                    System.out.println(d.getCurrentValue());
	                    System.out.println(d.getAcquireDate());
	                }
	            });
	         break;
			}
			
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice1);
			}
			
		}
		
		
		//For 2nd searching
		
		else if(press==2){
			System.out.println("Enter a format that you want to search: \n 1.Country + Denomination\n "
					+ "2.Country + Year of Minting\n 3.Country + Denomination + Year of Minting\n 4.Acquired Date + Country");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				
				System.out.println("Enter Country Name:");
	            String country=sc.next();
	            System.out.println("Enter Denomination:");
	            String denomination=sc.next();
	            coins.forEach(c -> {
	                if(c.getCountry().equalsIgnoreCase(country) &&
	                       c.getDemonition().equalsIgnoreCase(denomination))
	                {
	      
	                    System.out.println(c.getCountry());
	                    System.out.println(c.getDemonition());
	                    System.out.println(c.getYearofmint());
	                    System.out.println(c.getCurrentValue());
	                    System.out.println(c.getAcquireDate());
	                }
	            });
	            break;
			}
			case 2: {
				System.out.println("Enter Country Name:");
	            String country=sc.next();
	            System.out.println("Enter Year of Minting:");
	            int minting=sc.nextInt();
	            coins.forEach(c -> {
	                if(c.getCountry().equalsIgnoreCase(country) &&
	                        c.getYearofmint()==minting)
	                {
	      
	                    System.out.println(c.getCountry());
	                    System.out.println(c.getDemonition());
	                    System.out.println(c.getYearofmint());
	                    System.out.println(c.getCurrentValue());
	                    System.out.println(c.getAcquireDate());
	                }
	            });
	            break;
			}
			case 3: {
				System.out.println("Enter Country Name:");
	            String country=sc.next();
	            System.out.println("Enter Denomination:");
	            String denomination=sc.next();
	            System.out.println("Enter Year of Minting:");
	            int minting=sc.nextInt();
	            coins.forEach(c -> {
	                if(c.getCountry().equalsIgnoreCase(country) &&
	                        c.getYearofmint()==minting &&
	                                c.getDemonition().equalsIgnoreCase(denomination))
	                {
	      
	                    System.out.println(c.getCountry());
	                    System.out.println(c.getDemonition());
	                    System.out.println(c.getYearofmint());
	                    System.out.println(c.getCurrentValue());
	                    System.out.println(c.getAcquireDate());
	                }
	            });
	            break;
			}
			case 4: {
				System.out.println("Enter Acquired Date(dd/mm/yyyy)");
	            String acquiredDate=sc.next();
	            System.out.println("Enter Country Name:");
	            String country=sc.next();
	            coins.forEach(c -> {
	                if(c.getCountry().equalsIgnoreCase(country) &&
	                        c.getAcquireDate().equals(acquiredDate))
	                {
	                    System.out.println(c.getCountry());
	                    System.out.println(c.getDemonition());
	                    System.out.println(c.getYearofmint());
	                    System.out.println(c.getCurrentValue());
	                    System.out.println(c.getAcquireDate());
	                }
	            });
	            break;
	        }
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		else {
			System.out.println("Wrong Input");
		}
//end main method
	}
//end class
}
