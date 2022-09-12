package com.witapp;

public static void main (String[]args)throws Exception 
		{
			Runner r1 = new Runner();
			Runner r2 = new Runner();
			Runner r3= new Runner();
			Runner r4= new Runner();
			Runner r5= new Runner();
			Runner r6= new Runner();
			r1.runner();
			r2.listAllRunner();
			r3.dailyActivityRunner();
			r4.runningDuration();
			r5.totalRunner();
			r6.avgRunner();
			
			boolean exit=false;
			
			Scanner sc = new Scanner(System.in);


			while (!exit)
			{
				System.out.println("1.Register the new runner");
				System.out.println("2.List all the runner");
				System.out.println("3.Upload daily activity of the runner");
				System.out.println("4.Upload running in db using csv");
				System.out.println("5.Find the total runner per region,per city");
				System.out.println("6.Find average runs on any given day");
				int a = sc.nextInt();
				switch(a)
				{
				case 1:
				{
				r1.runner();
				break;
				}
				case 2:
				{
				r2.listAllRunner();
				break;
				}
				case 3:
				{
				r3.dailyActivityRunner();
				break;
				}
				case 4:
				{
				r4.runningDuration();
				break;
				}
				case 5:
				{
				r5.totalRunner();
				break;
				}
				case 6:
				{
				r6.avgRunner();
				break;
				}
				default:{
				System.out.println("Invalid case option");
						}
							
				}
			
	}
		}
}