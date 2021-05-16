package com;

import java.util.*;

public class Trader extends User {

	private LinkedList<Order> orders;
	
	public Trader(int id, String name, String password){
		super(id, name, password);
		this.orders = null;
	}

	public String showAllProducts(){
		ArrayList<Product> products = ECommerce.getAllProducts(this.getName());

		return products.toString();
	}

	public void addProduct(String productName, String description, int price, int discountedPrice){

		// ECommerce.addProduct(new Product(productName, price, discountedPrice, description, this.getName()));
	}

	public void removeProduct(String id){
		ECommerce.removeProduct(id);
	}

	public void editProduct(String id, String description){
		ECommerce.editProduct(id, description);
	}

	private void syncOrders(){
		this.orders = ECommerce.getOrdersTrader(this.getName());
		System.out.println(this.orders == null);
	}

	public void getOrdersTrader(){
		this.syncOrders();
		Iterator<Order> iter = this.orders.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public void meetOrder(){

		ECommerce.updateOrders(this.orders.getFirst(), OrderState.ACCEPTED);

		// this.orders.getFirst().setSOrderStatus(OrderState.ACCEPTED);
		this.orders.poll();
	}

	public void cancelOrder(){

		ECommerce.updateOrders(this.orders.getFirst(), OrderState.CANCELLED);

		// this.orders.getFirst().setSOrderStatus(OrderState.CANCELLED);
		this.orders.poll();
	}


}
