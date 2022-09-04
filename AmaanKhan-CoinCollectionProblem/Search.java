package coin.collection;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Search {
	public void display(List<Coin> list,int displayOn) {
		int sizeofArray=list.size();
		int[] intArray=new int[sizeofArray+1];
		for(int i=0;i<list.size();i++) {
			String myvalue=list.get(i).toString();
			String[] split=myvalue.split(" ");
			if(displayOn==3) {
				int value=Integer.parseInt(split[3]);
				intArray[i]=value;
			}
			else{
			System.out.println(split[displayOn-1]);
			}
			
			
		}
		if(displayOn==3) {
			Arrays.sort(intArray);
			for(int i=0;i<intArray.length;i++) {
				System.out.println(intArray[i]);
			}
		}
	}
	
	public void searchForSpecificCoin(List<Coin> list,int search,String Country,String Denomination, String YearOfMinting,String AcquiredDate) {
		int flag=0;
		for(int i=0;i<list.size();i++) {
			String myvalue=list.get(i).toString();
			String[] split=myvalue.split("\\s");
			if(search==1) 
			{
				if(split[0].equals(Country) && split[1].equals(Denomination)) {
					System.out.println(myvalue);
					flag=1;
				}
			}
			else if(search==2)
			{
				if(split[0].equals(Country) && split[2].equals(YearOfMinting)) {
					System.out.println(myvalue);
					flag=1;
				}
			}
			else if(search==3)
			{
				if(split[0].equals(Country) && split[2].equals(YearOfMinting) && split[1].equals(Denomination)) {
					System.out.println(myvalue);
					flag=1;
				}
			}
			else if(search==4)
			{
				if(split[0].equals(Country) && split[4].equals(AcquiredDate)) {
					System.out.println(myvalue);
					flag=1;
				}
			}
		}
		if(flag==1) {
			System.out.println("These are the coins that are found!!!");
		}
		else {
			System.out.println("There is no coin available with this info \n kindly check for spelling mistakes or try again !!!");
		}
	}
	
}
;