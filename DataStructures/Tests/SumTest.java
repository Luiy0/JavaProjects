/*
 * SumTest.java
 * This is a source file with a class to test the sum method implementations.
 */

package Tests;

import java.util.Scanner;

import Algorithms.Iteration;
import Algorithms.Recursion;

public class SumTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int num = kb.nextInt();
		kb.close();

		if (num < 1) {
			System.err.println("Fatal error: Cannot compute the sum" +
					" of a non-positive integer!");
			System.exit(1);  // Exit with error status code
		}
		System.out.println("Iteration: Sum up to the integer is " +
				Iteration.sum1To(num));
		System.out.println("Recursion: Sum up to the integer is " +
				Recursion.sum1To(num));
	}

}

