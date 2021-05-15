package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

import java.io.FileWriter;   // Import the FileWriter class

import java.util.ArrayList;

public class ECommerce {

	public static void initDataBase(){
		ArrayList<String> traderNames = new ArrayList<String>();

		// read csv
		try{
			
			BufferedReader csvReader = new BufferedReader(new FileReader("./e-commerce-samples.csv"));
			String row;

			// write products.txt
			try{
				FileWriter productsWriter = new FileWriter("products.txt");
				FileWriter tradersWriter = new FileWriter("users.txt");

				// reading header
				row = csvReader.readLine();

				productsWriter.write(row + "\n");
				tradersWriter.write("id;trader;password;role" + "\n");

				while((row = csvReader.readLine()) != null){
					String[] data = row.split(";");
					String name = data[6];

					if(!traderNames.contains(name)){
						traderNames.add(name);
						// traders.add(new Trader(name));

						// tradersWriter.write(traders.get(traders.size()-1).toString() + ";trader" + "\n");
						tradersWriter.write(String.valueOf(generateId(name)) + ";" + name + ";" + "123456" + ";" +  "trader" + "\n");
					}

					// productsWriter.write(data[0] + ";" + data[1] + ";" + data[3] + ";" + data[4] + ";" + data[6] + "\n");
					productsWriter.write(row + "\n");
				}

				tradersWriter.write("39469264;Barış Ayyıldız;123456;customer" + "\n");

				productsWriter.close();
				tradersWriter.close();

			}catch(Exception exception){
				System.out.println(exception.getMessage());
			}

			csvReader.close();

		}catch(Exception exception){
			System.out.println(exception.getMessage());
		}

	}

	private static int generateId(String str){
		int id = str.hashCode() % 100000000;
		if(id < 0)	id += 100000000;
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
			
			while((row = myreader.readLine()) != null){
				String[] data = row.split(";");
				String str = data[6];
				if(name.equals(str)){
					products.add(new Product(data[0], data[1], Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], data[6]));
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
	
			fw.write(product.toString());

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










	// private class Trader
	// {
	// 	private String name;
	// 	private int id;
	// 	private String password; 
	// 	public Trader(String name){
	// 		this.name = name;
	// 		this.id = this.name.hashCode() % 100000000;
	// 		if(this.id < 0){
	// 			this.id += 100000000;
	// 		}
	// 		this.password = "123456";
	// 	}
		
	// 	@Override
	// 	public String toString(){
	// 		return this.id + ";" + this.name + ";" + this.password;
	// 	}

	// }


}
