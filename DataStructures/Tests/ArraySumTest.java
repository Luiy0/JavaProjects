/*
 * ArraySumTest.java
 * This is a source file with a class to test the sumElements method 
 * implementations.
 */

package Tests;

import Algorithms.ArrayIteration;
import Algorithms.ArrayRecursion;

public class ArraySumTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		int[] myArray = { 10, 15, 8, 3, 20 };
		
		System.out.println("Iteration: Sum of elements is " +
				ArrayIteration.sumElements(myArray));
		System.out.println("Recursion: Sum of elements is " +
				ArrayRecursion.sumElements(myArray));
	}

}

