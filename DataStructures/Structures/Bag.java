/*
 * Bag.java
 * This source file contains an interface that describes a bag.
 */

package Structures;

public interface Bag<E> extends Collection<E> {
	
	// Adds the given element to this bag.
	// Returns true only if the element was added to this bag.
	
	boolean add(E element);
	// Removes the given element from this bag.
	// Returns true only if the element was removed from this bag.
	boolean remove(E element);
	
	// Returns the number of occurrences of the given element in this bag.
	int count(E element);
	
	

	

}

