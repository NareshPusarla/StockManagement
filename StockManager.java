package com.bridgelabz.stockmanagement;

public class StockManager {

	public static void main(String[] args) throws Exception{
		StockAccount stockAccount = new StockAccount("C:\\Users\\Naresh\\Documents\\stock.json");
		System.out.println("Initial report");
		
		stockAccount.printReport();
		
		stockAccount.buy(50, "TCS");
		System.out.println("After buying 50 HCL shares");
		stockAccount.printReport();
		
		stockAccount.sell(50, "HCL");
		System.out.println("After selleing 50 TCS shares");
		stockAccount.printReport();
		
		stockAccount.buy(50, "Wipro");
		System.out.println("After buting nre stock of wipro");
		stockAccount.printReport();
		
		stockAccount.save("C:\\Users\\Naresh\\Documents\\stock.json");
	}

}
