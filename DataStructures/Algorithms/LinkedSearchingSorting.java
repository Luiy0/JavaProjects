package Algorithms;

import Structures.Node;

public class LinkedSearchingSorting {
	
	// Prevents instantiation.
		private LinkedSearchingSorting() { }

	// Determines the position of a key in a list using linear search.
	public static int linearSearch(Node<Integer> ls, Integer key) {
		int pos = 0;
		for (Node<Integer> curr = ls; curr != null; curr = curr.getNext())
			if (key.equals(curr.getData()))
				return pos;    // found at pos
			else
				pos++;
		return -1;             // not found
	}

	// Sorts the elements in a list using insertion sort.
	public static Node<Integer> insertionSort(Node<Integer> ls) {
		if (ls != null && ls.getNext() != null) { // size > 1
			Node<Integer> tail = ls.getNext();
			ls.setNext(null);
			
			while (tail != null) {
				Node<Integer> node = tail;
				tail = tail.getNext();
				
				// find insertion point
				Node<Integer> prev = null, curr = ls;
				while (curr != null && 
						node.getData().compareTo(curr.getData()) > 0) {
					prev = curr;
					curr = curr.getNext();
				}
				if (prev == null) {    // insert at the beginning
					node.setNext(ls);
					ls = node;
				}
				else {                 // insert at another point
					prev.setNext(node);
					node.setNext(curr);
				}
			}
		}
		return ls;
	}

}

