package Structures;

public interface Map<K,V> extends Collection<Entry <K,V>> {
	
	// Returns the value associated with the given key.
	V get(K key);
	
	// Adds or modifies the values associated with the given key.
	void put(K key, V value);
	
	// Removes the value associated with a given key.
	V removeKey(K key);
	
	// Returns true if the map contains a given key.
	boolean containsKey(K key);
	

}
