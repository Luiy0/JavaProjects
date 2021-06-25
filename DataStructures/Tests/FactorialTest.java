/*
 * FactorialTest.java
 * This is a source file with a class to test the factorial method 
 * implementations.
 */

package Tests;

import java.util.Scanner;

import Algorithms.Iteration;
import Algorithms.Recursion;

public class FactorialTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a non-negative integer: ");
		int num = kb.nextInt();
		kb.close();

		if (num < 0) {
			System.err.println("Fatal error: Cannot compute the factorial " +
					"of a negative integer!");
			System.exit(1);  // Exit with error status code
		}
		System.out.println("Iteration: Factorial is " +
				Iteration.factorial(num));
		System.out.println("Recursion: Factorial is " +
				Recursion.factorial(num));
	}

}

