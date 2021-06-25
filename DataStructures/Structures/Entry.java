package Structures;

public class Entry<K,V> {
	
	private K key;
	private V value;
	
	public Entry(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey() { return this.key; }
	public V getValue() { return this.value; }
	public void setValue(V value) { this.value = value; }

	@SuppressWarnings("unchecked") // casting
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(!(obj instanceof Entry))
			return false;
		Entry<K,V> other = (Entry <K,V>) obj;
		return (this.key.equals(other.key));
	}
	
	@Override
	public String toString(){
		return key + "=>" + value;
	}
	
	
}
