import com.*;
import java.util.*;

import java.util.Random;

public class Main
{
	public static void testCasesIterator(){

		// ============= Test Cases for MapIterator
		MapIterator<String,Integer> hashMapIter = new MapIterator<String,Integer>();

		hashMapIter.put("baris",100); hashMapIter.put("asya",95);	hashMapIter.put("ruzgar",85);	hashMapIter.put("pelin",70);	hashMapIter.put("orhun",88);

		System.out.println("\nHashMap : " + hashMapIter);

		System.out.println("\nTest Case ID 000 and 001 : ");

		System.out.println("next : " + hashMapIter.next());
		System.out.println("next : " + hashMapIter.next());
		System.out.println("prev : " + hashMapIter.prev());
		System.out.println("next : " + hashMapIter.next());
		System.out.println("next : " + hashMapIter.next());
		System.out.println("prev : " + hashMapIter.prev());
		System.out.println("prev : " + hashMapIter.prev());

		System.out.println("\nTest Case ID 002 : ");
		System.out.println("hasNext : " + hashMapIter.hasNext());


		MapIterator<String,Integer> hashMapIter2 = new MapIterator<String,Integer>("baris");
		hashMapIter2.put("baris",100); hashMapIter2.put("asya",95);	hashMapIter2.put("ruzgar",85);	hashMapIter2.put("pelin",70);	hashMapIter2.put("orhun",88);
		
		System.out.println("\nHashMap : " + hashMapIter2);
		System.out.println("One parameter constructor with the parameter \'baris\'");

		System.out.println("\nTest Case ID 000 and 002 : ");
		while(hashMapIter2.hasNext()){
			System.out.println(hashMapIter2.next());
		}

	}

	public static void testCasesHashMapList(){

		String rndStr = "";
		int rndInt = 0;
		long startTime, endTime;
		double BILLION = 1000000000;

		System.out.println("\n ======================================================== Test Cases for HashMapList ======================================================== \n");

		// ============= Small Sized HashMapList
		HashMapList<Integer,String> hMapList = new HashMapList<Integer,String>();

		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 20 items ============================== ");
		
		startTime = System.nanoTime();
		for(int i=0; i<20; i++){
			rndInt = randomIntger(20);
			rndStr = randomString();

			hMapList.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 20 elements to HashMapList took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapList with " + hMapList.size()  + " elements took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 009 : ");
		startTime = System.nanoTime();
		System.out.println("Removing the pair with the key value of " + rndInt);
		hMapList.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapList with " + String.valueOf(hMapList.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);

		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));


		// ============= Medium Sized HashMapList
		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 100 more items ============================== ");
		startTime = System.nanoTime();
		for(int i=0; i<100; i++){
			rndInt = randomIntger(200);
			rndStr = randomString();

			hMapList.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 100 elements to HashMapList took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapList with " + hMapList.size()  + " elements took " + (endTime - startTime) / BILLION);



		System.out.println("\nTest Case ID 009 : ");
		System.out.println("Removing the pair with the key value of " + rndInt);
		startTime = System.nanoTime();
		hMapList.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapList with " + String.valueOf(hMapList.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));


		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 1000 more items ============================== ");
		startTime = System.nanoTime();
		for(int i=0; i<1000; i++){
			rndInt = randomIntger(200);
			rndStr = randomString();

			hMapList.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 100 elements to HashMapList took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapList with " + hMapList.size()  + " elements took " + (endTime - startTime) / BILLION);



		System.out.println("\nTest Case ID 009 : ");
		System.out.println("Removing the pair with the key value of " + rndInt);
		startTime = System.nanoTime();
		hMapList.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapList with " + String.valueOf(hMapList.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));


		System.out.println("Size of HashMapList : " + hMapList.size());

	}

	public static void testCasesHashMapTree(){

		String rndStr = "";
		int rndInt = 0;
		long startTime, endTime;
		double BILLION = 1000000000;

		System.out.println("\n ======================================================== Test Cases for HashMapTree ======================================================== \n");

		// ============= Small Sized HashMapTree
		HashMapTree<Integer,String> hMapTree = new HashMapTree<Integer,String>();

		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 20 items ============================== ");
		
		startTime = System.nanoTime();
		for(int i=0; i<20; i++){
			rndInt = randomIntger(20);
			rndStr = randomString();

			hMapTree.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 20 elements to HashMapTree took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapTree with " + hMapTree.size()  + " elements took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 009 : ");
		startTime = System.nanoTime();
		System.out.println("Removing the pair with the key value of " + rndInt);
		hMapTree.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapTree with " + String.valueOf(hMapTree.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);

		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));


		// ============= Medium Sized HashMapTree
		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 100 more items ============================== ");
		startTime = System.nanoTime();
		for(int i=0; i<100; i++){
			rndInt = randomIntger(200);
			rndStr = randomString();

			hMapTree.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 100 elements to HashMapTree took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapTree with " + hMapTree.size()  + " elements took " + (endTime - startTime) / BILLION);



		System.out.println("\nTest Case ID 009 : ");
		System.out.println("Removing the pair with the key value of " + rndInt);
		startTime = System.nanoTime();
		hMapTree.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapTree with " + String.valueOf(hMapTree.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));


		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 1000 more items ============================== ");
		startTime = System.nanoTime();
		for(int i=0; i<1000; i++){
			rndInt = randomIntger(200);
			rndStr = randomString();

			hMapTree.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 100 elements to HashMapTree took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapTree with " + hMapTree.size()  + " elements took " + (endTime - startTime) / BILLION);



		System.out.println("\nTest Case ID 009 : ");
		System.out.println("Removing the pair with the key value of " + rndInt);
		startTime = System.nanoTime();
		hMapTree.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapTree with " + String.valueOf(hMapTree.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));


		System.out.println("Size of HashMapTree : " + hMapTree.size());

	}

	public static void testCasesHashMapOpen(){

		String rndStr = "";
		int rndInt = 0;
		long startTime, endTime;
		double BILLION = 1000000000;

		System.out.println("\n ======================================================== Test Cases for HashMapOpen ======================================================== \n");

		// ============= Small Sized HashMapOpen
		HashMapOpen<Integer,String> hMapOpen = new HashMapOpen<Integer,String>();

		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 20 items ============================== ");
		
		startTime = System.nanoTime();
		for(int i=0; i<20; i++){
			rndInt = randomIntger(20);
			rndStr = randomString();

			hMapOpen.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 20 elements to HashMapOpen took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapOpen with " + hMapOpen.size()  + " elements took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 009 : ");
		startTime = System.nanoTime();
		System.out.println("Removing the pair with the key value of " + rndInt);
		hMapOpen.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapOpen with " + String.valueOf(hMapOpen.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);

		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));


		// ============= Medium Sized HashMapOpen
		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 100 more items ============================== ");
		startTime = System.nanoTime();
		for(int i=0; i<100; i++){
			rndInt = randomIntger(200);
			rndStr = randomString();

			hMapOpen.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 100 elements to HashMapOpen took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapOpen with " + hMapOpen.size()  + " elements took " + (endTime - startTime) / BILLION);



		System.out.println("\nTest Case ID 009 : ");
		System.out.println("Removing the pair with the key value of " + rndInt);
		startTime = System.nanoTime();
		hMapOpen.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapOpen with " + String.valueOf(hMapOpen.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));


		System.out.println("\nTest Case ID 003 : ");
		System.out.println("============================== Adding 1000 more items ============================== ");
		startTime = System.nanoTime();
		for(int i=0; i<1000; i++){
			rndInt = randomIntger(200);
			rndStr = randomString();

			hMapOpen.put(rndInt, rndStr);
		}
		endTime = System.nanoTime();
		System.out.println("Putting 100 elements to HashMapOpen took " + (endTime - startTime) / BILLION);

		System.out.println("\nTest Case ID 006 : ");
		startTime = System.nanoTime();
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));
		endTime = System.nanoTime();
		System.out.println("Getting a single element from HashMapOpen with " + hMapOpen.size()  + " elements took " + (endTime - startTime) / BILLION);



		System.out.println("\nTest Case ID 009 : ");
		System.out.println("Removing the pair with the key value of " + rndInt);
		startTime = System.nanoTime();
		hMapOpen.remove(rndInt);
		endTime = System.nanoTime();
		System.out.println("Removing a single element from HashMapOpen with " + String.valueOf(hMapOpen.size() + 1)  + " elements took " + (endTime - startTime) / BILLION);
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));


		System.out.println("Size of HashMapOpen : " + hMapOpen.size());

	}


	public static void testCasesMain(){


		testCasesIterator();
		testCasesHashMapList();
		testCasesHashMapTree();
		testCasesHashMapOpen();

	}

	public static String randomString(){
		Random rand = new Random();
		
		String arr = "qwertyuıopğüasdfghjklşizxcvbnmöç1234567890";
		int size = arr.length();
		String res = "";
		for(int i=0; i<6; i++){
			res += arr.charAt(rand.nextInt(size-1));
		}

		return res;
	}

	public static int randomIntger(int n){
		Random rand = new Random();
		return rand.nextInt(n);
	}

	public static void main(String args[]){

		testCasesMain();

	}
}