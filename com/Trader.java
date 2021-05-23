package com;

import java.util.*;

public class Trader extends User implements UserInterface{
	
	public Trader(int id, String name, String password){
		super(id, name, password);
	}

	public Trader(int id, String password){
		super(id, password);
	}

	public void showAllProducts(){
		ArrayList<Product> products = ECommerce.getAllProducts(this.getName());

		Iterator<Product> iter = products.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public void addProduct(String productName, String description, int price, int discountedPrice, String categoryTree){

		categoryTree = "\"[\"\"" + categoryTree + "\"\"]";

		ECommerce.addProduct(new Product(productName, categoryTree, price, discountedPrice, description, this.getName()));

	}

	public void removeProduct(String id){
		ECommerce.removeProduct(id);
	}

	public void editProduct(String id, String description){
		ECommerce.editProduct(id, description);
	}

	private void syncOrders(){
		this.orders = ECommerce.getOrders(this.getName(), true);
		System.out.println(this.orders == null);
	}

	public void getOrders(){
		this.syncOrders();
		Iterator<Order> iter = this.orders.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public void meetOrder(){

		ECommerce.updateOrders(this.orders.getFirst(), OrderState.ACCEPTED);
		this.orders.poll();
	}

	public void cancelOrder(){

		ECommerce.updateOrders(this.orders.getFirst(), OrderState.CANCELLED);
		this.orders.poll();
	}


}
