package com.lib;

/**
 * Pair class, holds a key-value pair
 * @param <E> Generic key
 * @param <T> Generic value
 */

public class Pair<E, T> 
{
	/** Key */
	E e;
	/** Value */
	T t;
	
	/**
	 * Constructor
	 * @param e initial key
	 * @param t initial value
	 */
	public Pair(E e, T t){
		this.e = e;
		this.t = t;
	}

	/**
	 * Return the key
	 * @return key
	 */
	public E getKey(){
		return this.e;
	}

	/**
	 * return the value
	 * @return value
	 */
	public T getValue(){
		return this.t;
	}

	/**
	 * Returns the string representation of the Pair class object
	 */
	@Override
	public String toString(){
		return String.valueOf(this.e + " : " + this.t);
	}
	
}
