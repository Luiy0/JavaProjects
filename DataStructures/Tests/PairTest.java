/*
 * PairTest.java
 * This source file contains a class to test the Pair<T> class.
 */

package Tests;

import java.util.Scanner;

import Structures.Pair;

public class PairTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		Pair<String> p1 = new Pair<>("cat", "dog");

		System.out.println("This is p1: " + p1);
		System.out.println();
		
		Pair<Integer> p2 = new Pair<>(10, 20);
		
		System.out.println("This is p2: " + p2);
		System.out.println();
		
		System.out.println("Are p1 and p2 equal? " + p1.equals(p2));
		System.out.println();
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a new integer for the first element: ");
		p2.setFirst(kb.nextInt());
		System.out.println("First set to " + p2.getFirst());
		System.out.println();
		
		System.out.print("Enter a new integer for the second element: ");
		p2.setSecond(kb.nextInt());
		System.out.println("Second set to " + p2.getSecond());
		
		System.out.println();
		kb.close();
		
		System.out.println("Now, this is p2: " + p2);
	}

}

