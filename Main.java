import com.*;

public class Main
{
	public static void main(String args[])
	{
		// Heap<Integer> h1 = new Heap<Integer>();
		// h1.offer(3);
		// h1.offer(7);
		// h1.offer(2);
		// h1.offer(4);
		// h1.offer(1);

		// System.out.println(h1);
		// System.out.println(h1.removeKthLargest(4));

		// h1.offer(10);
		// h1.offer(2);
		// System.out.println(h1);

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		System.out.println(bst.offer(3));
		System.out.println(bst.offer(4));
		System.out.println(bst.offer(5));
		System.out.println(bst.offer(6));
		System.out.println(bst.offer(7));
		System.out.println(bst.offer(8));
		System.out.println(bst.offer(9));

		System.out.println(bst.offer(10));
		System.out.println(bst.offer(11));
		System.out.println(bst.offer(1));
		System.out.println(bst.offer(1));

		System.out.println(bst.offer(-10));
		System.out.println(bst.offer(-11));
		System.out.println(bst.offer(-8));
		System.out.println(bst.offer(-9));

		System.out.println(bst.offer(-10));
		System.out.println(bst.offer(-11));
		System.out.println(bst.offer(-8));
		System.out.println(bst.offer(-9));

		System.out.println(bst.offer(-10));
		System.out.println(bst.offer(-99));


		System.out.println(bst);



	}
}

