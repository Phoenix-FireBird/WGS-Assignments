package abhishek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) throws InputMismatchException {
		
		Coin cs=new Coin();
		Scanner sc = new Scanner(System.in);
		
		 while(true) {
			 
		 System.out.println("Choose your Option:");
		 System.out.println("1. Add Coins");
		 System.out.println("2. Search Coins");
		 
		 int cz=sc.nextInt();
		 
			switch(cz)
			{
			case 1:
				   cs.Add();
				   break;
			case 2:
				   cs.Search();
				   break;
			default:
				throw new IllegalArgumentException("Invalid Input: " + cz);
		 }
	}
  }
}
