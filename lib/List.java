package lib;

import lib.furniture.*;
import lib.user.*;

public class List<T> implements ListInterface<T> {

	private int size;
	private int cap;
	private T[] arr;

	public List()
	{
		this.size = 0;
		this.cap = 10;
		// this.arr = new T[this.cap];
		this.arr = (T[]) new Object[this.cap];
	}

	public List(int cap)
	{
		this.size = 0;
		this.cap = cap;
		// this.arr = new T[this.cap];
		this.arr = (T[]) new Object[this.cap];
	}

	public void insert(T val)
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

	}

	public void remove(int index)
	{
		if(index < 0 || index >= this.size)
			throw new ArrayIndexOutOfBoundsException();

		T[] temp = (T[]) new Object[this.size-1];

		for(int i=0, k=0; i<this.size; i++)
		{
			if(i == index)
				continue;

			temp[k++] = this.arr[i];
		}
		
		this.arr = temp;
		this.size--;

	}

	public int length(){return size;}

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
