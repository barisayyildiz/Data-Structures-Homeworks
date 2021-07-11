package com;

import java.util.HashMap;

/**
 * @author Barış Ayyıldız
 * MapIterator that extends HashMap
 */

/**
 * @param K key type, it should be compareable
 * @param V value type
 */
public class MapIterator<K,V> extends HashMap<K,V>
{
	/** cursor of the iterator */
	private int counter;
	/** array of key values */
	private K[] keyArr;
	/** initialKey */
	private K initialKey;
	/** true, if the initial key is set by the user */
	private boolean setInitial;

	/**
	 * zero parameter constructor
	 */
	public MapIterator(){
		super();
		this.counter = 0;
		this.setInitial = false;
		
		this.setKeyArray();

	}

	/**
	 * one parameter constructor, sets the initialKey to key
	 * @param key key
	 */
	public MapIterator(K key){
		super();
		this.counter = 0;
		this.initialKey = key;
		this.setInitial = true;

		this.setKeyArray();


	}

	/**
	 * sets key array
	 */
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

	/**
	 * returns true if iterator hasn't exceeded the size of the hashmap
	 * @return true if iterator hasn't exceeded the size of the hashmap
	 */
	public boolean hasNext(){
		return this.counter < size();
	}

	/**
	 * returns the next key
	 * @return next key
	 */
	public K next(){

		if(this.counter == size()) this.counter = 0;

		this.setKeyArray();
		return this.keyArr[this.counter++];
	}
	
	/**
	 * returns the prev key
	 * @return prev key
	 */
	public K prev(){
		if(this.counter == 0) this.counter = size();

		this.setKeyArray();
		return this.keyArr[--this.counter];
	}

}

