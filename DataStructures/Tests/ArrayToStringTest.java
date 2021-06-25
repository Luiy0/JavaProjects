/*
 * ArrayToStringTest.java
 * This is a source file with a class to test the toString method implementations.
 */

package Tests;

import Algorithms.ArrayIteration;
import Algorithms.ArrayRecursion;

public class ArrayToStringTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		int[] myArray = { 10, 15, 8, 3, 20 };
		
		System.out.println("Iteration: Array is " + 
				ArrayIteration.toString(myArray));
		System.out.println("Recursion: Array is " +
				ArrayRecursion.toString(myArray));
	}

}

