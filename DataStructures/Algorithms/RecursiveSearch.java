/*
 * RecursiveSearching.java
 * This is a source file with a class that contains recursive searching 
 * methods.
 */

package Algorithms;

public class RecursiveSearch {
	
	// Prevents instantiation of this class.
	private RecursiveSearch() { }
	
	// Determines the index of a key in an array using linear search.
	public static int linearSearch(int[] arr, int key) {
		return linearSearch(arr, 0, key);
	}
	
	private static int linearSearch(int[] arr, int idx, int key) {
		if (idx > arr.length - 1)
			return -1;              // not found
		else if (key == arr[idx])
			return idx;              // found at idx
		else
			return linearSearch(arr, idx + 1, key);
	}
	
	// Determines the index of a key in an array using binary search.
	public static int binarySearch(int[] arr, int key) {
		return binarySearch(arr, 0, arr.length - 1, key);
	}
	
	private static int binarySearch(int[] arr, int lo, int hi, int key) {
		if (lo > hi)
			return -1;              // not found
		else {
			int mid = (lo + hi) / 2;
			if (key == arr[mid])
				return mid;         // found at mid
			else if (key < arr[mid])
				return binarySearch(arr, lo, mid - 1, key);
			else // (key > arr[mid])
				return binarySearch(arr, mid + 1, hi, key);
		}
	}

}

