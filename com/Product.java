package com;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Barış Ayyıldız
 */

 /**
	* Product class that is used in ECommerce App 
  */
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

	/**
	 * Product constructor
	 * @param id product's id
	 * @param productName product name
	 * @param categoryString product category string
	 * @param price product price
	 * @param discountedPrice product discounted price
	 * @param description products description
	 * @param trader product trader name
	 */
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
	
	/**
	 * Product constructor without product id, id is generated inside constructor
	 * @param productName product name
	 * @param categoryString product category string
	 * @param price product price
	 * @param discountedPrice product discounted price
	 * @param description products description
	 * @param trader product trader name
	 */
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

	/**
	 * Returns the product id
	 * @return Product id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * Returns the product name
	 * @return Product name
	 */
	public String getProductName(){
		return this.productName;
	}

	/**
	 * Returns the product price
	 * @return Product price
	 */
	public int getPrice(){
		return this.price;
	}

	/**
	 * Returns the discounted price
	 * @return Discounted price
	 */
	public int discountedPrice(){
		return this.discountedPrice;
	}

	/**
	 * Returns the product description
	 * @return Product description
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * Returns product trader name
	 * @return Product trader name
	 */
	public String getTrader(){
		return this.trader;
	}

	/**
	 * Returns product discount percentage
	 * @return Product discount percentage
	 */
	public double getDiscountPercentage(){
		return this.discountPercentage;
	}

	/**
	 * Returns the product category tree
	 * @return category tree
	 */
	public TreeSet<String> getCategoryTree(){
		return this.categoryTree;
	}

	/**
	 * Returns the category string
	 * @return category string
	 */
	public String getCategoryString(){
		return this.categoryString;
	}

	/**
	 * Returns true if the given query is in the category tree
	 * @param query query given by the user
	 * @return true if the given query is in the category tree
	 */
	public boolean containsCategory(String query){
		Iterator<String> iter = this.categoryTree.iterator();
		String current;
		while(iter.hasNext()){
			current = iter.next();
			if(current.contains(query))	return true;
		}
		return false;
	}

	/**
	 * Returns the string representation of the Product object
	 * @return String representation of the Product object
	 */
	@Override
	public String toString(){
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
