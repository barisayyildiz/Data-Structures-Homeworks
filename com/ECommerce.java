package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

import java.io.FileWriter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Iterator;

public class ECommerce {

	public static void initDataBase(){
		ArrayList<String> traderNames = new ArrayList<String>();
		HashMap<String,String> traders = new HashMap<String,String>();

		// read csv
		try{
			
			BufferedReader csvReader = new BufferedReader(new FileReader("./e-commerce-samples.csv"));
			String row;

			// write products.txt
			try{
				FileWriter productsWriter = new FileWriter("products.txt");
				FileWriter tradersWriter = new FileWriter("users.txt");
				FileWriter ordersWriter = new FileWriter("orders.txt");

				// reading header
				row = csvReader.readLine();

				productsWriter.write(row + "\n");
				tradersWriter.write("id;trader;password;role" + "\n");
				ordersWriter.write("product_id;from;to;status" + "\n");

				while((row = csvReader.readLine()) != null){
					String[] data = row.split(";");
					String name = data[6];

					if(!traderNames.contains(name)){
						// traderNames.add(name);

						traders.put(name, generatePassword());

						// tradersWriter.write(String.valueOf(generateId(name)) + ";" + name + ";" + "123456" + ";" +  "trader" + "\n");
					}

					productsWriter.write(row + "\n");
				}

				// write traders
				for (String name: traders.keySet()) {
					tradersWriter.write(String.valueOf(generateId(name)) + ";" + name + ";" + traders.get(name) + ";" +  "trader" + "\n");
				}


				tradersWriter.write("39469264;Barış Ayyıldız;123456;customer" + "\n");
				tradersWriter.write(String.valueOf(generateId("Barış The Trader")) +  ";Barış The Trader;123456;trader" + "\n");

				productsWriter.close();
				tradersWriter.close();
				ordersWriter.close();

			}catch(Exception exception){
				System.out.println(exception.getMessage());
			}

			csvReader.close();

		}catch(Exception exception){
			System.out.println(exception.getMessage());
		}

	}

	private static String generatePassword(){
		Random rand = new Random();

		String str = "qwertyuiasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		String password = "";
		int length = str.length();

		for(int i=0; i<6; i++){
			password += str.charAt(rand.nextInt(length));
		}

		return password;
	}

	private static int generateId(String str){
		int id = str.hashCode() % 100000000;
		if(id < 0)	id = -id;
		if(id < 10000000) id += 10000000;
		return id;
	}

	// -1	not found
	// 0		trader
	// 1		customer
	public static int login(int id, String password){
		String row;

		try{
			BufferedReader myreader = new BufferedReader(new FileReader("users.txt"));

			myreader.readLine();

			while((row = myreader.readLine()) != null){
				String[] data = row.split(";");

				// id's matches
				if(Integer.parseInt(data[0]) == id && data[2].equals(password)){
					myreader.close();

					if(data[3].equals("trader")) return 0;
					return 1;

				}
			}

			myreader.close();

			return -1;
		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return -1;
		}

	}

	public static ArrayList<Product> getAllProducts(String name){

		String row;
		BufferedReader myreader;
		ArrayList<Product> products = new ArrayList<Product>();

		try{
			myreader = new BufferedReader(new FileReader("products.txt"));

			myreader.readLine();
			
			while((row = myreader.readLine()) != null){
				String[] data = row.split(";");
				String str = data[6];
				if(name.equals(str)){

					products.add(new Product(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6]));

				}
			}

			myreader.close();
			return products;

		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return null;
		}
		

	}

	public static void addProduct(Product product){

		try{
			FileWriter fw = new FileWriter("products.txt", true);

			TreeSet<String> tree = product.getCategoryTree();
			Iterator<String> iter = tree.iterator();

			String str = product.getId() + ";" + product.getProductName() + ";" + product.getCategoryString() + ";" + product.getPrice() + ";" + product.discountedPrice() + ";" + product.getDescription() + ";" + product.getTrader() + "\n";
	
			fw.write(str);

			fw.close();

		}catch(Exception excepiton){
			System.out.println(excepiton.getMessage());
		}

	}

	public static void removeProduct(String id){

		String row;
		BufferedReader myreader;
		BufferedWriter mywriter;

		try{
			myreader = new BufferedReader(new FileReader("products.txt"));
			mywriter = new BufferedWriter(new FileWriter("temp_products.txt"));
			
			// read header and save it
			row = myreader.readLine();
			mywriter.write(row + "\n");

			while((row = myreader.readLine()) != null){
				String[] data = row.split(";");
				
				if(data[0].equals(id)) continue;
				mywriter.write(row + "\n");
			}


			// rename the temp_products.txt to products.txt
			File file = new File("temp_products.txt");
			File file2 = new File("products.txt");
			file.renameTo(file2);

			myreader.close();
			mywriter.close();


		}catch(Exception exception){
			System.out.println(exception.getMessage());
		}

	}

	public static void editProduct(String id, String description){

		String row;
		BufferedReader myreader;
		BufferedWriter mywriter;

		try{

			myreader = new BufferedReader(new FileReader("products.txt"));
			mywriter = new BufferedWriter(new FileWriter("temp_products.txt"));

			// read header
			row = myreader.readLine();
			mywriter.write(row + "\n");

			while((row = myreader.readLine()) != null){

				String[] data = row.split(";");
				
				if(data[0].equals(id)){
					row = data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";" + data[4] + ";"	+ description + ";" + data[6];
				}

				mywriter.write(row + "\n");
			}

			// rename the temp_products.txt to products.txt
			File file = new File("temp_products.txt");
			File file2 = new File("products.txt");
			file.renameTo(file2);

			myreader.close();
			mywriter.close();

		}catch(Exception exception){
			System.out.println(exception.getMessage());
		}

	}

	public static LinkedList<String> getAllTraders(){

		String row;
		BufferedReader myreader;
		LinkedList<String> traders = new LinkedList<String>();

		try{
			myreader = new BufferedReader(new FileReader("users.txt"));

			// read header first
			myreader.readLine();

			while((row = myreader.readLine()) != null){
				String[] data = row.split(";");
				if(data[3].equals("trader"))
					traders.add(data[1]);
			}

			myreader.close();
			return traders;

		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return null;
		} 


	}

	private static int getUserId(String name){
		String row;
		BufferedReader myreader;
		int res = -1;

		try{
			myreader = new BufferedReader(new FileReader("users.txt"));

			myreader.readLine();

			while((row = myreader.readLine()) != null){
				String[] data = row.split(";");
				if(data[1].equals(name)){
					res = Integer.parseInt(data[0]);
				}
			}

			myreader.close();
			return res;

		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return res;
		}
	}

	public static void makeAnOrder(int customerId, String productId){

		String row;
		BufferedReader myreader;
		BufferedWriter mywriter;
		
		try{
			myreader = new BufferedReader(new FileReader("products.txt"));
			mywriter = new BufferedWriter(new FileWriter("orders.txt", true));

			// read header first
			myreader.readLine();

			while((row = myreader.readLine()) != null){

				String[] data = row.split(";");

				// product id's matches
				if(data[0].equals(productId)){
					mywriter.write(productId + ";" + customerId + ";" + getUserId(data[6]) + ";" + String.valueOf(OrderState.WAITING) + "\n");
					break;
				}
			}

			myreader.close();
			mywriter.close();

		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return;
		}


	}

	public static LinkedList<Order> getOrders(String name, boolean isTrader){

		String row;
		BufferedReader myreader;
		LinkedList<Order> result = new LinkedList<Order>();

		int id = getUserId(name);

		try{
			myreader = new BufferedReader(new FileReader("orders.txt"));

			// read header first
			myreader.readLine();

			while((row = myreader.readLine()) != null){
				String[] data = row.split(";");

				if(isTrader){
					if(data[2].equals(String.valueOf(id)) && data[3].equals(String.valueOf(OrderState.WAITING))){
						result.offer(new Order(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), OrderState.valueOf(data[3])));
					}
				}else{
					if(data[1].equals (String.valueOf(id) )){
						result.offer(new Order(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
					}
				}
			}

			myreader.close();
			return result;


		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return null;
		}


	}

	public static void updateOrders(Order order, OrderState state){

		String row;
		BufferedReader myreader;
		BufferedWriter mywriter;

		try{

			myreader = new BufferedReader(new FileReader("orders.txt"));
			mywriter = new BufferedWriter(new FileWriter("temp_orders.txt"));

			// read header first
			row = myreader.readLine();
			mywriter.write(row + "\n");

			while((row = myreader.readLine()) != null){

				String[] data = row.split(";");

				// found a match
				if(data[0].equals(order.getProductId()) && data[1].equals(String.valueOf(order.getCustomerId())) && data[2].equals(String.valueOf(order.getTraderId())) ){
					row = order.getProductId() + ";" + order.getCustomerId() + ";" + order.getTraderId() + ";" + state;
				}

				mywriter.write(row + "\n");

			}

			// rename the temp_orders.txt to orders.txt
			File file = new File("temp_orders.txt");
			File file2 = new File("orders.txt");
			file.renameTo(file2);

			myreader.close();
			mywriter.close();


		}catch(Exception exception){
			System.out.println(exception.getMessage());
		}

	}


	public static ArrayList<Product> getProductsByQuery(String query){

		String row;
		BufferedReader myreader;
		ArrayList<Product> products = new ArrayList<Product>();
		TreeSet<String> categoryTree = new TreeSet<String>();

		try{
			myreader = new BufferedReader(new FileReader("products.txt"));
			
			myreader.readLine();

			while((row = myreader.readLine()) != null){

				String[] data = row.split(";");

				// if name or description contains the query
				if(data[1].contains(query) || data[5].contains(query)){

					products.add(new Product(data[0], data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6]));
				}

				categoryTree.clear();


			}

			myreader.close();
			return products;


		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return null;
		}

	}

}
