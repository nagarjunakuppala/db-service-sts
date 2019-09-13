package org.uhcl.edu.stock.dbservice.model;

import java.util.List;

public class Stocks {

	private String userName;
	private List<Stock> stocks;
	
	public Stocks() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
}
