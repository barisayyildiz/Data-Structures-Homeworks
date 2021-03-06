package com.users;

import com.ecommerce.*;

import java.util.*;

/**
 * @author Barış Ayyıldız
 */

 /**
	* Trader class, represents a trader in the ECommerce application
	* Extends from User and implements UserInterface
  */
public class Trader extends User implements UserInterface{
	
	/**
	 * Trader constructor
	 * @param id trader id
	 * @param password trader password
	 */
	public Trader(int id, String password){
		super(id, password);
	}

	/**
	 * Prints all the products of the trader
	 */
	public void showAllProducts(){
		ArrayList<Product> products = ECommerce.getAllProducts(this.getName());

		Iterator<Product> iter = products.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	/**
	 * Creates a product and sends it as a parameter to ECommerce.addProduct method, where it will be written on orders.txt
	 * @param productName
	 * @param description
	 * @param price
	 * @param discountedPrice
	 * @param categoryTree
	 */
	public void addProduct(String productName, String description, int price, int discountedPrice, String categoryTree){

		categoryTree = "\"[\"\"" + categoryTree + "\"\"]";

		ECommerce.addProduct(new Product(productName, categoryTree, price, discountedPrice, description, this.getName()));

	}

	/**
	 * Removes the product by the product id
	 * @param id prodcut id
	 */
	public void removeProduct(String id){
		ECommerce.removeProduct(id, this);
	}

	/**
	 * Edits a prodcut's description
	 * @param id product id
	 * @param description product description
	 */
	public void editProduct(String id, String description){
		ECommerce.editProduct(id, description, this);
	}

	private void syncOrders(){
		this.orders = ECommerce.getOrders(this.getName(), true);
	}

	/**
	 * Prints all the orders of the trader
	 */
	@Override
	public void getOrders(){
		this.syncOrders();
		Iterator<Order> iter = this.orders.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	/**
	 * Meets the first order in the list
	 */
	public void meetOrder(){

		this.syncOrders();
		if(this.orders.size() == 0)	return;

		ECommerce.updateOrders(this.orders.getFirst(), OrderState.ACCEPTED);
		this.orders.poll();
	}

	/**
	 * Cancels the first order in the list
	 */
	public void cancelOrder(){
		
		this.syncOrders();
		if(this.orders.size() == 0)	return;

		ECommerce.updateOrders(this.orders.getFirst(), OrderState.CANCELLED);
		this.orders.poll();
	}


	/**
	 * Returns string representation of Trader object
	 * @return String representation of Trader object
	 */
	@Override
	public String toString(){
		return super.toString() + ", trader";
	}


}
