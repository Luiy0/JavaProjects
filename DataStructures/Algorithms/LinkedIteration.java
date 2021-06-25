/*
 * LinkedIteration.java
 * This source file contains a class with iterative static methods for
 * a linked list of nodes
 */

package Algorithms;

import Structures.Node;

public class LinkedIteration {

	// Prevents instantiation.
	private LinkedIteration() { }

	// Returns the number of nodes in the given list.
	public static int size(Node<Integer> ls) {
		int size = 0;
		for (Node<Integer> curr = ls; curr != null; curr = curr.getNext())
			size++;
		return size;
	}

	// Returns the sum of the elements in the given list of numbers.
	public static int sumElements(Node<Integer> ls) {
		int sum = 0;
		for (Node<Integer> curr = ls; curr != null; curr = curr.getNext())
			sum += curr.getData();
		return sum;
	}
	
	// Returns the string representation of the given list.
	public static String toString(Node<Integer> ls) {
		String str = "[";
		if (ls != null) {
			str += ls.getData();
			for (Node<Integer> curr = ls.getNext(); curr != null; curr = curr.getNext())
				str += ", " + curr.getData();
		}
		return str + "]";
	}

}

