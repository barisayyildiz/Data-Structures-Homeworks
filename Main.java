import com.structures.*;
import com.lib.*;

import java.util.Iterator;

public class Main
{
	public static void main(String args[])
	{
		
		Heap<Integer> h1 = new Heap<Integer>(true);
		h1.offer(3);
		h1.offer(7);
		h1.offer(2);
		h1.offer(4);
		h1.offer(1);
		h1.offer(4);
		h1.offer(1);
		h1.offer(1);

		Iterator<Integer> iter = h1.iterator();

		System.out.println(h1);
		try{
			System.out.println(h1.removeKthLargest(3));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(h1);

		h1.offer(10);
		h1.offer(10);
		h1.offer(10);
		h1.offer(10);
		h1.offer(10);
		h1.offer(10);
		h1.offer(10);
		System.out.println(h1);
		h1.poll();
		System.out.println(h1);
		h1.poll();
		h1.poll();
		System.out.println(h1);

		System.out.println(h1.findMode());
		



		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		bst.add(7);
		bst.add(8);
		bst.add(9);

		
		bst.add(10);
		bst.add(11);
		bst.add(1);
		bst.add(1);
		
		bst.add(-10);
		bst.add(-11);
		bst.add(-11);
		bst.add(-11);
		bst.add(-8);
		bst.add(-9);
		
		bst.add(-10);
		bst.add(-11);
		bst.add(-8);
		bst.add(-9);
		
		bst.add(-10);
		bst.add(-99);

		System.out.println(bst);

		bst.remove(-11);
		bst.remove(-99);
		bst.add(-23);
		bst.add(500);
		bst.add(500);
		bst.add(500);
		bst.add(500);
		bst.add(500);
		bst.add(500);
		
		System.out.println(bst);

		System.out.println(bst.find(-11));
		System.out.println(bst.find_mode());




	}
}

