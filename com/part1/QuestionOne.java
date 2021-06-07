package com.part1;

import com.*;
import java.util.Iterator;
import java.util.SortedSet;

public class QuestionOne<E extends Comparable<E>> implements NavigableSet<E>{

	private SkipList<E> list;

	public boolean insert(E key)throws Exception{
		return list.add(key);
	}
	public boolean delete(E key) throws Exception{
		return list.remove(key);
	}
	public Iterator<E> descendingIterator() throws Exception{
		throw new Exception();
	};
	public Iterator<E> iterator() throws Exception{
		throw new Exception();
	};
	public SortedSet<E> headSet(E toElement) throws Exception{
		throw new Exception();
	};
	public SortedSet<E> tailSet(E fromElement) throws Exception{
		throw new Exception();
	};


	
}
