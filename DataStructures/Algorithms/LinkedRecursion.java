/*
 * LinkedRecursion.java
 * This source file contains a class with recursive static methods for
 * a linked list of nodes
 */

package Algorithms;

import Structures.Node;

public class LinkedRecursion {
	
	// Prevents instantiation.
	private LinkedRecursion() { }
	
	// Returns the number of nodes in the given list.
	public static int size(Node<Integer> ls) {
		if (ls == null)
			return 0;
		else
			return 1 + size(ls.getNext());
	}

	// Returns the sum of the elements in the given list of numbers.
	public static int sumElements(Node<Integer> ls) {
		if (ls == null)
			return 0;
		else
			return ls.getData() + sumElements(ls.getNext());
	}
	
	// Returns the string representation of the given list.
	public static String toString(Node<Integer> ls) {
		return "[" + toStringHelper(ls) + "]";
	}
	
	private static String toStringHelper(Node<Integer> ls) {
		if (ls == null)
			return "";
		else if (ls.getNext() == null)
			return ls.getData().toString();
		else
			return ls.getData() + ", " + toStringHelper(ls.getNext());
	}

}

