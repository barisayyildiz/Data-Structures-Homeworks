package lib;

import lib.furniture.*;
import lib.user.*;

/**
 * Stock class
 * @author Barış Ayyıldız
 */

public class Stock {

	private int id;
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
