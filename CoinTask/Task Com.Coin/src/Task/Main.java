package Task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void getChoice() throws DataInvalidException , InputMismatchException {
		
		Coin c1 = new Coin();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		while(flag!=true)
		{
			System.out.println("Enter your choice:\n"+
								"1.Add a coin\n"+
								"2.Search a coin \n "+
								"3.For Bulk Upload"+
								"4.Display a List"+							
								"5:Exit");
			int ch;
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				c1.addition();	
				break;
			}
			case 2: {
				c1.search();
				break;
			}
			case 3:{
					c1.bulkUpload();
				break;
			}
			case 4:{
				c1.display();
				break;
			}
			case 5:
			{
				System.out.println("Thanks for your time...");
				flag=true;
				break;
			}
				
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}

	}
		}
	public static void main(String[] args) {
				
		try {
			getChoice();
		} catch (InputMismatchException | DataInvalidException e1) {
			System.out.println("Invalid Process...");
		}
	}
}


