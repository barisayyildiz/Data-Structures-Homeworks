package com;

import java.util.*;

public class Customer extends User{

	private LinkedList<Order> orders;
	private ArrayList<Product> searchResult;

	public Customer(int id, String name, String password){
		super(id, name, password);
		this.orders = null;
		this.searchResult = null;
	}

	// get trader name as a paramter
	public String showSingleTrader(String name){

		ArrayList<Product> products = ECommerce.getAllProducts(name);

		return products.toString();
		
	}

	public void showAllTraderNames(){
		LinkedList<String> traderNames = ECommerce.getAllTraders();
		Iterator<String> iter = traderNames.iterator();
		System.out.println("Trader Names : ");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}	
	}

	public void makeAnOrder(String productId){
		
		ECommerce.makeAnOrder(this.getId(), productId);

	}

	private void syncOrders(){
		this.orders = ECommerce.getOrdersCustomer(this.getName());
		System.out.println(this.orders == null);
	}

	public void getOrdersCustomer(){
		this.syncOrders();
		Iterator<Order> iter = this.orders.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public void search(String query){

		this.searchResult = ECommerce.getProductsByQuery(query);

		System.out.println(searchResult);

	}

	public ArrayList<Product> getSearchResult(){
		return this.searchResult;
	}
	
}
