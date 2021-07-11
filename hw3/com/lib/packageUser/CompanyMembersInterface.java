package com.lib.packageUser;

import com.lib.furniture.*;
import com.lib.company.*;

/**
 * Company Members Interface
 * @author Barış Ayyıldız
 */

public interface CompanyMembersInterface {
	
	/**
	 * Displays all the products from all the branches that is out of stock
	 */
	void productsNeedToBeSupplied();

	/**
	 * Adds a new customer to the company
	 * @param customer new customer
	 * @return true when there is no error
	 */
	boolean addCustomer(Customer customer);

	/**
	 * Removes a customer from the company
	 * @param customerId id of the customer that is going to be deleted
	 * @return returns true when there is no error
	 */
	boolean removeCustomer(int customerId);

	/**
	 * Adds a product to a branch
	 * @param branchId branch id
	 * @param productId product id
	 * @param amount amount of product
	 * @throws Exception throws when amount is negative or branch is not found
	 */
	void addProducts(int branchId, int productId, int amount) throws Exception;

	/**
	 * Removes a product from a branch
	 * @param branchId branch id
	 * @param productId product id
	 * @param amount amount of product
	 * @throws Exception throws when amount is negative or branch is not found
	 */
	void removeProducts(int branchId, int productId, int amount) throws Exception;
	
}
