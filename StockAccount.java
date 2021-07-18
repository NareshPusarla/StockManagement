package com.bridgelabz.stockmanagement;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.stockmanagement.LinkedList.Node;
import com.fasterxml.jackson.core.JacksonException;

public class StockAccount implements Account{
	LinkedList companyShares;
	
	public StockAccount(String fileName) throws Exception{
		String data = new String(Files.readAllBytes(Paths.get(fileName)));
		JSONArray jsonArray = new JSONArray();
		companyShares = new LinkedList();
		for(int i = 0; i<jsonArray.size();i++) {
			CompanyShare company = new CompanyShare();
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			company.setSymbol(jsonObject.getString("symbol"));
			company.setCount(jsonObject.getInt("count"));
			companyShares.append(company);
		}
	}

	@Override
	public double valueOf() {
		return 0;
	}

	@Override
	public void buy(int amount, String symbol) {
		Node node = companyShares.head;
		boolean isNewShare = true;
		while(node != null) {
			if(node.data.getSymbol().equals(symbol)) {
				isNewShare = false;
				node.data.setCount(node.data.getCount()+amount);
				break;
			}
			node = node.next;
		}
		if(isNewShare) {
			CompanyShare newData = new CompanyShare();
			newData.setSymbol(symbol);
			newData.setCount(amount);
			companyShares.append(newData);
		}
	}

	@Override
	public void sell(int amount, String symbol) {
		Node node = companyShares.head;
		while(node != null) {
			if(node.data.getSymbol().equals(symbol)) {
				node.data.setCount(node.data.getCount() - amount);
				break;
			}
			node = node.next;
		}
	}

	@Override
	public void save(String filename) throws IOException, JacksonException {
		Node node = companyShares.head;
		JSONArray jsonArray = new JSONArray();
		while(node != null) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("symbol", node.data.getSymbol());
			jsonObject.put("count", node.data.getCount());
			jsonArray.add(jsonObject);
			node = node.next;
		}
		FileWriter file = new FileWriter(filename);
		file.write(jsonArray.toString());
		file.close();
	}

	@Override
	public void printReport() {
		Node node = companyShares.head;
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
}
