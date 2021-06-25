/*
 * SearchingTest.java
 * This is a source file with a class to test the iterative searching 
 * methods.
 */

package Tests;

import java.util.Random;
import java.util.Scanner;

import Algorithms.Search;

public class SearchTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		int[] unsorted = createUnsortedArray(25);

		System.out.println("This is an unsorted array: ");
		displayArray(unsorted);
		System.out.println();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a key to search: ");
		int key = kb.nextInt();

		System.out.println("Using linear search, index=" + 
				Search.linearSearch(unsorted, key));
		System.out.println();

		int[] sorted = createSortedArray(25);

		System.out.println("This is a sorted array: ");
		displayArray(sorted);
		System.out.println();

		System.out.print("Enter a key to search: ");
		key = kb.nextInt();
		kb.close();

		System.out.println("Using linear search, index=" + 
				Search.linearSearch(sorted, key));
		System.out.println("Using binary search, index=" + 
				Search.binarySearch(sorted, key));
	}

	// Creates and returns an unsorted array.
	public static int[] createUnsortedArray(int size) {
		int[] arr = new int[size];
		Random gen = new Random();
		for (int idx = 0; idx < arr.length; idx++)
			arr[idx] = gen.nextInt(100);  // random num in 0..99
		return arr;
	}

	// Creates and returns a sorted array.
	public static int[] createSortedArray(int size) {
		int[] arr = new int[size];
		for (int idx = 0; idx < arr.length; idx++)
			arr[idx] = idx * 5;
		return arr;
	}

	// Displays the contents of an array.
	public static void displayArray(int[] arr) {
		for (int elem : arr)
			System.out.print(elem + " ");
		System.out.println();
	}

}

