package lib.user;

import lib.furniture.*;
import lib.*;


public class Admin extends User implements AdminInterface {

	private Company company;

	public Admin(int id, String name, String surname, String mail, String password, Company company)
	{
		super(id, name, surname, mail, password);
		this.company = company;
	}

	public boolean addBranch()
	{
		List<Branch> branches = this.company.getBranches();
		List<Stock> stocks = this.company.getStocks();
		int branchNumber = branches.length();
		int uniqueId = this.company.getBranchCounter();


		// adds new branch
		// branches.insert(new Branch(uniqueId, branchNumber));
		branches.insert(new Branch(uniqueId, uniqueId));

		// // insert new Furniture List for the new branch
		// stocks.insert( new Stock(uniqueId, null) );

		// this.stocks[branchNumber].insert(new Furniture(0, Type.CHAIR, Color.RED, this.branches[branchNumber]));

		Type t[] = Type.values();
		Color c[] = Color.values();
		List<Furniture> furniture = new List<Furniture>();

		int counter = 0;

		// insert chairs
		for(int i=0; i<7; i++)
		{
			for(int j=0; j<5; j++)
			{
				furniture.insert(new Furniture(counter++, i, t[0], c[j], branches.get(branchNumber), 5));
			}
		}

		// insert desks
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<4; j++)
			{
				furniture.insert(new Furniture(counter++, i, t[1], c[j], branches.get(branchNumber), 5));
			}
		}

		// insert tables
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<4; j++)
			{
				furniture.insert(new Furniture(counter++, i, t[2], c[j], branches.get(branchNumber), 5));
			}
		}

		// insert bookcases
		for(int i=0; i<12; i++)
		{
			furniture.insert(new Furniture(counter++, i, t[3], Color.NONE, branches.get(branchNumber), 5));
		}

		// insert cabinets
		for(int i=0; i<12; i++)
		{
			furniture.insert(new Furniture(counter++, i, t[4], Color.NONE, branches.get(branchNumber), 5));
		}


		stocks.insert(new Stock(uniqueId, furniture));

		// stocks.get(branchNumber).insert(new Stock(uniqueId, new Furniture(0, type, color, branches.get(branchNumber), 5)));
		
		// this.company.setCounter(uniqueId+1);

		return true;
	}

	public boolean removeBranch(int branchId)
	{
		List<Branch> branches = this.company.getBranches();
		List<Stock> stocks = this.company.getStocks();
		int stockIndex;

		// find the branch with the id of branchId
		for(int i=0; i<branches.length(); i++)
		{
			if(branches.get(i).getBranchId() == branchId)
			{
				// get stockId
				stockIndex = branches.get(i).getStockIndex();
				
				// remove stock
				for(int j=0; j<stocks.length(); j++)
				{
					if(stocks.get(j).getId() == stockIndex)
					{
						// stocks.remove(stockIndex);
						stocks.remove(j);
						break;
					}
				}

				// remove branch
				branches.remove(i);

				return true;
			}
		}
		
		
		return false;

	}

	public boolean addBranchEmployee(Employee person)
	{
		person.setId(this.company.getEmployeeCounter());
		this.company.getEmployees().insert(person);

		return true;
	}

	public boolean removeBranchEmployee(int id)
	{
		List<Employee> employees = this.company.getEmployees();

		for(int i=0; i<employees.length(); i++)
		{
			if(employees.get(i).getId() == id)
			{
				employees.remove(i);
				return true;
			}
		}
		return false;
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

	

	public Company getCompany(){return this.company;}
	
}
