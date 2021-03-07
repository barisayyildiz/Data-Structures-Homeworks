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

	public Employee(String name, String surname, String mail, String password, int branchId, Company company)
	{
		super(name, surname, mail, password, company);
		this.branchId = branchId;
	}

	// public void addProducts(int branchId, int productId, int amount)
	// {
	// 	List<Stock> stocks = this.company.getStocks();
	// 	int index = -1;

	// 	Stock tempStock = null;
		
	// 	for(int i=0; i<stocks.length(); i++)
	// 	{
	// 		if(stocks.get(i).getId() == branchId)
	// 		{
	// 			index = i;
	// 			break;
	// 		}
	// 	}

	// 	if(index == -1)
	// 		throw new Error("branch is not found...");

	// 	int total = stocks.get(index).getFurnitures().get(productId).getTotal();
	// 	stocks.get(index).getFurnitures().get(productId).setTotal(total + amount);

	// }

	// public void removeProducts(int branchId, int productId, int amount)
	// {
	// 	List<Stock> stocks = this.company.getStocks();
	// 	int index = -1;

	// 	Stock tempStock = null;
		
	// 	for(int i=0; i<stocks.length(); i++)
	// 	{
	// 		if(stocks.get(i).getId() == branchId)
	// 		{
	// 			index = i;
	// 			break;
	// 		}
	// 	}

	// 	if(index == -1)
	// 		throw new Error("branch is not found...");

	// 	int total = stocks.get(index).getFurnitures().get(productId).getTotal();

	// 	if(amount > total)
	// 		throw new Error("çok fazla istedin...");

	// 	stocks.get(index).getFurnitures().get(productId).setTotal(total - amount);

	// }

	public void sell(int customerId, int productId, int amount)
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
			throw new Error("user not found...");

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
			throw new Error("çok fazla istedin...");

		stocks.get(stockIndex).getFurnitures().get(productId).setTotal(total - amount);

		List<Furniture> newPurchase = new List<Furniture>();
		Furniture temp = stocks.get(stockIndex).getFurnitures().get(productId);
		
		newPurchase.insert(new Furniture(productId, temp.getModelId(), temp.getType(), temp.getColor(), temp.getBranch(), temp.getTotal()));
		newPurchase.get(0).setTotal(amount);

		// previous order a ekle
		Customer customer = subs.get(index);

		customer.addNewOrder(new Stock( customer.getCounter(), newPurchase));

		// customer.orderHistory.insert()




		// this.orderHistory.insert(new Stock(this.counter++, newPurchase));


	}

	// public void productsNeedToBeSupplied()
	// {
	// 	List<Stock> stocks = this.company.getStocks();

	// 	String str = "ID\tModelId\tType\tColor\t\tBranchId\t\tAmount\n";

	// 	for(int i=0; i<stocks.length(); i++)
	// 	{
	// 		for(int j=0; j<stocks.get(i).getFurnitures().length(); j++)
	// 		{
	// 			int total = stocks.get(i).getFurnitures().get(j).getTotal();
	// 			if(total == 0)
	// 				str += stocks.get(i).getFurnitures().get(j).toString() + "\t\t" + stocks.get(i).getFurnitures().get(i).getBranch().getBranchId() + "\t\t" + total + "\n";
	// 		}
	// 	}

	// 	System.out.println(str);


	// }

	// public void addCustomer(Customer customer)
	// {
	// 	customer.subscribe();
	// }
	
	// public void removeCustomer(int customerId)
	// {
	// 	List<Customer> customerList = this.company.getSubs();

	// 	for(int i=0; i<customerList.length(); i++)
	// 	{
	// 		if(customerList.get(i).getId() == customerId)
	// 		{
	// 			customerList.remove(customerId);
	// 			return;
	// 		}
	// 	}



	// }

	@Override
	public boolean equals(Object obj)
	{
		Employee temp = (Employee)obj;

		if(temp.getId() == this.getId())
			return true;
		return false;

	}

	
}
