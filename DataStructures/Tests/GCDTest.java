/*
 * GcdTest.java
 * This is a source file with a class to test the gcd method implementations.
 */

package Tests;

import java.util.Scanner;

import Algorithms.Iteration;
import Algorithms.Recursion;

public class GCDTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter two non-negative integers: ");
		int num1 = kb.nextInt();
		int num2 = kb.nextInt();
		kb.close();

		if (num1 < 0 || num2 < 0) {
			System.err.println("Fatal error: Cannot compute the greatest" +
					" common divisor of negative integers!");
			System.exit(1);  // Exit with error status code
		}
		System.out.println("Iteration: Greatest common divisor is " +
				Iteration.gcd(num1, num2));
		System.out.println("Recursion: Greatest common divisor is " +
				Recursion.gcd(num1, num2));
	}

}

