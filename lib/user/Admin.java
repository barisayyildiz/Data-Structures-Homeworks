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
		int uniqueId = this.company.getCounter();


		// adds new branch
		branches.insert(new Branch(uniqueId, branchNumber));

		// // insert new Furniture List for the new branch
		// stocks.insert( new Stock(uniqueId, null) );

		// this.stocks[branchNumber].insert(new Furniture(0, Type.CHAIR, Color.RED, this.branches[branchNumber]));

		Type t[] = Type.values();
		Color c[] = Color.values();
		List<Furniture> furniture = new List<Furniture>();

		// add products to stocks
		for(Type type : t)
		{
			for(Color color : c)
			{
				furniture.insert(new Furniture(0, type, color, branches.get(branchNumber), 5));

				// stocks.get(branchNumber).insert(new Furniture(0, type, color, branches.get(branchNumber), 5));
			}
		}
		stocks.insert(new Stock(uniqueId, furniture));

		// stocks.get(branchNumber).insert(new Stock(uniqueId, new Furniture(0, type, color, branches.get(branchNumber), 5)));
		
		this.company.setCounter(uniqueId+1);

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
						stocks.remove(stockIndex);
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

	public boolean addBranchEmployee(int branchId, String name, String surname, int employeeId)
	{
		return true;
	}

	public boolean removeBranchEmployee(int branchId, String name, String surname, int employeeId)
	{
		return true;
	}

	public Company getCompany(){return this.company;}
	
}
