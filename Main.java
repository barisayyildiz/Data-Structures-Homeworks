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

		while(hashMapIter.hasNext()){
			System.out.println(hashMapIter.next());
		}

		try{
			System.out.println(hashMapIter.next());
		}catch(Exception exception){
			System.out.println(exception.getMessage() + "\n");
		}

		MapIterator<String,Integer> hashMapIter2 = new MapIterator<String,Integer>("baris");
		hashMapIter2.put("baris",100); hashMapIter2.put("asya",95);	hashMapIter2.put("ruzgar",85);	hashMapIter2.put("pelin",70);	hashMapIter.put("orhun",88);
		
		while(hashMapIter2.hasNext()){
			System.out.println(hashMapIter2.next());
		}

		// ============= Test Cases for HashMapList
		// ============= Small Sized Hash Maps
		HashMapList<Integer,String> hMapList = new HashMapList<Integer,String>();
		HashMapTree<Integer,String> hMapTree = new HashMapTree<Integer,String>();
		HashMapOpen<Integer,String> hMapOpen = new HashMapOpen<Integer,String>();
		String rndStr = "";
		int rndInt = 0;

		// for(int i=0; i<20; i++){
		// 	rndInt = randomIntger(20);
		// 	rndStr = randomString();

		// 	hMapList.put(rndInt, rndStr);
		// 	hMapTree.put(rndInt, rndStr);
		// 	hMapOpen.put(rndInt, rndStr);
		// }

		// System.out.println("HashMapList : " +  hMapList);
		// System.out.println("HashMapTree : " +  hMapTree);
		// System.out.println("HashMapOpen : " +  hMapOpen + "\n");

		// System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		// System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		// System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));

		// System.out.println("\nRemoving the pair with the key value of " + rndInt);
		// hMapList.remove(rndInt);
		// hMapTree.remove(rndInt);
		// hMapOpen.remove(rndInt);
		// System.out.println("After removal...\n");
		// System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		// System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		// System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));

		// System.out.println("\nRemoving non existing item 999");
		// System.out.println("Removed value is " + hMapList.remove(999));
		// System.out.println("Removed value is " + hMapTree.remove(999));
		// System.out.println("Removed value is " + hMapOpen.remove(999));




		// System.out.println("\n =============== Adding 100 more items =============== \n");

		// for(int i=0; i<100; i++){
		// 	rndInt = randomIntger(200);
		// 	rndStr = randomString();

		// 	hMapList.put(rndInt, rndStr);
		// 	hMapTree.put(rndInt, rndStr);
		// 	hMapOpen.put(rndInt, rndStr);
		// }

		// System.out.println("HashMapList : " +  hMapList + "\n");
		// System.out.println("HashMapTree : " +  hMapTree + "\n");
		// System.out.println("HashMapOpen : " +  hMapOpen + "\n");


		// System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		// System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		// System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));

		// System.out.println("\nRemoving the pair with the key value of " + rndInt);
		// hMapList.remove(rndInt);
		// hMapTree.remove(rndInt);
		// hMapOpen.remove(rndInt);
		// System.out.println("After removal...\n");
		// System.out.println("For HashMapList key : " + rndInt + ", value : " + hMapList.get(rndInt));
		// System.out.println("For HashMapTree key : " + rndInt + ", value : " + hMapTree.get(rndInt));
		// System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));



		

		System.out.println("\n =============== Adding 500 more items =============== \n");

		for(int i=0; i<500; i++){
			rndInt = randomIntger(2000);
			rndStr = randomString();
			// rndInt = i;

			hMapList.put(rndInt, rndStr);
			hMapTree.put(rndInt, rndStr);
			hMapOpen.put(rndInt, rndStr);
		}

		System.out.println("HashMapList : " +  hMapList + "\n");
		System.out.println("HashMapTree : " +  hMapTree + "\n");
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
		// System.out.println("For HashMapOpen key : " + rndInt + ", value : " + hMapOpen.get(rndInt));
		hMapOpen.get(rndInt);

		System.out.println("HashMapList size : " + hMapList.size());
		System.out.println("HashMapTree size : " + hMapTree.size());
		System.out.println("HashMapOpen size : " + hMapOpen.size());






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

		HashMapOpen<Integer,String> hMapOpen = new HashMapOpen<Integer,String>();
		hMapOpen.put(8,"qawe");
		hMapOpen.put(5,"qawe");
		hMapOpen.put(11,"qawe");
		hMapOpen.put(18,"qawe");
		hMapOpen.put(6,"qawe");
		hMapOpen.put(2,"qawe");
		hMapOpen.put(17,"qawe");
		hMapOpen.put(3,"qawe");
		hMapOpen.put(13,"qawe");
		hMapOpen.put(21,"qawe");
		hMapOpen.put(34,"qawe");
		hMapOpen.put(-34,"qawe");
		hMapOpen.put(-34,"12317273");

		System.out.println(hMapOpen);

	}

	public static void main(String args[]){

		// testCases2();

		testCases();

		// HashMapList<Integer,String> hmap = new HashMapList<Integer,String>();
		// hmap.put(3,"baris");
		// hmap.put(4,"asya");

		// hmap.put(3,"pelin");

		// System.out.println(hmap);

		// // MapIterator<String,String> mapIter = new MapIterator<String,String>();

		// // mapIter.put("56941479184","baris");
		// // mapIter.put("55555555555","john");
		// // mapIter.put("33333333333","doe");

		// // mapIter.next();
		// // mapIter.next();
		// // mapIter.prev();

		// // while(mapIter.hasNext()){
		// // 	System.out.println(mapIter.next());
		// // }

		// // System.out.println(mapIter);




		// HashMapList<Integer,String> hmap = new HashMapList<Integer,String>();

		// hmap.put(1,"asd");
		// hmap.put(2,"qwe");
		// hmap.put(3,"qwe");
		// hmap.put(4,"qwe");
		// hmap.put(5,"qwe");
		// hmap.put(6,"qwe");
		// hmap.put(7,"qwe");
		// hmap.put(8,"qwe");
		// hmap.put(8,"123213");
		// // hmap.put(9,"qwe");
		// // hmap.put(10,"qwe");
		// // hmap.put(11,"qwe");
		// // hmap.put(12,"qwe");
		// // hmap.put(13,"qwe");
		// // hmap.put(14,"qwe");
		// // hmap.put(15,"qwe");
		// // hmap.put(16,"qwe");

		// System.out.println(hmap);

		// hmap.remove(4);

		// // hmap.put(1,"baris");
		// // hmap.put(2,"baqwes");
		// // hmap.put(12,"!!!!!!!!!!!!!!");
		// // hmap.put(3,"bqweqw");
		// // hmap.put(4,"b12312");
		// // hmap.put(5,"23gfsf");
		// // // hmap.put(12,"qqqqqqqqqqqqqqqqqqqqqqqq");
		// // hmap.put(6,"rgwe");
		// // hmap.put(7,"b2qfqws");
		// // hmap.put(11,"!!!!!");
		// // hmap.put(67,"bqweqw");
		// // hmap.put(13,"b12312");
		// // hmap.put(34,"23gfsf");
		// // // hmap.put(-3,"b2qfqws");

		// // System.out.println(hmap);

		// // hmap.remove(7);
		// // hmap.remove(6);
		// // hmap.remove(12);
		// // hmap.remove(1);
		// // hmap.remove(2);

		// // System.out.println(hmap.get(4));
		// System.out.println(hmap);


		// // MapIterator<Integer,String> mapiter = new MapIterator<Integer,String>();

		// // mapiter.put(2,"baris");
		// // mapiter.put(6,"asya");
		// // mapiter.put(21,"ruzgar");

		// // mapiter.next();
		// // mapiter.next();
		// // mapiter.prev();

		// // while(mapiter.hasNext()){
		// // 	System.out.println(mapiter.next());
		// // }



	}
}