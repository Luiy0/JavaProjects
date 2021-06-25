/*
 * Queue.java
 * This source file contains an interface that describes a queue.
 */

package Structures;

public interface Queue<E> extends Collection<E> {
	
	// for circular queue:
	// rear.next = first.next
	
	// Adds the given element at the rear end of this queue.
	void enqueue(E element);
	
	// Removes and returns the element from the front end of this queue.
	E dequeue();
	
	// Returns the element at the front end of this queue.
	E front();
	
	// Returns the number of occurrences of the given element in this bag.
	int count(E element);

}

