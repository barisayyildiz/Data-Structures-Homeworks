package com;

import java.util.HashMap;

public class MapIterator<K,V> extends HashMap<K,V>
{
	private int counter;
	private K[] keyArr;
	private K initialKey;
	private boolean setInitial;

	public MapIterator(){
		super();
		this.counter = 0;
		this.setKeyArray();

		this.setInitial = false;
	}

	public MapIterator(K key){
		super();
		this.counter = 0;
		this.setKeyArray();

		this.initialKey = key;
		this.setInitial = true;

	}

	@SuppressWarnings("unchecked")
	private void setKeyArray(){
		this.keyArr = (K[])keySet().toArray();
		
		if(this.setInitial){
			K temp;
			for(int i=0; i<size(); i++){
				if(this.keyArr[i].equals(this.initialKey)){
					// swap the values
					temp = this.keyArr[0];
					this.keyArr[0] = this.initialKey;
					this.keyArr[i] = temp;
					break;
				}
			}
		}

	}

	public boolean hasNext(){
		return this.counter < size();
	}

	public K next(){
		this.setKeyArray();
		return this.keyArr[this.counter++];
	}
	
	public K prev(){
		this.setKeyArray();
		return this.keyArr[--this.counter];
	}

}

