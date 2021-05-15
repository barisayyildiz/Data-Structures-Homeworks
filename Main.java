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
		
		System.out.println("Trader Menu : \n");

		while(flag){

			System.out.println("1. Show all your products");
			System.out.println("2. Add product");
			System.out.println("3. Remove product");
			System.out.println("4. Edit product");
			System.out.println("5. See list of orders");
			System.out.println("q. Exit");
			
			command = scanner.nextLine();

			switch(command){
				case "1":
					System.out.println(trader.showAllProducts());
					break;
				case "2":

					String productName, description;
					int price, discountedPrice;

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
					String id;
					System.out.print("Product id : ");
					id = scanner.nextLine();

					trader.removeProduct(id);

					break;
				case "4":
					break;
				case "5":
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

	}


	public static void main(String args[]){
		
		// menu();
		traderMenu();

	}
}

