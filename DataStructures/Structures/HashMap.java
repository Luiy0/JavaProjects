/*
 * HashMap.java
 * This source file contains a class that implements a map using a 
 * hash table.  Collisions are resolved by separate chaining.
 */

package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K extends Comparable<K>, V> 
		extends AbstractCollection<Entry<K, V>> 
		implements Map<K, V> {

	// Field for the default capacity of this map
	private static final int DEFAULT_CAPACITY = 19;
	
	// Field for the data of this map
	private LinkedMap<K, V>[] data;

	// Creates a new map with the given initial capacity.
	@SuppressWarnings("unchecked")
	public HashMap(int initialCapacity) {
		if (initialCapacity < 1)
			throw new InvalidCapacityException("capacity is less than one");
		data = (LinkedMap<K, V>[])new LinkedMap[initialCapacity];
		for (int bucket = 0; bucket < data.length; bucket++)
			data[bucket] = new LinkedMap<K, V>();

	}

	// Creates a new map with the default initial capacity.
	public HashMap() {
		this(DEFAULT_CAPACITY);
	}

	// Removes all elements from this collection.
	@Override
	public void clear() {
		super.clear();
		for (int bucket = 0; bucket < data.length; bucket++)
			data[bucket].clear();
	}
	
	// Returns the value associated with the given key.
	@Override
	public V get(K key) {
		int bucket = findBucket(key);
		return data[bucket].get(key);
	}

	// Returns the corresponding bucket for a given key.
	private int findBucket(K key) {
		return key.hashCode() % data.length;
	}

	// Adds or modifies the value associated with the given key.
	@Override
	public void put(K key, V value) {
		if ((double)size / data.length > 0.75)  // Load > 75%
			doubleCapacity();

		int bucket = findBucket(key);
		//System.out.println("key = " + key + ", bucket = " + bucket);
		if (! data[bucket].containsKey(key))
			size++;
		data[bucket].put(key, value);
	}

	// Doubles the capacity for the data of this map.
	private void doubleCapacity() {
		HashMap<K, V> temp = new HashMap<>(2 * data.length);
		for (int bucket = 0; bucket < data.length; bucket++)
			for (Entry<K, V> element : data[bucket])
				temp.put(element.getKey(), element.getValue());
		this.data = temp.data;
	}

	// Removes and returns the value associated with the given key.
	@Override
	public V removeKey(K key) {
		int bucket = findBucket(key);
		V value = data[bucket].get(key);
		if (data[bucket].containsKey(key)) {
			data[bucket].removeKey(key);
			size--;
		} 
		return value;
	}

	// Returns true if the map contains the given key.
	@Override
	public boolean containsKey(K key) {
		return get(key) != null;
	}

	// Returns an iterator for this map.
	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new HashMapIterator();
	}

	// Iterator private class
	private class HashMapIterator implements Iterator<Entry<K, V>> {

		// Reference to a queue with the contents of the hash table
		private Queue<Entry<K, V>> contents = new LinkedQueue<>();

		// Creates a new iterator by visiting each bucket and its chain.
		public HashMapIterator() {
			for (int bucket = 0; bucket < data.length; bucket++)
				for (Entry<K, V> element : data[bucket])
					contents.enqueue(element);
		}

		// Returns true only if this iterator has another element.
		@Override
		public boolean hasNext() {
			return !contents.isEmpty();
		}

		// Returns the next element in this iterator.
		@Override
		public Entry<K, V> next() {
			if (! hasNext())
				throw new NoSuchElementException();
			return contents.dequeue();
		}

		// Unsupported: Removes the current element from this iterator.
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}

