package structure;
/*
 * EmptyCollectionException.java
 * This is a source file with a class that represents the exception for 
 * empty collections.
 */



@SuppressWarnings("serial")
public class EmptyCollectionException extends RuntimeException {
	
	// Creates a new exception with the given message.
	public EmptyCollectionException(String message) {
		super(message);
	}
	
	// Creates a new exception with the default message.
	public EmptyCollectionException() {
		this("collection is empty");
	}

}

