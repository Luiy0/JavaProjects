/*package datastructures;
import java.util.Iterator;

public class LinkedQueue<E> extends AbstractCollection<E> implements Queue<E> {
	private Node<E> front = null, rear = null;

	public E front(){
		if(isEmpty())
			throw new EmptyCollectionException("Queue is empty.");
		return front.data;
	}

	public Iterator<E> iterator(){
		return new Iterator<E>(){

			private Node<E> current = front;

			@Override
			public boolean hasNext(){
				return (current != null);			
			}		
			@Override
			public E next(){
				E element = current.data;
				current = current.next;
				return element;
			}	
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public void clear(){
		super.clear();
		front = rear = null;
	}

	@Override
	public void enqueue(E element) {
		Node<E> temp = new Node<>(element,null);
		if(isEmpty())
			front = rear = temp;
		else
			rear = (rear.next = temp);
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty())
			throw new EmptyCollectionException("Queue is empty");
		E element = front.data;
		size--;
		if(isEmpty())
			rear = null;		
		return element;
	}
	
	
	// Counts the time an element repeats itself in the LinkedBag
	@Override
	public int count(E element) {
		int count=0;
		for(Node<E> curr = front; curr != null; curr=curr.getNext())
			if(element == curr.getData())		
				count++;
		return count;
	}

	// Returns true if the LinkedBag contains an element
	@Override
	public boolean contains(E element) {
		for(Node<E> current = front; current != null; current=current.getNext())
			if(element.equals(current.data))
				return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
}

*/


/*
 * LinkedQueue.java
 * This source file contains a class that implements a queue using a
 * linked list.
 */

//
 
// Luis Angel Flores
package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> extends AbstractCollection<E> implements Queue<E> {

	// Fields for references to the front and rear nodes of this queue
	private Node<E> front = null, rear = null;

	// Removes all elements from this collection.
	@Override
	public void clear() {
		super.clear();
		front = rear = null;
	}

	// Adds the given element at the rear end of this queue.
	@Override
	public void enqueue(E element) {
		Node<E> node = new Node<>(element, null);
		if (isEmpty())
			front = rear = node;
		else
			rear = rear.next = node;
		size++;
	}

	// Removes and returns the element from the front end of this queue.
	@Override
	public E dequeue() {
		if (isEmpty())
			throw new EmptyCollectionException("queue is empty");
		E element = front.data;
		front = front.next;
		if (front == null)
			rear = null;
		size--;
		return element;
	}

	// Returns the element at the front end of this queue.
	@Override
	public E front() {
		if (isEmpty())
			throw new EmptyCollectionException("queue is empty");
		return front.data;
	}
	
	// Returns an iterator for this queue.
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			// Field for a reference to the current node in this iterator
			private Node<E> current = front;

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
	
		};
	}

	// Counts the time an element repeats itself in the LinkedBag
	@Override
	public int count(E element) {
		int count=0;
		for(Node<E> curr = front; curr != null; curr=curr.getNext())
			if(element == curr.getData())		
				count++;
		return count;
	}
	
	// Returns true if the LinkedBag contains an element
	@Override
	public boolean contains(E element) {
		for(Node<E> current = front; current != null; current=current.getNext())
			if(element.equals(current.data))
				return true;
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}

