package com;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class HashMapTree<K extends Comparable<K>,V> implements KWHashMap<K,V> 
{
	private int size;
	private int cap;
	private final double loadFactor = 1.5;
	private final int INIT_CAP = 5;
	private TreeSet<Node<K,V>>[] arr;

	@SuppressWarnings("unchecked")
	public HashMapTree(){
		this.size = 0;
		this.cap = INIT_CAP;
		this.arr = (TreeSet<Node<K,V>>[]) new TreeSet<?>[this.cap];
	}

	public V get(Object key){

		K myKey = (K)key;
		if(myKey == null) return null;

		int index = this.hash(myKey);

		if(index >= this.cap || index < 0)	return null;

		Iterator<Node<K,V>> iter = this.arr[index].iterator();
		Node<K,V> current;

		while(iter.hasNext()){
			current = iter.next();
			if(current.getKey() == myKey){
				return current.getValue();
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public V put(K key, V value){

		int index = this.hash(key);

		if(index >= this.cap || index < 0)	return null;

		if(this.arr[index] == null){
			this.arr[index] = new TreeSet<Node<K,V>>();
		}
		this.arr[index].add(new Node<K,V>(key,value));

		this.size++;

		if( ((double)this.size / this.cap) > loadFactor ){
			this.rehash();
		}

		return value;


	}

	public V remove(Object key){

		K myKey = (K)key;
		if(myKey == null) return null;

		int index = this.hash(myKey);

		if(index >= this.cap || index < 0 || this.arr[index] == null)	return null;

		Iterator<Node<K,V>> iter = this.arr[index].iterator();
		Node<K,V> current;
		V value;
		int counter = 0;

		while(iter.hasNext()){
			current = iter.next();
			if(current.getKey() == myKey){
				value = current.getValue();
				// this.arr[index].remove(counter);
				this.arr[index].remove(new Node<K,V>(current.getKey(), current.getValue()));
				return value;
			}
			counter++;
		}

		return null;
	}

	public boolean isEmpty(){
		return this.size == 0;
	}

	public int size(){
		return this.size;
	}

	@SuppressWarnings("unchecked")
	private void rehash(){
		Iterator<Node<K,V>> iter;
		Node<K,V> current;
		int index;

		TreeSet<Node<K,V>>[] temp = (TreeSet<Node<K,V>>[]) new TreeSet<?>[this.cap*2+1];
			

		for(int i=0; i<this.cap; i++){
			if(this.arr[i] == null || this.arr[i].size() == 0)	continue;

			iter = this.arr[i].iterator();

			while(iter.hasNext()){
				current = iter.next();
				index = this.hash(current.getKey());

				if(temp[i] == null){
					temp[i] = new TreeSet<Node<K,V>>();
				}

				temp[i].add(new Node<K,V>(current.getKey(), current.getValue()));
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



	private class Node<K extends Comparable<K>,V> implements Comparable<Node<K,V>>
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

		public int compareTo(Node<K,V> node){
			return this.key.compareTo(node.getKey());
		}

		@Override
		public boolean equals(Object obj){
			Node<K,V> temp = (Node<K,V>)obj;

			if(temp == null)	return false;

			if(this.key.compareTo(temp.getKey()) == 0)	return true;
			return false;
		}

	}






}
