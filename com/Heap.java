package com;

import java.util.Iterator;
import java.util.PriorityQueue;

import java.util.NoSuchElementException;

import com.lib.*;

public class Heap<E extends Comparable<E>> implements Comparable<E>
{
	private static final int INITIAL_SIZE = 8;

	private int counter;
	private int size;
	private int cap;
	private Node<E> arr[];

	@SuppressWarnings("unchecked")
	public Heap()
	{
		this.cap = INITIAL_SIZE;
		this.size = 0;
		this.arr = new Node[this.cap];
	}

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

	public E peek()
	{
		if(this.size() == 0)	return null;
		return this.arr[0].getData();
	}

	public int size(){
		return this.size;
	}

	public boolean contains(E e)
	{
		for(int i=0; i<this.size; i++)
			if(this.arr[i].compareTo(e) == 0)
				return true;
		return false;
	}

	public void merge(Heap<E> h1)
	{
		for(int i=0; i<h1.size(); i++){
			this.offer(h1.arr[i].getData());
		}
	}

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

	public int indexOf(E e){

		for(int i=0; i<this.size(); i++){
			if(this.arr[i].compareTo(e) == 0)
				return i;
		}
		return -1;
	}

	public int numberOfOccurrences(E e){
		int total = 0;
		for(int i=0; i<this.size; i++){
			if(this.arr[i].compareTo(e) == 0)
				total += this.arr[i].getFreq();
		}
		return total;
	}


	@SuppressWarnings("unchecked")
	private void reallocate()
	{
		this.cap *= 2;
		Node<E>[] temp = new Node[this.cap];

		for(int i=0; i<this.size; i++)
			temp[i] = this.arr[i];
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
			str += String.valueOf(this.arr[i].getData() + "," + this.arr[i].getFreq() + " | ") ;
		}
		return str;
	}

	public int compareTo(E e){
		return this.arr[0].compareTo(e);
	}

	public E get(int index) throws Exception{
		if(index < 0 || index >= this.size()) throw new Exception("Index is out of bounds...");
		return this.arr[index].getData();
	}


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

	public Iterator<E> iterator(){
		return new myIter();
	}


	private class myIter implements Iterator<E>
	{
		protected int cursor;
		protected boolean flag;

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

	class Node<E extends Comparable<E>> implements Comparable<E>
	{
		E data;
		int freq;

		public Node(E data){
			this.data = data;
			this.freq = 1;
		}

		public E getData(){
			return this.data;
		}

		public int getFreq(){
			return this.freq;
		}

		public void setFreq(int freq){
			this.freq = freq;
		}

		public void setData(E data){
			this.data = data;
		}

		public int compareTo(E e){
			return this.data.compareTo(e);
		}

	}
	
}


