/*	Luis A. Flores (841-10-2500)
 *  February 8, 2016.
 *  FirstIndex.java 
 *  This program determines the index of the first occurrence of a given element in an array.
 */

package apps;

import java.util.Arrays;
import libraries.StdIn;
import libraries.StdOut;
import libraries.StdRandom;

public class FirstIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StdOut.print("Enter the number of elements in the sequence: ");
		int N = StdIn.readInt();		
		int[] sequence = new int[N];

		for(int x=0; x<N; x++)
			sequence[x] = StdRandom.uniform(20);

		StdOut.print("The random sequence is: ");
		for(int i=0; i<N; i++)
			StdOut.print(sequence[i] + " ");
		
		Arrays.sort(sequence);
		StdOut.print("\nThe sorted sequence is: ");
		for(int i=0; i<N; i++)
			StdOut.print(sequence[i] + " ");
		
		StdOut.print("\nEnter a key to search: ");
		int keySearch = StdIn.readInt();	

		int index = binarySearch(sequence, keySearch);				
		StdOut.println("The index of the first occurance is: " + index);	

	}//main
		
	public static int binarySearch(int input[], int element){
	    int lo=0, mid=0;
	    int high = input.length-1;
	    int result = -1;
	    while(lo <= high){
	        mid = (lo + high )/2;
	        if(element == input[mid] ){
	            result = mid;
	            high = mid-1;
	        }
	        else if(element < input[mid])
	            high = mid-1;
	        else
	        	lo = mid+1;
	    }
	    return result;
	}

}// class
