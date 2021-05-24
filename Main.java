import java.util.Scanner;

import com.ecommerce.*;
import com.users.*;

public class Main
{
	public static void menu(){
		
		// ECommerce.initDataBase();

		Scanner scanner = new Scanner(System.in);
		User user;
		Trader trader;
		Customer customer;

		int id;
		String password;

		System.out.println("Welcome to my ECommerce App");

		while(true){
			System.out.print("User Id : ");
			id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Password : ");
			password = scanner.nextLine();

			user = ECommerce.login(id, password);

			System.out.println("user : " + user);

			if(user == null){
				System.out.println("User is not found...\n");
				continue;
			}

			break;
			
		}
		
		try{
			trader = (Trader)user;
			// scanner.close();
			traderMenu(trader, scanner);
		}catch(ClassCastException exception){
			customer = (Customer)user;
			// scanner.close();
			customerMenu(customer, scanner);
		}

	}

	public static void traderMenu(Trader trader, Scanner scanner){

		boolean flag = true;
		String command;

		String productName, description, id, categoryTree;
		int price, discountedPrice;

		System.out.println("Trader Menu : \n");

		while(flag){

			System.out.println("1. Show all your products");
			System.out.println("2. Add product");
			System.out.println("3. Remove product");
			System.out.println("4. Edit product");
			System.out.println("5. See list of orders");
			System.out.println("6. Meet the first order in the order list");
			System.out.println("7. Cancel the first order in the order list");
			System.out.println("q. Exit");
			
			System.out.print("\nCommand : ");
			command = scanner.nextLine();

			switch(command){
				case "1":
					trader.showAllProducts();
					break;
				case "2":

					System.out.print("Product name : ");
					productName = scanner.nextLine();
					// scanner.nextLine();
					System.out.print("Product Description : ");
					description = scanner.nextLine();
					System.out.print("Category tree ( leave >>  between two categories => Clothing >> Women's Clothing >> Sports ) : ");
					categoryTree = scanner.nextLine();
					// scanner.nextLine();
					System.out.print("Product Price : ");
					price = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Product Discounted Price : ");
					discountedPrice = scanner.nextInt();
					scanner.nextLine();

					trader.addProduct(productName, description, price, discountedPrice, categoryTree);
					break;
				case "3":
					System.out.print("Product id : ");
					id = scanner.nextLine();

					trader.removeProduct(id);
					break;
				case "4":
					System.out.print("Product id : ");
					id = scanner.nextLine();
					System.out.print("Product Description : ");
					description = scanner.nextLine();

					trader.editProduct(id, description);
					break;
				case "5":
					trader.getOrders();
					break;
				case "6":
					trader.meetOrder();
					break;
				case "7":
					trader.cancelOrder();
					break;
				case "q":
					flag = false;
					break;
				default:
					System.out.println("Command not valid\n");
			}

		}

		scanner.close();


	}

	public static void customerMenu(Customer customer, Scanner scanner){
		
		boolean flag = true;
		String command;

		String traderName, productId, query;
		int lowerBound, upperBound;

		System.out.println("Customer Menu : \n");

		while(flag){

			System.out.println("1. Show all traders names...");
			System.out.println("2. Show single trader's products...");
			System.out.println("3. Make an order...");
			System.out.println("4. See list of orders.");
			System.out.println("5. Search for a product...");
			System.out.println("6. Get last searched result");
			System.out.println("7. Filter by price ( upper and lower bounds )");
			System.out.println("8. Filter by price ( only lower bound ) ");
			System.out.println("9. Filter by price ( only upper bound ) ");
			System.out.println("10. Filter by category name");
			System.out.println("11. Sort the results by name...");
			System.out.println("12. Sort the results by price...");
			System.out.println("13. Sort the results by % of discount...");
			System.out.println("q. Exit");
			
			System.out.print("\nCommand : ");
			command = scanner.nextLine();

			switch(command){
				case "1":
					customer.showAllTraderNames();
					break;
				case "2":
					System.out.print("Trader name : ");
					traderName = scanner.nextLine();

					customer.showSingleTrader(traderName);
					break;
				case "3":
					System.out.print("Product id : ");
					productId = scanner.nextLine();

					customer.makeAnOrder(productId);
					break;
				case "4":
					customer.getOrders();
					break;
				case "5":
					System.out.print("Query : ");
					query = scanner.nextLine();

					customer.search(query);
					break;
				case "6":
					customer.getSearchResult();
					break;
				case "7":
					System.out.print("Lower bound : ");
					lowerBound = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Upper bound : ");
					upperBound = scanner.nextInt();
					scanner.nextLine();

					customer.filterByPrice(lowerBound, upperBound);
					break;
				case "8":
					System.out.print("Lower bound : ");
					lowerBound = scanner.nextInt();
					scanner.nextLine();
					customer.filterByPriceLowerBound(lowerBound);
					break;
				case "9":
					System.out.print("Upper bound : ");
					upperBound = scanner.nextInt();
					scanner.nextLine();
					customer.filterByPriceUpperBound(upperBound);
					break;
				case "10":
					System.out.print("Category name : ");
					query = scanner.nextLine();
					customer.filterByCategory(query);
					// scanner.nextLine();
					break;
				case "11":
					customer.sortByName();
					break;
				case "12":
					customer.sortByPrice();
					break;
				case "13":
					customer.sortByDiscount();
					break;
				case "q":
					flag = false;
					break;
				default:
					System.out.println("Command not valid\n");
			}

		}

		scanner.close();

	}


	public static void main(String args[]){
		
		// menu();
		// traderMenu(new Trader(63876974, "lk13ZR"), new Scanner(System.in));
		customerMenu(new Customer(39469264, "123456"), new Scanner(System.in));

	}
}

