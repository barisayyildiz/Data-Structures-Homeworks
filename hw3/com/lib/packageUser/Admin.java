package com.lib.packageUser;

import com.lib.furniture.*;
import com.lib.company.*;

import java.util.ListIterator;

import com.collections.*;

/**
 * Admin class, inherits from CompanyMembers
 * @author Barış Ayyıldız
 */


public class Admin extends CompanyMembers{

	/**
	 * Admin constructor
	 * @param name
	 * @param surname
	 * @param mail
	 * @param password
	 * @param company
	 */
	public Admin(String name, String surname, String mail, String password, Company company)
	{
		super(name, surname, mail, password, company);
	}

	/**
	 * Alternative admin constructor
	 * @param name
	 * @param surname
	 * @param mail
	 * @param password
	 */
	public Admin(String name, String surname, String mail, String password)
	{
		super(name, surname, mail, password);
	}

	/**
	 * Creates a new branch
	 * Inserts
	 * office chairs (7 models and for each, 5 colors),
		office desks (5 models and for each, 4 colors), meeting tables (10 models and for each, 4
		colors), bookcases (12 models) and office cabinets (12 models).
	 * @return returns true when there is no error
	 */
	public boolean addBranch()
	{
		KWLinkedList<Branch> branches = this.company.getBranches();
		KWArrayList<Stock> stocks = this.company.getStocks();
		int branchNumber = branches.size();
		int uniqueId = this.company.getBranchCounter();

		branches.add(new Branch(uniqueId, uniqueId));

		Type t[] = Type.values();
		Color c[] = Color.values();
		HybridList<Furniture> furniture = new HybridList<Furniture>();

		int counter = 0;

		// insert chairs
		for(int i=0; i<7; i++)
		{
			for(int j=0; j<5; j++)
			{
				furniture.add(new Furniture(counter++, i, t[0], c[j], branches.get(branchNumber), 5));
			}
		}

		// insert desks
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<4; j++)
			{
				furniture.add(new Furniture(counter++, i, t[1], c[j], branches.get(branchNumber), 5));
			}
		}

		// insert tables
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<4; j++)
			{
				furniture.add(new Furniture(counter++, i, t[2], c[j], branches.get(branchNumber), 5));
			}
		}

		// insert bookcases
		for(int i=0; i<12; i++)
		{
			furniture.add(new Furniture(counter++, i, t[3], Color.NONE, branches.get(branchNumber), 5));
		}

		// insert cabinets
		for(int i=0; i<12; i++)
		{
			furniture.add(new Furniture(counter++, i, t[4], Color.NONE, branches.get(branchNumber), 5));
		}


		stocks.add(new Stock(uniqueId, furniture));

		return true;
	}

	/**
	 * Removes branch from company
	 * @param branchId removes the branch with this id
	 * @return returns true when branch is removed
	 */
	public boolean removeBranch(int branchId)
	{
		KWLinkedList<Branch> branches = this.company.getBranches();
		KWArrayList<Stock> stocks = this.company.getStocks();
		int stockIndex;
		Branch tempBranch;

		// find the branch with the id of branchId
		ListIterator<Branch> listIterator = branches.listIterator();

		while(listIterator.hasNext())
		{
			tempBranch = (Branch)listIterator.next();

			if(tempBranch.getBranchId() == branchId)
			{
				// get stock id
				stockIndex = tempBranch.getStockIndex();
	
				// remove stock
				for(int j=0; j<stocks.size(); j++)
				{
					if(stocks.get(j).getId() == stockIndex)
					{
						// stocks.remove(stockIndex);
						stocks.remove(j);
						break;
					}
				}

				listIterator.remove();
				return true;
				
			}

		}

		return false;
	}

	/**
	 * Adds a new employee to the company
	 * @param person new employee
	 * @return returns true if the new employee's email is not already registered before
	 */
	public boolean addBranchEmployee(Employee person)
	{
		KWArrayList<Employee> employees = this.company.getEmployees();

		for(int i=0; i<employees.size(); i++)
		{
			if(employees.get(i).getMail().equals(person.getMail()))
				return false;
		}

		person.setId(this.company.getEmployeeCounter());
		this.company.getEmployees().add(person);

		return true;
	}

	/**
	 * Removes an employee from the company
	 * @param id id of the employee
	 * @return returns true when the employee is removed
	 */
	public boolean removeBranchEmployee(int id)
	{
		KWArrayList<Employee> employees = this.company.getEmployees();

		for(int i=0; i<employees.size(); i++)
		{
			if(employees.get(i).getId() == id)
			{
				employees.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Displays all the employees in the company
	 */
	public void listEmployees()
	{
		String str = "Name\tSurname\tMail\tPassword\tBranchId\tId\n";
		
		KWArrayList<Employee> employees = this.company.getEmployees();

		for(int i=0; i<employees.size(); i++)
		{
			str += employees.get(i).getName() + "\t" + employees.get(i).getSurname() + "\t" + employees.get(i).getMail() + "\t" + employees.get(i).getPassword() + "\t\t" + employees.get(i).getBranchId() + "\t\t" + employees.get(i).getId() + "\n";
		}

		System.out.println(str);

	}

	/**
	 * Displays all the subscribers of the company
	 */
	public void listSubscribers()
	{
		String str = "Name\tSurname\tMail\tPassword\tId\n";

		KWArrayList<Customer> customers = this.company.getSubs();

		for(int i=0; i<customers.size(); i++)
		{
			str += customers.get(i).getName() + "\t" + customers.get(i).getSurname() + "\t" + customers.get(i).getMail() + "\t" + customers.get(i).getPassword() + "\t" + customers.get(i).getId() + "\n";

		}
		
		System.out.println(str);


	}
	
}
