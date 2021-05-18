package com;

import java.util.*;

public class Customer extends User{

	private LinkedList<Order> orders;
	private ArrayList<Product> searchResult;

	public Customer(int id, String name, String password){
		super(id, name, password);
		this.orders = null;
		this.searchResult = null;
	}

	// get trader name as a paramter
	public String showSingleTrader(String name){

		ArrayList<Product> products = ECommerce.getAllProducts(name);

		return products.toString();
		
	}

	public void showAllTraderNames(){
		LinkedList<String> traderNames = ECommerce.getAllTraders();
		Iterator<String> iter = traderNames.iterator();
		System.out.println("Trader Names : ");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}	
	}

	public void makeAnOrder(String productId){
		
		ECommerce.makeAnOrder(this.getId(), productId);

	}

	private void syncOrders(){
		this.orders = ECommerce.getOrdersCustomer(this.getName());
		System.out.println(this.orders == null);
	}

	public void getOrdersCustomer(){
		this.syncOrders();
		Iterator<Order> iter = this.orders.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public void search(String query){

		this.searchResult = ECommerce.getProductsByQuery(query);

		// sort by name
		quickSort(this.searchResult, 0, this.searchResult.size()-1);
		

		System.out.println(searchResult);

	}

	public ArrayList<Product> getSearchResult(){
		return this.searchResult;
	}


	public ArrayList<Product> filterByPriceLowerBound(int lowerBound){

		ArrayList<Product> temp = new ArrayList<Product>();

		Iterator<Product> iter = this.searchResult.iterator();
		Product current;

		while(iter.hasNext()){
			current = iter.next();
			if(current.getPrice() >= lowerBound){
				temp.add(current);
			}
		}

		this.searchResult = temp;
		return this.searchResult;

	}

	public ArrayList<Product> filterByPriceUpperBound(int upperBound){

		ArrayList<Product> temp = new ArrayList<Product>();

		Iterator<Product> iter = this.searchResult.iterator();
		Product current;

		while(iter.hasNext()){
			current = iter.next();
			if(current.getPrice() <= upperBound){
				temp.add(current);
			}
		}

		this.searchResult = temp;
		return this.searchResult;
		
	}

	public ArrayList<Product> filterByPrice(int lowerBound, int upperBound){

		ArrayList<Product> temp = new ArrayList<Product>();

		Iterator<Product> iter = this.searchResult.iterator();
		Product current;

		while(iter.hasNext()){
			current = iter.next();
			if(current.getPrice() >= lowerBound && current.getPrice() <= upperBound){
				temp.add(current);
			}
		}

		this.searchResult = temp;

		return this.searchResult;

	}

	public ArrayList<Product> filterByCategory(String query){
		ArrayList<Product> temp = new ArrayList<Product>();
		Iterator<Product> iter = this.searchResult.iterator();
		Product current;

		while(iter.hasNext()){
			current = iter.next();
			if(current.containsCategory(query)){
				temp.add(current);
			}
		}
		
		this.searchResult = temp;
		return this.searchResult;

	}

	// quick sort is used
	public ArrayList<Product> sortByName(){

		quickSort(this.searchResult, 0, this.searchResult.size()-1);

		return this.searchResult;

	}

	public ArrayList<Product> sortByPrice(){

		bubbleSort(this.searchResult);

		return this.searchResult;

	}

	public ArrayList<Product> sortByDiscount(){

		this.searchResult = mergeSort(this.searchResult);

		return this.searchResult;

	}

	private ArrayList<Product> mergeSort(ArrayList<Product> arr){

		if(arr.size() == 1){
			return arr;
		}

		// divide left and right arrays
		ArrayList<Product> left = new ArrayList<Product>(arr.subList(0, arr.size()/2));
		ArrayList<Product> right = new ArrayList<Product>(arr.subList(arr.size()/2, arr.size()));

		left = mergeSort(left);
		right = mergeSort(right);

		int i = 0, j =0, counter = 0;

		while(i < left.size() && j < right.size()){
			if(left.get(i).getDiscountPercentage() > right.get(j).getDiscountPercentage()){
				arr.set(counter, left.get(i));
				i++;
			}else{
				arr.set(counter, right.get(j));
				j++;
			}
			counter++;
		}

		// empty left array
		while(i < left.size()){
			arr.set(counter, left.get(i));
			i++;
			counter++;
		}

		// empty right array
		while(j < right.size()){
			arr.set(counter, right.get(j));
			j++;
			counter++;
		}

		return arr;

	}

	private void bubbleSort(ArrayList<Product> arr){

		int n = arr.size();

		for(int i=0; i<n-1; i++){
			for(int j=0; j<n-i-1; j++){
				if(arr.get(j).getPrice() > arr.get(j+1).getPrice()){
					swap(arr, j, j+1);
				}
			}
		}

	}

	private void quickSort(ArrayList<Product> arr, int low, int high){

		if(low < high){

			int pi = partition(arr, low, high);

			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);

		}

	}

	private int partition(ArrayList<Product> arr, int low, int high){
		// pivot
		Product pivot = arr.get(high);
			 
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);
 
		for(int j = low; j <= high - 1; j++)
		{
				 
				// If current element is smaller
				// than the pivot
				if (arr.get(j).getProductName().compareTo(pivot.getProductName()) < 0)
				{
						// Increment index of
						// smaller element
						i++;
						swap(arr, i, j);
				}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	private void swap(ArrayList<Product> arr, int i, int j){
		Product temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
}
