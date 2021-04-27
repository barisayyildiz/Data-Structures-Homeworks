package com.structures;

import com.lib.*;

import java.lang.Comparable;

/**
 * Binary Search Tree with the generic type E, that holds Heap<E> data structure
 * @param <E> Generic data type
 */

public class BinarySearchTree<E extends Comparable<E>>
{
	/** A single node */
	private Heap<E> node;
	/** Number of unique elements on the heap */
	private int size;
	/** Maximum number of unique elements that a heap can have */
	private static final int MAX_ELEMENTS = 7;
	/** Left pointer of the node */
	private BinarySearchTree<E> left;
	/** Right pointer of the node */
	private BinarySearchTree<E> right;

	/**
	 * No param constructor
	 */
	public BinarySearchTree(){
		this.node = new Heap<E>(true);
		this.size = 0;
		this.left = null;
		this.right = null;
	}

	/**
	 * Adds a new value to the BST
	 * @param e param given by the user
	 * @return number of occurences after insertion
	 */
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

	/**
	 * Removes the item given by the user
	 * @param item param given by the user
	 * @return number of occurences after removal
	 */
	public int remove(E item){

		int val = this.node.removeByValue(item);
		if(val >= 0)	return val;

		if(this.left != null){
			val = this.left.remove(item);
			if(val >= 0) return val;
		}

		if(this.right != null){
			val = this.right.remove(item);
			if(val >= 0) return val;
		}

		return val;

	}

	/**
	 * Returns number of occurences
	 * @param item param given by the user
	 * @return number of occurences
	 */
	public int find(E item){
		
		int total = 0;
		total += this.node.numberOfOccurrences(item);
		if(this.left != null)
			total += this.left.find(item);
		if(this.right != null)
			total += this.right.find(item);
		return total;		
	}

	/**
	 * calls the private find_mode_recur method
	 * @return return of the find_mode_recur
	 */
	public E find_mode(){
		return this.find_mode_recur();
	}

	/**
	 * Returns the mode value
	 * @return mode value
	 */
	private E find_mode_recur(){

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

	/**
	 * Returns the string representation of the BST
	 */
	@Override
	public String toString(){

		String str = "";
		if(this.left != null)	str += this.left.toString();
		str += this.node.toString();
		if(this.right != null) str += this.right.toString();

		return str;
	}




}

