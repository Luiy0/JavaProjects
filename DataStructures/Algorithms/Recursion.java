/*
 * Recursion.java
 * This is a source file that contains a class with recursive static methods.
 */

package Algorithms;

public class Recursion {
	
	// Prevents instantiation.
	private Recursion() { }

	// Returns the sum from 1 to a non-negative integer.
	public static int sum1To(int n) {
		if (n == 1)
			return 1;
		else
			return n + sum1To(n - 1);
	}

	// Returns the factorial of a non-negative integer.
	public static long factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	// Returns the greatest common divisor for two non-negative integers.
	public static int gcd(int m, int n) {
		if (n == 0)
			return m;
		else
			return gcd(n, m % n);
	}

}

