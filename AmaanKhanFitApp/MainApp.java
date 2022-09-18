package com.amaan.application;

public class MainApp {

	public static void main(String[] args) {
		creatingDataBase();
		// TODO Auto-generated method stub

	}
	public static void creatingDataBase() {
		CreateDb cd=new CreateDb();
//		cd.createDatabases();
//		cd.creatingTables();
		Features fe=new Features();
//		fe.RegisterNewUser();
//		fe.listAllTheRunners();
//		fe.UploadDailyActivityForRunner();
//		fe.UploadRunnerActivityUsingCsv();
//		fe.TotalRunnerPerRegionAndPerCity();
		fe.AverageRunsOnGivenDay();
		
	}

}
