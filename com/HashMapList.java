package com;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class HashMapList<K,V> implements KWHashMap<K,V> 
{
	private int size;
	private int cap;
	private final double loadFactor = 3.0;
	private final int INIT_CAP = 5;
	private LinkedList<Node<K,V>>[] arr;

	public HashMapList(){
		this.size = 0;
		this.cap = INIT_CAP;
		this.arr = (LinkedList<Node<K,V>>[]) new LinkedList<?>[this.cap];
	}

	public V get(K key){
		int index = this.hash(key);

		if(index >= this.cap || index < 0)	return null;

		Iterator<Node<K,V>> iter = this.arr[index].iterator();
		Node<K,V> current;

		while(iter.hasNext()){
			current = iter.next();
			if(current.getKey() == key){
				return current.getValue();
			}
		}

		return null;
	}

	public V put(K key, V value){

		int index = this.hash(key);

		if(index >= this.cap || index < 0)	return null;

		if(this.arr[index] == null){
			this.arr[index] = new LinkedList<Node<K,V>>();
		}
		this.arr[index].addLast(new Node(key,value));

		this.size++;

		if( ((double)this.size / this.cap) > loadFactor ){
			this.rehash();
		}

		return value;


	}

	public boolean isEmpty(){
		return this.size == 0;
	}

	public int size(){
		return this.size;
	}

	private void rehash(){
		Iterator<Node<K,V>> iter;
		Node<K,V> current;
		int index;

		LinkedList<Node<K,V>>[] temp = (LinkedList<Node<K,V>>[]) new LinkedList<?>[this.cap*2+1];
			

		for(int i=0; i<this.cap; i++){
			if(this.arr[i] == null || this.arr[i].size() == 0)	continue;

			iter = this.arr[i].iterator();

			while(iter.hasNext()){
				current = iter.next();
				index = this.hash(current.getKey());

				if(temp[i] == null){
					temp[i] = new LinkedList<Node<K,V>>();
				}

				temp[i].addLast(new Node(current.getKey(), current.getValue()));
			}

		}

		this.arr = temp;
		this.cap *= 2 + 1;

	}


	private int hash(K key){
		int index = key.hashCode() % this.cap;
		if(index < 0){
			index += this.cap;
		}
		return index;
	}

	@Override
	public String toString(){
		String str = "{";

		Iterator<Node<K,V>> iter;
		Node<K,V> current;

		for(int i=0; i<this.cap; i++){
			if(this.arr[i] == null)	continue;

			iter = this.arr[i].iterator();

			while(iter.hasNext()){
				current = iter.next();
				str += current.getKey() + ":" + current.getValue() + ",";
			}
		}
		
		str += "}";
		return str;
	}



	private class Node<K,V>
	{
		private K key;
		private V value;

		public Node(K key, V value){
			this.key = key;
			this.value = value;
		}

		public K getKey(){
			return this.key;
		}

		public V getValue(){
			return this.value;
		}

		public void setKey(K key){
			this.key = key;
		}

		public void setValue(V value){
			this.value = value;
		}
	}






}
