import lib.furniture.*;
import lib.user.*;
import lib.*;

public class Main
{
	public static void main(String args[])
	{
		List<Integer> l1 = new List<Integer>();

		l1.insert(2);
		l1.insert(4);
		l1.insert(6);

		l1.remove(1);

		System.out.println(l1);

		// Company c1 = new Company();
		// c1.test();

	}
}

