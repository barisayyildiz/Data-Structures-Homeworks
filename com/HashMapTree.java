package com;

import java.util.TreeSet;
import java.util.Iterator;

/**
 * @author Barış Ayyıldız
 * 
 * HashMapTree
 * HashMap that is implemented with a TreeSet
 * part-2
 * 
 */

/**
 * @param K key type, it should be compareable
 * @param V value type
 */
public class HashMapTree<K extends Comparable<K>,V> implements KWHashMap<K,V> 
{
	// data fields

	/** number of elements in the hashmap */
	private int size;
	/** size of the treeset */
	private int cap;
	/** maximum loadfactor */
	private final double loadFactor = 1.5;
	/** initial capacity */
	private final int INIT_CAP = 5;
	/** node's of treeset */
	private TreeSet<Node<K,V>>[] arr;

	/**
	 * zero parameter constructor
	 */
	@SuppressWarnings("unchecked")
	public HashMapTree(){
		this.size = 0;
		this.cap = INIT_CAP;
		this.arr = (TreeSet<Node<K,V>>[]) new TreeSet<?>[this.cap];
	}

	/**
	 * returns the value with the matching key
	 * @param key key parameter
	 * @return null if the key's data type is not K or not found in the hashmap, if it is found returns the matching value
	 */
	@SuppressWarnings("unchecked")
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

	/**
	 * puts key,value pair to the hashmap
	 * @param key key
	 * @param value value
	 */
	public V put(K key, V value){

		Iterator<Node<K,V>> iter;

		int index = this.hash(key);

		if(index >= this.cap || index < 0)	return null;

		if(this.arr[index] == null){
			this.arr[index] = new TreeSet<Node<K,V>>();
		}

		iter = this.arr[index].iterator();
		while(iter.hasNext()){
			if(iter.next().getKey().equals(key)) return null;
		}

		this.arr[index].add(new Node<K,V>(key,value));

		this.size++;

		if( ((double)this.size / this.cap) > loadFactor ){
			this.rehash();
		}

		return value;


	}

	/**
	 * removes the key,value pair based on the parameter key
	 * @param key key
	 * @return deleted value, or null if it is not deleted
	 */
	@SuppressWarnings("unchecked")
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

	/**
	 * checks if the hashmap is empty
	 * @return true if the hashmap is empty
	 */
	public boolean isEmpty(){
		return this.size == 0;
	}

	/**
	 * returns the number of elements in the hashmap
	 * @return number of elements in the hashmap
	 */
	public int size(){
		return this.size;
	}

	/**
	 * does rehashing when it is needed
	 */
	@SuppressWarnings("unchecked")
	private void rehash(){
		Iterator<Node<K,V>> iter;
		Node<K,V> current;
		int index;

		int oldCap = this.cap;
		this.cap = 2*this.cap+1;

		TreeSet<Node<K,V>>[] temp = (TreeSet<Node<K,V>>[]) new TreeSet<?>[this.cap];
			

		for(int i=0; i<oldCap; i++){
			if(this.arr[i] == null || this.arr[i].size() == 0)	continue;

			iter = this.arr[i].iterator();

			while(iter.hasNext()){
				current = iter.next();
				index = this.hash(current.getKey());

				if(temp[index] == null){
					temp[index] = new TreeSet<Node<K,V>>();
				}

				temp[index].add(new Node<K,V>(current.getKey(), current.getValue()));
			}

		}

		this.arr = temp;

	}

	/**
	 * gets a key and hashes it and returns the index
	 * @param key key
	 * @return hashed index
	 */
	private int hash(K key){
		int index = key.hashCode() % this.cap;
		if(index < 0){
			index += this.cap;
		}
		return index;
	}

	/**
	 * returns the string representation of the hasmap
	 * @return string representation of the hasmap 
	 */
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


	/**
	 * Node, private inner class. Holds a key value pair
	 * @param <K> key, should be compareable
	 * @param <V> value
	 */
	private class Node<K extends Comparable<K>,V> implements Comparable<Node<K,V>>
	{
		/** key */
		private K key;
		/** value */
		private V value;

		/**
		 * constructor
		 * @param key key
		 * @param value value
		 */
		public Node(K key, V value){
			this.key = key;
			this.value = value;
		}

		/**
		 * returns the key
		 * @return key
		 */
		public K getKey(){
			return this.key;
		}

		/**
		 * returns the value
		 * @return value
		 */
		public V getValue(){
			return this.value;
		}

		/**
		 * sets the key with key parameter
		 * @param key key
		 */
		public void setKey(K key){
			this.key = key;
		}

		/**
		 * sets the value with value parameter
		 * @param value value
		 */
		public void setValue(V value){
			this.value = value;
		}

		/**
		 * overriden compareTo method
		 * @return result of the key's compareto method
		 */
		public int compareTo(Node<K,V> node){
			return this.key.compareTo(node.getKey());
		}

		/**
		 * overriden equals method
		 * @return true if the keys are the same
		 */
		@Override
		public boolean equals(Object obj){
			Node<K,V> temp = (Node<K,V>)obj;

			if(temp == null)	return false;

			if(this.key.compareTo(temp.getKey()) == 0)	return true;
			return false;
		}

	}






}
