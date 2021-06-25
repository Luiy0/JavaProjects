/*
 * ArraysDemo.java
 * This is a source file with a class to demonstrate some array methods
 * from the Arrays class.
 */

package Apps;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayDemo {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		int[] arr1 = createUnsortedArray(25);

		System.out.println("This is an unsorted array:\n" + 
				Arrays.toString(arr1));
		System.out.println();
		
		Arrays.sort(arr1);
		
		System.out.println("After sorting using quick sort...\n" + 
				Arrays.toString(arr1));
		System.out.println();
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a key to search: ");
		int key = kb.nextInt();
		kb.close();
		
		System.out.println("Using binary search, index=" + 
				Arrays.binarySearch(arr1, key));
	}

	// Creates and returns an unsorted array.
	public static int[] createUnsortedArray(int size) {
		int[] arr = new int[size];
		Random gen = new Random();
		for (int k = 0; k < arr.length; k++)
			arr[k] = gen.nextInt(100);  // random num in 0..99
		return arr;
	}

}

