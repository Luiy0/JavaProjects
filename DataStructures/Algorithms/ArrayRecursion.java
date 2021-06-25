/*
 * ArrayRecursion.java
 * This is a source file that contains a class with recursive static methods
 * for array processing.
 */

package Algorithms;

public class ArrayRecursion {
	
	// Prevents instantiation.
	private ArrayRecursion() { }

	// Returns the sum of the elements of an array of integers.
	public static int sumElements(int[] arr) {
		return sumElements(arr, arr.length);
	}

	private static int sumElements(int[] arr, int len) {
		if (len == 0)
			return 0;
		else
			return sumElements(arr, len - 1) + arr[len - 1];
	}

	// Returns the string representation of an array of integers.
	public static String toString(int [] arr) {
		return "[" + toString(arr, arr.length) + "]";
	}
	
	private static String toString(int[] arr, int len) {
		if (len == 0)
			return "";
		else if (len == 1)
			return Integer.toString(arr[0]);
		else
			return toString(arr, len - 1) + ", " + arr[len - 1];
	}

}

