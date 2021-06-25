/*
 * QueueTest.java
 * This source file contains a class that tests the Queue interface and
 * implementation.
 */

package Tests;


//import datastructures.CircularLinkedQueue;
import Structures.EmptyCollectionException;
import Structures.LinkedQueue;
import Structures.Queue;

public class QueueTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Queue<String> que = new LinkedQueue<>();

		System.out.println("After creating a new queue...");
		CollectionTest.print(que);
		System.out.println();

		que.enqueue("cat");
		que.enqueue("tree");
		que.enqueue("dog");
		que.enqueue("house");
		que.enqueue("boat");
		que.enqueue("woman");
		que.enqueue("man");
		que.enqueue("tree");

		System.out.println("After adding some elements...");
		CollectionTest.print(que);
		System.out.println();

		System.out.println("The front element is " + que.front());
		System.out.println("Does it contains a man? " + que.contains("man"));
		System.out.println("How many trees does it contain? " + que.count("tree"));
		System.out.println();

		System.out.println("Traversing the queue...");

		for (String element : que)
			System.out.println(element);
		System.out.println();

		System.out.println("Removing: " + que.dequeue());
		System.out.println("Removing: " + que.dequeue());

		System.out.println("After removing the first two elements...");
		CollectionTest.print(que);
		System.out.println();

		System.out.println("The front element is " + que.front());
		System.out.println("Does it contains a man? " + que.contains("man"));
		System.out.println("How many trees does it contain? " + que.count("tree"));

		System.out.println();

		que.clear();
		System.out.println("After clearing the queue...");
		CollectionTest.print(que);
		System.out.println();

		System.out.println("Trying to get the front element...");
		try {
			System.out.println("The front element is " + que.front());
		}
		catch (EmptyCollectionException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}

