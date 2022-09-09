package com.coincollection;

import static com.coincollection.CoinUtil.bulkUpload;
import static com.coincollection.CoinUtil.constructCoin;
import static com.coincollection.CoinUtil.print;
import static com.coincollection.CoinUtil.printCoin;
import static com.coincollection.CoinUtil.search;
import static com.coincollection.CoinUtil.sortCoinCollectionsList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinCollectionManagement
{

	static List<Coin> coinCollectionsList = new ArrayList<>();

	public static void main(String[] args)
	{
		boolean exit = false;
		while(!exit)
		{
			print("1. Addition");
			print("2. Bulk Upload (Data.csv)");
			print("3. Display all");
			print("4. Search coin");
			print("5. Exit");
			int a = new Scanner(System.in).nextInt();
			switch(a)
			{
				case 1:
				{
					Coin coin = constructCoin();
					if(coin != null)
					{
						coinCollectionsList.add(coin);
					}
					break;
				}
				case 2:
				{
					bulkUpload(coinCollectionsList);
					break;
				}
				case 3:
				{
					sortCoinCollectionsList(coinCollectionsList);

					for(Coin coin : coinCollectionsList)
					{
						printCoin(coin);
					}
					break;
				}
				case 4:
				{
					search(coinCollectionsList);
					break;
				}
				case 5:
				{
					exit = true;
					break;
				}
				default:
				{
					print("Invalid Option");
				}
			}
		}
	}

}

