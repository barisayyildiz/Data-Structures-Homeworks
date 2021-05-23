package com;

import java.util.LinkedList;

public class User {
	private int id;
	private String name;
	private String password;
	protected LinkedList<Order> orders;
	
	public User(int id, String name, String password){
		this.id = id;
		this.name = name;
		this.password = password;
		this.orders = null;
	}

	public User(int id, String password){
		this.id = id;
		this.password = password;
		this.orders = null;
		this.name = ECommerce.getUserName(id);
	}

	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}

}
