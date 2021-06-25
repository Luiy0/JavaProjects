/*
 * BagIteratorTest.java
 * This source file contains a class that tests iterators for the Bag 
 * interface and implementation.
 */

package Tests;

import java.util.Iterator;

import Structures.*;

public class BagIteratorTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Bag<String> bag = new LinkedBag<>();
		
		bag.add("cat");
		bag.add("dog");
		bag.add("tree");
		bag.add("house");
		bag.add("boat");
		bag.add("woman");
		bag.add("man");
		
		System.out.println("After adding some elements...");
		CollectionTest.print(bag);
		System.out.println();
		
		System.out.println("Traversing the bag using an explicit iterator...");
		Iterator<String> it = bag.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println();
		
		System.out.println("Traversing the bag using the enhanced for...");
		for (String element : bag)
			System.out.println(element);
	}

}

