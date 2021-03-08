package lib.user;

import lib.*;
import lib.furniture.*;

public class CompanyMembers extends User implements CompanyMembersInterface{

	public CompanyMembers(int id, String name, String surname, String mail, String password, Company company)
	{
		super(id, name, surname, mail, password, company);

	}

	public CompanyMembers(int id, String name, String surname, String mail, String password)
	{
		super(id, name, surname, mail, password);

	}

	public CompanyMembers(String name, String surname, String mail, String password, Company company)
	{
		super(name, surname, mail, password, company);

	}

	public void productsNeedToBeSupplied()
	{
		List<Stock> stocks = this.company.getStocks();

		String str = "ID\tModelId\tType\tColor\t\tBranchId\t\tAmount\n";

		for(int i=0; i<stocks.length(); i++)
		{
			for(int j=0; j<stocks.get(i).getFurnitures().length(); j++)
			{
				int total = stocks.get(i).getFurnitures().get(j).getTotal();
				if(total == 0)
					str += stocks.get(i).getFurnitures().get(j).toString() + "\t\t" + stocks.get(i).getFurnitures().get(i).getBranch().getBranchId() + "\t\t" + total + "\n";
			}
		}

		System.out.println(str);


	}

	public void addCustomer(Customer customer)
	{
		customer.subscribe();
	}
	
	public void removeCustomer(int customerId)
	{
		List<Customer> customerList = this.company.getSubs();

		for(int i=0; i<customerList.length(); i++)
		{
			if(customerList.get(i).getId() == customerId)
			{
				customerList.remove(customerId);
				return;
			}
		}



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
	
	
}
