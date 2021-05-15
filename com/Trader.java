package com;

import java.util.*;

public class Trader extends User {
	
	public Trader(int id, String name, String password){
		super(id, name, password);

	}

	public String showAllProducts(){
		ArrayList<Product> products = ECommerce.getAllProducts(this.getName());

		return products.toString();
	}

	public void addProduct(String productName, String description, int price, int discountedPrice){

		ECommerce.addProduct(new Product(productName, price, discountedPrice, description, this.getName()));
	}

	public void removeProduct(String id){
		ECommerce.removeProduct(id);
	}


}
