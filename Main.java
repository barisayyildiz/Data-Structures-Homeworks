import lib.furniture.*;
import lib.user.*;
import lib.*;
import java.util.Scanner;

public class Main
{
	public static Company initCompany()
	{
		// Company company = new Company();
		Scanner myObj = new Scanner(System.in);
		String name, surname, mail, password;
		int id;

		// System.out.print("Name : ");
		// name = myObj.nextLine();
		name = getString("Name : ");

		// System.out.print("Surname : ");
		// surname = myObj.nextLine();
		surname = getString("Surname : ");

		// System.out.print("Mail : ");
		// mail = myObj.nextLine();
		mail = getString("Mail : ");

		// System.out.print("Password : ");
		// password = myObj.nextLine();
		password = getString("Password : ");

		id = getInteger("Id : ");

		// myObj.nextInt();

		// myObj.close();

		// return new Company(new Admin(0,name,surname,mail,password));
		return new Company(new Admin(id, name, surname, mail, password)  );

	}

	public static String getString(String str)
	{
		System.out.print(str);
		return (new Scanner(System.in)).nextLine();
	}

	public static int getInteger(String str)
	{
		System.out.print(str);
		return (new Scanner(System.in)).nextInt();
	}

	public static void registerCustomer(Company company)
	{
		Customer customer = new Customer(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : "), company);

		try
		{
			customer.subscribe();
		}catch(Exception exceptiopn)
		{
			System.out.println(exceptiopn.getMessage() + "\n");
		}

	}

	public static void mainMenu()
	{
		Company company = initCompany();
		boolean flag = true;
		String input;
		// Scanner myObj = new Scanner(System.in);
		
		while(flag)
		{
			System.out.println("1. login as admin");
			System.out.println("2. login as employee");
			System.out.println("3. login as customer");
			System.out.println("4. register/subscribe as a customer");
			System.out.println("5. show company information");
			System.out.println("6. show a branch information");
			System.out.println("q. quit");

			// System.out.print("command : ");
			// input = (new Scanner(System.in)).nextLine();
			input = getString("command : ");

			switch(input)
			{
				case "1":
					adminMenu(company);
					break;
				case "2":
					employeeMenu(company);
					break;
				case "3":
					customerMenu(company);
					break;
				case "4":
					registerCustomer(company);
					break;
				case "5":
					break;
				case "6":
					try
					{
						company.showSingleBranch(getInteger("BranchId : "));
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "q":
					flag = false;
					break;
				default:
					System.out.println("Wrong input...");
					break;
			}
		}

	}

	public static void customerMenu(Company company)
	{
		String mail, password;
		boolean flag = true;
		String input;

		Customer customer = company.login(new Customer(getString("Mail : "), getString("Password : "), company));
		if(customer == null)
		{
			System.out.println("customer not found");
			return;
		}


	}

	public static void employeeMenu(Company company)
	{
		String mail, password;
		boolean flag = true;
		String input;

		mail = getString("Mail : ");
		password = getString("Password : ");

		Employee employee = company.login(new Employee(mail, password, company));

		if(employee == null)
		{
			System.out.println("user not found");
			return;
		}

		while(flag)
		{
			System.out.println("1. show employee info");
			System.out.println("2. make a sell");
			System.out.println("3. add customer");
			System.out.println("4. remove customer");
			System.out.println("5. add products");
			System.out.println("6. remove products");
			System.out.println("7. list products that needs to be supplied");
			System.out.println("8. list products in this branch");
			System.out.println("q. quit");

			// System.out.print("command : ");
			// input = (new Scanner(System.in)).nextLine();
			input = getString("command : ");

			switch(input)
			{
				case "1":
					System.out.println(employee);
					break;
				case "2":
					try
					{
						employee.sell(getInteger("CustomerId : "), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "3":
					if(employee.addCustomer(new Customer(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : "), company)))
						System.out.println("Customer added...");
					else
						System.out.print("This email is already registered...\n\n");
					break;
				case "4":
					if(employee.removeCustomer(getInteger("CustomerId : ")))
						System.out.print("Customer removed\n\n");
					else
						System.out.print("Customer id is not found...\n\n");
					break;
				case "5":
					// add products
					try
					{
						employee.addProducts(employee.getBranchId(), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "6":
					// remove products
					try
					{
						employee.removeProducts(employee.getBranchId(), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "7":
					// products needs to be supplied
					employee.productsNeedToBeSupplied();
					break;
				case "8":
					// list products in this branch
					try
					{
						company.showSingleBranch(employee.getBranchId());
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "q":
					flag = false;
					break;
				default:
					System.out.println("Wrong input...");
					break;
			}
		}

		// System.out.println("loggin in...");


	}

	public static void adminMenu(Company company)
	{
		Admin admin = company.getAdmin();

		String mail, password;
		
		boolean flag = true;
		String input;

		mail = getString("Mail : ");
		password = getString("Password : ");

		if(!mail.equals(admin.getMail())  || !password.equals(admin.getPassword()))
		{
			System.out.println("Mail or Password incorrect...");
			return;
		}

		while(flag)
		{
			System.out.println("1. show admin info");
			System.out.println("2. add branch");
			System.out.println("3. remove branch");
			System.out.println("4. add branch employee");
			System.out.println("5. remove branch employee");
			System.out.println("6. add customer");
			System.out.println("7. remove customer");
			System.out.println("8. add products");
			System.out.println("9. remove products");
			System.out.println("10. show branch id's");
			System.out.println("11. list all employees");
			System.out.println("12. list products that needs to be supplied");
			System.out.println("13. list all products");
			System.out.println("14. list all customers");
			System.out.println("15. show company info");

			System.out.println("q. quit");

			input = getString("command : ");

			switch(input)
			{
				case "1":
					System.out.print(admin + "\n\n");
					break;
				case "2":
					admin.addBranch();
					System.out.print("Branch have created...\n\n");
					break;
				case "3":
					if(admin.removeBranch(getInteger("Branch Id : ")))
						System.out.print("Branch have removed\n\n");
					else
						System.out.print("Branch id not found\n\n");
					break;
				case "4":
					if(admin.addBranchEmployee(new Employee(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : "), getInteger("Branch Id : "), company)))
						System.out.print("Employee hired!\n\n");
					else
						System.out.print("This email is already registered with another employee...\n\n");
					
					break;
				case "5":
					if(admin.removeBranchEmployee(getInteger("Employee id : ")))
						System.out.println("Employee have fired!\n\n");
					else
						System.out.println("Employee id is not found...\n\n");

					break;
				
				case "6":
					if(admin.addCustomer(new Customer(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : "), company)))
						System.out.println("Customer added...");
					else
						System.out.print("This email is already registered...\n\n");

					break;
				case "7":
					if(admin.removeCustomer(getInteger("CustomerId : ")))
						System.out.print("Customer removed\n\n");
					else
						System.out.print("Customer id is not found...\n\n");
					break;
				
				case "8":
					// add products
					try
					{
						admin.addProducts(getInteger("BranchId : "), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "9":
					// remove products
					try
					{
						admin.removeProducts(getInteger("BranchId : "), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}

					break;

				case "10":
					company.showBranchIds();
					break;
				case "11":
					admin.listEmployees();
					break;
				case "12":
					admin.productsNeedToBeSupplied();
					break;
				case "13":
					System.out.println(company);
					break;
				case "14":
					admin.listSubscribers();
					break;
				case "15":
					break;
				case "q":
					flag = false;
					break;
				default:
					System.out.println("Wrong input...");
					break;
			}
			


		}

		




	}

	public static void main(String args[])
	{
		mainMenu();

		// List<Integer> l1 = new List<Integer>();

		// l1.insert(2);
		// l1.insert(4);
		// l1.insert(6);

		// l1.remove(1);

		// System.out.println(l1);


		// Company c1 = new Company();

		// Admin admin = c1.getAdmin();

		// admin.addBranch();
		// admin.addBranch();
		// admin.removeBranch(0);
		// admin.removeBranch(1);
		// admin.addBranch();
		// admin.addBranch();
		// admin.addBranch();
		// admin.addBranch();

		// Customer customer = new Customer("baris", "ayyildiz", "asd", "123", c1);
		// Customer customer2 = new Customer("baris", "ayyildiz", "qwe", "123", c1);

		// customer.subscribe();
		// customer2.subscribe();

		// // customer.login();
		// // customer2.buyInShop(2, 8, 5);

		// customer.buyOnline(60, 20);

		// admin.addProducts(2, 60, 30);
		// admin.removeProducts(2, 59, 2);

		// // // admin.test(3,4);

		// Employee e1 = new Employee("john", "doe", "@mail123", "123", 2, c1);
		
		// admin.addBranchEmployee(e1);
		// admin.addBranchEmployee(new Employee("john", "doe", "@mail123", "123", 3, c1));
		// admin.addBranchEmployee(new Employee("john", "doe", "@mail123", "123", 4, c1));
		// admin.addBranchEmployee(new Employee("john", "doe", "@mail123", "123", 2, c1));

		// admin.removeBranchEmployee(2);

		// e1.addCustomer(new Customer("asya", "ayyildiz", "@mail", "345", c1));

		// e1.removeCustomer(1);

		// e1.productsNeedToBeSupplied();


		// e1.addProducts(3, 60, 500);

		// // e1.sell(0, 34, 100);

		// System.out.println(c1);

		// e1.productsNeedToBeSupplied();


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

