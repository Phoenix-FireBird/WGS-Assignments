package Coin_package;



import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;


import java.io.BufferedWriter;

import java.io.PrintWriter;




public class Coin {
        String Country;
        String Denomination;
        int Year_of_minting;
        int Current_value;
        String Acquired_date;
      
        
public Coin()
{
	
	
}

public Coin(String v1,String v2,int v3,int v4,String v5) {
	Country=v1;
	Denomination=v2;
	Year_of_minting=v3;
	Current_value=v4;
	Acquired_date=v5;
	
	
}

public String getCountry() {
	return Country;
}

public void setCountry(String country) {
	Country = country;
}

public String getDenomination() {
	return Denomination;
}

public void setDenomination(String denomination) {
	Denomination = denomination;
}

public int getYear_of_minting() {
	return Year_of_minting;
}

public void setYear_of_minting(int year_of_minting) {
	Year_of_minting = year_of_minting;
}

public int getCurrent_value() {
	return Current_value;
}

public void setCurrent_value(int current_value) {
	Current_value = current_value;
}

public String getAcquired_date() {
	return Acquired_date;
}

public void setAcquired_date(String acquired_date) {
	Acquired_date = acquired_date;
}


Set<Coin> coins = new HashSet();
Scanner sc = new Scanner(System.in);
 

	public void addcoin(){
		
		System.out.println("How many Coins do you want to add?");
		int coinsAdd = sc.nextInt();
		System.out.println("Enter Country, Denomination, Year, Value, AcquiredDate");
		for(int i=0;i<coinsAdd;i++) 
		{
			coins.add(new Coin(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),(sc.next())));
		}
		
	}
	
  public void bulkupload(){
		System.out.println("file path to add csv file");
		String filepath = sc.next();
	    
	  
	    try {
	       
	           FileWriter fw = new FileWriter(filepath,true);
	           BufferedWriter bw = new BufferedWriter(fw);
	           PrintWriter pw = new PrintWriter (bw);
	           
	           pw.flush();
	           pw.close();
	
	           JOptionPane.showMessageDialog(null,"Record Added");
	    }
	    catch (Exception e)
	    {
	    	JOptionPane.showMessageDialog(null,"Fail to Add Record ");
	    }
    }
	public void search() {
		int choice;
		System.out.println("Please Choose One Option:\n"
				+ "1.	Country + Denomination\r\n"
				+ "2.	Country + Year_of_Minting\r\n"
				+ "3.	Country + Denomination + Year_of_Minting\r\n"
				+ "4.	Acquired Date + Country\r\n"
				+ "");
		choice=sc.nextInt();
		switch (choice) {
		case 1: {
			coins.forEach(c -> {
				System.out.println("Enter Country Name:");
				String Country=sc.next();
				System.out.println("Enter Denomination:");
				String Denomination=sc.next();
				if(c.getCountry().equalsIgnoreCase(Country) &&
						c.getDenomination().equalsIgnoreCase(Denomination)) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_of_minting());
					System.out.println(c.getCurrent_value());
					System.out.println(c.getAcquired_date());
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
						c.getYear_of_minting()==minting) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_of_minting());
					System.out.println(c.getCurrent_value());
					System.out.println(c.getAcquired_date());
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
						c.getYear_of_minting()==minting &&
								c.getDenomination().equalsIgnoreCase(denomination)) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_of_minting());
					System.out.println(c.getCurrent_value());
					System.out.println(c.getAcquired_date());
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
						c.getAcquired_date().equals(acquiredDate)) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_of_minting());
					System.out.println(c.getCurrent_value());
					System.out.println(c.getAcquired_date());
				}
			});
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	 
	
	public void display() {
		int ch;
		System.out.println("Please Enter your choice:\n"+""
				+ "1.	Country\n"
				+ "2.	Year of Minting\n"
				+ "3.	Current Value (sorted)\n"
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
					System.out.println(c.getYear_of_minting());
					System.out.println(c.getCurrent_value());
					System.out.println(c.getAcquired_date());
				}
			});
			break;			
		}
		case 2: {
			System.out.println("Enter Year of Minting:");
			int minting=sc.nextInt();
			coins.forEach(c -> {
				if(c.getYear_of_minting()==minting) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_of_minting());
					System.out.println(c.getCurrent_value());
					System.out.println(c.getAcquired_date());
				}
			});
			break;
		}
		case 3: {
			System.out.println("Enter Current Value:");
			int value=sc.nextInt();
			coins.forEach(c -> {
				if(c.getCurrent_value()==value) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_of_minting());
					System.out.println(c.getCurrent_value());
					System.out.println(c.getAcquired_date());
				}
			});
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);
		}
	}
	
	
	
	
}
