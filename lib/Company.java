package lib;

import lib.furniture.*;
import lib.user.*;

public class Company {
	
	private Admin companyAdmin;
	private int branchNumber;
	// private Branch[] branches;
	private List<Branch> branches;


	public Company()
	{
		this.companyAdmin = new Admin(0, "baris", "ayyildiz", "99ayyldzbaris99@gmail.com", "123456", this);
		this.branchNumber = 2;

		branches = new List<Branch>();
		branches.insert(new Branch(0));
		branches.insert(new Branch(1));

	}
	
}
