/*
 * ArrayStack.java
 * This source file contains a class that implements a stack using an array.
 * 
 * Luis A. Flores(841-10-2500)
 */
package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> extends AbstractCollection<E> implements Stack<E> {

	// Field for the default capacity of this stack
	private static final int DEFAULT_CAPACITY = 10;

	// Field for the data of this stack
	private E[] data;

	// Creates a new stack with the given initial capacity.
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		if (capacity < 1)
			throw new InvalidCapacityException("capacity is less than one");
		data = (E[])new Object[capacity];
	}

	// Creates a new stack with the default initial capacity.
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	// Removes all elements from this collection.
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		super.clear();
		data = (E[])new Object[DEFAULT_CAPACITY];
	}

	// Adds the given element at the top of this stack.
	@Override
	public void push(E element) {
		if (size == data.length)
			doubleCapacity();
		data[size++] = element;
	}

	// Doubles the capacity for the data of this stack.
	@SuppressWarnings("unchecked")
	private void doubleCapacity() {
		E[] temp = (E[])new Object[data.length * 2];
		for (int current = 0; current < size; current++)
			temp[current] = data[current];
		data = temp;
	}

	// Removes and returns the element from the top of this stack.
	@Override
	public E pop() {
		if (isEmpty())
			throw new EmptyCollectionException("stack is empty");
		E element = data[--size];
		data[size] = null;
		return element;
	}

	// Returns the element at the top of this stack.
	@Override
	public E top() {
		if (isEmpty())
			throw new EmptyCollectionException("stack is empty");
		return data[size - 1];
	}

	// Returns an iterator for this stack.
	@Override
	public Iterator<E> iterator() {
		return new ArrayStackIterator();
	}

	// Private class for the iterator of this stack
	private class ArrayStackIterator implements Iterator<E> {

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
	
	// Equals method comparing two ArrayStacks
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ArrayStack))
			return false;
		ArrayStack<E> other = (ArrayStack<E>)obj;
		for(int x=0; x<data.length; x++)
			if(this.data[x] != other.data[x])
				return false;
		return true;				
	}

}

