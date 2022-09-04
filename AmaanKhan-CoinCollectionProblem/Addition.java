package coin.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Addition {
		
	public void AddCoin(List<Coin> list) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of record: ");
		int i=sc.nextInt();
		for(int j=0;j<i;j++) {
			System.out.println("Enter the Country\n");
			String Country=sc.next();
			System.out.println("Enter the denomination\n");
			String Denomination=sc.next();
			System.out.println("Enter Year of Mining\n");
			String YearOfMinting=sc.next();
			System.out.println("Enter the Current Value\n");
			String CurrentValue=sc.next();
			System.out.println("Enter the acquired date\n");
			String AcquiredDate=sc.next();
			Coin c=new Coin(Country,Denomination,YearOfMinting,CurrentValue,AcquiredDate);
			list.add(c);
		}
	}
	public void bulkUpload(List<Coin> list, String FilePath) {
		try {
//			Scanner sc=new Scanner(new File("C:\\Users\\w127281\\Documents\\CoinData.csv"));
//			sc.useDelimiter(",");
//			while(sc.hasNext()) {
//				System.out.println(sc.next());
			StringTokenizer st=null;
			FileReader inputFileReader=new FileReader(FilePath);
			BufferedReader inputStream=new BufferedReader(inputFileReader);
			String inLine=null;
			try {
				while((inLine=inputStream.readLine())!=null) {
					st=new StringTokenizer(inLine,",");
					String v1=st.nextToken();
					String v2=st.nextToken();
					String v3=st.nextToken();
					String v4=st.nextToken();
					String v5=st.nextToken();
					Coin c=new Coin(v1,v2,v3,v4,v5);
					list.add(c);
					
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
