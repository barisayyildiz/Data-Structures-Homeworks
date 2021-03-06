package lib;

import lib.furniture.*;
import lib.user.*;

public class Company {
	
	private Admin companyAdmin;
	private int counter;
	private List<Branch> branches;
	private List<Employee> employees;

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

		// this.branches.insert(new Branch(0));
		// this.branches.insert(new Branch(1));
	}


	@Override
	public String toString()
	{
		String str = "ID\tModelId\tType\tColor\t\tAmount\n";

		// for(int i=0; i<this.stocks.length(); i++)
		// {
		// 	int total = 0;

		// 	for(int j=0; j<this.stocks.get(i).getFurnitures().length() ; j++)
		// 	{
		// 		str += this.stocks.get(i).getFurnitures().get(j).toString();
		// 		// total += this.stocks.get(i).getFurnitures().get(j).getTotal();
		// 	}
		// 	str += "--------------------\n";
		// }

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


	public Admin getAdmin(){return companyAdmin;}
	public int getCounter(){return counter;}
	public void setCounter(int val){
		this.counter = val;
		System.out.println("counter : " +  this.counter);
	}
	public List<Branch> getBranches(){return branches;}
	public List<Employee> getEmployees(){return employees;}
	public List<Stock> getStocks(){return stocks;}

	
}
