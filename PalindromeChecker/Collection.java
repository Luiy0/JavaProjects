package structure;
/*
 * Collection.java
 * This source file contains an interface that describes a collection.
 */

public interface Collection<E> extends Iterable<E> {
	
	// Removes all elements from this collection.
	void clear();

	// Returns the number of elements in this collection.
	int size();

	// Returns true only if this collection has no elements.
	boolean isEmpty();
	
	// Returns true only if this collection contains the given element.
	boolean contains(E element);
	
}

