package com.collection.java;


	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.HashSet;
	import java.util.Scanner;
	import java.util.Set;
	import java.util.StringTokenizer;

	public class Coin {

		String country;
		String denomination;
		int yearOfMinting;
		int currentValue;
		String acquiredDate;
		
		Set<Coin> coins = new HashSet();
		Scanner sc = new Scanner(System.in);
		
		public Coin() {
			// TODO Auto-generated constructor stub
		}
		
		public Coin(String v1,String v2,int v3,int v4,String v5) {
			country = v1;
			denomination = v2;
			yearOfMinting = v3;
			currentValue = v4;
			acquiredDate = v5;
		}


		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getDenomination() {
			return denomination;
		}

		public void setDenomination(String denomination) {
			this.denomination = denomination;
		}

		public int getYearOfMinting() {
			return yearOfMinting;
		}

		public void setYearOfMinting(int yearOfMinting) {
			this.yearOfMinting = yearOfMinting;
		}

		public int getCurrentValue() {
			return currentValue;
		}

		public void setCurrentValue(int currentValue) {
			this.currentValue = currentValue;
		}

		public String getAcquiredDate() {
			return acquiredDate;
		}

		public void setAcquiredDate(String acquiredDate) {
			this.acquiredDate = acquiredDate;
		}
		
		// To add Coin 
		
		public void addCoin(){
	
			System.out.println("Enter Coin Details");
			System.out.println("Enter Country Name");
			String s1=sc.next();
			System.out.println("Enter the Denomination");
			String s2=sc.next();
			System.out.println("Enter the Year");
			int s3=sc.nextInt();
			System.out.println("Enter the Current Value");
			int s4=sc.nextInt();
			System.out.println("Enter the Acquired Date");
			String s5=sc.next();
			
				coins.add(new Coin(s1,s2,s3,s4,s5));
				
			
		}
		
		// To search Coin
		
		public void search() {
			int choice;
			System.out.println(" Options:\n"
					+ "1.	Country + Denomination\r\n"
					+ "2.	Country + Year of Minting\r\n"
					+ "3.	Country + Denomination + Year of Minting\r\n"
					+ "4.	Acquired Date + Country\r\n"
					+ "");
			choice=sc.nextInt();
			switch (choice) {
			case 1: {
				coins.forEach(c -> {
					System.out.println("Enter Country Name:");
					String country=sc.next();
					System.out.println("Enter Denomination:");
					String denomination=sc.next();
					if(c.getCountry().equalsIgnoreCase(country) &&
							c.getDenomination().equalsIgnoreCase(denomination)) 
					{
						System.out.println(c.getCountry());
						System.out.println(c.getDenomination());
						System.out.println(c.getYearOfMinting());
						System.out.println(c.getCurrentValue());
						System.out.println(c.getAcquiredDate());
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
							c.getYearOfMinting()==minting) 
					{
						System.out.println(c.getCountry());
						System.out.println(c.getDenomination());
						System.out.println(c.getYearOfMinting());
						System.out.println(c.getCurrentValue());
						System.out.println(c.getAcquiredDate());
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
							c.getYearOfMinting()==minting &&
									c.getDenomination().equalsIgnoreCase(denomination)) 
					{
						System.out.println(c.getCountry());
						System.out.println(c.getDenomination());
						System.out.println(c.getYearOfMinting());
						System.out.println(c.getCurrentValue());
						System.out.println(c.getAcquiredDate());
					}
				});
				break;
			}
			case 4: {
				System.out.println("Enter Acquired Date");
				String acquiredDate=sc.next();
				System.out.println("Enter Country Name:");
				String country=sc.next();
				coins.forEach(c -> {
					if(c.getCountry().equalsIgnoreCase(country) &&
							c.getAcquiredDate().equals(acquiredDate)) 
					{
						System.out.println(c.getCountry());
						System.out.println(c.getDenomination());
						System.out.println(c.getYearOfMinting());
						System.out.println(c.getCurrentValue());
						System.out.println(c.getAcquiredDate());
					}
				});
				break;
			}
			default:
				System.out.println("Please Enter Valid Input");
			}
		}
		
		// To display Coin on basis of Criteria 
		
		public void display() {
			int ch;
			System.out.println("Please Enter your choice:\n"+""
					+ "1.	Country\n"
					+ "2.	Year of Minting\n"
					+ "3.	Current Value \n"
					+ "");
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("Enter Country Name:");
				String country=sc.next();
				coins.forEach(c -> {
					if(c.getCountry().equalsIgnoreCase(country)) 
					{
						System.out.println(c.getCountry());
						System.out.println(c.getDenomination());
						System.out.println(c.getYearOfMinting());
						System.out.println(c.getCurrentValue());
						System.out.println(c.getAcquiredDate());
					}
				});
				break;			
			}
			case 2: {
				System.out.println("Enter Year of Minting:");
				int minting=sc.nextInt();
				coins.forEach(c -> {
					if(c.getYearOfMinting()==minting) 
					{
						System.out.println(c.getCountry());
						System.out.println(c.getDenomination());
						System.out.println(c.getYearOfMinting());
						System.out.println(c.getCurrentValue());
						System.out.println(c.getAcquiredDate());
					}
				});
				break;
			}
			case 3: {
				System.out.println("Enter Current Value:");
				int value=sc.nextInt();
				coins.forEach(c -> {
					if(c.getCurrentValue()==value) 
					{
						System.out.println(c.getCountry());
						System.out.println(c.getDenomination());
						System.out.println(c.getYearOfMinting());
						System.out.println(c.getCurrentValue());
						System.out.println(c.getAcquiredDate());
					}
				});
				break;
			}
			default:
				System.out.println("Please Enter Valid Input");
			}
		}
		
		// To file Upload
		
		public void importdata() 
		{
			
			try{
	            StringTokenizer st=null;
	            FileReader inputFileReader = new FileReader("C:\\JAVA_WGS_Trainiing\\CoinsCollections\\src\\Coindata.csv");
	            BufferedReader inputStream = new BufferedReader(inputFileReader);
	            String str = null;
	            try {
					while((str =  inputStream.readLine())!=null){
					    st = new StringTokenizer(str, ",");
					    coins.add(new Coin(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.nextToken()));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        catch (FileNotFoundException e)
	         {  
	        System.out.println("Please Upload file .");
	        }
		}
		
		
		
	
}
