package lib.user;

import lib.*;
import lib.furniture.*;

public class Customer extends User
{
	private List<Stock> orderHistory;

	public Customer(int id, String name, String surname, String mail, String password)
	{
		super(id, name, surname, mail, password);

		this.orderHistory = new List<Stock>();

	}
	
}
