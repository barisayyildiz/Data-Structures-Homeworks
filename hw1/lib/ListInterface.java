package lib;

import lib.furniture.*;
import lib.user.*;

/**
 * List interface
 * @author Barış Ayyıldız
 * @param <T> generic type
 */

public interface ListInterface<T> {

	/**
	 * Sets val
	 * @param val val
	 */
	public void insert(T val);
	/**
	 * Removes element by index
	 * @param index index
	 * @throws ArrayIndexOutOfBoundsException index out of bound
	 */
	public void remove(int index) throws ArrayIndexOutOfBoundsException;
	/**
	 * Returns the length
	 * @return length
	 */
	public int length();
	/**
	 * Returns the element by the index
	 * @param index index
	 * @return Generic T type
	 * @throws ArrayIndexOutOfBoundsException index out of bound
	 */
	public T get(int index) throws ArrayIndexOutOfBoundsException;
	/**
	 * Sets element by the val
	 * @param index index
	 * @param val val
	 */
	public void set(int index, T val) throws ArrayIndexOutOfBoundsException;
	
}
