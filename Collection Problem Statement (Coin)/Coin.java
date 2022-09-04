package abhishek;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Coin{
	
	String con;
	String denom;
	int year_mint;
	int cur_val;
	String acq_date;
	
	Set<Coin> l=new HashSet<Coin>();
	Scanner sc = new Scanner(System.in);
	
	public Coin() {
		// TODO Auto-generated constructor stub
	}
	
	public Coin(String v1,String v2,int v3,int v4,String v5) {
		con=v1;
		denom=v2;
		year_mint=v3;
		cur_val=v4;
		acq_date=v5;
    }
	
	public void Add()
	{
		 System.out.println("Enter your choice:");
		 System.out.println("1. Add Single Coin");
		 System.out.println("2. Add Bulk Coins");
		 
		 int choice= sc.nextInt();
		 switch (choice) {
		 
		  case 1:
			  
			System.out.println("Enter Coin Details:");
			
			System.out.println("Country:");
			String con1=sc.next();
			
			System.out.println("Denomination:");
			String denom1=sc.next();
			
			System.out.println("Year Of Minting:");
			int year_mint1=sc.nextInt();
			
			System.out.println("Current Value:");
			int cur_val1=sc.nextInt();
			
			System.out.println("Acquired Date:");
			String acq_date1=sc.next();
			
			l.add(new Coin(con1,denom1,year_mint1,cur_val1,acq_date1));
			break;	
			
		   case 2: 
			  try {
				     StringTokenizer st=null;
				     FileReader ir = new FileReader("C:/Users/w127278/Downloads/coin.csv");
					 BufferedReader br = new BufferedReader(ir);
					 String inLine = null;
					 try {
	                      while((inLine=br.readLine())!=null){
								st = new StringTokenizer(inLine, ",");
								l.add(new Coin(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.nextToken()));
							    }}    
					 catch (IOException e) 
					 {
						e.printStackTrace();
					}
					}catch (FileNotFoundException e)
					    { 
					      System.out.println("File not found.");
					    }
			       System.out.println("Added Bulk Coins\n");
			     break;  
		    default:
		    	throw new IllegalArgumentException("Invalid Input: "+ choice);
			}

	}
	
	public void Search()
	{ 
			 System.out.println("What do you want to do");
			 System.out.println("1. To display a list on");
			 System.out.println("2. To search a specific coin based on ");
			 
			 int ch = sc.nextInt();
			 switch(ch) 
			 {
				case 1: 
					System.out.println("Enter your choice:");
					System.out.println("1. Country");
					System.out.println("2. Year of Minting");
					System.out.println("3. Current Value (sorted)");
					
					int ci= sc.nextInt();
					switch (ci) 
					{
					case 1: 
						System.out.println("Enter Country:");
						String con2=sc.next();
						l.forEach(c -> {
							if(c.getCon().equalsIgnoreCase(con2)) 
							{
								System.out.println("\nCountry:"+c.getCon());
								System.out.println("Denomination:"+c.getDenom());
								System.out.println("Year of Minting:"+c.getYear_mint());
								System.out.println("Current Value:"+c.getCur_val());
								System.out.println("Acquired Date:"+c.getAcq_date()+"\n");
							}
						});
						break;			
					
					case 2: 
						System.out.println("Enter Year of Minting:");
						int year_mint2=sc.nextInt();
						l.forEach(c -> {
							if(c.getYear_mint()==year_mint2) 
							{
								System.out.println("\nCountry:"+c.getCon());
								System.out.println("Denomination:"+c.getDenom());
								System.out.println("Year of Minting:"+c.getYear_mint());
								System.out.println("Current Value:"+c.getCur_val());
								System.out.println("Acquired Date:"+c.getAcq_date()+"\n");
							}
						});
						break;
					
					case 3: 
						System.out.println("Enter Current Value:");
						int cur_val2=sc.nextInt();
						l.forEach(c -> {
							if(c.getCur_val()==cur_val2) 
							{
								System.out.println("\nCountry:"+c.getCon());
								System.out.println("Denomination:"+c.getDenom());
								System.out.println("Year of Minting:"+c.getYear_mint());
								System.out.println("Current Value:"+c.getCur_val());
								System.out.println("Acquired Date:"+c.getAcq_date()+"\n");
							}
						});
						break;
					
					default:
						throw new IllegalArgumentException("Invalid Input: " + ci);
			         }
					break;
				case 2:
					int cho;
					System.out.println("Enter your choice:");
					System.out.println("1. Country + Denomination");
					System.out.println("2. Country + Year of Minting");
					System.out.println("3. Country + Denomination + Year of Minting");
					System.out.println("4. Acquired Date + Country");
						
					cho=sc.nextInt();
					
					switch (cho) 
					{
					case 1: 
						
							System.out.println("Enter Country:");
							String con2=sc.next();
							System.out.println("Enter Denomination:");
							String denom2=sc.next();
							
						l.forEach(c -> {
							if(c.getCon().equalsIgnoreCase(con2) && c.getDenom().equalsIgnoreCase(denom2)) 
							{
								System.out.println("\nCountry:"+c.getCon());
								System.out.println("Denomination:"+c.getDenom());
								System.out.println("Year of Minting:"+c.getYear_mint());
								System.out.println("Current Value:"+c.getCur_val());
								System.out.println("Acquired Date:"+c.getAcq_date()+"\n");
							}
						});
						break;
					
					case 2: 
						System.out.println("Enter Country:");
						String con21=sc.next();
						System.out.println("Enter Year of Minting:");
						int year_mint21=sc.nextInt();
						
						l.forEach(c -> {
							if(c.getCon().equalsIgnoreCase(con21) && c.getYear_mint()==year_mint21) 
							{
								System.out.println("\nCountry:"+c.getCon());
								System.out.println("Denomination:"+c.getDenom());
								System.out.println("Year of Minting:"+c.getYear_mint());
								System.out.println("Current Value:"+c.getCur_val());
								System.out.println("Acquired Date:"+c.getAcq_date()+"\n");
							}
						});
						break;
					
					case 3: 
						System.out.println("Enter Country:");
						String con22=sc.next();
						System.out.println("Enter Denomination:");
						String denom22=sc.next();
						System.out.println("Enter Year of Minting:");
						int year_mint22=sc.nextInt();
						
						l.forEach(c -> {
							if(c.getCon().equalsIgnoreCase(con22) && c.getYear_mint()==year_mint22 && c.getDenom().equalsIgnoreCase(denom22)) 
							{
								System.out.println("\nCountry:"+c.getCon());
								System.out.println("Denomination:"+c.getDenom());
								System.out.println("Year of Minting:"+c.getYear_mint());
								System.out.println("Current Value:"+c.getCur_val());
								System.out.println("Acquired Date:"+c.getAcq_date()+"\n");
							}
						});
						break;
					
					case 4: 
						System.out.println("Enter Acquired Date:");
						String acq_date12=sc.next();
						System.out.println("Enter Country:");
						String con12=sc.next();
						
						l.forEach(c -> {
							if(c.getCon().equalsIgnoreCase(con12) && c.getAcq_date().equals(acq_date12)) 
							{
								System.out.println("\nCountry:"+c.getCon());
								System.out.println("Denomination:"+c.getDenom());
								System.out.println("Year of Minting:"+c.getYear_mint());
								System.out.println("Current Value:"+c.getCur_val());
								System.out.println("Acquired Date:"+c.getAcq_date()+"\n");
							}
						});
						break;
					
					default:
						throw new IllegalArgumentException("Invalid Input: " + cho);
					}	
					break;
		      default:
		    	  throw new IllegalArgumentException("Invalid Input: " + ch);
                }
   }


	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public String getDenom() {
		return denom;
	}

	public void setDenom(String denom) {
		this.denom = denom;
	}

	public int getYear_mint() {
		return year_mint;
	}

	public void setYear_mint(int year_mint) {
		this.year_mint = year_mint;
	}

	public int getCur_val() {
		return cur_val;
	}

	public void setCur_val(int cur_val) {
		this.cur_val = cur_val;
	}

	public String getAcq_date() {
		return acq_date;
	}

	public void setAcq_date(String acq_date) {
		this.acq_date = acq_date;
	}

}
