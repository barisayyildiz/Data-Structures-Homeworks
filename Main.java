import java.util.Iterator;
import java.util.Random;

import com.*;
import com.part2.*;
import com.Pair;

public class Main{

	public static void partOneTest(){

		System.out.println("=========================== PART1 ===========================");

		SkipList<Integer> skipList = new SkipList<Integer>();
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		
		System.out.println("=========== SkipList ===========");
		System.out.println("insert method");
		skipList.insert(10);
		skipList.insert(20);
		skipList.insert(30);
		skipList.insert(40);
		skipList.insert(50);

		System.out.println(skipList);
		System.out.println("remove method");
		skipList.delete(40);
		System.out.println(skipList);

		System.out.println("descendingIterator method");
		Iterator<Integer> iter = skipList.descendingIterator();
		while(iter.hasNext()){
			System.out.println("item : " + iter.next());
		}

		System.out.println("\n=========== AVLTree ===========");
		System.out.println("insert method");
		avlTree.insert(10);
		avlTree.insert(20);
		avlTree.insert(30);
		avlTree.insert(40);
		avlTree.insert(50);

		System.out.println(avlTree);

		System.out.println("iterator method");
		iter = avlTree.iterator();
		while(iter.hasNext()){
			System.out.println("item : " + iter.next());
		}

		System.out.println("headSet method, 30");
		System.out.println(avlTree.headSet(30));

		System.out.println("tailSet method, 10");
		System.out.println(avlTree.headSet(20));


	}

	public static void partTwoTest(){

		System.out.println("=========================== PART2 ===========================");

		Part2<Integer> p2 = new Part2<Integer>();

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		System.out.println("Binary Search Tree : ");
		bst.add(12);bst.add(6);bst.add(1);bst.add(45);
		bst.add(3);bst.add(-3);bst.add(44);bst.add(78);
		bst.add(2);bst.add(5);bst.add(0);bst.add(99);
		System.out.println(bst);

		System.out.println("Is AVLTree : " + p2.isAVLTree(bst));
		System.out.println("Is RedBlackTree : " + p2.isRedBlackTree(bst));

		AVLTree<Integer> avl = new AVLTree<Integer>();
		System.out.println("AVLTree : ");
		avl.add(12);avl.add(6);avl.add(1);avl.add(45);
		avl.add(3);avl.add(-3);avl.add(44);avl.add(78);
		avl.add(2);avl.add(5);avl.add(0);avl.add(99);
		System.out.println(avl);

		System.out.println("Is AVLTree : " + p2.isAVLTree(avl));
		System.out.println("Is RedBlackTree : " + p2.isRedBlackTree(avl));

		RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
		System.out.println("RedBlackTree : ");
		rbt.add(12);rbt.add(6);rbt.add(1);rbt.add(45);
		rbt.add(3);rbt.add(-3);rbt.add(44);rbt.add(78);
		rbt.add(2);rbt.add(5);rbt.add(0);rbt.add(99);
		System.out.println(rbt);

		System.out.println("Is AVLTree : " + p2.isAVLTree(rbt));
		System.out.println("Is RedBlackTree : " + p2.isRedBlackTree(rbt));

	}

	public static void partThreeTest(){

		System.out.println("=========================== PART3 ===========================");

		Random rand = new Random();
		long startTime;
		long bstTime, rbtTime, slTime, ttTime, btTime;

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

		partOneTest();
		partThreeTest();
		partTwoTest();

	}

}