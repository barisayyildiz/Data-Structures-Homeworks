package lib.user;

import lib.*;
import lib.furniture.*;

public class Customer extends User
{
	private List<Stock> orderHistory;
	private boolean isSubscribed;
	private int counter; // to generate unique stock id

	public Customer(int id, String name, String surname, String mail, String password, Company company)
	{
		super(id, name, surname, mail, password, company);

		this.orderHistory = new List<Stock>();
		this.isSubscribed = false;
		this.counter = 0;

	}


	public Customer(String name, String surname, String mail, String password, Company company)
	{
		super(name, surname, mail, password, company);

		this.orderHistory = new List<Stock>();
		this.isSubscribed = false;
		this.counter = 0;

	}

	public void subscribe() throws Exception
	{
			
		List<Branch> branches = this.company.getBranches();
		List<Employee> employees = this.company.getEmployees();
		List<Customer> subs = this.company.getSubs();

		for(int i=0; i<subs.length(); i++)
		{
			if(subs.get(i).getMail().equals(this.mail))
			{
				throw new Exception("This email is already registered...");
			}
		}

		this.setId(this.company.getCustomerCounter());
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
		int tempAmount = amount;

		List<Stock> stocks = this.company.getStocks();

		// 1. yeterli sayıda var mı
		// 2. varsa mağazalardan sil

		int total = 0;

		for(int i=0; i<stocks.length(); i++)
		{
			total += stocks.get(i).getFurnitures().get(productId).getTotal();
		}

		if(tempAmount > total)
			throw new Error("Çok fazla istedin...");
		
		// mağazalardan sil
		for(int i=0; i<stocks.length(); i++)
		{
			int current = stocks.get(i).getFurnitures().get(productId).getTotal();

			if(current >= tempAmount)
			{
				stocks.get(i).getFurnitures().get(productId).setTotal(current-tempAmount);
				break;
			}else
			{
				tempAmount -= current;
				stocks.get(i).getFurnitures().get(productId).setTotal(0);
			}


		}

		List<Furniture> newPurchase = new List<Furniture>();
		Furniture temp = stocks.get(0).getFurnitures().get(productId);
		
		newPurchase.insert(new Furniture(productId, temp.getModelId(), temp.getType(), temp.getColor(), temp.getBranch(), temp.getTotal()));
		newPurchase.get(0).setTotal(amount);

		// previous order a ekle
		this.orderHistory.insert(new Stock(this.counter++, newPurchase));


	}

	// 2,8,5
	public void buyInShop(int branchId, int productId, int amount)
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

		// int total = tempStock.getFurnitures().get(productId).getTotal();
		int total = stocks.get(index).getFurnitures().get(productId).getTotal();
		
		// System.out.println("total : " + total + ", amount : " + amount);

		if(amount > total)
			throw new Error("çok fazla istedin...");

		stocks.get(index).getFurnitures().get(productId).setTotal(total - amount);


		List<Furniture> newPurchase = new List<Furniture>();
		Furniture temp = stocks.get(0).getFurnitures().get(productId);
		
		newPurchase.insert(new Furniture(productId, temp.getModelId(), temp.getType(), temp.getColor(), temp.getBranch(), temp.getTotal()));
		newPurchase.get(0).setTotal(amount);

		// previous order a ekle
		this.orderHistory.insert(new Stock(this.counter++, newPurchase));


	}

	public void addNewOrder(Stock newOrder)
	{
		this.orderHistory.insert(newOrder);
	}

	public int getCounter(){return this.counter++;}

	
}
