package lib.user;

import lib.*;
import lib.furniture.*;

public class Customer extends User
{
	private List<Stock> orderHistory;
	private Company company;
	private boolean isSubscribed;

	public Customer(String name, String surname, String mail, String password, Company company)
	{
		super(name, surname, mail, password);

		this.orderHistory = new List<Stock>();
		this.company = company;
		this.isSubscribed = false;

	}

	// public void subscribe(String name, String surname, String mail, String password, Company company)
	// {
	// 	Customer temp = new Customer(0, name, surname, mail, password, company);
		
	// 	List<Branch> branches = this.company.getBranches();
	// 	List<Employee> employees = this.company.getEmployees();
	// 	List<Customer> subs = this.company.getSubs();

	// 	for(int i=0; i<subs.length(); i++)
	// 	{
	// 		if(subs.get(i).getMail() == mail)
	// 		{
	// 			throw new Error("This email is already registered...");
	// 		}
	// 	}

	// 	subs.insert(temp);

	// 	System.out.println("user id is : " + 0);

	// }

	public void subscribe()
	{
			
		List<Branch> branches = this.company.getBranches();
		List<Employee> employees = this.company.getEmployees();
		List<Customer> subs = this.company.getSubs();

		for(int i=0; i<subs.length(); i++)
		{
			if(subs.get(i).getMail() == this.mail)
			{
				throw new Error("This email is already registered...");
			}
		}

		subs.insert(this);
		this.isSubscribed = true;

		System.out.println("user id is : " + 0);

	}

	public boolean login()
	{
		if(!this.isSubscribed)
			throw new Error("you are not subscribed...");


		List<Branch> branches = this.company.getBranches();
		List<Employee> employees = this.company.getEmployees();
		List<Customer> subs = this.company.getSubs();

		for(int i=0; i<subs.length(); i++)
		{
			if(subs.get(i).getMail() == this.mail && subs.get(i).getPassword() == this.password)
				return true;
		}
		return false;
	}

	public void buyOnline(int productId, int amount)
	{
		List<Stock> stocks = this.company.getStocks();

		// 1. yeterli sayıda var mı
		// 2. varsa mağazalardan sil

		int total = 0;

		for(int i=0; i<stocks.length(); i++)
		{
			total += stocks.get(i).getFurnitures().get(productId).getTotal();
		}

		if(amount > total)
			throw new Error("Çok fazla istedin...");
		
		// mağazalardan sil
		for(int i=0; i<stocks.length(); i++)
		{
			int current = stocks.get(i).getFurnitures().get(productId).getTotal();

			System.out.println("current : " + current + ", amount : " + amount);
			if(current >= amount)
			{
				stocks.get(i).getFurnitures().get(productId).setTotal(current-amount);
				return;
			}else
			{
				amount -= current;
				stocks.get(i).getFurnitures().get(productId).setTotal(0);
			}


		}


	}

	public void buyInShop(int branchId, int productId, int amount)
	{
		List<Stock> stocks = this.company.getStocks();

		Stock tempStock = null;
		
		for(int i=0; i<stocks.length(); i++)
		{
			if(stocks.get(i).getId() == branchId)
			{
				tempStock = stocks.get(i);
				break;
			}
		}

		if(tempStock == null)
			throw new Error("branch is not found...");

		int total = tempStock.getFurnitures().get(productId).getTotal();
		
		// System.out.println("total : " + total + ", amount : " + amount);

		if(amount > total)
			throw new Error("çok fazla istedin...");

		tempStock.getFurnitures().get(productId).setTotal(total - amount);


	}

	
}
