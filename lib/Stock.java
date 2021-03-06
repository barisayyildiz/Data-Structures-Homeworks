package lib;

import lib.furniture.*;
import lib.user.*;

public class Stock {

	private int id;
	private List<Furniture> furnArr;

	public Stock(int id, List<Furniture> furnArr)
	{
		this.id = id;
		this.furnArr = furnArr;
	}


	public int getId(){return id;}
	public List<Furniture> getFurnitures(){return furnArr;}

}
