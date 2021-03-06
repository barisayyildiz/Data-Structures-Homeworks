import lib.furniture.*;
import lib.user.*;
import lib.*;

public class Main
{
	public static void main(String args[])
	{
		// List<Integer> l1 = new List<Integer>();

		// l1.insert(2);
		// l1.insert(4);
		// l1.insert(6);

		// l1.remove(1);

		// System.out.println(l1);





		Company c1 = new Company();

		Admin admin = c1.getAdmin();

		admin.addBranch();
		admin.addBranch();
		admin.removeBranch(0);
		admin.removeBranch(1);
		admin.addBranch();
		admin.addBranch();

		c1.subscribe("john", "doe", "asd@mail.com", "123");
		// c1.subscribe("john", "doe", "asd@mail.com", "123");

		String name = "john";
		String surname = "doe";
		String mail = "asd@mail.com";
		String password = "123";

		c1.login(mail, password);
		
		// buyOnline(product_id, amount)
		
		// c1.buyOnline(12, 4);

		
		// // buyInShop(branchId, productId, amount)
		
		c1.buyInShop(2,12,1);
		c1.showSingleBranch(2);
		
		
		// System.out.println(c1);


		// // Add branch employee
		// admin.addBranchEmployee(new Employee(0, "john", "doe", "johndoe@gmail.com", "123", 0));
		// admin.addBranchEmployee(new Employee(1, "john", "doe", "johndoe@gmail.com", "123", 0));
		// admin.addBranchEmployee(new Employee(2, "john", "doe", "johndoe@gmail.com", "123", 2));

		// admin.removeBranchEmployee(1);

		// System.out.println(c1);





	}
}

