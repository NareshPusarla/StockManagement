package com.bridgelabz.stockmanagement;

public class CompanyShare {
	String symbol;
	int count;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "CompanyShare [symbol=" + symbol + ", count=" + count + "]";
	}
}
