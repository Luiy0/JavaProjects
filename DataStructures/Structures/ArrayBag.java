/*
 * This is the ArrayBag Class which extends AbstractCollection and implements
 * the interface Bag. 
 * 
 * Luis A. Flores(841-10-2500)
 */

package Structures;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBag<E> extends AbstractCollection<E> implements Bag<E> {

	private E[] data ;
	private static final int DEFAULT_CAPACITY = 10;

	// Constructor method
	@SuppressWarnings("unchecked")
	public ArrayBag(int capacity) { data = (E[])new Object[capacity]; }

	public ArrayBag(){ this(DEFAULT_CAPACITY); }

	// Adds an element to the array
	@Override
	public boolean add(E element) {
		if (size == data.length)
			return false;
		data[size++] = element;
		return true;
	}

	// Removes an element from the array
	@Override
	public boolean remove(E element) {
		if (isEmpty())
			return false;
		int pos = linearSearch(element);
		if(pos == -1)
			return false;
		else{
			data[pos] = null;
			return true;
		}
	}

	// Search in the array for a given element
	public int linearSearch(E key) {
		for(int idx = 0; idx < data.length; idx++)
			if(key == data[idx])
				return idx;				
		return -1;
	}

	// Counts the times an element repeats itself
	@Override
	public int count(E element) {
		int count = 0;
		for (int current = 0; current < size; current++)
			if (element.equals(data[current]))
				count++;
		return count;
	}

	// Returns true if an element is contained in the array
	@Override
	public boolean contains(E element) {
		for (int current = 0; current < size; current++)
			if (element.equals(data[current]))
				return true;
		return false;
	}

	// To string method
	@Override
	public String toString() {
		String buffer = "[";
		if (! isEmpty()) {
			buffer += data[0];
			for (int current = 1; current < size; current++)
				buffer += ", " + data[current];
		}
		return buffer + "]";
	}

	public boolean equals(Object obj){ return false; }

	@Override
	public Iterator<E> iterator() {
		return new ArrayBagIterator();
	}

	// Private class for the iterator of this stack
	private class ArrayBagIterator implements Iterator<E> {

		// Field for the index of the current element in this iterator
		private int current = 0;

		// Returns true only if this iterator has another element.
		@Override
		public boolean hasNext() {
			return current < size;
		}

		// Returns the next element in this iterator.
		@Override
		public E next() {
			if (! hasNext())
				throw new NoSuchElementException();
			return data[current++];
		}

		// Unsupported: Removes the current element from this iterator.
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
