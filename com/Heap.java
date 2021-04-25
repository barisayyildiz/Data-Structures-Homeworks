package com;

import java.lang.reflect.Array;

public class Heap<E> implements Comparable<E>
{

	private static class Node<E> implements Comparable<E>
	{
		private E data;
		private int freq;

		public Node(E data)
		{
			this.data = data;
			this.freq = 1;
		}

		public int getFreq(){
			return this.freq;
		}

		public void setFreq(int freq){
			this.freq = freq;
		}

		public E getData(){
			return this.data;
		}

		@Override
		public boolean equals(Object obj){

			if(!(obj instanceof Node))
				return false;
			
			Node<E> temp = (Node<E>)obj;

			return this.data == temp.getData();
		}

		@Override
		public int compareTo(E o){

			Comparable temp = (Comparable)this.data;

			return temp.compareTo(o);

		}

	}


	private static final int INITIAL_SIZE = 8;

	private int counter;
	private int size;
	private int cap;
	private Node<E> arr[];

	public Heap()
	{
		this.cap = INITIAL_SIZE;
		this.size = 0;
		// this.arr = (Node<E>[]) new Object[this.cap];
		// this.arr = new Node<E>[this.cap];

		this.arr = (Node<E>[]) new Object[this.cap];

		// this.arr = Array.newInstance(Node<E>, this.cap);


	}

	public boolean offer(E e){

		if(this.size == this.cap) this.reallocate();

		this.arr[this.size++] = new Node<E>(e);

		int child = this.size;
		int parent = (child-1)/2;
		
		while(true){

			if(this.arr[child].compareTo(this.arr[parent].getData()) > 0){
				this.swap(child,parent);
				child = parent;
				parent = (child-1)/2;				
			}else{
				break;
			}
		}

		return true;
	}

	public E poll(){

		Node<E> val = this.arr[0];
		this.arr[0] = this.arr[--this.size];
		int parent = 0;
		int left, right;

		while(true){
			left = 2*parent + 1;

			if(left >= this.size()) break;

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

		return val.getData();


	}

	public E peek()
	{
		return this.arr[0].getData();
	}

	public int size(){
		return this.size;
	}

	public boolean contains(E e){

		for(int i=0; i<this.size; i++){
			if(this.arr[i].equals(e)) return true;
		}
		return false;
	}

	public void merge(Heap<E> h1){
		for(int i=0; i<h1.size(); i++){
			this.offer( h1.arr[i].getData() );
		}
	}

	public E removeKthLargest(int k){

		if(k > this.size() || k <= 0)	return null;

		k = this.size() - k + 1;

		Heap<E> temp = new Heap<E>();

		for(int i=0; i<this.size(); i++){
			temp.offer(this.arr[i].getData());
			if(temp.size() > k){
				temp.poll();
			}
		}

		this.remove(temp.peek());

		return temp.poll();

	}

	public void remove(E val){

		int index = this.indexOf(val);

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

	}

	public int indexOf(E e){

		// System.out.println("value : " + String.valueOf(e));

		for(int i=0; i<this.size(); i++){
			if(this.arr[i].equals(e))
				return i;
		}
		return -1;
	}


	private void reallocate()
	{
		this.cap *= 2;
		Node<E> temp[] = (Node<E>[]) new Object[this.cap];
		// private Node<E> arr[];
		// this.arr = (Node<E>[]) new Comparable[this.cap];

		for(int i=0; i<this.size; i++)
			temp[i] = this.arr[i];

		this.arr = temp;
	}

	private void swap(int i1, int i2){
		Node<E> temp = this.arr[i1];
		this.arr[i1] = this.arr[i2];
		this.arr[i2] = temp;
	}

	@Override
	public String toString()
	{
		String str = "";
		for(int i=0; i<this.size; i++)
		{
			str += String.valueOf(this.arr[i].getData()) + " ";
		}
		return str;
	}
	
	@Override
	public int compareTo(E o){
		Comparable temp = (Comparable)this.arr[0];

		return temp.compareTo(o);
	}

}
