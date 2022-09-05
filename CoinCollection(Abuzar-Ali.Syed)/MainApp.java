package com.coin.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Coins> listOfCoins=new ArrayList<Coins>();
        AddCoin addCoin=new AddCoin();
        Search search1=new Search();
        System.out.println("Please enter your choice\n1.Add\n2.BulkAdd\n3.Search\n4.exit");
        while(true){
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    addCoin.add(listOfCoins);
                    break;

                case 2:
                    addCoin.bulkAdd(listOfCoins);
                    break;

                case 3:
                    search1.search(listOfCoins);
                    break;

                case 4:
                    return;
            }
        }
    }
}

