/*
 * Iteration.java
 * This is a source file that contains a class with iterative static methods.
 */

package Algorithms;

public class Iteration {
	
	// Prevents instantiation.
	private Iteration() { }
		
	// Returns the sum from 1 to a non-negative integer.
	public static int sum1To(int n) {
		int sum = 1;
		while (n > 1)
			sum += n--;
		return sum;
	}
	
	// Returns the factorial of a non-negative integer.
	public static long factorial(int n) {
		long product = 1;
		while (n > 0)
			product *= n--;
		return product;
	}
	
	// Returns the greatest common divisor for two non-negative integers.
	public static int gcd(int m, int n) {
		while (n > 0) {
			int rem = m % n;
			m = n;
			n = rem;
		}
		return m;
	}

}

