import com.*;
import java.util.*;

import java.util.Random;

public class Main
{

	public static void testCases(){

		// ============= Test Cases for MapIterator
		MapIterator<String,Integer> hashMapIter = new MapIterator<String,Integer>();

		hashMapIter.put("baris",100); hashMapIter.put("asya",95);	hashMapIter.put("ruzgar",85);	hashMapIter.put("pelin",70);	hashMapIter.put("orhun",88);
		hashMapIter.next();	hashMapIter.next();	hashMapIter.prev();

		System.out.println("next : " + hashMapIter.next());
		System.out.println("next : " + hashMapIter.next());
		System.out.println("next : " + hashMapIter.prev());
		System.out.println("next : " + hashMapIter.next());
		System.out.println("next : " + hashMapIter.next());

		System.out.println("\nHashMap : " + hashMapIter);
		System.out.println("testing hasNext, prev and next methods\n");

		while(hashMapIter.hasNext()){
			System.out.println(hashMapIter.next());
		}

		try{
			System.out.println(hashMapIter.next());
		}catch(Exception exception){
			System.out.println(exception.getMessage() + "\n");
		}

		MapIterator<String,Integer> hashMapIter2 = new MapIterator<String,Integer>("baris");
		hashMapIter2.put("baris",100); hashMapIter2.put("asya",95);	hashMapIter2.put("ruzgar",85);	hashMapIter2.put("pelin",70);	hashMapIter2.put("orhun",88);
		
		System.out.println("\nHashMap : " + hashMapIter2);
		System.out.println("One parameter constructor with the parameter \'baris\'");

		while(hashMapIter2.hasNext()){
			System.out.println(hashMapIter2.next());
		}

		System.out.println("\n ================================== Test Cases for HashMaps ================================== \n");

		// ============= Small Sized Hash Maps
		HashMapList<Integer,String> hMapList = new HashMapList<Integer,String>();
		HashMapTree<Integer,String> hMapTree = new HashMapTree<Integer,String>();
		HashMapOpen<Integer,String> hMapOpen = new HashMapOpen<Integer,String>();
		String rndStr = "";
		int rndInt = 0;

		for(int i=0; i<20; i++){
			rndInt = randomIntger(20);
			rndStr = randomString();

			hMapList.put(rndInt, rndStr);
			hMapTree.put(rndInt, rndStr);
			hMapOpen.put(rndInt, rndStr);
		}

		System.out.println("\nFor HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));

		System.out.println("\nRemoving the pair with the key value of " + rndInt);
		hMapList.remove(rndInt);
		hMapTree.remove(rndInt);
		hMapOpen.remove(rndInt);
		System.out.println("After removal...\n");
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));

		System.out.println("\nRemoving non existing item 999");
		System.out.println("Removed value is " + hMapList.remove(999));
		System.out.println("Removed value is " + hMapTree.remove(999));
		System.out.println("Removed value is " + hMapOpen.remove(999));




		System.out.println("\n =============== Adding 100 more items =============== \n");

		for(int i=0; i<100; i++){
			rndInt = randomIntger(200);
			rndStr = randomString();

			hMapList.put(rndInt, rndStr);
			hMapTree.put(rndInt, rndStr);
			hMapOpen.put(rndInt, rndStr);
		}


		System.out.println("\nFor HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));

		System.out.println("\nRemoving the pair with the key value of " + rndInt);
		hMapList.remove(rndInt);
		hMapTree.remove(rndInt);
		hMapOpen.remove(rndInt);
		System.out.println("After removal...\n");
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));
		

		System.out.println("\n =============== Adding 500 more items =============== \n");

		for(int i=0; i<500; i++){
			rndInt = randomIntger(2000);
			rndStr = randomString();
			// rndInt = i;

			hMapList.put(rndInt, rndStr);
			hMapTree.put(rndInt, rndStr);
			hMapOpen.put(rndInt, rndStr);
		}

		System.out.println("HashMapOpen : " +  hMapOpen + "\n");

		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));
		hMapOpen.get(rndInt);

		System.out.println("\nRemoving the pair with the key value of " + rndInt);
		hMapList.remove(rndInt);
		hMapTree.remove(rndInt);
		hMapOpen.remove(rndInt);
		System.out.println("After removal...\n");
		System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));

		System.out.println("\nSize of HashMapList : " + hMapList.size());
		System.out.println("Size of HashMapTree : " + hMapTree.size());
		System.out.println("Size of HashMapOpen : " + hMapOpen.size());

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

	public static void testCases2(){

		HashMapOpen<Integer,String> hmap = new HashMapOpen<Integer,String>();
		// hmap.put(randomIntger(100), randomString());

		hmap.put(2, "a");
		hmap.put(13, "b");
		hmap.put(24, "c");
		hmap.put(7, "d");
		hmap.put(8, "e");
		hmap.put(99, "f");

		hmap.remove(2);
		hmap.remove(24);
		hmap.remove(99);
		hmap.remove(13);

		System.out.println(hmap);

	}

	public static void main(String args[]){

//		testCases();
		testCases2();

	}
}