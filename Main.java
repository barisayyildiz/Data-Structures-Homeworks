import com.*;

public class Main
{
	public static void main(String args[])
	{
		// Test<Integer> t1 = new Test<Integer>();
		// t1.add(3);
		// t1.add(7);
		// t1.add(12);

		// System.out.println(t1);


		// Heap<Integer> h1 = new Heap<Integer>();
		// h1.offer(3);
		// h1.offer(7);
		// h1.offer(2);
		// h1.offer(4);
		// h1.offer(1);
		// h1.offer(4);
		// h1.offer(1);
		// h1.offer(1);

		// // System.out.println(h1);
		// // System.out.println(h1.removeKthLargest(1));

		// h1.offer(10);
		// h1.offer(10);
		// h1.offer(10);
		// System.out.println(h1);
		// h1.poll();
		// System.out.println(h1);
		// h1.poll();
		// h1.poll();
		// System.out.println(h1);



		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.offer(3);
		bst.offer(4);
		bst.offer(5);
		bst.offer(6);
		bst.offer(7);
		bst.offer(8);
		bst.offer(9);

		
		bst.offer(10);
		bst.offer(11);
		bst.offer(1);
		bst.offer(1);
		
		bst.offer(-10);
		bst.offer(-11);
		bst.offer(-8);
		bst.offer(-9);
		
		bst.offer(-10);
		bst.offer(-11);
		bst.offer(-8);
		bst.offer(-9);
		
		bst.offer(-10);
		bst.offer(-99);
		
		System.out.println(bst);




	}
}

