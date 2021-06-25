/*
 * LinkedStack.java
 * This source file contains a class that implements a stack using a linked
 * structure.
 * 
 * Luis A. Flores(841-10-2500)
 */

package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> extends AbstractCollection<E> implements Stack<E> {

	// Field for the node with the top element of this stack
	private Node<E> top = null;

	// Removes all elements from this collection.
	@Override
	public void clear() {
		super.clear();
		top = null;
	}
		
	// Adds the given element at the top of this stack.
	@Override
	public void push(E element) {
		top = new Node<E>(element, top);
		size++;
	}

	// Removes and returns the element from the top of this stack.
	@Override
	public E pop() {
		if (isEmpty())
			throw new EmptyCollectionException("stack is empty");
		E element = top.data;
		top = top.next;
		size--;
		return element;
	}

	// Returns the element at the top of this stack.
	@Override
	public E top() {
		if (isEmpty())
			throw new EmptyCollectionException("stack is empty");
		return top.data;
	}

	// Returns an iterator for this stack.
	@Override
	public Iterator<E> iterator() {
		return new LinkedStackIterator();
	}

	// Private class for the iterator of this stack
	private class LinkedStackIterator implements Iterator<E> {

		// Field for the node with the current element in this iterator
		private Node<E> current = top;

		// Returns true only if this iterator has another element.
		@Override
		public boolean hasNext() {
			return current != null;
		}

		// Returns the next element in this iterator.
		@Override
		public E next() {
			if (! hasNext())
				throw new NoSuchElementException();
			E element = current.data;
			current = current.next;
			return element;
		}

		// Unsupported: Removes the current element from this iterator.
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
	
	// Equals method comparing two LinkedStacks
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LinkedStack))
			return false;
		LinkedStack<E> other = (LinkedStack<E>)obj;
		for(Node<E> curr = top; curr != null; curr=curr.getNext())
			if(this.top.getData() != other.top.getData())
				return false;
		return true;
	}

}

