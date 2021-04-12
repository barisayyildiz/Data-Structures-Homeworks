package com.collections;

import java.util.ListIterator;

public class HybridList<E>{

	private KWLinkedList< KWArrayList<E> > linkedList;
	private static int MAX_NUMBER = 10;
	private int size;

	public HybridList()
	{
		this.linkedList = new KWLinkedList< KWArrayList<E> >();
		this.size = 0;
	}

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


	public int size()
	{
		return this.size;
	}

	public E get(int index) throws IndexOutOfBoundsException
	{
		if(index > this.size || index < 0)
			throw new IndexOutOfBoundsException("Index is out of bound...");

		int row = index / MAX_NUMBER;
		int col = index % MAX_NUMBER;

		return this.linkedList.get(row).get(col);
	}

	@Override
	public String toString()
	{
		return this.linkedList.toString();
	}

	
}
