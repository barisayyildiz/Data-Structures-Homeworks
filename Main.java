import com.*;
import com.part2.*;

public class Main{
	public static void main(String args[]){

		BinarySearchTree<Integer> bst = new AVLTree<Integer>();
		bst.add(12);
		bst.add(21);
		bst.add(2);
		bst.add(33);
		bst.add(55);
		bst.add(66);
		bst.add(77);
		bst.add(88);
		bst.add(99);

		// bst.delete(1222);

		// // System.out.println(bst);
		bastir(bst);

		// System.out.println(bst.size());

		Part2<Integer> part2 = new Part2<Integer>();
		// part2.isAVLTree(bst);

		System.out.println("Is AVL : " + part2.isAVLTree(bst));



	}

	public static void bastir(BinarySearchTree<Integer> bst){
		System.out.println(bst.toString());
	}

}