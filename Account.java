package com.bridgelabz.stockmanagement;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;

public interface Account {
	double valueOf();
	void buy (int amount, String symbol);
	void sell(int amount, String symbol);
	void save(String filename) throws IOException, JacksonException;
	void printReport();
}
