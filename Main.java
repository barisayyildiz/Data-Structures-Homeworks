import com.lib.furniture.*;
import com.lib.user.*;
import com.lib.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		// mainMenu();

	}

	public static Company initCompany()
	{		
	
		Company company = new Company(new Admin(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : ")));
		Admin admin = company.getAdmin();

		// add 4 branches
		for(int i=0; i<4; i++) admin.addBranch();

		return company;
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
		
		while(flag)
		{
			System.out.println("1. login as admin");
			System.out.println("2. login as employee");
			System.out.println("3. login as customer");
			System.out.println("4. register/subscribe as a customer");
			System.out.println("5. show company information");
			System.out.println("6. show a branch information");
			System.out.println("q. quit");

			try
			{
				input = getString("command : ");

			}catch(InputMismatchException exception)
			{
				System.out.println("Wrong input...\n");
				continue;
			}

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
					System.out.println(company);
					break;
				case "6":
					try
					{
						company.showSingleBranch(getInteger("BranchId : "));
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
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
		boolean flag = true;
		String input;
		Customer customer;


		try
		{
			customer = company.login(new Customer(getString("Mail : "), getString("Password : "), company));

		}catch(InputMismatchException exception)
		{
			System.out.println("Wrong input...\n");
			return;
		}



		if(customer == null)
		{
			System.out.println("customer not found");
			return;
		}

		while(flag)
		{
			System.out.println("1. show customer info");
			System.out.println("2. buy online");
			System.out.println("3. buy in shop");
			System.out.println("4. list all products");
			System.out.println("5. show a branch information");
			System.out.println("6. list previous orders");
			System.out.println("q. quit");

			try
			{
				input = getString("command : ");

			}catch(InputMismatchException exception)
			{
				System.out.println("Wrong input...\n");
				continue;
			}

			switch(input)
			{
				case "1":
					System.out.println(customer);
					break;
				case "2":
					try
					{
						customer.buyOnline(getInteger("ProductId : "), getInteger("Amount : "));
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "3":
					try
					{
						customer.buyInShop(getInteger("BranchId : "), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}
					catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "4":
					// System.out.println(company);
					company.showAllProducts();
					break;
				case "5":
					try
					{
						company.showSingleBranch(getInteger("BranchId : "));
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "6":
					customer.showOrderHistory();
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

	public static void employeeMenu(Company company)
	{
		boolean flag = true;
		String input;
		Employee employee;

		try
		{
			employee = company.login(new Employee(getString("Mail : "), getString("Password : "), company));
		}catch(InputMismatchException exception)
		{
			System.out.println("Wrong input...\n");
			return;
		}


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

			try
			{
				input = getString("command : ");

			}catch(InputMismatchException exception)
			{
				System.out.println("Wrong input...\n");
				continue;
			}

			switch(input)
			{
				case "1":
					System.out.println(employee);
					break;
				case "2":
					try
					{
						employee.sell(getInteger("CustomerId : "), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "3":

					try
					{
						if(employee.addCustomer(new Customer(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : "), company)))
							System.out.println("Customer added...");
						else
							System.out.print("This email is already registered...\n\n");
						
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}

					
					break;
				case "4":

					try
					{
						if(employee.removeCustomer(getInteger("CustomerId : ")))
							System.out.print("Customer removed\n\n");
						else
							System.out.print("Customer id is not found...\n\n");
						
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}

					break;
				case "5":
					// add products
					try
					{
						employee.addProducts(employee.getBranchId(), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
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
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
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
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");	
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

	public static void adminMenu(Company company)
	{
		Admin admin = company.getAdmin();

		String mail, password;
		
		boolean flag = true;
		String input;

		try
		{
			mail = getString("Mail : ");
			password = getString("Password : ");
		}catch(InputMismatchException exception)
		{
			System.out.println("Wrong input...\n");
			return;
		}

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
			System.out.println("16. show a branch information");

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
					try
					{
						if(admin.removeBranch(getInteger("Branch Id : ")))
							System.out.print("Branch have removed\n\n");
						else
							System.out.print("Branch id not found\n\n");
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}

					break;
				case "4":

					try
					{
						if(admin.addBranchEmployee(new Employee(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : "), getInteger("Branch Id : "), company)))
							System.out.print("Employee hired!\n\n");
						else
							System.out.print("This email is already registered with another employee...\n\n");

					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}

					
					break;
				case "5":

					try
					{
						if(admin.removeBranchEmployee(getInteger("Employee id : ")))
							System.out.println("Employee have fired!\n\n");
						else
							System.out.println("Employee id is not found...\n\n");
						
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}


					break;
				
				case "6":

					try
					{
						if(admin.addCustomer(new Customer(getString("Name : "), getString("Surname : "), getString("Mail : "), getString("Password : "), company)))
							System.out.println("Customer added...");
						else
							System.out.print("This email is already registered...\n\n");
						
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}

					break;
				case "7":

					try
					{
						if(admin.removeCustomer(getInteger("CustomerId : ")))
							System.out.print("Customer removed\n\n");
						else
							System.out.print("Customer id is not found...\n\n");
						break;
						
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
					}
				
				case "8":
					try
					{
						admin.addProducts(getInteger("BranchId : "), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(InputMismatchException exception)
					{
						System.out.print("Wrong input...\n");
						
					}catch(Exception exception)
					{
						System.out.println(exception.getMessage());
					}
					break;
				case "9":
					try
					{
						admin.removeProducts(getInteger("BranchId : "), getInteger("ProductId : "), getInteger("Amount : "));
					}catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
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
					company.showAllProducts();
					break;
				case "14":
					admin.listSubscribers();
					break;
				case "15":
					System.out.println(company);
					break;
				case "16":
					try
					{
						company.showSingleBranch(getInteger("BranchId : "));
					}
					catch(InputMismatchException exception)
					{
						System.out.println("Wrong input...\n");
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


}

