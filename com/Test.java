package com;

public class Test<E>
{
	private Node<E> arr[];
	private int size;
	
	public Test(){
		this.arr = new Node[10];
		this.size = 0;
	}

	public void add(E e){
		this.arr[this.size++] = new Node<E>(e);	
	}

	@Override
	public String toString(){
		String str = "";
		for(int i=0; i<this.size; i++){
			str += String.valueOf(this.arr[i].getData() + " ");
		}
		return str;
	}
	
}


class Node<E> extends Object
{
	private E data;
	public Node(E data){
		this.data = data;
	}
	public E getData(){
		return data;
	}
}
