package com.upm.others;

/*
 * This class contains all constants variables that require in application.
 */
public class Constants {
	
	/*
	 * For getting API_KEY & SECRET_KEY, just login or register to AppHQ Console (http://apphq.shephertz.com/). 
	 */
	 public static final String App42ApiKey = "630dd63d305199a99a9df0797a8a63929e73f76390627805c2399025483f9335";  // API_KEY received From AppHQ console, When You create your first app in AppHQ Console.
	 public static final String App42ApiSecret = "ec6361e00a2cb5ef95d7e3480cd7b0d576df12cd6aeba20115c2a2f36412ae67"; // SECRET_KEY received From AppHQ console, When You create your first app in AppHQ Console.
	 
	 /*
	  * For creating Database from AppHQ console, just go to (Technical Service Manager -> Storage Service -> click "Add DB".)
	  */
	 public static final String App42DBName = "APP42_ANDROID";  // Change it as your requirement. (Note that, only one DataBase can be created through same API_KEY & SECRET_KEY);
	
	 public static final String CollectionName = "AndroidSample"; // Change it as your requirement. 
	
	 /*
	  * For Creating Game, just go to (Business Service Manager -> Game Service -> select Game -> click "Add Game".)
	  */
	 public static final String App42GameName = "UPMNotification"; // Change it as your requirement. (You have to create game through AppHQ console.);
	 
	 public static final String IntentUserName = "intentUserName";
	 public static final String App42AndroidPref="App42AndroidPreferences";
	 public static final String UserName = "TestUser";
}