package lib;

import lib.furniture.*;
import lib.user.*;

public class Company {
	
	private Admin companyAdmin;
	private int branchCounter;
	private int customerCounter;
	private int employeeCounter;
	private List<Branch> branches;
	private List<Employee> employees;
	private List<Customer> subs;

	// private List< List<Furniture> > stocks; 

	private List<Stock> stocks;


	public Company()
	{
		this.companyAdmin = new Admin(0, "baris", "ayyildiz", "99ayyldzbaris99@gmail.com", "123456", this);
		// this.branchNumber = 2;
		this.branchCounter = 0;
		this.customerCounter = 0;
		this.employeeCounter = 0;

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



	// getters
	public Admin getAdmin(){return companyAdmin;}

	public int getBranchCounter(){
		return this.branchCounter++;
	}
	public int getCustomerCounter(){
		return this.customerCounter++;
	}
	public int getEmployeeCounter(){
		return this.employeeCounter++;
	}
	
	public void setCounter(int val){this.branchCounter = val;}
	public List<Branch> getBranches(){return branches;}
	public List<Employee> getEmployees(){return employees;}
	public List<Stock> getStocks(){return stocks;}
	public List<Customer> getSubs(){return subs;}

	
}
