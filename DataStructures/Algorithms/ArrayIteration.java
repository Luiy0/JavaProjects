/*
 * ArrayIteration.java
 * This is a source file that contains a class with iterative static methods
 * for array processing.
 */

package Algorithms;

public class ArrayIteration {
	
	// Prevents instantiation.
	private ArrayIteration() { }

	// Returns the sum of the elements of an array of integers.
	public static int sumElements(int[] arr) {
		int sum = 0;
		for (int elem: arr)
			sum += elem;
		return sum;
	}

	// Returns the string representation of an array of integers.
	public static String toString(int [] arr) {
		String str = "[";
		if (arr.length > 0) {
			str += arr[0];
			for (int idx = 1; idx < arr.length; idx++)
				str += ", " + arr[idx];
		}
		return str + "]";
	}
	
}

