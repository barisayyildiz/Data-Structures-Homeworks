package com;

import java.util.HashMap;

public class MapIterator<K,V> extends HashMap<K,V>
{
	private int counter;

	public MapIterator(){
		super();
		this.counter = 0;
	}

	public boolean hasNext(){
		return this.counter < size();
	}

	@SuppressWarnings("unchecked")
	public K next(){
		K[] temp = (K[])keySet().toArray();
		return temp[this.counter++];
	}

	@SuppressWarnings("unchecked")
	public K prev(){
		K[] temp = (K[])keySet().toArray();
		return temp[--this.counter];
	}

	
}
