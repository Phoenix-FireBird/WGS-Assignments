package Task;
	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		
		Set<Coin> coins = new HashSet<Coin>();
		Scanner sc = new Scanner(System.in);
		
		public Coin() {

		}
		
		public Coin(String v2,String v3,int v4,int v5,String v6) {
			country = v2;
			denomination = v3;
			yearOfMinting = v4;
			currentValue = v5;
			acquiredDate = v6;
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
		
		public void addition(){
			
			System.out.println("Coins wants to add:");
			int coinsAdd = sc.nextInt();
			System.out.println("Enter Country,Denomination,YearOfMinting,CurrValue,AcquiredDate");
			for(int i=0;i<coinsAdd;i++) 
			{
				coins.add(new Coin(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),(sc.next())));
			}
			
		}
		
		// To search Coin
		
		public void search() {
			int choice;
			System.out.println("Please Choose One Option:\n"
					+ "1.	Country + Denomination\n"
					+ "2.	Country + Year of Minting\n"
					+ "3.	Country + Denomination + Year of Minting\n"
					+ "4.	Acquired Date + Country\n"
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
				}
				);
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
				System.out.println("Enter Acquired Date(dd/mm/yyyy)");
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
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		// For bulkUplaod
		public void bulkUpload() 
		{
			
			try{
	            StringTokenizer st=null;
	            FileReader inputFileReader = new FileReader("C:\Users\w127267\OneDrive - Worldline\Desktop\CoinTask\Task Com.Coin\src\Task\Coin.csv");
	            BufferedReader inputStream = new BufferedReader(inputFileReader);
	            String inLine = null;
	            try {
					while((inLine =  inputStream.readLine())!=null){
					    st = new StringTokenizer(inLine, ",");
					    coins.add(new Coin(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.nextToken()));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        catch (FileNotFoundException e)
	         {  // This block executed if the file is not found
	            // and then the program exits
	        System.out.println("File not found.");
	        System.exit(0);
	        }
		}
		
		// To display Coin
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
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}
		
		
		
	

}
