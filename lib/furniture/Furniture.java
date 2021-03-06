package lib.furniture;

import lib.*;

public class Furniture {

	private int id;
	private int modelId;
	private Type type;
	private Color color;
	private Branch branch;
	private int amount;

	public Furniture(int id, int modelId, Type type, Color color, Branch branch, int amount)
	{
		this.id = id;
		this.modelId = modelId;
		this.type = type;
		this.color = color;
		this.branch = branch;
		this.amount = amount;
	}

	@Override
	public String toString()
	{
		// return this.id + "\t" + this.modelId + "\t" + this.type + "\t" + this.color + "\t\t" + this.amount + "\n";
		return this.id + "\t" + this.modelId + "\t" + this.type + "\t" + this.color;
	}

	public int getTotal(){return amount;}

}
