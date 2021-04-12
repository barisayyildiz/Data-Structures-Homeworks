package com.lib.furniture;

import com.lib.*;

/**
 * Furniture class
 * @author Barış Ayyıldız
 */

public class Furniture {

	private int id;
	private int modelId;
	private Type type;
	private Color color;
	private Branch branch;
	private int amount;

	/**
	 * Furniture constructor
	 * @param id id of the furniture
	 * @param modelId model if of the furniture
	 * @param type type of the furniture
	 * @param color color of the furniture
	 * @param branch branch of the furniture
	 * @param amount amount of the furniture
	 */
	public Furniture(int id, int modelId, Type type, Color color, Branch branch, int amount)
	{
		/**
		 * id of the furniture
		 */
		this.id = id;
		/**
		 * model id of the furniture
		 */
		this.modelId = modelId;
		/**
		 * type of the furniture
		 */
		this.type = type;
		/**
		 * color of the furniture
		 */
		this.color = color;
		/**
		 * branch of the furniture that it belongs to
		 */
		this.branch = branch;
		/**
		 * amount of this furniture in the branch
		 */
		this.amount = amount;
	}

	/**
	 * Returns a string representation of a Furniture object
	 * @return string representation of a Furniture object
	 */
	@Override
	public String toString()
	{
		return this.id + "\t" + this.modelId + "\t" + this.type + "\t" + this.color;
	}

	/**
	 * Returns the amount of furniture
	 * @return amount of furniture
	 */
	public int getTotal(){return this.amount;}
	/**
	 * Sets the amount of furniture
	 * @param val amount of furniture
	 */
	public void setTotal(int val){this.amount = val;}
	/**
	 * Returns the model id of the furniture
	 * @return model id of the furniture
	 */
	public int getModelId(){return this.modelId;}
	/**
	 * Returns the type of the furniture
	 * @return type of the furniture
	 */
	public Type getType(){return this.type;}
	/**
	 * Returns the color of the furniture
	 * @return color of the furniture
	 */
	public Color getColor(){return this.color;}

	/**
	 * Returns the branch of the furniture
	 * @return branch of the furniture
	 */
	public Branch getBranch(){return this.branch;}

}
