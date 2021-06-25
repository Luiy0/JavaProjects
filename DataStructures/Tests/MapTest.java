/*
 * MapTest.java
 * This source file contains a class that tests the map interface and
 * implementations.
 */

package Tests;
import Structures.*;

public class MapTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Map<String, String> map = new LinkedMap<>();
		
		System.out.println("After creating a new map...");
		CollectionTest.print(map);
		System.out.println();
		
		map.put("dog", "perro");
		map.put("cat", "gato");
		map.put("tree", "árbol");
		map.put("house", "casa");
		map.put("boat", "bote");
		map.put("woman", "mujer");
		map.put("man", "hombre");
		
		System.out.println("After adding some elements...");
		CollectionTest.print(map);
		System.out.println();
				
		System.out.println("Does it contains house? " + map.containsKey("house"));
		System.out.println("The definition of house is " + map.get("house"));
		System.out.println();
		
		System.out.println("Traversing the map...");
		for (Entry<String, String> element : map)
			System.out.println("Key: " + element.getKey() + 
					"\tValue: " + element.getValue());
		System.out.println();

		Entry<String, String> entry = new Entry<>("house", "casa");
		System.out.println("Does it contains house defined as casa? " + map.contains(entry));
		System.out.println();
		
		map.put("boat", "barco");
		
		System.out.println("After changing the definition of boat...");
		System.out.println("The definition of boat is " + map.get("boat"));
		System.out.println();
		
		CollectionTest.print(map);
		System.out.println();
		
		System.out.println("Removing: boat=>" + map.removeKey("boat"));
		System.out.println("Removing: house=>" + map.removeKey("house"));
		System.out.println("Removing: woman=>" + map.removeKey("woman"));
		
		System.out.println("After removing three elements...");
		CollectionTest.print(map);
		System.out.println();
		
		System.out.println("Does it contains house? " + map.containsKey("house"));
		System.out.println("The definition of house is " + map.get("house"));
		System.out.println();
		
		map.clear();
		System.out.println("After clearing the map...");
		CollectionTest.print(map);
		System.out.println();
		
		System.out.println("Trying to get the definition of boat...");
		String value = map.get("boat");
		if (value != null)
			System.out.println("boat is " + value);
		else
			System.out.println("Error: map does not contain boat");
	}

}

