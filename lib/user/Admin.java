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

	public boolean addBranch(int branchId)
	{
		return true;
	}

	public boolean removeBranch(int branchId)
	{
		return true;
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
