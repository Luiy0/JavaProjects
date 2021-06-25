/*
 * StackIteratorTest.java
 * This source file contains a class that tests iterators for the Stack 
 * interface and implementation.
 */

package Tests;

import java.util.Iterator;
import Structures.ArrayStack;
import Structures.Stack;

public class StackIteratorTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Stack<String> stk = new ArrayStack<>();
		
		stk.push("cat");
		stk.push("dog");
		stk.push("tree");
		stk.push("house");
		stk.push("boat");
		stk.push("woman");
		stk.push("man");
		
		System.out.println("After adding some elements...");
		CollectionTest.print(stk);
		System.out.println();
		
		System.out.println("Traversing the stack using an explicit iterator...");
		Iterator<String> it = stk.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println();
		
		System.out.println("Traversing the stack using the enhanced for...");
		for (String element : stk)
			System.out.println(element);
	}

}

