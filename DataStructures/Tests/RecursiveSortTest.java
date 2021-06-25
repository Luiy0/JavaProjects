/*
 * RecursiveSortingTest.java
 * This is a source file with a class to test the recursive sorting 
 * methods.
 */

package Tests;

import java.util.Random;
import Algorithms.RecursiveSort;

public class RecursiveSortTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		int[] arr1 = createUnsortedArray(25);

		System.out.println("This is an unsorted array: ");
		displayArray(arr1);
		System.out.println();

		RecursiveSort.mergeSort(arr1);

		System.out.println("After merge sort...");
		displayArray(arr1);
		System.out.println();
		
		int[] arr2 = createUnsortedArray(25);
		
		System.out.println("This is another unsorted array: ");
		displayArray(arr2);
		System.out.println();

		RecursiveSort.quickSort(arr2);

		System.out.println("After quick sort...");
		displayArray(arr2);
	}

	// Creates and returns an unsorted array.
	public static int[] createUnsortedArray(int size) {
		int[] arr = new int[size];
		Random gen = new Random();
		for (int idx = 0; idx < arr.length; idx++)
			arr[idx] = gen.nextInt(100);  // random num in 0..99
		return arr;
	}

	// Displays the contents of an array.
	public static void displayArray(int[] arr) {
		for (int elem : arr)
			System.out.print(elem + " ");
		System.out.println();
	}

}

