/*
 * BagTest.java
 * This source file contains a class that tests the Bag interface and
 * implementation.
 */

package Tests;


//import datastructures.ArrayBag;
import Structures.ArrayBag;
import Structures.Bag;


public class BagTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		
		Bag<String> bag = new ArrayBag<>();
		
		System.out.println("After creating a new bag...");
		CollectionTest.print(bag);
		System.out.println();
		
		bag.add("cat");
		bag.add("dog");
		bag.add("tree");
		bag.add("house");
		bag.add("boat");
		bag.add("woman");
		bag.add("dog");
		bag.add("man");
		
		System.out.println("After adding some elements...");
		CollectionTest.print(bag);
		System.out.println();
		
		System.out.println("Does it contain a house? " + bag.contains("house"));
		System.out.println("Does it contain a dog? " + bag.contains("dog"));
		System.out.println("How many dogs are in the bag? " + bag.count("dog"));
		System.out.println();
				
		bag.remove("dog");
		bag.remove("house");
		
		System.out.println("After removing a dog and a house...");
		CollectionTest.print(bag);
		System.out.println();
		
		System.out.println("Does it contain a house? " + bag.contains("house"));
		System.out.println("Does it contain a dog? " + bag.contains("dog"));
		System.out.println("How many dogs are in the bag? " + bag.count("dog"));
		System.out.println();
		
		bag.clear();
		System.out.println("After clearing the bag...");
		CollectionTest.print(bag);
	}

}

