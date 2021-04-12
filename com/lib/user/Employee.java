package com.lib.user;

import com.lib.furniture.*;
import com.lib.*;

/**
 * Employee class
 * @author Barış Ayyıldız
 */

public class Employee extends CompanyMembers
{
	/**
	 * Holds the employee's branch id
	 */
	private int branchId;

	/**
	 * Employee constructor
	 * @param mail mail
	 * @param password password
	 * @param company company
	 */
	public Employee(String mail, String password, Company company)
	{
		super(mail, password, company);
	}

	/**
	 * Employee constructor
	 * @param name name
	 * @param surname surname
	 * @param mail mail
	 * @param password password
	 * @param branchId branch id
	 * @param company company
	 */
	public Employee(String name, String surname, String mail, String password, int branchId, Company company)
	{
		super(name, surname, mail, password, company);
		this.branchId = branchId;
	}

	/**
	 * handles selling products to customers
	 * @param customerId customer id
	 * @param productId product id
	 * @param amount amount of product
	 * @throws Exception throws when the amount is negative or there is not enough product in the company
	 */
	public void sell(int customerId, int productId, int amount) throws Exception
	{
		if(amount < 0)
			throw new Exception("amount cannot negative...");

		List<Customer> subs = this.company.getSubs();
		List<Stock> stocks = this.company.getStocks();

		int index = -1;
		int stockIndex = -1;

		for(int i=0; i<subs.size(); i++)
		{
			if(subs.get(i).getId() == customerId)
			{
				index = i;
				break;
			}
		}

		if(index == -1)
			throw new Exception("user not found...");

		for(int i=0; i<stocks.size(); i++)
		{
			if(stocks.get(i).getId() == this.branchId)
			{
				stockIndex = i;
				break;
			}
		}

		int total = stocks.get(stockIndex).getFurnitures().get(productId).getTotal();

		if(amount > total)
			throw new Exception("there is not enough products...");

		stocks.get(stockIndex).getFurnitures().get(productId).setTotal(total - amount);

		List<Furniture> newPurchase = new List<Furniture>();
		Furniture temp = stocks.get(stockIndex).getFurnitures().get(productId);
		
		newPurchase.add(new Furniture(productId, temp.getModelId(), temp.getType(), temp.getColor(), temp.getBranch(), temp.getTotal()));
		newPurchase.get(0).setTotal(amount);

		// previous order a ekle
		Customer customer = subs.get(index);

		customer.addNewOrder(new Stock( customer.getCounter(), newPurchase));

	}

	/**
	 * Returns branch id
	 * @return branch id
	 */
	public int getBranchId(){return this.branchId;}

	
}
