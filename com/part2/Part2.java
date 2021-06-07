package com.part2;

import com.*;
import com.Pair;

public class Part2<E extends Comparable<E>>{

	public boolean isAVLTree(BinarySearchTree<E> bst){
		
		if(bst.size() == 0)	return true;

		// System.out.println("giriş");
		Pair<Integer, Boolean> pair = isAVLTreeRec(bst);

		// System.out.println("çıkış");

		return pair.second;

	}

	private Pair<Integer,Boolean> isAVLTreeRec(BinarySearchTree<E> bst){
		

		int leftHeight = 0, rightHeight = 0;
		BinarySearchTree<E> left = bst.getLeftSubtree();
		BinarySearchTree<E> right = bst.getRightSubtree();
		Pair<Integer, Boolean> pair;

		if(left != null){
			pair = isAVLTreeRec(left);
			leftHeight = ++pair.first;
			if(!pair.second)	return pair;
		}

		if(right != null){
			pair = isAVLTreeRec(right);
			rightHeight = ++pair.first;
			if(!pair.second)	return pair;
		}

		// System.out.println("leftHeight : " + leftHeight);
		// System.out.println("rightHeight : " + rightHeight);

		if(Math.abs(leftHeight - rightHeight) > 1)	return new Pair<Integer,Boolean>(Math.max(leftHeight, rightHeight), false);
		return new Pair<Integer,Boolean>(Math.max(leftHeight, rightHeight), true);
		
	}


	public boolean isRedBlackTree(BinarySearchTree<E> bst){

		if(bst.size() == 0)	return true;
		if(bst.isRed())	return false;

		Pair<Integer,Boolean> pair;

		pair = isRedBlackTreeRec(bst);

		return pair.second;

	}

	private Pair<Integer,Boolean> isRedBlackTreeRec(BinarySearchTree<E> bst){

		int leftTotal = 0, rightTotal = 0;
		BinarySearchTree<E> left = bst.getLeftSubtree();
		BinarySearchTree<E> right = bst.getRightSubtree();
		Pair<Integer, Boolean> pair;

		// if leaf, the node is black
		if(bst == null){
			return new Pair<Integer,Boolean>(1,true);
		}

		// if current node is red and one of the child is not black, return false
		if(bst.isRed()){
			if((bst.getLeftSubtree() != null && bst.getLeftSubtree().isRed()) || (bst.getRightSubtree() != null && bst.getRightSubtree().isRed())){
				return new Pair<Integer, Boolean>(0,false);
			}
		}

		// count black nodes in every path
		if(left != null){
			pair = isRedBlackTreeRec(left);
			leftTotal = bst.isRed() ? pair.first + 1: pair.first;
			if(!pair.second)	return pair;
		}

		if(right != null){
			pair = isRedBlackTreeRec(left);
			rightTotal = bst.isRed() ? pair.first + 1: pair.first;
			if(!pair.second)	return pair;
		}

		if(leftTotal != rightTotal)	return new Pair<Integer,Boolean>(0,false);
		return new Pair<Integer,Boolean>(leftTotal,true);


	}


}
