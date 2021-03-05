package lib.user;

public class Admin extends User implements AdminInterface {

	private String company;

	public Admin(int id, String name, String surname, String mail, String password)
	{
		super(id, name, surname, mail, password);
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
	
}
