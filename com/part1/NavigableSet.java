package com.part1;

import java.util.Iterator;
import java.util.SortedSet;

public interface NavigableSet<E> {

	boolean insert(E key) throws Exception;
	boolean delete(E key) throws Exception;
	Iterator<E> descendingIterator() throws Exception;
	Iterator<E> iterator() throws Exception;
	SortedSet<E> headSet(E toElement) throws Exception;
	SortedSet<E> tailSet(E fromElement) throws Exception;
	
}
