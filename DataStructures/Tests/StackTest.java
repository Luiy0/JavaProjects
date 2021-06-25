package Tests;
/*
 * StackTest.java
 * This source file contains a class that tests the Stack interface and
 * implementation.
 */



//import datastructures.ArrayStack;
import Structures.EmptyCollectionException;
import Structures.LinkedStack;
import Structures.Stack;

public class StackTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Stack<String> stk = new LinkedStack<>();
		
		System.out.println("After creating a new stack...");
		CollectionTest.print(stk);
		System.out.println();
		
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
		
		Stack<String> stk2 = new LinkedStack<>();
		
		System.out.println("After creating a new stack...");
		CollectionTest.print(stk2);
		System.out.println();
		
		stk2.push("cat");
		stk2.push("dog");
		stk2.push("tree");
		stk2.push("house");
		stk2.push("boat");
		stk2.push("woman");
		stk2.push("man");
		
		System.out.println("After adding some elements...");
		CollectionTest.print(stk2);
		System.out.println();
		
		System.out.println("Are the two stacks equal? "+ stk.equals(stk2));	
		
		
		System.out.println("\nThe top element is " + stk.top());
		System.out.println("Does it contains a man? " + stk.contains("man"));
		System.out.println();
		
		System.out.println("Traversing the stack...");
		for (String element : stk)
			System.out.println(element);
		System.out.println();
		
		System.out.println("Removing: " + stk.pop());
		System.out.println("Removing: " + stk.pop());
		
		System.out.println("After removing the top two elements...");
		CollectionTest.print(stk);
		System.out.println();
		
		System.out.println("The top element is " + stk.top());
		System.out.println("Does it contains a man? " + stk.contains("man"));
		System.out.println();
		
		stk.clear();
		System.out.println("After clearing the stack...");
		CollectionTest.print(stk);
		System.out.println();
		
		System.out.println("Trying to get the top element...");
		try {
			System.out.println("The top element is " + stk.top());
		}
		catch (EmptyCollectionException e) {
			System.out.println("Error: " + e.getMessage());
		}		
	}

}

