package com;

import java.lang.Comparable;


public class BinarySearchTree<E extends Comparable<E>>
{
	private Heap<E> node;
	private int size;
	private static final int MAX_ELEMENTS = 7;
	private BinarySearchTree<E> left;
	private BinarySearchTree<E> right;

	public BinarySearchTree(){
		this.node = new Heap<E>();
		this.size = 0;
		this.left = null;
		this.right = null;
	}

	public boolean add(E e){

		if( (this.node.size() >= MAX_ELEMENTS && this.node.contains(e)) || (this.node.size() < MAX_ELEMENTS) ){
			this.node.offer(e);
		}else{

			if(this.node.compareTo(e) < 0){
				if(this.right == null) this.right = new BinarySearchTree<E>();
				this.right.add(e);
			}else{
				if(this.left == null) this.left = new BinarySearchTree<E>();
				this.left.add(e);
			}

		}

		return true;	
		
	}

	public void remove(E item){

		boolean val = this.node.remove(item);
		if(val)	return;

		if(this.left != null){
			val = this.left.node.remove(item);
			if(val) return;
		}

		if(this.right != null){
			val = this.right.node.remove(item);
			if(val) return;
		}

	}

	public int find(E item){
		
		int total = 0;
		total += this.node.numberOfOccurrences(item);
		if(this.left != null)
			total += this.left.find(item);
		if(this.right != null)
			total += this.right.find(item);
		return total;		
	}

	@Override
	public String toString(){

		String str = "";
		if(this.left != null)	str += this.left.toString();
		str += this.node.toString();
		if(this.right != null) str += this.right.toString();

		return str;
	}




}

