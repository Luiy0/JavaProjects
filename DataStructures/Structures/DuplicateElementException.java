package Structures;

@SuppressWarnings("serial")
public class DuplicateElementException extends Exception {
		
		// Creates a new exception with the given message.
		public DuplicateElementException(String message) {
			super(message);
		}
		
		// Creates a new exception with the default message.
		public DuplicateElementException() {
			this("No repetitions allowed.");
		}
}
