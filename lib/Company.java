package lib;

import lib.furniture.*;
import lib.user.*;

public class Company {
	
	private Admin companyAdmin;
	private int counter;
	private List<Branch> branches;
	private List<Employee> employees;
	private List<Customer> subs;

	// private List< List<Furniture> > stocks; 

	private List<Stock> stocks;


	public Company()
	{
		this.companyAdmin = new Admin(0, "baris", "ayyildiz", "99ayyldzbaris99@gmail.com", "123456", this);
		// this.branchNumber = 2;
		this.counter = 0;

		// init 2d array
		// this.stocks = new List < List <Furniture> >();

		this.employees = new List<Employee>();
		this.stocks = new List<Stock>();
		this.branches = new List<Branch>();
		this.subs = new List<Customer>();

		// this.branches.insert(new Branch(0));
		// this.branches.insert(new Branch(1));
	}


	@Override
	public String toString()
	{
		String str = "ID\tModelId\tType\tColor\t\tAmount\n";

		for(int i=0; i<this.stocks.get(0).getFurnitures().length(); i++)
		{
			int total = 0;
			int j;

			for(j=0; j<this.stocks.length(); j++)
			{
				total += this.stocks.get(j).getFurnitures().get(i).getTotal();
			}
			str +=  this.stocks.get(0).getFurnitures().get(i).toString() + "\t\t" + total + "\n";

		}

		return str;
	}


	public void subscribe(String name, String surname, String mail, String password)
	{
		Customer temp = new Customer(0, name, surname, mail, password);

		for(int i=0; i<this.subs.length(); i++)
		{
			if(this.subs.get(i).getMail() == mail)
			{
				throw new Error("This email is already registered...");
			}
		}

		subs.insert(temp);

		System.out.println("user id is : " + 0);

	}

	public boolean login(String mail, String password)
	{
		for(int i=0; i<this.subs.length(); i++)
		{
			if(this.subs.get(i).getMail() == mail && this.subs.get(i).getPassword() == password)
				return true;
		}
		return false;
	}

	public void buyOnline(int productId, int amount)
	{
		// 1. yeterli sayıda var mı
		// 2. varsa mağazalardan sil

		int total = 0;

		for(int i=0; i<this.stocks.length(); i++)
		{
			total += this.stocks.get(i).getFurnitures().get(productId).getTotal();
		}

		if(amount > total)
			throw new Error("Çok fazla istedin...");
		
		// mağazalardan sil
		for(int i=0; i<this.stocks.length(); i++)
		{
			int current = this.stocks.get(i).getFurnitures().get(productId).getTotal();

			System.out.println("current : " + current + ", amount : " + amount);
			if(current >= amount)
			{
				System.out.println("qwetqyeqw");
				this.stocks.get(i).getFurnitures().get(productId).setTotal(current-amount);
				return;
			}else
			{
				amount -= current;
				this.stocks.get(i).getFurnitures().get(productId).setTotal(0);
			}


		}


	}

	public void showSingleBranch(int branchId)
	{
		Stock tempStock = null;

		for(int i=0; i<this.stocks.length(); i++)
		{
			if(this.stocks.get(i).getId() == branchId)
				tempStock = this.stocks.get(i);
		}


		if(tempStock == null)
			throw new Error("cannot find that branch...");

		// String str = tempStock.toString();
		String str = "ID\tModelId\tType\tColor\t\tAmount\n";

		for(int i=0; i<tempStock.getFurnitures().length() ; i++)
		{
			str += tempStock.getFurnitures().get(i).toString() + "\t\t" + tempStock.getFurnitures().get(i).getTotal() +  "\n";
		}

		System.out.println(str);


	}

	public void buyInShop(int branchId, int productId, int amount)
	{
		Stock tempStock = null;
		
		for(int i=0; i<this.stocks.length(); i++)
		{
			if(this.stocks.get(i).getId() == branchId)
			{
				tempStock = this.stocks.get(i);
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




	// getters
	public Admin getAdmin(){return companyAdmin;}
	public int getCounter(){return counter;}
	public void setCounter(int val){this.counter = val;}
	public List<Branch> getBranches(){return branches;}
	public List<Employee> getEmployees(){return employees;}
	public List<Stock> getStocks(){return stocks;}

	
}
