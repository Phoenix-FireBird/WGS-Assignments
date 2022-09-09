package com.coincollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class CoinUtil
{
	static Scanner sc = new Scanner(System.in);

	public static Coin constructCoin()
	{
		Coin coin = new Coin();
		try
		{
			print("Enter country");
			coin.setCountry(sc.next());
			print("Enter denomination");
			coin.setDenomination(sc.next());
			print("Enter year Of Mining");
			coin.setYearOfMining(String.valueOf(Integer.parseInt(sc.next())));
			print("Enter current Value");
			coin.setCurrentValue(Double.parseDouble(sc.next()));
			print("Enter acquired Date");
			coin.setAcquiredDate(sc.next());
			print("com.coincollection.Coin Added Successfully");
			print("");
			return coin;
		}
		catch(Exception e)
		{
			print("Invalid Input");
			print("");
			return null;
		}

	}

	public static void sortCoinCollectionsList(List<Coin> coinCollectionsList)
	{
		Collections.sort(coinCollectionsList, (Coin c1, Coin c2) -> c1.getCurrentValue() < c2.getCurrentValue() ? -1 : 1);
	}

	public static void print(String s)
	{
		System.out.println(s);
	}

	public static void printCoin(Coin coin)
	{
		print("country : " + coin.getCountry());
		print("denomination : " + coin.getDenomination());
		print("year Of Mining : " + coin.getYearOfMining());
		print("current Value : " + coin.getCurrentValue());
		print("acquired Date : " + coin.getAcquiredDate());
		print("--------------------------------------------------");
	}

	public static void search(List<Coin> coinCollectionsList)
	{
		print("1. Country + Denomination");
		print("2. Country + Year of Mining");
		print("3. Country + Denomination + Year of Mining");
		print("4. Acquired Date + Country");

		int choice;
		choice = sc.nextInt();
		switch(choice)
		{
			case 1:
			{
				print("Enter country");
				String country = sc.next();
				print("Enter denomination");
				String denomination = sc.next();
				for(Coin coin : coinCollectionsList)
				{
					if(coin.getCountry().equals(country) && coin.getDenomination().equals(denomination))
					{
						printCoin(coin);
						return;
					}
				}
				print("No coin found");
				break;
			}

			case 2:
			{
				print("Enter country");
				String country = sc.next();
				print("Enter year Of Mining");
				String yearOfMining = sc.next();
				for(Coin coin : coinCollectionsList)
				{
					if(coin.getCountry().equals(country) && coin.getYearOfMining().equals(yearOfMining))
					{
						printCoin(coin);
						break;
					}
				}
				break;
			}

			case 3:
			{
				print("Enter country");
				String country = sc.next();
				print("Enter denomination");
				String denomination = sc.next();
				print("Enter year Of Mining");
				String yearOfMining = sc.next();
				for(Coin coin : coinCollectionsList)
				{
					if(coin.getCountry().equals(country) && coin.getDenomination().equals(denomination) && coin.getYearOfMining().equals(yearOfMining))
					{
						printCoin(coin);
						return;
					}
				}
				print("No coin found");
			}

			case 4:
			{
				print("Enter country");
				String country = sc.next();
				print("Enter acquired Date");
				String acquiredDate = sc.next();
				for(Coin coin : coinCollectionsList)
				{
					if(coin.getCountry().equals(country) && coin.getAcquiredDate().equals(acquiredDate))
					{
						printCoin(coin);
						return;
					}
				}
				print("No coin found");
			}
			default:
			{
				print("Invalid Option");
			}

		}

	}

	public static void bulkUpload(List<Coin> coinCollectionsList)
	{

		try
		{
			StringTokenizer st;
			FileReader inputFileReader = new FileReader("C:/Assignment/Data.csv");
			BufferedReader inputStream = new BufferedReader(inputFileReader);
			String inLine;
			try
			{
				while((inLine = inputStream.readLine()) != null)
				{
					st = new StringTokenizer(inLine, ",");
					Coin coin = new Coin();
					coin.setCountry(st.nextToken());
					coin.setDenomination(st.nextToken());
					coin.setYearOfMining(st.nextToken());
					coin.setCurrentValue(Double.parseDouble(st.nextToken()));
					coin.setAcquiredDate(st.nextToken());
					coinCollectionsList.add(coin);
				}
				print("Data uploaded Successfully");
			}
			catch(Exception e)
			{
				print(e.getMessage());
			}
		}
		catch(Exception e)
		{
			System.out.println("File not found.");
		}
	}
}
