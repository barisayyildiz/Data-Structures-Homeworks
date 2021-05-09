package com;

/**
 * @author Elliot B. Koffman, Paul A. T. Wolfgang
 * KWHashMap interface
 * HashMapList, HashMapTree and HashMapOpen implements this interface
 */

public interface KWHashMap<K,V> {

	V get (Object key);
	boolean isEmpty();
	V put( K key, V value);
	V remove(Object key);
	int size();

}
