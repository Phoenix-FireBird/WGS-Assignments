package MyPackage;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Coin {
	String Country;
	String Denomination;
	int Year_Of_Minting;
	int Current_Value;
	String Acquired_Date;
	
	Set<Coin> coins = new HashSet();
	Scanner sc = new Scanner(System.in);
	
	public Coin() {
		// TODO Auto-generated constructor stub
	}
	
	public Coin(String v2,String v3,int v4,int v5,String v6) {
		Country = v2;
		Denomination = v3;
		Year_Of_Minting = v4;
		Current_Value = v5;
		Acquired_Date = v6;
	}


	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public String getDenomination() {
		return Denomination;
	}

	public void setDenomination(String Denomination) {
		this.Denomination = Denomination;
	}

	public int getYear_Of_Minting() {
		return Year_Of_Minting;
	}

	public void setYear_Of_Minting(int Year_Of_Minting) {
		this.Year_Of_Minting = Year_Of_Minting;
	}

	public int getCurrent_Value() {
		return Current_Value;
	}

	public void setCurrentValue(int currentValue) {
		this.Current_Value = currentValue;
	}

	public String getAcquiredDate() {
		return Acquired_Date;
	}

	public void setAcquired_Date(String Acquired_Date) {
		this.Acquired_Date = Acquired_Date;
	}

	public void addition() {
		System.out.println("How many Coins do you want to add?");
		int coinsAdd = sc.nextInt();
		System.out.println("Enter CoinId,Country,Denomination,Year,Value,AcquiredDate");
		for(int i=0;i<coinsAdd;i++) 
		{
			coins.add(new Coin(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),(sc.next())));
		}

		
		
	}

	public void search() {
		int choice;
		System.out.println("Please Choose One Option:\n"
				+ "1.Country + Denomination\r\n"
				+ "2.Country + Year of Minting\r\n"
				+ "3.Country + Denomination + Year of Minting\r\n"
				+ "4.Acquired Date + Country\r\n"
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
					System.out.println(c.getYear_Of_Minting());
					System.out.println(c.getCurrent_Value());
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
						c.getYear_Of_Minting()==minting) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_Of_Minting());
					System.out.println(c.getCurrent_Value());
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
						c.getYear_Of_Minting()==minting &&
								c.getDenomination().equalsIgnoreCase(denomination)) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_Of_Minting());
					System.out.println(c.getCurrent_Value());
					System.out.println(c.getAcquiredDate());
				}
			});
			break;
		}
		case 4: {
			System.out.println("Enter Acquired Date(dd/mm/yyyy)");
			String acquiredDate=sc.next();
			System.out.println("Enter Country Name:");
			String country=sc.next();
			coins.forEach(b -> {
				if(b.getCountry().equalsIgnoreCase(country) &&
						b.getAcquiredDate().equals(acquiredDate)) 
				{
					System.out.println(b.getCountry());
					System.out.println(b.getDenomination());
					System.out.println(b.getYear_Of_Minting());
					System.out.println(b.getCurrent_Value());
					System.out.println(b.getAcquiredDate());
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
				+ "1.Country\n"
				+ "2.Year of Minting\n"
				+ "3.Current Value (sorted)\n"
				+ "");
		ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Enter Country Name:");
			String country=sc.next();
			coins.forEach(ab -> {
				if(ab.getCountry().equalsIgnoreCase(country)) 
				{
					System.out.println(ab.getCountry());
					System.out.println(ab.getDenomination());
					System.out.println(ab.getYear_Of_Minting());
					System.out.println(ab.getCurrent_Value());
					System.out.println(ab.getAcquiredDate());
				}
			});
			break;			
		}
		case 2: {
			System.out.println("Enter Year of Minting:");
			int minting=sc.nextInt();
			coins.forEach(c -> {
				if(c.getYear_Of_Minting()==minting) 
				{
					System.out.println(c.getCountry());
					System.out.println(c.getDenomination());
					System.out.println(c.getYear_Of_Minting());
					System.out.println(c.getCurrent_Value());
					System.out.println(c.getAcquiredDate());
				}
			});
			break;
		}
		case 3: {
			System.out.println("Enter Current Value:");
			int value=sc.nextInt();
			coins.forEach(a -> {
				if(a.getCurrent_Value()==value) 
				{
					System.out.println(a.getCountry());
					System.out.println(a.getDenomination());
					System.out.println(a.getYear_Of_Minting());
					System.out.println(a.getCurrent_Value());
					System.out.println(a.getAcquiredDate());
				}
			});
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);
		}
	}
		
		
	
	

	

}
