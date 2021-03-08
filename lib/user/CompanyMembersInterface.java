package lib.user;

import lib.furniture.*;
import lib.*;

public interface CompanyMembersInterface {
	
	void productsNeedToBeSupplied();

	boolean addCustomer(Customer customer);
	boolean removeCustomer(int customerId);

	void addProducts(int branchId, int productId, int amount) throws Exception;
	void removeProducts(int branchId, int productId, int amount) throws Exception;
	
}
