package com;
import java.lang.Comparable;

public class Heap<E extends Comparable<E>>
{
	private static final int INITIAL_SIZE = 8;

	private int counter;
	private int size;
	private int cap;
	private E arr[];
	private int freq[];

	public Heap()
	{
		this.cap = INITIAL_SIZE;
		this.size = 0;
		this.arr = (E[]) new Comparable[this.cap];
		this.freq = new int[this.cap];


	}

	public boolean offer(E e)
	{
		if(this.size == this.cap) this.reallocate();

		this.arr[this.size] = e;
		this.freq[this.size] = 1;

		int child = this.size;
		int parent = (child-1)/2;
		while(true)
		{

			if(this.arr[child].compareTo(this.arr[parent]) > 0){
				this.swap(child, parent);
				child = parent;
				parent = (child-1)/2;
			}else{
				break;
			}

		}

		this.size++;
		return true;
	}

	public E poll() //throws Exception
	{
		// if(this.size == 0)
		// 	throw new Exception("Size is 0...");

		E val = this.arr[0];
		this.arr[0] = this.arr[this.size-1];
		this.freq[0] = this.freq[--this.size];
		int parent = 0;
		int left, right;

		while(true)
		{
			left = 2*parent + 1;

			if(left >= this.size())
				break;

			right = left+1;

			int maxChild = left;
			if(right < this.size() && this.arr[right].compareTo(this.arr[left]) > 0){
				maxChild = right;
			}

			if(this.arr[parent].compareTo(this.arr[maxChild]) < 0){
				this.swap(parent, maxChild);
				parent = maxChild;
			}else{
				break;
			}

		}


		return val;
	}

	public E peek()
	{
		return this.arr[0];
	}

	public int size(){
		return this.size;
	}

	public boolean contains(E e)
	{
		for(int i=0; i<this.size; i++)
			if(this.arr[i].equals(e))
				return true;
		return false;
	}

	public void merge(Heap<E> h1)
	{
		for(int i=0; i<h1.size(); i++){
			this.offer((E)h1.arr[i]);
		}


	}

	public E removeKthLargest(int k){

		if(k > this.size() || k <= 0)
			return null;

		k = this.size() - k + 1;

		System.out.println("k : " + String.valueOf(k));

		Heap<E> temp = new Heap<E>();

		for(int i=0; i<this.size(); i++){
			temp.offer(this.arr[i]);
			if(temp.size() > k){
				temp.poll();
			}
		}

		this.remove(temp.peek());

		return temp.poll();

	}

	public void remove(E val){

		int index = this.indexOf(val);

		System.out.println("index : " + String.valueOf(index));

		this.arr[index] = this.arr[this.size-1];
		this.freq[index] = this.freq[--this.size];


		int parent = index;
		int left, right;

		while(true)
		{
			left = 2*parent + 1;

			if(left >= this.size())
				break;

			right = left+1;

			int maxChild = left;
			if(right < this.size() && this.arr[right].compareTo(this.arr[left]) > 0){
				maxChild = right;
			}

			if(this.arr[parent].compareTo(this.arr[maxChild]) < 0){
				this.swap(parent, maxChild);
				parent = maxChild;
			}else{
				break;
			}

		}

	}

	public int indexOf(E e){

		System.out.println("value : " + String.valueOf(e));

		for(int i=0; i<this.size(); i++){
			if(this.arr[i].equals(e))
				return i;
		}
		return -1;
	}


	private void reallocate()
	{
		this.cap *= 2;
		E[] temp = (E[]) new Object[this.cap];

		for(int i=0; i<this.size; i++)
			temp[i] = this.arr[i];

		int[] temp2 = new int[this.cap];
		for(int i=0; i<this.size; i++)
			temp2[i] = this.freq[i];

		this.arr = temp;
		this.freq = temp2;
	}

	private void swap(int i1, int i2){
		E temp = this.arr[i1];
		this.arr[i1] = this.arr[i2];
		this.arr[i2] = temp;

		int temp2 = this.freq[i1];
		this.freq[i1] = this.freq[i2];
		this.freq[i2] = temp2; 
	}

	@Override
	public String toString()
	{
		String str = "";
		for(int i=0; i<this.size; i++)
		{
			str += String.valueOf(this.arr[i]) + " ";
		}
		return str;
	}

	public void printFreq(){
		for(int i=0; i<this.size; i++){
			System.out.println(String.valueOf(this.freq[i]) + " ");
		}
	}




	
}
