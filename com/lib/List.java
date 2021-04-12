package com.lib;

import java.lang.reflect.Array;

import com.lib.furniture.*;
import com.lib.user.*;

/**
 * List class that implements ListInterface
 * @param <T> generic T type
 */

public class List<T> implements ListInterface<T> {

	/**
	 * size of the array
	 */
	private int size;
	/**
	 * capacity of the array
	 */
	private int cap;
	/**
	 * actual array that we use as I data structure
	 */
	private T[] arr;

	/**
	 * List constructor
	 */
	public List()
	{
		this.size = 0;
		this.cap = 10;
		// this.arr = new T[this.cap];
		this.arr = (T[]) new Object[this.cap];
	}

	/**
	 * List constructor with initial cap
	 */
	public List(int cap)
	{
		this.size = 0;
		this.cap = cap;
		// this.arr = new T[this.cap];
		this.arr = (T[]) new Object[this.cap];
	}

	@Override
	public boolean add(T val)
	{
		if(this.size == this.cap)
		{
			// T[] temp = new T[this.cap+10];
			T[] temp = (T[]) new Object[this.cap+10];

			for(int i=0; i<this.cap; i++)
			{
				temp[i] = arr[i];
			}

			this.arr = temp;
			this.cap += 10;
		}

		this.arr[this.size++] = val;

		return true;

	}

	@Override
	public T remove(int index) throws ArrayIndexOutOfBoundsException
	{
		if(index < 0 || index >= this.size)
			throw new ArrayIndexOutOfBoundsException();

		T[] temp = (T[]) new Object[this.cap];
		T val = this.arr[index];

		for(int i=0, k=0; i<this.size; i++)
		{
			if(i == index)
				continue;

			temp[k++] = this.arr[i];
		}
		
		this.arr = temp;
		this.size--;

		return val;

	}

	@Override
	public T get(int index) throws ArrayIndexOutOfBoundsException
	{
		if(index >= this.size || index < 0)
			throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
		return this.arr[index];
	}

	public T set(int index, T val) throws ArrayIndexOutOfBoundsException
	{
		if(index >= this.size || index < 0)
			throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
		
		T oldVal = this.arr[index];
		this.arr[index] = val;

		if(val == null)
		{
			this.size--;
		}

		return oldVal;

	}

	@Override
	public int size(){return size;}

	@Override
	public String toString()
	{
		String str = "";

		for(int i=0; i<this.size; i++)
		{
			str += String.valueOf(this.arr[i]) + " ";
		}

		return str;
	}

}
