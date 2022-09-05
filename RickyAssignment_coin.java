package taskk;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Coin{
	
int mint_year;
String coun;
String denomination;
int current_val;String acquired_date;
	Set<Coin> l=new HashSet<Coin>();
	Scanner s = new Scanner(System.in);
	public Coin() {
		// TODO Auto-generated constructor stub
	}
	
	public Coin(String v1,String v2,int v3,int v4,String v5) {
		coun=v1;
		denomination=v2;
		mint_year=v3;
		current_val=v4;
		acquired_date=v5;
    }
	
	public void Adding()
	{  System.out.println("Enter your choice:");
	   System.out.println("1. Add  a Single Coin");
		System.out.println("2. Add Bulk Coins");
		 int choice= s.nextInt();
		 switch (choice) {
		   case 1:System.out.println("Enter the details of coin:");
			System.out.println("Enter the Country name:");
			String coun=s.next();
			System.out.println("Enter the Denomination:");
			String denomination=s.next();
			System.out.println("Enter the Year Of Minting:");
			int mint_year=s.nextInt();
		   System.out.println("Current Value:");
			int current_val=s.nextInt();
			System.out.println("Acquired Date:");
			String acquired_date=s.next();
			l.add(new Coin(coun,denomination,mint_year,current_val,acquired_date));
			break;	
			 case 2: 
			  try {String inLine = null;
				     StringTokenizer st=null;
				     FileReader fr = new FileReader("C:\\Users\\w127375\\OneDrive - Worldline\\Documents\\Assignmentcoin.csv");
					 BufferedReader br = new BufferedReader(fr);
					try { while((inLine=br.readLine())!=null){
					st = new StringTokenizer(inLine, ",");
		l.add(new Coin(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.nextToken()));
							    }}    
					 catch (IOException e) 
					{	e.printStackTrace();
					}
			  }catch (FileNotFoundException e)
					    {  System.out.println("File not found."); }
			       System.out.println(" Bulk Coins Added\n");
			     break;  
		    default:throw new IllegalArgumentException(" Input is Invalid: "+ choice);}}
	
	public void Searching()
	{ 
			 System.out.println("Select the option");
			 System.out.println("1. Display the list");
			 System.out.println("2. Search the coin with Specifications");
			 int choice = s.nextInt();
			 switch(choice) 
			 {case 1: 
					System.out.println("Enter the choice:");
					System.out.println("1. Country name ");
					System.out.println("2. Year of Minting");
					System.out.println("3. Current Value (sorted value)");
					int choice1= s.nextInt();
					switch (choice1) 
					{
					case 1: 
						System.out.println("Enter the Country:");
						String coun1=s.next();
						l.forEach(c -> {
							if(c.getCoun().equalsIgnoreCase(coun1)) 
							{
								System.out.println("\nCountry:"+c.getCoun());
								System.out.println("       Denomination:"      +c.getdenomination());
								System.out.println("       Year of Minting:"   +c.getmint_year());
								System.out.println("        Current Value:"    +c.getCurrent_val());
								System.out.println("        Acquired Date:"     +c.getAcquired_date()+"\n");
							}
						});
						break;			
						case 2: 
						System.out.println("Enter  the Year of Minting:");
						int mint_year2=s.nextInt();
						l.forEach(c -> {
							if(c.getmint_year()==mint_year2) 
							{System.out.println("      Country\n:"      +c.getCoun());
							System.out.println("      Denomination:"     +c.getdenomination());
							System.out.println("      Year of Minting:"   +c.getmint_year());
							System.out.println("       Current Value:"     +c.getCurrent_val());
						System.out.println("       Acquired Date:"      +c.getAcquired_date()+"\n");
							}
						});
						break;
					
					case 3: 
						System.out.println("Enter the  Current Value:");
						int curr_val1=s.nextInt();
						l.forEach(c -> 
						{
							if(c.getCurr_val()==curr_val1) 
							{System.out.println("\nCountry:"+c.getCoun());
						     System.out.println("Denomination:"+c.getdenomination());
							System.out.println("Year of Minting:"+c.getmint_year());
							System.out.println("Current Value:"+c.getCurrent_val());
							System.out.println("Acquired Date:"+c.getAcquired_date()+"\n");
							}
						});
						break;
						default:
						throw new IllegalArgumentException("Invalid Input: " + coun);
			         }break;
				case 2:
					int choice12;
					System.out.println("Enter your choice:");
					System.out.println("1. Country + Denomination");
					System.out.println("2. Country + Year of Minting");
					System.out.println("3. Country + Denomination + Year of Minting");
					System.out.println("4. Acquired Date + Country");
				    choice12=s.nextInt();
					switch (choice12) 
					{
					case 1: System.out.println("Enter the  Country:");
							String con2=s.next();
							System.out.println("Enter the  Denomination:");
							String denom2=s.next();
							l.forEach(c -> {
							if(c.getCoun().equalsIgnoreCase(coun2) && c.getdenomination().equalsIgnoreCase(denom2)) 
							{System.out.println("\nCountry:"+c.getCoun());
							System.out.println("Denomination:"+c.getdenomination());
							System.out.println("Year of Minting:"+c.getmint_year());
							System.out.println("Current Value:"+c.getCurrent_val());
							System.out.println("Acquired Date:"+c.getAcquired_date()+"\n");
							}
						});
						break;
					case 2: 
						System.out.println("Enter the  Country:");
						String coun26=s.next();
						System.out.println("Enter the Year of Minting:");
						int mint_year21=s.nextInt();
						l.forEach(c -> {
							if(c.getCoun().equalsIgnoreCase(coun26) && c.getmint_year()==mint_year) 
							{System.out.println("\nCountry:"+c.getCoun());
							System.out.println("Denomination:"+c.getdenomination());
							System.out.println("Year of Minting:"+c.getmint_year());
							System.out.println("Current Value:"+c.getCurrent_val());
							System.out.println("Acquired Date:"+c.getAcquired_date()+"\n");
							}
						});
						break;
				      case 3: 
						System.out.println("Enter the Name of Country:");
						String coun15=s.next();
						System.out.println("Enter  the Denomination:");
						String denom22=s.next();
						System.out.println("Enter Year of Minting:");
						int mint_years=s.nextInt();
						l.forEach(c -> {
							if(c.getCoun().equalsIgnoreCase(con2) && c.getmint_year()==mint_years && c.getdenomination().equalsIgnoreCase(denom22)) 
							{System.out.println("\nCountry:"+c.getCoun());
								System.out.println("Denomination:"+c.getdenomination());
								System.out.println("Year of Minting:"+c.getmint_year());
								System.out.println("Current Value:"+c.getCurrent_val());
								System.out.println("Acquired Date:"+c.getAcquired_date()+"\n");
							}
						});break;
					   case 4: 
						System.out.println("Enter  the Acquired Date:");
						String acq_date12=s.next();
						System.out.println("Enter the name of  Country:");
						String con12=s.next();
						l.forEach(c -> {
							if(c.getCoun().equalsIgnoreCase(con12) && c.getAcquired_date().equals(acq_date12)) 
							{System.out.println("\nCountry:"+c.getCoun());
							System.out.println("Denomination:"+c.getdenomination());
							System.out.println("Year of Minting:"+c.getmint_year());
							System.out.println("Current Value:"+c.getCurrent_val());
							System.out.println("Acquired Date:"+c.getAcquired_date()+"\n");
							}
						});break;
					default:
					throw new IllegalArgumentException("Input is Invalid : " + choice);
					}break;
		      default:
		    	  throw new IllegalArgumentException(" Input  is inavlid: " + choice);
                }
   }
	
	public String getdenomination() {
		return denomination;
	}

	public void setdenomination(String denom) {
		this.denomination = denomination;
	}

	public int getmint_year() {
		return mint_year;
	}

	public void set(int mint_year) {
		this.mint_year = mint_year;
	}



	public String getAcquired_date() {
		return acquired_date;
	}

	public void setAcq_date(String acquired_date) {
		this.acquired_date = acquired_date;
	}

	public String getCoun() {
		return coun;
	}

	public void setCoun(String coun) {
		this.coun = coun;
	}

	public int getCurrent_val() {
		return current_val;
	}

	public void setCurrent_val(int current_val) {
		this.current_val = current_val;
	}
	

}