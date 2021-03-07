package lib.user;

import lib.furniture.*;
import lib.*;

public class Employee extends User
{
	private int branchId;
	private Company company;

	public Employee(int id, String name, String surname, String mail, String password, int branchId, Company company)
	{
		super(id, name, surname, mail, password);
		this.branchId = branchId;
		this.company = company;
	}

	public Employee(String name, String surname, String mail, String password, int branchId, Company company)
	{
		super(name, surname, mail, password);
		this.branchId = branchId;
		this.company = company;
	}

	public void addProducts(int branchId, int productId, int amount)
	{
		List<Stock> stocks = this.company.getStocks();
		int index = -1;

		Stock tempStock = null;
		
		for(int i=0; i<stocks.length(); i++)
		{
			if(stocks.get(i).getId() == branchId)
			{
				index = i;
				break;
			}
		}

		if(index == -1)
			throw new Error("branch is not found...");

		int total = stocks.get(index).getFurnitures().get(productId).getTotal();
		stocks.get(index).getFurnitures().get(productId).setTotal(total + amount);

	}

	public void removeProducts(int branchId, int productId, int amount)
	{
		List<Stock> stocks = this.company.getStocks();
		int index = -1;

		Stock tempStock = null;
		
		for(int i=0; i<stocks.length(); i++)
		{
			if(stocks.get(i).getId() == branchId)
			{
				index = i;
				break;
			}
		}

		if(index == -1)
			throw new Error("branch is not found...");

		int total = stocks.get(index).getFurnitures().get(productId).getTotal();

		if(amount > total)
			throw new Error("çok fazla istedin...");

		stocks.get(index).getFurnitures().get(productId).setTotal(total - amount);

	}

	@Override
	public boolean equals(Object obj)
	{
		Employee temp = (Employee)obj;

		if(temp.getId() == this.getId())
			return true;
		return false;

	}

	
}
