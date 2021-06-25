/*
 * This is the LinkedBag Class which extends AbstractCollection and implements
 * the interface Bag. 
 * 
 * Luis A. Flores(841-10-2500)
 */

package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<E> extends AbstractCollection<E> implements Bag<E> {

	private Node<E> top = null;

	// Adds an element to the LinkedBag
	@Override
	public boolean add(E element) {
		top = new Node<E>(element, top);
		size++;
		return true;
	}

	// Removes and element from the LinkedBag
	@Override
	public boolean remove(E element){
		Node<E> list = top;  
		Node<E> next;  
		Node<E> next2;

		while(list != null){
			if(list.getNext().getData()== element){
				next = list.getNext(); 
				next2 = next.getNext(); 
				list.setNext(next2);
				return true;
			}
			else
				list = list.getNext();
		}
		return false;
	}

	// Counts the time an element repeats itself in the LinkedBag
	@Override
	public int count(E element) {
		int count=0;
		for(Node<E> curr = top; curr != null; curr=curr.getNext())
			if(element == curr.getData())		
				count++;
		return count;
	}

	// Returns true if the LinkedBag contains an element
	@Override
	public boolean contains(E element) {
		for(Node<E> current = top; current != null; current=current.getNext())
			if(element.equals(current.data))
				return true;
		return false;
	}

	// Tostring method showing the LinkedBag
	@Override
	public String toString() {
		String str = "[";
		if(top != null){
			str += top.getData();
			for(Node<E> curr = top; curr != null; curr=curr.getNext())
				str += ", " + curr.getData();
		}
		return str + "]";
	}

	public boolean equals(Object obj){ return false; }

	// Returns an iterator for this stack.
	@Override
	public Iterator<E> iterator() {
		return new LinkedBagIterator();
	}

	// Private class for the iterator of this stack
	private class LinkedBagIterator implements Iterator<E> {

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

}
