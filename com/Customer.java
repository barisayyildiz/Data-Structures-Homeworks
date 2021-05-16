package com;

import java.util.*;

public class Customer extends User{

	public Customer(int id, String name, String password){
		super(id, name, password);
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
	
}
