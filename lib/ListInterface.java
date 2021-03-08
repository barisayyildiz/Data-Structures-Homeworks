package lib;

import lib.furniture.*;
import lib.user.*;

public interface ListInterface<T> {

	public void insert(T val);
	public void remove(int index) throws ArrayIndexOutOfBoundsException;
	public int length();
	public T get(int index) throws ArrayIndexOutOfBoundsException;
	public void set(int index, T val);
	
}
