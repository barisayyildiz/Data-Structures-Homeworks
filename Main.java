import java.util.Iterator;
import java.util.Random;

import com.*;
import com.part2.*;

public class Main{

	public static void partThreeTest(){

		Random rand = new Random();
		long startTime;
		long bstTime, rbtTime, slTime, ttTime, btTime;

		// PART-3
		int temp;

		// objects
		BinarySearchTree<Integer> bst = null;
		RedBlackTree<Integer> rbTree = null;
		SkipList<Integer> sList = null;
		BTree<Integer> ttTree = null;
		BTree<Integer> bTree = null;

		bstTime = 0;
		rbtTime = 0;
		slTime = 0;
		ttTime = 0;
		btTime = 0;
		for(int i=0; i<10; i++){
			bst = new BinarySearchTree<Integer>();
			rbTree = new RedBlackTree<Integer>();
			sList = new SkipList<Integer>();
			ttTree = new BTree<Integer>(3);
			bTree = new BTree<Integer>(50);

			startTime = System.currentTimeMillis();
			for(int j=0; j<10000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bst.add(temp);
			}
			bstTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<10000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				rbTree.add(temp);
			}
			rbtTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<10000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				sList.add(temp);
			}
			slTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<10000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				ttTree.add(temp);
			}
			ttTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<10000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bTree.add(temp);
			}
			btTime += System.currentTimeMillis() - startTime;
		}

		System.out.println("Average time elapsed to insert 10K integers to BinarySearchTree : " + (double)bstTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 10K integers to RedBlackTree : " + (double)rbtTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 10K integers to SkipList : " + (double)slTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 10K integers to 23Tree : " + (double)ttTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 10K integers to BTree with order 50 : " + (double)btTime/10 + " milliseconds...\n");

		// adding extra 100 items
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bst.add(temp);
		}
		System.out.println("Adding 100 more integers to 10K sized BinarySearchTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			rbTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 10K sized RedBlackTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			sList.add(temp);
		}
		System.out.println("Adding 100 more integers to 10K sized SkipList : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			ttTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 10K sized 23Tree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 10K sized BTree with order 50 : " + (double)(System.currentTimeMillis())/10 + " milliseconds...\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------\n");


		bstTime = 0;
		rbtTime = 0;
		slTime = 0;
		ttTime = 0;
		btTime = 0;
		for(int i=0; i<10; i++){
			bst = new BinarySearchTree<Integer>();
			rbTree = new RedBlackTree<Integer>();
			sList = new SkipList<Integer>();
			ttTree = new BTree<Integer>(3);
			bTree = new BTree<Integer>(50);

			startTime = System.currentTimeMillis();
			for(int j=0; j<20000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bst.add(temp);
			}
			bstTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<20000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				rbTree.add(temp);
			}
			rbtTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<20000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				sList.add(temp);
			}
			slTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<20000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				ttTree.add(temp);
			}
			ttTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<20000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bTree.add(temp);
			}
			btTime += System.currentTimeMillis() - startTime;
		}

		System.out.println("Average time elapsed to insert 20K integers to BinarySearchTree : " + (double)bstTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 20K integers to RedBlackTree : " + (double)rbtTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 20K integers to SkipList : " + (double)slTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 20K integers to 23Tree : " + (double)ttTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 20K integers to BTree with order 50 : " + (double)btTime/10 + " milliseconds...\n");

		// adding extra 100 items
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bst.add(temp);
		}
		System.out.println("Adding 100 more integers to 20K sized BinarySearchTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			rbTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 20K sized RedBlackTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			sList.add(temp);
		}
		System.out.println("Adding 100 more integers to 20K sized SkipList : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			ttTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 20K sized 23Tree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 20K sized BTree with order 50 : " + (double)(System.currentTimeMillis())/10 + " milliseconds...\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------\n");


		bstTime = 0;
		rbtTime = 0;
		slTime = 0;
		ttTime = 0;
		btTime = 0;
		for(int i=0; i<10; i++){
			bst = new BinarySearchTree<Integer>();
			rbTree = new RedBlackTree<Integer>();
			sList = new SkipList<Integer>();
			ttTree = new BTree<Integer>(3);
			bTree = new BTree<Integer>(50);

			startTime = System.currentTimeMillis();
			for(int j=0; j<40000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bst.add(temp);
			}
			bstTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<40000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				rbTree.add(temp);
			}
			rbtTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<40000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				sList.add(temp);
			}
			slTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<40000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				ttTree.add(temp);
			}
			ttTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<40000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bTree.add(temp);
			}
			btTime += System.currentTimeMillis() - startTime;
		}

		System.out.println("Average time elapsed to insert 40K integers to BinarySearchTree : " + (double)bstTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 40K integers to RedBlackTree : " + (double)rbtTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 40K integers to SkipList : " + (double)slTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 40K integers to 23Tree : " + (double)ttTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 40K integers to BTree with order 50 : " + (double)btTime/10 + " milliseconds...\n");

		// adding extra 100 items
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bst.add(temp);
		}
		System.out.println("Adding 100 more integers to 40K sized BinarySearchTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			rbTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 40K sized RedBlackTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			sList.add(temp);
		}
		System.out.println("Adding 100 more integers to 40K sized SkipList : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			ttTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 40K sized 23Tree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 40K sized BTree with order 50 : " + (double)(System.currentTimeMillis())/10 + " milliseconds...\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------\n");


		bstTime = 0;
		rbtTime = 0;
		slTime = 0;
		ttTime = 0;
		btTime = 0;
		for(int i=0; i<10; i++){
			bst = new BinarySearchTree<Integer>();
			rbTree = new RedBlackTree<Integer>();
			sList = new SkipList<Integer>();
			ttTree = new BTree<Integer>(3);
			bTree = new BTree<Integer>(50);

			startTime = System.currentTimeMillis();
			for(int j=0; j<80000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bst.add(temp);
			}
			bstTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<80000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				rbTree.add(temp);
			}
			rbtTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<80000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				sList.add(temp);
			}
			slTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<80000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				ttTree.add(temp);
			}
			ttTime += System.currentTimeMillis() - startTime;

			startTime = System.currentTimeMillis();
			for(int j=0; j<80000; j++){
				temp = rand.nextInt(Integer.MAX_VALUE);
				bTree.add(temp);
			}
			btTime += System.currentTimeMillis() - startTime;
		}

		System.out.println("Average time elapsed to insert 80K integers to BinarySearchTree : " + (double)bstTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 80K integers to RedBlackTree : " + (double)rbtTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 80K integers to SkipList : " + (double)slTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 80K integers to 23Tree : " + (double)ttTime/10 + " milliseconds...");
		System.out.println("Average time elapsed to insert 80K integers to BTree with order 50 : " + (double)btTime/10 + " milliseconds...\n");

		// adding extra 100 items
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bst.add(temp);
		}
		System.out.println("Adding 100 more integers to 80K sized BinarySearchTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			rbTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 80K sized RedBlackTree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			sList.add(temp);
		}
		System.out.println("Adding 100 more integers to 80K sized SkipList : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			ttTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 80K sized 23Tree : " + (double)(System.currentTimeMillis())/10 + " milliseconds...");
		startTime = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			temp = rand.nextInt(Integer.MAX_VALUE);
			bTree.add(temp);
		}
		System.out.println("Adding 100 more integers to 80K sized BTree with order 50 : " + (double)(System.currentTimeMillis())/10 + " milliseconds...\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------\n");



	}

	public static void main(String args[]){

		partThreeTest();


		// BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();
		// RedBlackTree<Integer> rbTree = new RedBlackTree<Integer>();
		// SkipList<Integer> sList = new SkipList<Integer>();

		// for(int i=0; i<80000; i++){
		// 	temp = rand.nextInt(Integer.MAX_VALUE);
		// 	bsTree.add(temp);
		// 	rbTree.add(temp);
		// 	sList.add(temp);
		// }

		// System.out.println(bsTree.size());
		// System.out.println(rbTree.size());
		// System.out.println(sList.size());



		// RedBlackTree<Integer> rbTree = new RedBlackTree<Integer>();
		// BTree<Integer> bTree = new BTree<Integer>(5);
		// SkipList<Integer> skipList = new SkipList<Integer>();
		



		// SkipList<Integer> sList = new SkipList<Integer>();
		// sList.add(12);
		// sList.add(5);
		// sList.add(13);
		// sList.add(25);

		// System.out.println(sList);

		// AVLTree<Integer> avlTree = new AVLTree<Integer>();
		// avlTree.add(3);
		// avlTree.add(8);
		// avlTree.add(12);
		// avlTree.add(21);
		// avlTree.add(1);
		
		// try{
		// 	Iterator<Integer> iter = avlTree.iterator();
		// 	while(iter.hasNext()){
		// 		System.out.println(iter.next());
		// 	}
		// 	System.out.println(avlTree.headSet(8));
		// }catch(Exception exception){
		// 	System.out.println(exception.getMessage());
		// }

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