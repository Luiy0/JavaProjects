/*
 * NodeTest.java
 * This source file contains a class to test the Node<T> class.
 */

package Tests;

import java.util.Scanner;
import Structures.Node;

public class NodeTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		Node<Integer> list = 
				new Node<>(10, 
						new Node<>(20, 
								new Node<>(30, 
										new Node<>(40, 
												new Node<>(50, null)))));
				
		System.out.println("This is the linked list: " + list);
		System.out.println();
		
		System.out.println("This the data of the first node: " + 
				list.getData());
		System.out.println("This the data of the second node: " + 
				list.getNext().getData());
		System.out.println("This the data of the third node: " + 
				list.getNext().getNext().getData());
		System.out.println();
		
		System.out.println("Traversing the list...");
		for (Node<Integer> curr = list; curr != null; curr = curr.getNext())
			System.out.println(curr.getData());
		System.out.println();
		
		Node<Integer> first = new Node<>(5, list);
		list = first;
		
		System.out.println("After prepending a new node...");
		System.out.println("This is the list: " + list);
		System.out.println();
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a new integer for the first node: ");
		first.setData(kb.nextInt());
		System.out.println("Data set to " + first.getData());
		System.out.println();
		kb.close();
		
		System.out.println("After changing the data of the first node...");
		System.out.println("This is the list: " + list);
		System.out.println();
		
		Node<Integer> second = first.getNext();
		second.setNext(null);
		
		System.out.println("After setting the succesor of the second node to null...");
		System.out.println("This is the list: " + list);
	}

}

