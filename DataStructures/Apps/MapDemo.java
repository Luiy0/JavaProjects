/*
 * JCF_MapDemo.java
 * This source file contains a class that demonstrates the Map interface
 * and the TreeMap class from the Java Collections Framework.
 */

package Apps;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<>();
		
		System.out.println("After creating a new map...");
		print(map);
		System.out.println();
		
		map.put("dog", "perro");
		map.put("cat", "gato");
		map.put("tree", "árbol");
		map.put("house", "casa");
		map.put("boat", "bote");
		map.put("woman", "mujer");
		map.put("man", "hombre");
		
		System.out.println("After adding some elements...");
		print(map);
		System.out.println();
				
		System.out.println("Does it contains house? " + map.containsKey("house"));
		System.out.println("The definition of house is " + map.get("house"));
		System.out.println();
		
		System.out.println("Traversing the map...");
		for (Map.Entry<String, String> element : map.entrySet())
			System.out.println("Key: " + element.getKey() + 
					"\tValue: " + element.getValue());
		System.out.println();
		
		map.put("boat", "barco");
		
		System.out.println("After changing the definition of boat...");
		System.out.println("The definition of boat is " + map.get("boat"));
		System.out.println();
		
		print(map);
		System.out.println();
		
		System.out.println("Removing: boat=>" + map.remove("boat"));
		System.out.println("Removing: house=>" + map.remove("house"));
		System.out.println("Removing: woman=>" + map.remove("woman"));
		
		System.out.println("After removing three elements...");
		print(map);
		System.out.println();
		
		System.out.println("Does it contains house? " + map.containsKey("house"));
		System.out.println("The definition of house is " + map.get("house"));
		System.out.println();
		
		map.clear();
		System.out.println("After clearing the map...");
		print(map);
		System.out.println();
		
		System.out.println("Trying to get the definition of boat...");
		String value = map.get("boat");
		if (value != null)
			System.out.println("boat is " + value);
		else
			System.out.println("Error: map does not contain boat");
	}
	
	// Prints the data, size and empty status of this map.
	public static <E> void print(Map<String, String> map) {
		System.out.println("This is the collection: " + map);
		System.out.println("Its size is " + map.size());
		System.out.println("Is it empty? " + map.isEmpty());
	}

}

