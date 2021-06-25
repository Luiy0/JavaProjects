//package datastructures;
//
//public interface Stack<E> extends Collection<E>{
//
//	void push(E element);
//	E pop();
//	E top();
//}
//


/*
 * Stack.java
 * This source file contains an interface that describes a stack.
 */

package Structures;

public interface Stack<E> extends Collection<E> {
	
	// Adds the given element at the top of this stack.
	void push(E element);
	
	// Removes and returns the element from the top of this stack.
	E pop();
	
	// Returns the element at the top of this stack.
	E top();

}

