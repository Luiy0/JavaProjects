package structure;
/*
 * AbstractCollection.java
 * This source file contains an abstract class that define some methods
 * in a collection. 
 */

import java.util.Iterator;
public abstract class AbstractCollection<E> implements Collection<E> {
	
	// Protected field for the number of elements in this collection
	protected int size = 0;

	// Removes all elements from this collection.
	@Override
	public void clear() {
		size = 0;
	}
		
	// Returns the number of elements in this collection.
	@Override
	public int size() {
		return size;
	}

	// Returns true only if this collection has no elements.
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns true only if this collection contains the given element.
	@Override
	public boolean contains(E element) {
		for (E currentElement : this)
			if (element.equals(currentElement))
				return true;
		return false;  // not found
	}
	
	// Returns a string representation for this collection.
	@Override
	public String toString() {
		String result = "[";
		Iterator<E> iter = this.iterator();
		
		if (iter.hasNext()) {
			result += iter.next();
			while (iter.hasNext())
				result += ", " + iter.next();
		}
		return result + "]";
	}
	
	// Returns an iterator for this collection.
	@Override
	public abstract Iterator<E> iterator();
	
	public abstract boolean equals(Object obj);
	
}

