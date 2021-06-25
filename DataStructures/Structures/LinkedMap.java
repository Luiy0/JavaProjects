/*
 * LinkedMap.java
 * This source file contains a class that implements a map using a linked list.
 */

package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedMap<K extends Comparable<K>, V> 
		extends AbstractCollection<Entry<K, V>> 
		implements Map<K, V> {

	// Field for the head node of this map
	private Node<Entry<K, V>> head = null;

	// Removes all elements from this collection.
	@Override
	public void clear() {
		super.clear();
		head = null;
	}

	// Returns the value associated with the given key.
	@Override
	public V get(K key) {
		for (Node<Entry<K, V>> current = head; current != null; current = current.next)
			if (key.equals(current.data.getKey()))
				return current.data.getValue();
		return null;
	}

	// Adds or modifies the value associated with the given key.
	@Override
	public void put(K key, V value) {
		Node<Entry<K, V>> previous = null, current = head;
		
		while (current != null && key.compareTo(current.data.getKey()) > 0) {
			previous = current;
			current = current.next;
		}
		
		if (current != null && key.equals(current.data.getKey())) {
			current.data.setValue(value);
			return;
		}
		Node<Entry<K, V>> node = new Node<>(new Entry<>(key, value), current);
		if (current == head)     // adding first element
			head = node;
		else                      // adding inner or last element
			previous.next = node;
		size++;
	}

	// Removes and returns the value associated with the given key.
	@Override
	public V removeKey(K key) {
		Node<Entry<K, V>> previous = null, current = head;
		
		while (current != null && key.compareTo(current.data.getKey()) > 0) {
			previous = current;
			current = current.next;
		}
		if (current != null && key.equals(current.data.getKey())) {
			V value = current.data.getValue();
			if (current == head)      // removing first element
				head = current.next;
			else                       // removing inner or last element
				previous.next = current.next;
			size--;
			return value;
		}
		return null;
	}

	// Returns true if the map contains the given key.
	@Override
	public boolean containsKey(K key) {
		return get(key) != null;
	}

	// Returns an iterator for this map.
	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new Iterator<Entry<K, V>>() {

			// Field for the current node in this iterator
			private Node<Entry<K, V>> current = head;

			// Returns true only if this iterator has another element.
			@Override
			public boolean hasNext() {
				return current != null;
			}

			// Returns the next element in this iterator.
			@Override
			public Entry<K, V> next() {
				if (! hasNext())
					throw new NoSuchElementException();
				Entry<K, V> element = current.data;
				current = current.next;
				return element;
			}

			// Unsupported: Removes the current element from this iterator.
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};

	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}

