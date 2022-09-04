package MyPackage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Main extends Coin {
	public static void main(String[] args) throws ParseException {
		Set<Coin> coins =new HashSet();
		Coin abc=new Coin();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Country of Coin");
		String a=sc.next();
		System.out.println("Enter the Denomination");
		String b=sc.next();
		System.out.println("Enter the Year Of Minting");
		int c=sc.nextInt();
		System.out.println("Enter the current value");
		int d=sc.nextInt();
		System.out.println("Enter the actual date");
		Scanner input = new Scanner(System.in);
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

		//System.out.print("Time period (DD/MM/YYYY): ");
		String sTime = input.nextLine();
		Date time = dateFormat.parse(sTime);
		
		System.out.println("how many coin you want to add");
        int coinAdd = sc.nextInt();
        
        
		System.out.println("Do you want to continue:");
		String flag=sc.next();
		if(flag.equals("y")||flag.equals("Y")){
		coins.forEach((ab)->
		{
			System.out.println(ab.getCountry());
			System.out.println(ab.getDenomination());
			System.out.println(ab.getYear_Of_Minting());
			System.out.println(ab.getCurrent_Value());
			System.out.println(ab.getAcquiredDate());
		});
		}
		//System.out.println("Search Coins");
		int ch;
		ch = sc.nextInt();
		switch (ch) {
		case 1: {
			abc.addition();	
			break;
		}
		case 2: {
			abc.search();
			break;
		}
		case 3: {
			abc.display();
			break;
		}
		
		}
	}
}
