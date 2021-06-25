/*
 * AddressBookManager.java
 * This class is an application that manages an address book using a map.
 */

package Apps;

import java.util.Scanner;
import Structures.*;

public class AddressBookManager {
	
	// Field for the managed address book
	private Map<String, Contact> addressBook = new TreeMap<>();
	
	// Field for a scanner to the keyboard
	private Scanner kb = new Scanner(System.in);
	
	// Field for the menu selection
	private int selection = 0;
	
	// Adds a new contact to the address book.
	private void processAdd() {
		kb.nextLine();
		System.out.print("Enter name: ");
		String name = kb.nextLine();
		System.out.print("Enter phone: ");
		String phone = kb.next();
		System.out.print("Enter email: ");
		String email = kb.next();
		
		addressBook.put(name, new Contact(name, phone, email));
		System.out.println("A contact has been added.");
	}

	// Removes a contact from the address book.
	private void processRemove() {
		kb.nextLine();
		System.out.print("Enter name: ");
		String name = kb.nextLine();
		
		addressBook.removeKey(name);
		System.out.println("A contact has been removed.");
	}

	// Lists the contacts in the address book.
	private void processView() {
		System.out.println("This is the adress book:");
		System.out.println();
		
		for (Entry<String, Contact> entry: addressBook) {
			System.out.println("Name: " + entry.getValue().getName());
			System.out.println("Phone: " + entry.getValue().getPhone());
			System.out.println("Email: " + entry.getValue().getEmail());
			System.out.println();
		}
		System.out.println("There are " + addressBook.size() + " contacts.");
	}
		
	// Displays and processes the menu.
	private void run() {
		do {
			System.out.print(
					"1. Add an entry\n" +
					"2. Remove an entry\n" +
					"3. View entries\n" +
					"0. Exit\n\n" +
					"Enter your selection: ");
			selection = kb.nextInt();
			System.out.println();
			
			switch (selection) {
				case 1:
					processAdd(); break;
				case 2:
					processRemove(); break;
				case 3:
					processView(); break;
				case 0:
					System.out.println("Thanks for using this program."); break;
				default:
					System.out.println("Error! Invalid selection. Try again...");
			}
			System.out.println();
		} while (selection != 0);
		kb.close();
	}

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		new AddressBookManager().run();
	}
	
}

