import java.util.Iterator;
import java.util.TreeSet;

public class Test
{
	public static void main(String args[]){
		
		TreeSet<String> tree = new TreeSet<String>();

		tree.add("g");
		tree.add("a");
		tree.add("b");

		System.out.println(tree.last());

		// Iterator<String> iter = tree.iterator();
		// while(iter.hasNext()){
		// 	System.out.println(iter.next());
		// }
		// System.out.println(tree.toArray());

	}
}