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
		admin.addBranch();
		admin.addBranch();

		Customer customer = new Customer("baris", "ayyildiz", "asd", "123", c1);
		Customer customer2 = new Customer("baris", "ayyildiz", "qwe", "123", c1);

		customer.subscribe();
		customer2.subscribe();

		// customer.login();
		// customer2.buyInShop(2, 8, 5);

		customer.buyOnline(60, 20);

		admin.addProducts(2, 60, 30);
		admin.removeProducts(2, 59, 2);

		// // admin.test(3,4);

		Employee e1 = new Employee("john", "doe", "@mail123", "123", 2, c1);
		
		admin.addBranchEmployee(e1);
		admin.addBranchEmployee(new Employee("john", "doe", "@mail123", "123", 3, c1));
		admin.addBranchEmployee(new Employee("john", "doe", "@mail123", "123", 4, c1));
		admin.addBranchEmployee(new Employee("john", "doe", "@mail123", "123", 2, c1));

		admin.removeBranchEmployee(2);

		e1.addCustomer(new Customer("asya", "ayyildiz", "@mail", "345", c1));

		e1.removeCustomer(1);

		e1.productsNeedToBeSupplied();


		e1.addProducts(3, 60, 500);

		// e1.sell(0, 34, 100);

		System.out.println(c1);

		e1.productsNeedToBeSupplied();


		// c1.subscribe("john", "doe", "asd@mail.com", "123");
		// // c1.subscribe("john", "doe", "asd@mail.com", "123");

		// String name = "john";
		// String surname = "doe";
		// String mail = "asd@mail.com";
		// String password = "123";

		// c1.login(mail, password);
		
		// // buyOnline(product_id, amount)
		
		// // c1.buyOnline(12, 4);

		
		// // // buyInShop(branchId, productId, amount)
		
		// c1.buyInShop(2,12,1);
		// c1.showSingleBranch(2);
		
		
		// System.out.println(c1);


		// // Add branch employee
		// admin.addBranchEmployee(new Employee(0, "john", "doe", "johndoe@gmail.com", "123", 0));
		// admin.addBranchEmployee(new Employee(1, "john", "doe", "johndoe@gmail.com", "123", 0));
		// admin.addBranchEmployee(new Employee(2, "john", "doe", "johndoe@gmail.com", "123", 2));

		// admin.removeBranchEmployee(1);

		// System.out.println(c1);

	}



}

