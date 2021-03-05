package lib;

import lib.furniture.*;
import lib.user.*;

public class Company {
	
	private Admin companyAdmin;
	private int branchNumber;
	private Branch[] branches;


	public Company()
	{
		this.companyAdmin = new Admin(0, "baris", "ayyildiz", "99ayyldzbaris99@gmail.com", "123456", this);
		this.branchNumber = 2;

		// branches = (Branch[]) new Object[this.branchNumber];
		
		this.branches = new Branch[this.branchNumber];

	}

	public void test()
	{
		branches[0] = new Branch(0);
	}

	
}
