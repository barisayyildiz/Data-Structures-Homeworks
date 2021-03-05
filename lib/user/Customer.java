package lib.user;

public class Customer extends User
{
	private int branchId;

	public Customer(int id, String name, String surname, String mail, String password)
	{
		super(id, name, surname, mail, password);
	}
	
}
