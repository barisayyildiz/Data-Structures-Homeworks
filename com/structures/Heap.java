package com.structures;

import java.util.Iterator;

import java.util.NoSuchElementException;

import com.lib.*;

/**
 * Max-Heap class with a generic type
 * @param <E> Generic data type
 */

public class Heap<E extends Comparable<E>> implements Comparable<E>
{
	/** Initial capacity of the heap */
	private static final int INITIAL_SIZE = 8;
	
	/** Holds the current size of the heap*/
	private int size;
	/**	Holds the current capacity of the heap */
	private int cap;
	/** Used to imitate heap data structure */
	private Node<E> arr[];

	/**
	 * No parameter constructor
	 */
	@SuppressWarnings("unchecked")
	public Heap()
	{
		this.cap = INITIAL_SIZE;
		this.size = 0;
		this.arr = new Node[this.cap];
	}

	/**
	 * Adds a new item to the heap
	 * @param e items that is going to be added
	 * @return number of occurences after insertion
	 */
	public int offer(E e)
	{
		if(this.size == this.cap) this.reallocate();

		if(this.contains(e)){
			int index = this.indexOf(e);
			this.arr[index].setFreq(this.arr[index].getFreq()+1);
			return this.arr[index].getFreq();
		}

		this.arr[this.size] = new Node<E>(e);

		int child = this.size;
		int parent = (child-1)/2;
		while(true)
		{

			if(this.arr[child].compareTo(this.arr[parent].getData()) > 0){
				this.swap(child, parent);
				child = parent;
				parent = (child-1)/2;
			}else{
				break;
			}

		}

		this.size++;
		return 1;
	}

	/**
	 * Removes the root of the heap
	 * @return number of occurences after removal
	 */
	public int poll()
	{
		if(this.size == 0)
			return -1;

		if(this.arr[0].getFreq() > 1){
			this.arr[0].setFreq(this.arr[0].getFreq() - 1);
			return this.arr[0].getFreq();
		}

		Node<E> val = this.arr[0];
		this.arr[0] = this.arr[--this.size];
		int parent = 0;
		int left, right;

		while(true)
		{
			left = 2*parent + 1;

			if(left >= this.size())
				break;

			right = left+1;

			int maxChild = left;
			if(right < this.size() && this.arr[right].compareTo(this.arr[left].getData()) > 0){
				maxChild = right;
			}

			if(this.arr[parent].compareTo(this.arr[maxChild].getData()) < 0){
				this.swap(parent, maxChild);
				parent = maxChild;
			}else{
				break;
			}

		}


		return 0;
	}

	/**
	 * Retrieves but does not remove the root of the heap
	 * @return root of the heap
	 */
	public E peek()
	{
		if(this.size() == 0)	return null;
		return this.arr[0].getData();
	}

	/**
	 * Returns number of unique elements in the heap
	 * @return number of unique elements
	 */
	public int size(){
		return this.size;
	}

	/**
	 * Check if the given element is in the heap
	 * @param e Generic data type
	 * @return true, if the given element is in the heap
	 */
	public boolean contains(E e)
	{
		for(int i=0; i<this.size; i++)
			if(this.arr[i].compareTo(e) == 0)
				return true;
		return false;
	}

	/**
	 * Merges two heaps together
	 * @param h1 Heap, that is going to be merged with 'this'
	 */
	public void merge(Heap<E> h1)
	{
		for(int i=0; i<h1.size(); i++){
			this.offer(h1.arr[i].getData());
		}
	}

	/**
	 * Removes the kth largest element
	 * @param k Integer given by the user
	 * @return Number of occurences after removal
	 * @throws Exception If k is out of bounds
	 */
	public int removeKthLargest(int k) throws Exception{

		if(k > this.size() || k <= 0)
			throw new Exception("Index is out of bound...");

		k = this.size() - k + 1;

		Heap<E> temp = new Heap<E>();

		for(int i=0; i<this.size(); i++){
			temp.offer(this.arr[i].getData());
			if(temp.size() > k){
				temp.poll();
			}
		}

		this.removeByValue(temp.peek());

		return temp.poll();

	}

	/**
	 * Removes the element given by user
	 * @param val Element that is going to be deleted from the heap
	 * @return true when successful
	 */
	public int removeByValue(E val){

		int index = this.indexOf(val);

		if(index < 0)	return -1;

		if(this.arr[index].getFreq() > 1){
			this.arr[index].setFreq(this.arr[index].getFreq() - 1);
			return this.arr[index].getFreq();
		}

		this.arr[index] = this.arr[--this.size];


		int parent = index;
		int left, right;

		while(true)
		{
			left = 2*parent + 1;

			if(left >= this.size())
				break;

			right = left+1;

			int maxChild = left;
			if(right < this.size() && this.arr[right].compareTo(this.arr[left].getData()) > 0){
				maxChild = right;
			}

			if(this.arr[parent].compareTo(this.arr[maxChild].getData()) < 0){
				this.swap(parent, maxChild);
				parent = maxChild;
			}else{
				break;
			}

		}

		return 0;

	}

	/**
	 * Returns the index of an element
	 * @param e Generic type
	 * @return the index of the element
	 */
	public int indexOf(E e){

		for(int i=0; i<this.size(); i++){
			if(this.arr[i].compareTo(e) == 0)
				return i;
		}
		return -1;
	}

	/**
	 * Number of occurences of a the given value
	 * @param e Given value
	 * @return number of occurences
	 */
	public int numberOfOccurrences(E e){
		int total = 0;
		for(int i=0; i<this.size; i++){
			if(this.arr[i].compareTo(e) == 0)
				total += this.arr[i].getFreq();
		}
		return total;
	}

	/**
	 * Reallocates the array when needed
	 */
	@SuppressWarnings("unchecked")
	private void reallocate()
	{
		this.cap *= 2;
		Node<E>[] temp = new Node[this.cap];

		for(int i=0; i<this.size; i++)
			temp[i] = this.arr[i];
	}

	/**
	 * Swaps two indexes on the array
	 * @param i1 index-1
	 * @param i2 index-2
	 */
	private void swap(int i1, int i2){
		Node<E> temp = this.arr[i1];
		this.arr[i1] = this.arr[i2];
		this.arr[i2] = temp;
	}

	/**
	 * Returns string representation of the heap data structure
	 */
	@Override
	public String toString()
	{
		String str = "";
		for(int i=0; i<this.size; i++)
		{
			str += String.valueOf(this.arr[i].getData() + "," + this.arr[i].getFreq() + " | ") ;
		}
		return str;
	}

	/**
	 * Overriden compare method
	 */
	@Override
	public int compareTo(E e){
		return this.arr[0].compareTo(e);
	}

	/**
	 * Returns the element in the given index
	 * @param index index given by the user
	 * @return the value in the given index
	 * @throws Exception When index is out of bounds
	 */
	public E get(int index) throws Exception{
		if(index < 0 || index >= this.size()) throw new Exception("Index is out of bounds...");
		return this.arr[index].getData();
	}

	/**
	 * Finds the mode
	 * @return returns a pair object, that holds both mode and the number of occurences of that node
	 */
	public Pair<E,Integer> findMode(){
		E mode = null;
		int max = 0;

		for(int i=0; i<this.size; i++){
			if(this.arr[i].getFreq() > max){
				max = this.arr[i].getFreq();
				mode = this.arr[i].getData();
			}
		}

		return new Pair<E,Integer>(mode,max);

	}

	/**
	 * Returns an iterator
	 * @return iterator
	 */
	public Iterator<E> iterator(){
		return new myIter();
	}

	/**
	 * Inner Heap Iterator class 
	 */
	private class myIter implements Iterator<E>
	{
		/** Cursor of the iterator */
		protected int cursor;
		/** flag, that is used for checking removeability */
		protected boolean flag;

		/**
		 * No parameter iterator constructor
		 */
		public myIter(){
			this.cursor = 0;
			this.flag = false;
		}

		public boolean hasNext(){
			return this.cursor != size();
		}

		public E next(){

			if(this.cursor == size())
				throw new NoSuchElementException("No such element...");

			this.flag = true;
			return arr[this.cursor++].getData();
		}

		public void remove(){
			if(!this.flag)
				throw new IllegalStateException("Next method needs to be called...");

			removeByValue(arr[this.cursor-1].getData());
			this.flag = false;
		}
		
	}

	/**
	 * Inner Node class, used for representing every node on the heap
	 * @param <E> Generic data type
	 */
	class Node<E extends Comparable<E>> implements Comparable<E>
	{
		/** Data inside the node */
		E data;
		/** Frequency of this node */
		int freq;

		/**
		 * Single value constructor
		 */
		public Node(E data){
			this.data = data;
			this.freq = 1;
		}

		/**
		 * Returns the data
		 * @return data
		 */
		public E getData(){
			return this.data;
		}

		/**
		 * Returns the frequency
		 * @return frequency
		 */
		public int getFreq(){
			return this.freq;
		}

		/**
		 * Sets the frequency
		 * @param freq frequency given by the user
		 */
		public void setFreq(int freq){
			this.freq = freq;
		}

		/**
		 * Sets the data
		 * @param data data given by the user
		 */
		public void setData(E data){
			this.data = data;
		}

		/**
		 * Overriden compareTo method
		 */
		@Override
		public int compareTo(E e){
			return this.data.compareTo(e);
		}

	}
	
}


