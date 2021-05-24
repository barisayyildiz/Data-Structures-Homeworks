import com.ecommerce.*;
import com.users.*;

public class Test
{
	public static void main(String args[]){

		User user = ECommerce.login(63876975, "lk13ZR");
		Customer customer;
		Trader trader;

		// System.out.println(user.getId() + ", " + user == null);
		// System.out.println(user.getName());

		if(user == null){
			// not found
		}

		try{

			trader = (Trader)user;

			
			customer = (Customer)user;
			if(customer != null)

			// call trader 

		}catch(ClassCastException exception){

			user = 

		}

		customer = (Customer)user;

		System.out.println(customer);

		// try{
		// 	Customer customer = (Customer)user;

		// }

		// System.out.println(customer == null);


		
	}
}