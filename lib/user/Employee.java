package lib.user;

public class Employee extends User
{
	private int branchId;

	public Employee(int id, String name, String surname, String mail, String password, int branchId)
	{
		super(id, name, surname, mail, password);
		this.branchId = branchId;
	}

	public Employee(String name, String surname, String mail, String password, int branchId)
	{
		super(name, surname, mail, password);
		this.branchId = branchId;
	}

	@Override
	public boolean equals(Object obj)
	{
		Employee temp = (Employee)obj;

		if(temp.getId() == this.getId())
			return true;
		return false;

	}

	
}
