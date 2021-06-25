/*
 * LinkedSearchingSortingTest.java
 * This source file contains a class to test the LinkedSearchingSorting class.
 */

package Tests;

import java.util.Scanner;

import Algorithms.LinkedSearchingSorting;
import Structures.Node;

public class LinkedSearchingSortingTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		Node<Integer> list = 
				new Node<>(40, 
						new Node<>(20, 
								new Node<>(50, 
										new Node<>(10, 
												new Node<>(30, null)))));
		System.out.println("This is the linked list: " + list);
		System.out.println();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a key to search: ");
		int key = kb.nextInt();
		System.out.println();
		kb.close();
		
		System.out.println("Using linear search, position=" + 
				LinkedSearchingSorting.linearSearch(list, key));
		System.out.println();
		
		list = LinkedSearchingSorting.insertionSort(list);
		
		System.out.println("After insertion sort...");
		System.out.println("This is the linked list: " + list);
	}

}

