import com.*;

public class Main
{
	public static void main(String args[])
	{
		Heap<Integer> h1 = new Heap<Integer>();
		h1.offer(3);
		h1.offer(7);
		h1.offer(2);
		h1.offer(4);
		h1.offer(1);

		System.out.println(h1);
		System.out.println(h1.removeKthLargest(4));

		h1.offer(10);
		System.out.println(h1);

		h1.printFreq();

	}
}

