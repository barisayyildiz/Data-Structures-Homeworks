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
		
		return false;


	}


}
