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
	private String categoryString;

	public Product(String id, String productName, String categoryString, int price, int discountedPrice, String description, String trader){
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.description = description;
		this.trader = trader;
		this.categoryString = categoryString;
		this.discountPercentage = ((this.price - this.discountedPrice) / (double)this.price) * 100;

		this.categoryTree = new TreeSet<String>();
		categoryString = categoryString.replace("\"", "").replace("[", "").replace("]", "");		
		String[] tokens = categoryString.split(" >> ");
		for(String str : tokens){
			this.categoryTree.add(str);
		}
	}
	 
	public Product(String productName, String categoryString, int price, int discountedPrice, String description, String trader){
		int temp = productName.hashCode();
		if(temp < 0)	temp = -temp;

		this.id = String.valueOf(temp);
		this.productName = productName;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.description = description;
		this.trader = trader;
		this.categoryString = categoryString;
		this.discountPercentage = ((this.price - this.discountedPrice) / (double)this.price) * 100;

		this.categoryTree = new TreeSet<String>();
		categoryString = categoryString.replace("\"", "").replace("[", "").replace("]", "");		
		String[] tokens = categoryString.split(" >> ");
		for(String str : tokens){
			this.categoryTree.add(str);
		}

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

	public TreeSet<String> getCategoryTree(){
		return this.categoryTree;
	}

	public String getCategoryString(){
		return this.categoryString;
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
		// String str = "";
		// // str += "id;product_name;price;discounted_price;description;trader\n";
		// str += this.id + ";" + this.productName + ";" + this.price + ";" + this.discountedPrice + ";" + this.description + ";" + this.description + "\n";
		// str += this.categoryTree.toString() + "\n\n";
		// return str;

		String str = "";

		str += "Id :\t" + this.id + "\n";
		str += "Name : \t" + this.productName + "\n";
		str += "Category Tree :\t" + this.categoryString.replace("\"", "").replace("[", "").replace("]", "") + "\n";
		str += "Price :\t" + this.price + "\n";
		str += "Discounted Price :\t" + this.discountedPrice + "\n";
		str += "Discount Percentage :\t" + this.discountPercentage + "%\n";
		str += "Description : \t" + this.description + "\n";
		str += "Trader :\t" + this.trader + "\n\n";

		return str;

	}

}
