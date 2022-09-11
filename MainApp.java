package mypack;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		City c1 = new City();
		Daily_Activity d1=new Daily_Activity(); 
		Runner r1=new Runner();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		while(flag!=true)
		{
			System.out.println("Enter your choice:\n"+
								"1.Register a new runner\n"+
								"2.List all the runners in the database\n"+
								"3.Upload daily activity for a runner \n"+
								"4.Upload running activity in the database for duration \n"+
								"5.Find total runner per region, per city \n"+
								"6.Find average runs on any given day \n"+
								"0.Exit");
			int ch;
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				r1.Insert_Runner();	
				break;
			}
			case 2: {
				r1.List_Of_Runners();
				break;
			}
			case 3: {
			    d1.Daily_Activity_Runner();
					break;
			}
			case 4: {
				d1.Running_Activity();
			break;
			}
			case 5: 
			{
				r1.Total_Runner();
				break;
			}
			case 6:
			{
				d1.Average_Runs();
				break;
			}
			case 0: {
				System.out.println("Thank You..");
				flag=true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}
	}
}
