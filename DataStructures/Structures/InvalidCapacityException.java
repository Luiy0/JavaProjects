/*
 * InvalidCapacityException.java
 * This is a source file with a class that represents the exception for 
 * an invalid capacity.
 */

package Structures;

@SuppressWarnings("serial")
public class InvalidCapacityException extends RuntimeException {
	
	// Creates a new exception with the given message.
	public InvalidCapacityException(String message) {
		super(message);
	}
	
	// Creates a new exception with the default message.
	public InvalidCapacityException() {
		this("capacity is invalid");
	}

}

