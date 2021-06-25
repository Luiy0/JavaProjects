package Tests;
/*
 * Luis A Flores(841-102500)
 * This application tests characters binary search tree.
 * 
 */

import java.io.*;
//import java.util.*;
import Structures.*;

public class CharacterTreeTest {

	// This method is the application's entry point.
	public static void main(String[] args) throws DuplicateElementException {
		CharacterTree<Character> tree = new CharacterTree<Character>();

		if (tree.isEmpty())
			System.out.println("The tree is empty.");
		else
			System.out.println("The tree is not empty.");

		tree.add('m');
		tree.add('h');
		tree.add('f');
		tree.add('a');
		tree.add('q');
		tree.add('w');
		tree.add('t');
		tree.add('d');

		System.out.println("After adding some elements, the tree is " + tree);
		System.out.println("The tree size is " + tree.size());
		System.out.println("The minimum element is '" + tree.minimum() + "'");
		System.out.println("The maximum element is '" + tree.maximum() + "'");
		System.out.println();

		if (tree.contains('a')) {
			System.out.println("The tree contains 'a'.");
			System.out.println("Its level is " + tree.level('a'));
		}
		else
			System.out.println("The tree does not contain 'a'.");

		File treeFile = new File("tree.txt");
		try {
			PrintWriter fileWriter = new PrintWriter(treeFile);
			tree.save(fileWriter);
			fileWriter.close();
			System.out.println("The data of the tree has been saved.");
		}
		catch (IOException ex) {
			System.out.println("The tree.txt file could not be written.");
		}
		System.out.println();

		tree.clear();
		System.out.println("After clearing the tree...");
		if (tree.isEmpty())
			System.out.println("Now, the tree is empty.");
		else
			System.out.println("The tree is not empty.");
		System.out.println("The tree size is " + tree.size());


		//		try {
		//			Scanner fileReader = new Scanner(treeFile);
		//			tree.load(fileReader);
		//			fileReader.close();
		//			System.out.println("The data of the tree has been loaded.");
		//		}
		//		catch (IOException ex) {
		//			System.out.println("The tree.txt file could not be read.");
		//		}
		//		System.out.println();
		//
		//		System.out.println("After loading the data, the tree is " + tree);
		//		System.out.println("The tree size is " + tree.size());
		//		System.out.println();
	}

}

