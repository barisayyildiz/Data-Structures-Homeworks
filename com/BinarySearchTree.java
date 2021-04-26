package com;

import com.lib.*;

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

	public int add(E e){

		int val;

		if( (this.node.size() >= MAX_ELEMENTS && this.node.contains(e)) || (this.node.size() < MAX_ELEMENTS) ){
			val = this.node.offer(e);
		}else{

			if(this.node.compareTo(e) < 0){
				if(this.right == null) this.right = new BinarySearchTree<E>();
				val = this.right.add(e);
			}else{
				if(this.left == null) this.left = new BinarySearchTree<E>();
				val = this.left.add(e);
			}

		}

		return val;	
		
	}

	public int remove(E item){

		int val = this.node.remove(item);
		if(val >= 0)	return val;

		if(this.left != null){
			val = this.left.node.remove(item);
			if(val >= 0) return val;
		}

		if(this.right != null){
			val = this.right.node.remove(item);
			if(val >= 0) return val;
		}

		return val;

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

	public E find_mode(){
		return this.find_mode_recur();
	}

	public E find_mode_recur(){

		E mode = null;
		int max = 0;

		Pair<E,Integer> pair = new Pair<E,Integer>(mode, max);

		pair = this.node.findMode();
		if(pair.getValue() > max){
			max = pair.getValue();
			mode = pair.getKey();
		}

		if(this.left != null){
			pair = this.left.node.findMode();
			if(pair.getValue() > max){
				max = pair.getValue();
				mode = pair.getKey();
			}
		}

		if(this.right != null){
			pair = this.right.node.findMode();
			if(pair.getValue() > max){
				max = pair.getValue();
				mode = pair.getKey();
			}
		}

		return mode;

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

