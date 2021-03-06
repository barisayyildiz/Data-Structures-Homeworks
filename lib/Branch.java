package lib;

import lib.furniture.*;
import lib.user.*;

public class Branch 
{
	private int branchId;
	private int stockIndex;

	public Branch(int id, int stockIndex)
	{
		this.branchId = id;
		this.stockIndex = stockIndex;

	}

	public int getBranchId(){return branchId;}
	public int getStockIndex(){return stockIndex;}

}
