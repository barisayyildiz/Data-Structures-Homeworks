import java.util.Iterator;

import com.*;
import com.part2.*;

public class Main{
	public static void main(String args[]){


		// SkipList<Integer> sList = new SkipList<Integer>();
		// sList.add(12);
		// sList.add(5);
		// sList.add(13);
		// sList.add(25);

		// System.out.println(sList);

		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		avlTree.add(3);
		avlTree.add(8);
		avlTree.add(12);
		avlTree.add(21);
		avlTree.add(1);
		
		try{
			Iterator<Integer> iter = avlTree.iterator();
			while(iter.hasNext()){
				System.out.println(iter.next());
			}
			System.out.println(avlTree.headSet(8));
		}catch(Exception exception){
			System.out.println(exception.getMessage());
		}

		// try{
		// 	Iterator<Integer> iter = sList.descendingIterator();
		// 	while(iter.hasNext()){
		// 		System.out.println(iter.next());
		// 	}
		// }catch(Exception exception){
		// 	System.out.println(exception.getMessage());
		// }











		// BinarySearchTree<Integer> bst = new RedBlackTree<Integer>();
		// bst.add(12);
		// bst.add(21);
		// bst.add(2);
		// bst.add(33);
		// bst.add(55);
		// bst.add(66);
		// bst.add(77);
		// bst.add(88);
		// bst.add(99);

		// System.out.println(((RedBlackTree<Integer>)bst.getLeftSubtree()));
		// System.out.println((bst.getLeftSubtree().getClass()));


		// bst.delete(1222);

		// // System.out.println(bst);
		// bastir(bst);

		// System.out.println(bst.size());

		// Part2<Integer> part2 = new Part2<Integer>();
		// System.out.println(part2.isRedBlackTree(bst));
		// // part2.isAVLTree(bst);

		// System.out.println("Is AVL : " + part2.isAVLTree(bst));



	}

	public static void bastir(BinarySearchTree<Integer> bst){
		System.out.println(bst.toString());
	}

}