package com;

import java.lang.Comparable;


public class BinarySearchTree<E extends Comparable<E>>
{
	private Heap<E> node;
	private int[] freq;

	private E[] keys;
	private int[] values;

	private int size;
	private static final int MAX_ELEMENTS = 7;

	private BinarySearchTree<E> left;
	private BinarySearchTree<E> right;

	public BinarySearchTree(){

		this.node = new Heap<E>();
		this.freq = new int[MAX_ELEMENTS];
		this.size = 0;

		this.keys = (E[]) new Comparable[MAX_ELEMENTS];
		this.values = new int[MAX_ELEMENTS];

		this.left = null;
		this.right = null;
	}

	public boolean offer(E e){

		// System.out.println("e : " + String.valueOf(e));

		// MAX_ELEMENTS IS EXECEEDED
		if(this.size >= MAX_ELEMENTS){
			if(this.contains(e)){
				int index = this.keyIndex(e);
				this.values[index]++;
				return true;
			}

			// if the value is smaller
			if(this.node.get(0).compareTo(e) > 0){
				if(this.right == null) this.right = new BinarySearchTree<E>();
				this.right.offer(e);
			}else{
				if(this.left == null) this.left = new BinarySearchTree<E>();
				this.left.offer(e);
			}

			return false; // diğer nodlara yönlendir
		
		// IF HEAP CONTAINS THE ELEMENT
		}else if(this.contains(e)){
			int index = this.keyIndex(e);
			this.values[index]++;
			return true;
		
		// IF IT DOES NOT CONTAINS THE ELEMENT
		}else{
			this.node.offer(e);
			this.keys[this.size] = e;
			this.values[this.size++] = 1;
			return true;
		}
	}

	public E poll(){

		



	}


	// FOR KEYS
	public int keyIndex(E e){
		for(int i=0; i<this.size; i++){
			if(this.keys[i].equals(e)) return i;
		}
		return -1;
	}

	public boolean contains(E e){
		for(int i=0; i<this.size; i++){
			if(this.keys[i].equals(e)) return true;
		}
		return false;
	}



	public String toString(){

		if(this.node == null)	return "";

		String str = "";

		if(this.left != null)	str += this.left.toString();

		for(int i=0; i<this.size; i++){
			E cur = this.node.get(i);
			str += String.valueOf( cur + "," + this.values[this.keyIndex(cur)] + " | "  );
		}

		if(this.right != null) str += this.right.toString();

		return str;


	}




	
}
