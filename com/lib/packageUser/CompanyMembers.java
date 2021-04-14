package com.lib.packageUser;

import com.lib.company.*;
import com.lib.furniture.*;

import com.collections.*;

/**
 * CompanyMembers class, superclass for Admin and Employee. Implements CompanyMembersInterface
 * @author Barış Ayyıldız
 */

public class CompanyMembers extends User implements CompanyMembersInterface{

	/**
	 * CompanyMembers constructor
	 * @param name name
	 * @param surname surname
	 * @param mail mail
	 * @param password password
	 */
	public CompanyMembers(String name, String surname, String mail, String password)
	{
		super(name, surname, mail, password);
	}

	/**
	 * CompanyMembers constructor
	 * @param mail mail
	 * @param password password
	 * @param company company
	 */
	public CompanyMembers(String mail, String password, Company company)
	{
		super(mail, password, company);

	}

	/**
	 * CompanyMembers constructor
	 * @param name name
	 * @param surname surname
	 * @param mail mail
	 * @param password password
	 * @param company company
	 */
	public CompanyMembers(String name, String surname, String mail, String password, Company company)
	{
		super(name, surname, mail, password, company);

	}

	@Override
	public void productsNeedToBeSupplied()
	{
		KWArrayList<Stock> stocks = this.company.getStocks();

		String str = "ID\tModelId\tType\tColor\t\tBranchId\t\tAmount\n";

		for(int i=0; i<stocks.size(); i++)
		{
			for(int j=0; j<stocks.get(i).getFurnitures().size(); j++)
			{
				int total = stocks.get(i).getFurnitures().get(j).getTotal();
				if(total == 0)
					str += stocks.get(i).getFurnitures().get(j).toString() + "\t\t" + stocks.get(i).getFurnitures().get(i).getBranch().getBranchId() + "\t\t" + total + "\n";
			}
		}

		System.out.println(str);


	}

	@Override
	public boolean addCustomer(Customer customer)
	{
		try
		{
			customer.subscribe();
			return true;
		}catch(Exception exc)
		{
			System.out.println(exc.getMessage());
			return false;
		}
	}
	
	@Override
	public boolean removeCustomer(int customerId)
	{
		KWArrayList<Customer> customerList = this.company.getSubs();

		for(int i=0; i<customerList.size(); i++)
		{
			if(customerList.get(i).getId() == customerId)
			{
				customerList.remove(customerId);
				return true;
			}
		}

		return false;
	}

	@Override
	public void addProducts(int branchId, int productId, int amount) throws Exception
	{
		if(amount < 0)
			throw new Exception("Amount should be greater than 0");


		KWArrayList<Stock> stocks = this.company.getStocks();
		int index = -1;
		
		for(int i=0; i<stocks.size(); i++)
		{
			if(stocks.get(i).getId() == branchId)
			{
				index = i;
				break;
			}
		}

		if(index == -1)
			throw new Exception("branch is not found...");

		int total = stocks.get(index).getFurnitures().get(productId).getTotal();
		stocks.get(index).getFurnitures().get(productId).setTotal(total + amount);

	}

	@Override
	public void removeProducts(int branchId, int productId, int amount) throws Exception
	{
		if(amount < 0)
			throw new Exception("Amount should be greater than 0");

		KWArrayList<Stock> stocks = this.company.getStocks();
		int index = -1;
		
		for(int i=0; i<stocks.size(); i++)
		{
			if(stocks.get(i).getId() == branchId)
			{
				index = i;
				break;
			}
		}

		if(index == -1)
			throw new Exception("branch is not found...");

		int total = stocks.get(index).getFurnitures().get(productId).getTotal();

		if(amount > total)
			throw new Exception("Not enough products...");

		stocks.get(index).getFurnitures().get(productId).setTotal(total - amount);

	}
	
	
}
