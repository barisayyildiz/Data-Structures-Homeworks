package com;


/**
 * @author Barış Ayyıldız
 * 
 * HashMapOpen
 * HashMap that is implemented with the concept open addressing
 * part-2
 * 
 */

public class HashMapOpen<K extends Comparable<K>,V> implements KWHashMap<K,V> 
{
	// data fields

	/** number of elements in the hashmap */
	private int size;
	/** size of the array */
	private int cap;
	/** maximum loadfactor */
	private final double loadFactor = 0.75;
	/** initial capacity */
	private final int INIT_CAP = 5;
	/** array of node */
	private Node<K,V>[] arr; // circular array

	/**
	 * zero parameter constructor
	 */
	@SuppressWarnings("unchecked")
	public HashMapOpen(){
		this.size = 0;
		this.cap = INIT_CAP;
		this.arr = new Node[this.cap];
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

		if(index >= this.cap || index < 0 || this.arr[index] == null)	return null;
		
		int currIndex = index;

		while(true){
			
			if(this.arr[currIndex].getKey().compareTo(myKey) == 0){
				return this.arr[currIndex].getValue();
			}else if(this.arr[currIndex].getNext() != -1){
				currIndex = this.arr[currIndex].getNext();
			}else{
				// not found
				return null;
			}
		}

	}

	/**
	 * puts key,value pair to the hashmap
	 * @param key key
	 * @param value value
	 */
	public V put(K key, V value){

		int index = this.hash(key);

		if(index >= this.cap || index < 0)	return null;

		if(this.arr[index] == null){
			this.arr[index] = new Node<K,V>(key,value);
		}else{
			
			if(this.contains(key)) return null;

			int counter = 0, incrememt = 0;
			int currIndex = index;

			while(true){
				counter++;
				incrememt = counter*counter;

				if(this.arr[(index+incrememt)%this.cap] == null){
					this.arr[currIndex].setNext((index+incrememt)%this.cap);					// orayı göster
					this.arr[(index+incrememt)%this.cap] = new Node<K,V>(key,value);	// orayı init et
					break;
				}
				
				currIndex = (index+incrememt)%this.cap;

				if(counter > this.cap/2){
					this.rehash();
					counter = 0;
					incrememt = 0;
					currIndex = index;
				}

			}
		}

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

		int currIndex = index;

		// find the node that is going to be deleted
		while(this.arr[currIndex].getKey().compareTo(myKey) != 0){
			currIndex = this.arr[currIndex].getNext();
		}

		while(true){
			int nextIndex = this.arr[currIndex].getNext();

			if(nextIndex == -1){
				V value = this.arr[currIndex].getValue();
				this.arr[currIndex] = null;
				this.size--;
				return value;
			}

			this.arr[currIndex] = this.arr[nextIndex];
			currIndex = nextIndex;

		}

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

	private boolean contains(K key){
		for(int i=0; i<this.cap; i++){
			if(this.arr[i] == null)	continue;
			if(this.arr[i].getKey().compareTo(key) == 0) return true;
		}
		return false;

	}

	/**
	 * does rehashing when it is needed
	 */
	@SuppressWarnings("unchecked")
	private void rehash(){

		Node<K,V>[] temp = new Node[this.cap*2+1];
		int index;
		int oldCap = this.cap;
		this.cap = 2*this.cap + 1;

		for(int i=0; i<oldCap; i++){
			if(this.arr[i] == null)	continue;

			index = this.hash(this.arr[i].getKey());
			
			if(temp[index] == null){
				// temp[index] = this.arr[i];
				temp[index] = new Node<K,V>(this.arr[i].getKey(), this.arr[i].getValue());
				continue;
			}

			int counter = 0, incrememt = 0;
			int currIndex = index;

			while(true){
				counter++;
				incrememt = counter*counter;

				if(temp[(index+incrememt)%this.cap] == null){
					temp[currIndex].setNext((index+incrememt)%this.cap);																						// orayı göster
					temp[(index+incrememt)%this.cap] = new Node<K,V>(this.arr[i].getKey(), this.arr[i].getValue());	// orayı init et
					break;
				}
				
				currIndex = (index+incrememt)%this.cap;

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

		for(int i=0; i<this.cap; i++){
			if(this.arr[i] == null)	continue;
			str += this.arr[i].getKey() + ":" + this.arr[i].getValue() + ",";
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
		/** next */
		private int next;

		/**
		 * constructor
		 * @param key key
		 * @param value value
		 */
		public Node(K key, V value){
			this.key = key;
			this.value = value;
			this.next = -1;
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
		 * returns the next
		 * @return next
		 */
		public int getNext(){
			return this.next;
		}

		/**
		 * sets the next with next parameter
		 * @param next next
		 */
		public void setNext(int next){
			this.next = next;
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
