package coin.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class MainApp {
	
	public static void displayData(List<Coin> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("\n");
		driverFunction(list);
	}
	
	
	public static void Add(List<Coin> list) {
		System.out.println("Type 1 for manually addition or 2 for bulk upload");
		Addition ad=new Addition();
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		if(choice==1) {
			ad.AddCoin(list);
		}
		else if(choice==2) {
			System.out.println("Please enter the file path: \n");
			String FilePath="C:\\Users\\w127281\\Documents\\CoinData.csv";
			ad.bulkUpload(list,FilePath);
		}
		else {
			System.out.println("Kindly choose the right value either 1 or 2");
			Add(list);
		}
		
		System.out.println("Do you want to enter more data type y for yes or n for no");
		String choose=sc.next();
		if(choose=="y") {
			Add(list);
		}
		else {
			System.out.println("Your Coin data added succesfully!!!");
		}
		
		System.out.println("Your data is showing below");
		displayData(list);
		System.out.println("\n");
		driverFunction(list);
	}
	
	
	public static void SearchData(List<Coin> list) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Type 1 for display the fields or \n2 for specific coin availability \n");
		int choice=sc.nextInt();
		Search sr =new Search();
		if(choice==1) {
			System.out.println("Kindly enter 1 for country \n2 for denomination and 3 for currentvalue");
			int choose=sc.nextInt();
			System.out.println("Below are the data available");
			System.out.println("\n");
			sr.display(list, choose);
		}
		else if(choice==2) {
			System.out.println("Kindly enter 1 for Country+Denomination \n"
					+ "enter 2 for Country+Year of Minting\n"
					+ "enter 3 for Country+Denomination+Year of Minting\n"
					+ "enter 4 for AcquiredDate+Country\n");
			int choose=sc.nextInt();
			System.out.println("Enter the country: \n");
			String country=sc.next();
			if(choose==1) {
				System.out.println("Enter the denomination: \n");
				String Denomination=sc.next();
				sr.searchForSpecificCoin(list, choose, country, Denomination, "", "");
			}
			else if(choose==2) {
				System.out.println("Enter the YearOfMinting: \n");
				String YearOfMinting=sc.next();
				sr.searchForSpecificCoin(list, choose, country, "", YearOfMinting, "");
			}
			else if(choose==3) {
				System.out.println("Enter the denomination: \n");
				String Denomination=sc.next();
				System.out.println("Enter the YearOfMinting: \n");
				String YearOfMinting=sc.next();
				sr.searchForSpecificCoin(list, choose, country, Denomination, YearOfMinting, "");
			}
			else if(choose==4) {
				System.out.println("Enter the AcquiredDate: \n");
				String AcquiredDate=sc.next();
				sr.searchForSpecificCoin(list, choose, country, "", "", AcquiredDate);
			}
			else {
				System.out.println("Kindly Choose the ryt option:::");
				SearchData(list);
			}
		}
		driverFunction(list);
	}
	
	
	public static void driverFunction(List<Coin> list) {
		Scanner sc=new Scanner(System.in);
		
		Coin c=new Coin();
		System.out.println("Welcome to coin inventory Data!!!\n"
				+ "type 1 for addition of coin or 2 to search for a coin\n"
				+ "type 3 for closing the inventory\n"
				+ "type 4 for viewing of data available");
		int choice=sc.nextInt();
		if(choice==1){
			Add(list);
		}
		
		else if(choice==2) {
			SearchData(list);
		}
		else if(choice==3) {
			System.out.println("Thanks for using the Coins inventory will see you again!!!");
		}
		else if(choice==4) {
			displayData(list);
		}
		else {
			System.out.println("Kindly choose the right value either 1 or 2");
			driverFunction(list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		List<Coin> list=new ArrayList<Coin>();
		driverFunction(list);
	}
}
