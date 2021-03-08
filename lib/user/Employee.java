package lib.user;

import lib.furniture.*;
import lib.*;

public class Employee extends CompanyMembers
{
	private int branchId;

	public Employee(int id, String name, String surname, String mail, String password, int branchId, Company company)
	{
		super(id, name, surname, mail, password, company);
		this.branchId = branchId;
	}

	public Employee(String mail, String password, Company company)
	{
		super(mail, password, company);
	}

	public Employee(String name, String surname, String mail, String password, int branchId, Company company)
	{
		super(name, surname, mail, password, company);
		this.branchId = branchId;
	}


	public void sell(int customerId, int productId, int amount) throws Exception
	{
		List<Customer> subs = this.company.getSubs();
		List<Stock> stocks = this.company.getStocks();

		int index = -1;
		int stockIndex = -1;

		for(int i=0; i<subs.length(); i++)
		{
			if(subs.get(i).getId() == customerId)
			{
				index = i;
				break;
			}
		}

		if(index == -1)
			throw new Exception("user not found...");

		for(int i=0; i<stocks.length(); i++)
		{
			if(stocks.get(i).getId() == this.branchId)
			{
				stockIndex = i;
				break;
			}
		}

		int total = stocks.get(stockIndex).getFurnitures().get(productId).getTotal();

		if(amount > total)
			throw new Exception("çok fazla istedin...");

		stocks.get(stockIndex).getFurnitures().get(productId).setTotal(total - amount);

		List<Furniture> newPurchase = new List<Furniture>();
		Furniture temp = stocks.get(stockIndex).getFurnitures().get(productId);
		
		newPurchase.insert(new Furniture(productId, temp.getModelId(), temp.getType(), temp.getColor(), temp.getBranch(), temp.getTotal()));
		newPurchase.get(0).setTotal(amount);

		// previous order a ekle
		Customer customer = subs.get(index);

		customer.addNewOrder(new Stock( customer.getCounter(), newPurchase));

	}


	@Override
	public boolean equals(Object obj)
	{
		Employee temp = (Employee)obj;

		if(temp.getId() == this.getId())
			return true;
		return false;

	}

	public int getBranchId(){return this.branchId;}

	
}
