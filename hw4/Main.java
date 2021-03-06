import com.structures.*;

import com.lib.*;

import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main
{

	public static void testCases(){

		System.out.println("// ===================== HEAP METHODS ===================== //");

		Heap<Integer> h1 = new Heap<Integer>();
		System.out.println("Heap, offer method : ");
		System.out.println("Before : " + h1);
		h1.offer(3);
		h1.offer(5);
		h1.offer(7);
		System.out.println("After : " + h1 + "\n");

		System.out.println("Heap, size method : ");
		System.out.println("Size : " + h1.size() + "\n");

		System.out.println("Heap, poll method : ");
		System.out.println("Before : " + h1);
		h1.poll();
		System.out.println("After : " + h1 + "\n");

		System.out.println("Heap, peek method : ");
		System.out.println("Element in the root : " + h1.peek() + "\n");

		System.out.println("Heap, contains method : ");
		System.out.println("Current heap : " + h1);
		System.out.println("Is it contains 5 : " + h1.contains(5));
		System.out.println("Is it contains 12 : " + h1.contains(12) + "\n");

		System.out.println("Heap, merge method : ");
		Heap<Integer> h2 = new Heap<Integer>();
		h2.offer(2);
		h2.offer(4);
		h2.offer(9);
		h2.offer(11);
		h2.offer(-6);

		System.out.println("heap-1 : " + h1 + "\nheap-2 : " + h2);
		h1.merge(h2);
		System.out.println("After merging : " + h1 + "\n");

		System.out.println("Heap, removeKthLargest method : ");
		
		try{
			h1.removeKthLargest(1);
			System.out.println("After removing 1st greatest number : " + h1);

			h1.removeKthLargest(3);
			System.out.println("After removing 3rd greatest number : " + h1);
			
			System.out.println("Trying to remove -2nd greatest element... : " + h1 + "\n");

		}catch(Exception exception){
			System.out.println(exception.getMessage() + "\n");
		}
		
		System.out.println("Heap, removeByValue method : ");
		System.out.println("Before : " + h1);
		h1.removeByValue(5);
		System.out.println("After removing the value 5 : " + h1 + "\n");

		System.out.println("Heap, indexOf method : ");
		System.out.println("Current heap : " + h1);
		System.out.println("Index of 2 : " + h1.indexOf(2));
		System.out.println("Index of 55 : " + h1.indexOf(55) + ", so it does not exists" + "\n");

		System.out.println("Heap, numberOfOccurrences : ");
		Heap<Integer> h3 = new Heap<Integer>(true);
		h3.offer(2); h3.offer(2); h3.offer(2);
		h3.offer(4);
		h3.offer(5);
		h3.offer(8); h3.offer(8); h3.offer(8); h3.offer(8);
		h3.offer(12);
		h3.offer(11);

		System.out.println("Current heap : " + h3);
		System.out.println("Frequency of 5 : " + h3.numberOfOccurrences(5));
		System.out.println("Frequency of 8 : " + h3.numberOfOccurrences(8) + "\n");

		System.out.println("Heap, findMode : ");
		System.out.println("Current heap : " + h3);
		System.out.println("Mode of the heap : " + h3.findMode().getKey() + ", it is repated for " + h3.findMode().getValue() + " times\n");
		
		
		System.out.println("// ===================== HEAP ITERATOR METHODS ===================== //");
		Heap<Integer> h4 = new Heap<Integer>();
		h4.offer(7);
		h4.offer(2);
		h4.offer(1);
		h4.offer(34);
		h4.offer(73);

		System.out.println("Current heap : " + h4);
		
		Iterator<Integer> iter = h4.iterator();
		while(iter.hasNext()){
			System.out.println("iter.next : " + iter.next());
		}

		iter = h4.iterator();
		System.out.println("Iterator reseted...\nRemoving second element");

		iter.next();
		iter.next();
		iter.remove();

		System.out.println("Heap : " + h4 + "\n");


		System.out.println("// ===================== BINARY SEARCH TREE METHODS ===================== //");

		BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
		
		System.out.println("BST, add method : ");
		System.out.println("Before : " + bst1);
		bst1.add(3);bst1.add(3);bst1.add(3);
		bst1.add(5);bst1.add(5);
		bst1.add(6);
		bst1.add(12);bst1.add(12);
		bst1.add(-4);bst1.add(-4);bst1.add(-4);bst1.add(-4);
		bst1.add(1);
		bst1.add(7);
		bst1.add(9);
		bst1.add(55);bst1.add(55);
		bst1.add(23);
		System.out.println("After : " + bst1 + "\n");

		System.out.println("\n\tINORDER TRAVERSAL IS USED!\n\n");

		System.out.println("After removing 9, there are  : " + bst1.remove(9) + ", 9 left " + " -> " + bst1);
		System.out.println("After removing 55, there are  : " + bst1.remove(55) + ", 55 left " + " -> " + bst1 + "\n");

		System.out.println("BST, find method : ");
		System.out.println("Current : " + bst1);
		System.out.println("Number of occurences of 12 : " + bst1.find(12));
		System.out.println("Number of occurences of -4 : " + bst1.find(-4));
		System.out.println("Number of occurences of 100 : " + bst1.find(100) + "\n");

		System.out.println("BST, find_mode method : ");
		System.out.println("Current : " + bst1);
		System.out.println("Mode : " + bst1.find_mode() + "\n");



	}

	public static void testCases2(){

		System.out.println("\n// ================== TEST CASES FOR PART 2 ================== //\n");

		Random r = new Random();

		int low = 0;
		int high = 5000;
		int result;

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for(int i=0; i<3000; i++){
			result = r.nextInt(high-low) + low;
			bst.add(result);
			arr.add(result);
		}

		Collections.sort(arr);

		for(int i=0; i<100; i++){
			result = r.nextInt(3000);
			System.out.println("Number of occurences of " + result + "\tin BST is " + bst.find(result) + ", in array : " + Collections.frequency(arr, result));
		}

		System.out.println("\n\n");

		for(int i=0; i<10; i++){
			System.out.println("Number of occurences of " + (6000+(i*10)) + "\tin BST is " + bst.find((6000+(i*10))) + ", in array : " + Collections.frequency(arr, (6000+(i*10))));
		}


		System.out.println("\n// ==================== REMOVAL ==================== //\n");

		for(int i=0; i<100; i++){
			result = r.nextInt(3000 - i);
			arr.get(result);
			arr.remove((Integer)result);
			bst.remove(result);
			System.out.println("After removal, number of occurences of " + result + "\tin BST is " + bst.find(result) + ", in array : " + Collections.frequency(arr, result));
		}

		System.out.println("\n\n");

		for(int i=0; i<10; i++){
			result = (6000+(i*10));
			arr.remove((Integer)result);
			bst.remove((Integer)result);
			System.out.println("After removal, number of occurences of " + result + "\tin BST is " + bst.find(result) + ", in array : " + Collections.frequency(arr, result));
		}

		
		System.out.println("Mode of BST : " + bst.find_mode());
		System.out.println("Mode of array : " + findModeArrayList(arr) + "\n");
		System.out.println("If there is an error finding the modes, the values should have the same frequency...\n");

		
	}

	public static int findModeArrayList(ArrayList<Integer> arr){
		
		int mode = arr.get(0);
		int max = 0;
		int counter = 1;
		int currentVal = arr.get(0);
		
		for(int i=1; i<arr.size(); i++){
			if(arr.get(i) != currentVal){
				if(counter > max){
					mode = currentVal;
					max = counter;
				}
				counter = 1;
				currentVal = arr.get(i);
				continue;
			}
			counter++;
		}

		return mode;
	}

	public static void main(String args[])
	{

		testCases();

		testCases2();
		
		
	}
}

