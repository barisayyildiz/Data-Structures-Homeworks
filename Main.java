import com.*;
import java.util.*;

public class Main
{
	public static void main(String args[]){

		// MapIterator<String,String> mapIter = new MapIterator<String,String>();

		// mapIter.put("56941479184","baris");
		// mapIter.put("55555555555","john");
		// mapIter.put("33333333333","doe");

		// mapIter.next();
		// mapIter.next();
		// mapIter.prev();

		// while(mapIter.hasNext()){
		// 	System.out.println(mapIter.next());
		// }

		// System.out.println(mapIter);




		// HashMapOpen<Integer,String> hmap = new HashMapOpen<Integer,String>();

		// hmap.put(1,"baris");
		// hmap.put(2,"baqwes");
		// hmap.put(12,"!!!!!!!!!!!!!!");
		// hmap.put(3,"bqweqw");
		// hmap.put(4,"b12312");
		// hmap.put(5,"23gfsf");
		// hmap.put(6,"rgwe");
		// hmap.put(7,"b2qfqws");
		// hmap.put(11,"!!!!!");
		// hmap.put(67,"bqweqw");
		// hmap.put(13,"b12312");
		// hmap.put(34,"23gfsf");
		// // hmap.put(-3,"b2qfqws");

		// System.out.println(hmap);

		// hmap.remove(7);
		// hmap.remove(6);
		// hmap.remove(12);
		// hmap.remove(1);
		// hmap.remove(2);

		// // System.out.println(hmap.get(12));
		// System.out.println(hmap);


		MapIterator<Integer,String> mapiter = new MapIterator<Integer,String>();

		mapiter.put(2,"baris");
		mapiter.put(6,"asya");
		mapiter.put(21,"ruzgar");

		mapiter.next();
		mapiter.next();
		mapiter.prev();

		while(mapiter.hasNext()){
			System.out.println(mapiter.next());
		}



	}
}