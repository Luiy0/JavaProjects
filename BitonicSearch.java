/*	Luis A. Flores (841-10-2500)
 *  February 9, 2016.
 *  BitonicSearch.java 
 *  Generates a random bitonic array and determines whether a given integer is in the array.
 */

package apps;
import libraries.StdIn;
import libraries.StdOut;
import libraries.StdRandom;

public class BitonicSearch {
	
	public static void main(String[] args) {

    	StdOut.print("Enter the size of the bitonic array: ");
    	int N = StdIn.readInt();
    	int[] a = bitonic(N);
    	
    	StdOut.print("\nEnter a key to search: ");
    	int value = StdIn.readInt();
        bitonic_search(a, 0, N, value);
       
    }

    // create a bitonic array of size N
    public static int[] bitonic(int N) {
        int mid = StdRandom.uniform(N);
        int[] a = new int[N];
        for (int i = 1; i < mid; i++) 
            a[i] = a[i-1] + 1 + StdRandom.uniform(9);

        if (mid > 0) a[mid] = a[mid-1] + StdRandom.uniform(10) - 5;

        for (int i = mid + 1; i < N; i++)
            a[i] = a[i-1] - 1 - StdRandom.uniform(9);

        StdOut.print("The bitonic array is: ");
        for (int i = 0; i < N; i++) 
            StdOut.print(a[i] + " ");
        
        return a;
    } 
    
    // Descending implementation of the binary search algorithm
    public static void descending_binary_search(int[] array, int left, int right, int value){
      if (left == right) {
        return;
      }

      int mid = (right+left)/2;
      if (array[mid] == value) {
        StdOut.println("Value found.");
        return;
      }

      if (left+1 == right) {
    	StdOut.println("value not found (descending Bsearch)");
        return;
      }

      if (value < array[mid]) {
        descending_binary_search(array, mid+1, right, value);
      }
      else {
        descending_binary_search(array, left, mid, value);
      }
    }
    
    // Ascending implementation of the binary search algorithm
    public static void ascending_binary_search(int[] array, int left, int right, int value){
      if (left == right) {
        return;
      }

      int mid = (right+left)/2;
      if (array[mid] == value) {
        StdOut.println("value found");;
        return;
      }

      if (left+1 == right) {
    	StdOut.println("value not found (ascending Bsearch)");
        return;
      }

      if (value > array[mid]) {
        ascending_binary_search(array, mid+1, right, value);
      }
      else {
        ascending_binary_search(array, left, mid, value);
      }
    }
    
    // Bitonic search algorithm
    public static void bitonic_search(int[] array, int left, int right, int value){
      if (left == right) {
    	
        return;
      }

      int mid = (right+left)/2;
      if (array[mid] == value) {
        StdOut.println("value found");
        return;
      }

      if (left+1 == right) {
        return;
      }

      if(array[mid] > array[mid-1]) {
        if (value > array[mid]){
          bitonic_search(array, mid+1, right, value);
        }
        else {
          ascending_binary_search(array, left, mid, value);
          descending_binary_search(array, mid+1, right, value);
        }
      }

      else {
        if (value > array[mid]) {
          bitonic_search(array, left, mid, value);
        }
        else {
          ascending_binary_search(array, left, mid, value);
          descending_binary_search(array, mid+1, right, value);
        }
      }
    }
    
}// class

