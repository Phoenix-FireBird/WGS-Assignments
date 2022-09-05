package com.coin.collection;
import java.util.List;
import java.util.Scanner;
public class Search {
        public void search(List<Coins> listOfCoins) {
            Scanner sc = new Scanner(System.in);
            int choice;
            System.out.println("Please Choose One Option:\n"
                    + "1.	Country + Denomination\r\n"
                    + "2.	Country + Year of Minting\r\n"
                    + "3.	Country + Denomination + Year of Minting\r\n"
                    + "4.	Acquired Date + Country\r\n"
                    + "");
            choice=sc.nextInt();
            switch (choice) {
            case 1: {
                listOfCoins.forEach(c -> {
                    System.out.println("Enter Country Name:");
                    String country=sc.next();
                    System.out.println("Enter Denomination:");
                    String denomination=sc.next();
                    if(c.getCountry().equalsIgnoreCase(country) &&
                            c.getDenomination().equalsIgnoreCase(denomination)) 
                    {
                        System.out.println(c.getCountry());
                        System.out.println(c.getDenomination());
                        System.out.println(c.getYearOfMinting());
                        System.out.println(c.getCurrentValue());
                        System.out.println(c.getAcquiredDate());
                    }
                });
                break;
            }
            case 2: {
                System.out.println("Enter Country Name:");
                String country=sc.next();
                System.out.println("Enter Year of Minting:");
                String minting=sc.next();
                listOfCoins.forEach(c -> {
                    if(c.getCountry().equalsIgnoreCase(country) &&
                            c.getYearOfMinting()==minting) 
                    {
                        System.out.println(c.getCountry());
                        System.out.println(c.getDenomination());
                        System.out.println(c.getYearOfMinting());
                        System.out.println(c.getCurrentValue());
                        System.out.println(c.getAcquiredDate());
                    }
                });
                break;
            }
            case 3: {
                System.out.println("Enter Country Name:");
                String country=sc.next();
                System.out.println("Enter Denomination:");
                String denomination=sc.next();
                System.out.println("Enter Year of Minting:");
                String minting=sc.next();
                listOfCoins.forEach(c -> {
                    if(c.getCountry().equalsIgnoreCase(country) &&
                            c.getYearOfMinting()==minting &&
                                    c.getDenomination().equalsIgnoreCase(denomination)) 
                    {
                        System.out.println(c.getCountry());
                        System.out.println(c.getDenomination());
                        System.out.println(c.getYearOfMinting());
                        System.out.println(c.getCurrentValue());
                        System.out.println(c.getAcquiredDate());
                    }
                });
                break;
            }
            case 4: {
                System.out.println("Enter Acquired Date(dd/mm/yyyy)");
                String acquiredDate=sc.next();
                System.out.println("Enter Country Name:");
                String country=sc.next();
                listOfCoins.forEach(c -> {
                    if(c.getCountry().equalsIgnoreCase(country) &&
                            c.getAcquiredDate().equals(acquiredDate)) 
                    {
                        System.out.println(c.getCountry());
                        System.out.println(c.getDenomination());
                        System.out.println(c.getYearOfMinting());
                        System.out.println(c.getCurrentValue());
                        System.out.println(c.getAcquiredDate());
                    }
                });
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + choice);
            }
        }

        
}
