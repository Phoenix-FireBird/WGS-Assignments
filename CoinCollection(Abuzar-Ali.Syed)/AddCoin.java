package com.coin.collection;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AddCoin {
    public void add(List<Coins> listOfCoins){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Country");
            String country=sc.next();
            System.out.println("Enter the denomination");
            String denomination=sc.next();
            System.out.println("Enter the year of Minting");
            String yearOfMinting=sc.next();
            System.out.println("Enter the Current value");
            String currentValue=sc.next();
            System.out.println("Enter the Acquired date");
            String acquiredDate=sc.next();
            Coins c1=new Coins(country,denomination,yearOfMinting,currentValue,acquiredDate);
            listOfCoins.add(c1); 
            System.out.println("Entered Successfully");
    }

    public void bulkAdd(List<Coins> listOfCoins){
        try {
            StringTokenizer st=null;
            FileReader ir = new FileReader("C:/Users/w127364/Downloads/coins.csv");
            BufferedReader br = new BufferedReader(ir);
            String inLine = null;
            try {
                 while((inLine=br.readLine())!=null){
                       st = new StringTokenizer(inLine, ",");
                       listOfCoins.add(new Coins(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken()));
                    }
                }
            catch (IOException e){
               e.printStackTrace();
            }
        }
        catch (FileNotFoundException e){ 
            System.out.println("File not found.");
        }
        System.out.println("Added Bulk Coins\n");
    }
}
