import java.util.TreeSet;

public class Test {

	public static void main(String args[]){

		TreeSet<Integer> tree = new TreeSet<Integer>();

		tree.add(3);
		tree.add(5);
		tree.add(7);

		System.out.println(tree);

		tree.remove(3);

		System.out.println(tree);


	}
}
