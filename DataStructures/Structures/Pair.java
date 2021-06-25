/*
 * Pair.java
 * This source file contains a class that represents a pair of elements of
 * the same type.
 */

package Structures;

public class Pair<T> {
	
	// Fields for the first and second elements in this pair
	private T first, second;

	// Creates a new pair with the given elements.
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	// Returns the first element in this pair.
	public T getFirst() {
		return first;
	}

	// Sets the first element in this pair to the given value.
	public void setFirst(T first) {
		this.first = first;
	}

	// Returns the second element in this pair.
	public T getSecond() {
		return second;
	}

	// Sets the second element in this pair to the given value.
	public void setSecond(T second) {
		this.second = second;
	}
	
	// Returns true only if this pair has the same elements as the other.
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (! (obj instanceof Pair))
			return false;
		Pair<T> other = (Pair<T>)obj;
		return this.first.equals(other.first) && this.second.equals(other.second);
	}

	// Returns a string representation of this pair.
	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}

}

