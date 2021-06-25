/*
 * Searching.java
 * This is a source file with a class that contains iterative searching 
 * methods.
 */

package Algorithms;

public class Search {
	
	// Prevents instantiation of this class.
	private Search() { }
	
	// Determines the index of a key in an array using linear search.
	public static int linearSearch(int[] arr, int key) {
		for (int idx = 0; idx < arr.length; idx++)
			if (key == arr[idx])
				return idx;         // found at idx
		return -1;                  // not found
	}
	
	// Determines the index of a key in an array using binary search.
	public static int binarySearch(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key < arr[mid])
				hi = mid - 1;
			else if (key > arr[mid])
				lo = mid + 1;
			else
				return mid;         // found at mid
		}
		return -1;                  // not found
	}

}

