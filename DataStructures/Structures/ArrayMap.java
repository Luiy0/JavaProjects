package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Esta implementacion no permite duplicados.

public class ArrayMap<K extends Comparable<K>,V> extends AbstractCollection<Entry <K,V>> implements Map<K,V> {

	private static final int DEFAULT_CAPACITY =  10;
	private Entry<K,V>[] data;

	@SuppressWarnings("unchecked")
	public ArrayMap(int initialCapacity){
		data = (Entry<K,V>[]) new Entry[initialCapacity];
	}

	public ArrayMap(){	this(DEFAULT_CAPACITY);	}

	@Override
	public V get(K key){
		int index = indexOf(key);		
		if(index >= 0)
			return data[index].getValue();
		return null;
	}

	private int indexOf(K key){
		int first = 0;
		int last = size - 1;

		while(first <= last){
			int middle = (first + last)/2;
			// devuelve -1 si el key es mas peque~o que lo que esta en el middle
			int comparison = key.compareTo(data[middle].getKey()); // extends comparable

			if(comparison < 0)
				last = middle - 1;
			else if(comparison > 0)
				first = middle + 1;
			else
				return middle;
		}	
		// no existe pero devuelve donde se va a insertar(rehusar codigo)
		return -(first + 1); // not found, return -(insertion point + 1)
	}

	@Override
	public void put(K key, V value){
		int index = indexOf(key);		
		if(index >= 0) // si lo encontro se escribe encima el value.
			data[index].setValue(value);
		else{
			if(size == data.length)
				doubleCapacity();
			index = -index - 1; // adjust index to find insertion point
			for(int destIndex = size; destIndex > index; destIndex--) // va desde el ultimo
				data[destIndex] = data[destIndex-1];
			data[index] = new Entry<>(key,value);
			size++; // size es cuantos elementos hay			

		}
	}

	@SuppressWarnings("unchecked")
	private void doubleCapacity(){
		Entry<K,V>[] temp = (Entry <K,V>[]) new Entry[data.length*2];
		for(int curr = 0; curr < size; curr++)
			temp[curr] = data[curr];
		data = temp;
	}

	@Override
	public boolean containsKey(K key){
		return get(key) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear(){
		super.clear();
		data = (Entry<K,V>[]) new Entry[DEFAULT_CAPACITY];
		// clear pone size en 0 y el data es uno nuevo
	}

	public V removeKey(K key){
		int index = indexOf(key);
		if(index >= 0){
			V result = data[index].getValue();
			size--;
			for(int destIndex = index; destIndex < size; destIndex++)
				data[destIndex] = data[destIndex+1];
			data[size] = null;
			return result;
		}
		else
			return null;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new Iterator<Entry<K, V>>() {

			// Field for the index of the current element in this iterator
			private int current = 0;

			// Returns true only if this iterator has another element.
			@Override
			public boolean hasNext() {
				return current < size;
			}

			// Returns the next element in this iterator.
			@Override
			public Entry<K, V> next() {
				if (! hasNext())
					throw new NoSuchElementException();
				return data[current++];
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

