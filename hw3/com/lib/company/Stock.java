package com.lib.company;

import com.collections.HybridList;
import com.lib.furniture.*;
import com.lib.packageUser.*;

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
	private HybridList<Furniture> furnArr;

	/**
	 * Stock constructor
	 * @param id id
	 * @param furnArr furniture array
	 */
	public Stock(int id, HybridList<Furniture> furnArr)
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
	public HybridList<Furniture> getFurnitures(){return furnArr;}

}
