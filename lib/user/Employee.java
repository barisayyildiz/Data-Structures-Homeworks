package lib.user;

public class Employee extends User
{
	private int branchId;

	public Employee(int id, String name, String surname, String mail, String password)
	{
		super(id, name, surname, mail, password);
	}
	
}
