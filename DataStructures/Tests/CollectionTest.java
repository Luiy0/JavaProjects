/*
 * CollectionTest.java
 * This source file contains a class that tests some Collection class methods.
 */

package Tests;

import Structures.Collection;

public class CollectionTest {
	
	// Prints the data, size and empty status of this collection.
	public static <E> void print(Collection<E> col) {
		System.out.println("This is the collection: " + col);
		System.out.println("Its size is " + col.size());
		System.out.println("Is it empty? " + col.isEmpty());
	}

}

