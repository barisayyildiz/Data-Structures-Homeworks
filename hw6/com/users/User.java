package com.users;

import com.ecommerce.*;

import java.util.LinkedList;

/**
 * @author Barış Ayyıldız
 */

 /**
	* User class, superclass of Trader and Customer
  */
public class User {
	private int id;
	private String name;
	private String password;
	protected LinkedList<Order> orders;

	/**
	 * User constructor
	 * @param id user id
	 * @param password user password
	 */
	public User(int id, String password){
		this.id = id;
		this.password = password;
		this.orders = null;
		this.name = ECommerce.getUserName(id);
	}

	/**
	 * Returns the user id
	 * @return User id
	 */
	public int getId(){
		return this.id;
	}

	/**
	 * Returns the user name
	 * @return User name
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * Returns the user password
	 * @return User password
	 */
	public String getPassword(){
		return this.password;
	}

	/**
	 * Sets the id with the id
	 * @param id User id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * Sets the name with the name
	 * @param name User name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Sets the password with the password
	 * @param password User password
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 * Returns string representation of User object
	 * @return String representation of User object
	 */
	@Override
	public String toString(){
		return "id : " + this.id + ", name : " + this.name;
	}

}
