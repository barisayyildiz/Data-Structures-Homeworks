package com.lib;

import com.lib.furniture.*;
import com.lib.user.*;

/**
 * Stock class
 * @author Barış Ayyıldız
 */

public class Stock {

	/**
	 * stock id
	 */
	private int id;
	/**
	 * List of furniture
	 */
	private List<Furniture> furnArr;

	/**
	 * Stock constructor
	 * @param id id
	 * @param furnArr furniture array
	 */
	public Stock(int id, List<Furniture> furnArr)
	{
		this.id = id;
		this.furnArr = furnArr;
	}

	/**
	 * Returns id
	 * @return id
	 */
	public int getId(){return id;}
	/**
	 * Returns furniture list
	 * @return furniture list
	 */
	public List<Furniture> getFurnitures(){return furnArr;}

}
