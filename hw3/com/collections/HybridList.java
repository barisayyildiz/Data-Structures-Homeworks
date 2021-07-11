package com.collections;

import java.util.ListIterator;


/**
 * Class HybridList, that uses KWLinkedList and KWArrayList as data field
 */

public class HybridList<E>{

	// Data Fields
	/** Linked list that holds KWArrayList<E> */
	private KWLinkedList< KWArrayList<E> > linkedList;

	/** Maximum capacity that a single KWArrayList<E> element can have */
	private static int MAX_NUMBER = 10;

	/** Size of the linked list */
	private int size;

	/**
	 * Constructor of HybridList
	 */
	public HybridList()
	{
		this.linkedList = new KWLinkedList< KWArrayList<E> >();
		this.size = 0;
	}

	/**
	 * Adds new element to the last arraylist in the linkedlist
	 * @param e - New element with the generic type E
	 * @return - true if successfull
	 */
	public boolean add(E e)
	{
		KWArrayList<E> lastArr = this.linkedList.getLast();

		if(lastArr == null)
		{
			this.linkedList.add(new KWArrayList<E>());
			lastArr = this.linkedList.getLast();
		}else if(lastArr.size() == MAX_NUMBER)
		{
			this.linkedList.add(new KWArrayList<E>());
			lastArr = this.linkedList.getLast();
		}

		lastArr.add(e);
		this.size++;
		return true;
	}

	/**
	 * Returns the size of the linkedlist
	 * @return - The size
	 */
	public int size()
	{
		return this.size;
	}

	/**
	 * Return the value in the specific index
	 * @param index Index value
	 * @return - Value in the index
	 */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if(index > this.size || index < 0)
			throw new IndexOutOfBoundsException("Index is out of bound...");

		int row = index / MAX_NUMBER;
		int col = index % MAX_NUMBER;

		return this.linkedList.get(row).get(col);
	}

	/**
	 * Returns the string representation of the HybridList
	 * @return String representation of the HybridList
	 */

	@Override
	public String toString()
	{
		return this.linkedList.toString();
	}

	
}
