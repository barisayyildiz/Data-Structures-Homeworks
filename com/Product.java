package com;

import java.util.Iterator;
import java.util.TreeSet;

public class Product {
	private String id;
	private String productName;
	private int price;
	private int discountedPrice;
	private String description;
	private String trader;
	private TreeSet<String> categoryTree;
	private double discountPercentage;

	public Product(String id, String productName, int price, int discountedPrice, String description, String trader, TreeSet<String> categoryTree){
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.description = description;
		this.trader = trader;
		this.categoryTree = categoryTree;
		this.discountPercentage = ((this.price - this.discountedPrice) / (double)this.price) * 100;
	}
	 
	public Product(String productName, int price, int discountedPrice, String description, String trader, TreeSet<String> categoryTree){
		int temp = productName.hashCode();
		if(temp < 0)	temp = -temp;

		this.id = String.valueOf(temp);
		this.productName = productName;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.description = description;
		this.trader = trader;
		this.categoryTree = categoryTree;
	}

	public String getId(){
		return this.id;
	}

	public String getProductName(){
		return this.productName;
	}

	public int getPrice(){
		return this.price;
	}

	public int discountedPrice(){
		return this.discountedPrice;
	}

	public String getDescription(){
		return this.description;
	}

	public String getTrader(){
		return this.trader;
	}

	public double getDiscountPercentage(){
		return this.discountPercentage;
	}

	public boolean containsCategory(String query){
		Iterator<String> iter = this.categoryTree.iterator();
		String current;
		while(iter.hasNext()){
			current = iter.next();
			if(current.contains(query))	return true;
		}
		return false;
	}

	@Override
	public String toString(){
		String str = "";
		// str += "id;product_name;price;discounted_price;description;trader\n";
		str += this.id + ";" + this.productName + ";" + this.price + ";" + this.discountedPrice + ";" + this.description + ";" + this.description + "\n";
		str += this.categoryTree.toString() + "\n\n";
		return str;
	}

}
