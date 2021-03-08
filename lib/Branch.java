package lib;

import lib.furniture.*;
import lib.user.*;

/**
 * Branch class
 * @author Barış Ayyıldız
 */

public class Branch 
{
	private int branchId;
	private int stockIndex;

	/**
	 * Branch constructor
	 * @param id id
	 * @param stockIndex stock index
	 */
	public Branch(int id, int stockIndex)
	{
		this.branchId = id;
		this.stockIndex = stockIndex;

	}

	/**
	 * Returns branch id
	 * @return branch id
	 */
	public int getBranchId(){return branchId;}
	/**
	 * Returns stock index
	 * @return stock index
	 */
	public int getStockIndex(){return stockIndex;}

}
