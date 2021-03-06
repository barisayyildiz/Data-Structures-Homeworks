package lib.user;

import lib.*;
import lib.furniture.*;

import java.util.Scanner;

/**
 * Customer class, inherits from User class
 * @author Barış Ayyıldız
 */

public class Customer extends User
{
	/**
	 * Holds previous orders
	 */
	private List<Stock> orderHistory;
	/**
	 * True when the customer is subscribed
	 */
	private boolean isSubscribed;
	/**
	 * It helps to generate unique stock id
	 */
	private int counter;

	/**
	 * Customer constructor
	 * @param mail mail
	 * @param password password
	 * @param company company
	 */
	public Customer(String mail, String password, Company company)
	{
		super(mail, password, company);
		
		this.orderHistory = new List<Stock>();
		this.isSubscribed = false;
		this.counter = 0;
	}

	/**
	 * Customer constructor
	 * @param name name
	 * @param surname surname
	 * @param mail mail
	 * @param password password
	 * @param company company
	 */
	public Customer(String name, String surname, String mail, String password, Company company)
	{
		super(name, surname, mail, password, company);

		this.orderHistory = new List<Stock>();
		this.isSubscribed = false;
		this.counter = 0;

	}

	/**
	 * Handles subscription
	 * @throws Exception throws when the email is already registered
	 */
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

		System.out.println("user id is : " + this.id);

	}

	/**
	 * Handles buying online
	 * @param productId product id
	 * @param amount amount of product
	 * @throws Exception throws when the amount is negative or there is not enough product in the company
	 */
	public void buyOnline(int productId, int amount) throws Exception
	{
		int tempAmount = amount;

		if(amount < 0)
			throw new Exception("amount cannot negative...");

		List<Stock> stocks = this.company.getStocks();

		int total = 0;

		for(int i=0; i<stocks.length(); i++)
		{
			total += stocks.get(i).getFurnitures().get(productId).getTotal();
		}

		System.out.print("Home address : ");
		(new Scanner(System.in)).nextLine();
		System.out.print("Phone number : ");
		(new Scanner(System.in)).nextLine();

		if(tempAmount > total)
			throw new Exception("Not enough products...");
		
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

		// this.orderHistory.insert(new Stock(this.counter++, newPurchase));
		this.addNewOrder(new Stock(this.counter++, newPurchase));


	}

	/**
	 * Handles buying in a shop
	 * @param branchId branch id
	 * @param productId product id
	 * @param amount amount of product
	 * @throws Exception throws when the amount is negative or there is not enough product in the company
	 */
	public void buyInShop(int branchId, int productId, int amount) throws Exception
	{
		if(amount < 0)
			throw new Exception("amount cannot negative...");

		List<Stock> stocks = this.company.getStocks();
		int index = -1;
		
		for(int i=0; i<stocks.length(); i++)
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
			throw new Exception("there is not enough products...");

		stocks.get(index).getFurnitures().get(productId).setTotal(total - amount);


		List<Furniture> newPurchase = new List<Furniture>();
		Furniture temp = stocks.get(0).getFurnitures().get(productId);
		
		newPurchase.insert(new Furniture(productId, temp.getModelId(), temp.getType(), temp.getColor(), temp.getBranch(), temp.getTotal()));
		newPurchase.get(0).setTotal(amount);

		this.addNewOrder(new Stock(this.counter++, newPurchase));


	}

	/**
	 * Shows all the previous orders of the customer
	 */
	public void showOrderHistory()
	{
		// private List<Stock> orderHistory;
		String str = "Id\tModel\tType\t\tColor\tAmount\n";

		for(int i=0; i<this.orderHistory.length(); i++)
		{
			str += this.orderHistory.get(i).getFurnitures().get(0).toString() + "\t" + String.valueOf(orderHistory.get(i).getFurnitures().get(0).getTotal()) +"\n";
		}
		System.out.println(str);
	}

	/**
	 * Adds a new order to the order history
	 * @param newOrder new order
	 */
	public void addNewOrder(Stock newOrder)
	{
		this.orderHistory.insert(newOrder);
	}

	/**
	 * Returns the counter that is going the using to generate unique stock id's
	 * @return counter
	 */
	public int getCounter(){return this.counter++;}

	
}
