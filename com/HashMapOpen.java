package com;

public class HashMapOpen<K extends Comparable<K>,V> implements KWHashMap<K,V> 
{
	private int size;
	private int cap;
	private final double loadFactor = 0.75;
	private final int INIT_CAP = 5;
	private Node<K,V>[] arr; // circular array

	@SuppressWarnings("unchecked")
	public HashMapOpen(){
		this.size = 0;
		this.cap = INIT_CAP;
		this.arr = new Node[this.cap];
	}

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

	public V put(K key, V value){

		int index = this.hash(key);

		if(index >= this.cap || index < 0)	return null;

		if(this.arr[index] == null){
			this.arr[index] = new Node<K,V>(key,value);
		}else{

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

			}
		}

		this.size++;

		if( ((double)this.size / this.cap) > loadFactor ){
			this.rehash();
		}

		return value;


	}

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

	public boolean isEmpty(){
		return this.size == 0;
	}

	public int size(){
		return this.size;
	}

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

		for(int i=0; i<this.cap; i++){
			if(this.arr[i] == null)	continue;
			str += this.arr[i].getKey() + ":" + this.arr[i].getValue() + ",";
		}

		str += "}";
		return str;
	}



	private class Node<K extends Comparable<K>,V> implements Comparable<Node<K,V>>
	{
		private K key;
		private V value;
		private int next;

		public Node(K key, V value){
			this.key = key;
			this.value = value;
			this.next = -1;
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

		public int getNext(){
			return this.next;
		}

		public void setNext(int next){
			this.next = next;
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
