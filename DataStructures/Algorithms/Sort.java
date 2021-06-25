/*
 * Sorting.java
 * This is a source file with a class that contains iterative sorting
 * methods.
 */

package Algorithms;

public class Sort {
	
	// Prevents instantiation of this class.
	private Sort() { }
	
	// Sorts an array using selection sort.
	public static void selectionSort(int[] arr) {
		for (int pos = 0; pos < arr.length - 1; pos++) {
			int minIdx = pos;
			for (int scan = pos + 1; scan < arr.length; scan++)
				if (arr[scan] < arr[minIdx])
					minIdx = scan;

			if (pos != minIdx) {
				int temp = arr[pos];
				arr[pos] = arr[minIdx];
				arr[minIdx] = temp;
			}
		}
	}
	
	// Sorts an array using insertion sort.
	public static void insertionSort(int[] arr) {
		for (int scan = 1; scan < arr.length; scan++) {
			int temp = arr[scan];
			
			int pos = scan;
			while (pos > 0 && arr[pos - 1] > temp) {
				arr[pos] = arr[pos - 1];
				pos--;
			}
			arr[pos] = temp;
		}
	}

}

