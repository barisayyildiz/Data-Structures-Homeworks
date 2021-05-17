import java.util.ArrayList;

public class Test{
     
	// A utility function to swap two elements
	static void swap(ArrayList<Integer> arr, int i, int j)
	{
			int temp = arr.get(i);
			arr.set(i, arr.get(j));
			arr.set(j, temp);
	}
	 
	/* This function takes last element as pivot, places
		 the pivot element at its correct position in sorted
		 array, and places all smaller (smaller than pivot)
		 to left of pivot and all greater elements to right
		 of pivot */
	static int partition(ArrayList<Integer> arr, int low, int high)
	{
			 
			// pivot
			int pivot = arr.get(high);
			 
			// Index of smaller element and
			// indicates the right position
			// of pivot found so far
			int i = (low - 1);
	 
			for(int j = low; j <= high - 1; j++)
			{
					 
					// If current element is smaller
					// than the pivot
					if (arr.get(j) < pivot)
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
	 
	/* The main function that implements QuickSort
						arr[] --> Array to be sorted,
						low --> Starting index,
						high --> Ending index
	 */
	static void quickSort(ArrayList<Integer> arr, int low, int high)
	{
			if (low < high)
			{
					 
					// pi is partitioning index, arr[p]
					// is now at right place
					int pi = partition(arr, low, high);
	 
					// Separately sort elements before
					// partition and after partition
					quickSort(arr, low, pi - 1);
					quickSort(arr, pi + 1, high);
			}
	}
	 
	// Driver Code
	public static void main(String[] args)
	{
			// int[] arr = { 10, 7, 8, 9, 1, 5 };
			// int n = arr.length;

			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(10);
			arr.add(7);
			arr.add(8);
			arr.add(9);
			arr.add(1);
			arr.add(5);

			System.out.println(arr);
			 
			quickSort(arr, 0, arr.size()-1);
			System.out.println(arr);
	}
	}