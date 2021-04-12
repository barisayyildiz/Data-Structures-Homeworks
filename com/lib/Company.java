package com.lib;

import com.lib.furniture.*;
import com.lib.user.*;

/**
 * Company class
 * @author Barış Ayyıldız
 */

public class Company {
	
	/**
	 * company admin
	 */
	private Admin companyAdmin;
	/**
	 * branch counter, it is used to generate a unique branch id
	 */
	private int branchCounter;
	/**
	 * customer counter, it is used to generate a unique customer id
	 */
	private int customerCounter;
	/**
	 * employee counter, it is used to generate a unique employee id
	 */
	private int employeeCounter;
	/**
	 * List of branches
	 */
	private List<Branch> branches;
	/**
	 * List of employees
	 */
	private List<Employee> employees;
	/**
	 * List of subs(registered customers)
	 */
	private List<Customer> subs;

	private List<Stock> stocks;

	/**
	 * Company constructor
	 * @param admin admin
	 */
	public Company(Admin admin)
	{
		admin.setCompany(this);
		admin.setId(0);
		this.companyAdmin = admin;
		this.branchCounter = 0;
		this.customerCounter = 0;
		this.employeeCounter = 0;

		this.employees = new List<Employee>();
		this.stocks = new List<Stock>();
		this.branches = new List<Branch>();
		this.subs = new List<Customer>();
	}

	/**
	 * Login method for the Employee
	 * @param employee employee
	 * @return Employee that is logged in
	 */
	public Employee login(Employee employee)
	{
		for(int i=0; i<this.employees.size(); i++)
		{
			if(this.employees.get(i).getMail().equals(employee.getMail()) && this.employees.get(i).getPassword().equals(employee.getPassword()))
				return this.employees.get(i);
		}

		return null;
	}

	/**
	 * Login method for the Customer
	 * @param customer customer
	 * @return Customer that is logged in
	 */
	public Customer login(Customer customer)
	{
		for(int i=0; i<this.subs.size(); i++)
		{
			if(this.subs.get(i).getMail().equals(customer.getMail()) && this.subs.get(i).getPassword().equals(customer.getPassword()))
				return this.subs.get(i);
		}

		return null;
	}

	/**
	 * Displays all branch id's
	 */
	public void showBranchIds()
	{
		String str = "\n";
		for(int i=0; i<this.branches.size(); i++)
		{
			// str += this.branches.get(i).getBranchId() + " ";
			str += "BranchId : " + this.branches.get(i).getBranchId() + "\n";
		}
		str +="\n";
		System.out.println(str);
	}

	/**
	 * Shows all the products in the company
	 */
	public void showAllProducts()
	{
		String str = "ID\tModelId\tType\tColor\t\tAmount\n";

		for(int i=0; i<this.stocks.get(0).getFurnitures().size(); i++)
		{
			int total = 0;
			int j;

			for(j=0; j<this.stocks.size(); j++)
			{
				total += this.stocks.get(j).getFurnitures().get(i).getTotal();
			}
			str +=  this.stocks.get(0).getFurnitures().get(i).toString() + "\t\t" + total + "\n";

		}

		System.out.println(str);
		
	}

	/**
	 * Shows a single branch
	 * @param branchId branch id
	 * @throws Exception throws when the id is not found
	 */
	public void showSingleBranch(int branchId) throws Exception
	{
		Stock tempStock = null;
		String str = "";

		for(int i=0; i<this.stocks.size(); i++)
		{
			if(this.stocks.get(i).getId() == branchId)
				tempStock = this.stocks.get(i);
		}


		if(tempStock == null)
			throw new Exception("cannot find that branch...");

		str += "ID\tModelId\tType\tColor\t\tAmount\n";

		for(int i=0; i<tempStock.getFurnitures().size() ; i++)
		{
			str += tempStock.getFurnitures().get(i).toString() + "\t\t" + tempStock.getFurnitures().get(i).getTotal() +  "\n";
		}

		System.out.println(str);


	}

	@Override
	public String toString()
	{
		String str = "";

		str += "\n~Company Info~\n";
		str += "Admin name : " + this.companyAdmin.getName() + " " + this.companyAdmin.getSurname() + "\n";
		str += "Number of employees : " + this.employees.size() + "\n";
		str += "Number of subscribers : " + this.subs.size() + "\n\n";

		return str;
	}



	// getters
	/**
	 * Returns admin
	 * @return admin
	 */
	public Admin getAdmin(){return companyAdmin;}

	/**
	 * Returns branch counter
	 * @return branch counter
	 */
	public int getBranchCounter(){
		return this.branchCounter++;
	}

	/**
	 * Returns customer counter
	 * @return customer counter
	 */
	public int getCustomerCounter(){
		return this.customerCounter++;
	}

	/**
	 * Returns employee counter
	 * @return employee counter
	 */
	public int getEmployeeCounter(){
		return this.employeeCounter++;
	}
	
	/**
	 * Sets counter
	 * @param val counter
	 */
	public void setCounter(int val){this.branchCounter = val;}

	/**
	 * Returns branches
	 * @return branches
	 */
	public List<Branch> getBranches(){return branches;}
	/**
	 * Returns employees
	 * @return employees
	 */
	public List<Employee> getEmployees(){return employees;}
	/**
	 * Returns stocks
	 * @return stocks
	 */
	public List<Stock> getStocks(){return stocks;}
	/**
	 * Returns subs
	 * @return subs
	 */
	public List<Customer> getSubs(){return subs;}

	
}
