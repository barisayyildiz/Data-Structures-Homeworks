package lib;

import lib.furniture.*;
import lib.user.*;

public interface ListInterface<T> {

	public void insert(T val);
	public void remove(int index);
	public int length();
	
}
