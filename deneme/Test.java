package deneme;

import java.lang.Comparable;

public class Test<E> {

	Node<E> mynode;

	public Test(E e){
		mynode = new Node<E>(e);
	}

	@Override
	public String toString(){
		return this.e.toString();
	}


	private class Node<E extends Comparable<E>> implements Comparable<E>
	{
		private E e;
		public Node(E e){
			this.e = e;
		}
		public int compareTo(E e){
			return this.e.compareTo(e);
		}
		public E getVal(){
			return this.e;
		}
	}

	
}
