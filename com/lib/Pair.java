package com.lib;

public class Pair<E, T> 
{
	E e;
	T t;
	
	public Pair(E e, T t){
		this.e = e;
		this.t = t;
	}

	public E getKey(){
		return this.e;
	}

	public T getValue(){
		return this.t;
	}

	@Override
	public String toString(){
		return String.valueOf(this.e + " : " + this.t);
	}
	
}
