package lib.user;

import lib.furniture.*;
import lib.*;

public interface AdminInterface {

	boolean addBranch();
	boolean removeBranch(int branchId);

	boolean addBranchEmployee(Employee person);
	boolean removeBranchEmployee(int id);

	void productsNeedToBeSupplied();

	void addCustomer(Customer customer);
	void removeCustomer(int customerId);

	void addProducts(int branchId, int productId, int amount);
	void removeProducts(int branchId, int productId, int amount);

	Company getCompany();
	
}
