import java.util.Scanner;

import com.*;

public class Main
{
	public static void menu(){
		
		ECommerce.initDataBase();

		Scanner scanner = new Scanner(System.in);

		int id, role;
		String password;

		System.out.println("Welcome to my ECommerce App");

		while(true){
			System.out.print("User Id : ");
			id = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Password : ");
			password = scanner.nextLine();

			role = ECommerce.login(id, password);
			if(role == -1){
				System.out.println("User is not found...\n");
			}
			break;
		}

		switch(role){
			case 0:
				traderMenu();
			case 1:
				customerMenu();
		}


		scanner.close();
	}

	public static void traderMenu(){

		Trader trader = new Trader(63876974, "Alisha", "123456");

		Scanner scanner = new Scanner(System.in);		
		boolean flag = true;
		String command;

		String productName, description, id;
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
					System.out.println(trader.showAllProducts());
					break;
				case "2":

					System.out.print("Product name : ");
					productName = scanner.nextLine();
					// scanner.nextLine();
					System.out.print("Product Description : ");
					description = scanner.nextLine();
					// scanner.nextLine();
					System.out.print("Product Price : ");
					price = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Product Discounted Price : ");
					discountedPrice = scanner.nextInt();
					scanner.nextLine();

					trader.addProduct(productName, description, price, discountedPrice);

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
					trader.getOrdersTrader();
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

	public static void customerMenu(){

		Customer customer = new Customer(39469264, "Barış Ayyıldız", "123456");

		Scanner scanner = new Scanner(System.in);		
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
					System.out.println(customer.showSingleTrader(traderName));
					break;
				case "3":
					System.out.print("Product id : ");
					productId = scanner.nextLine();
					customer.makeAnOrder(productId);
					break;
				case "4":
					customer.getOrdersCustomer();
					break;
				case "5":
					System.out.print("Query : ");
					query = scanner.nextLine();
					customer.search(query);
					break;
				case "6":
					System.out.println(customer.getSearchResult());
					break;
				case "7":
					System.out.println("Lower bound : ");
					lowerBound = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Upper bound : ");
					upperBound = scanner.nextInt();

					System.out.println(customer.filterByPrice(lowerBound, upperBound));

					break;
				case "8":
					break;
				case "9":
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
		// traderMenu();
		customerMenu();

	}
}

