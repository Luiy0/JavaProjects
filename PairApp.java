/*	Luis A. Flores (841-10-2500)
 *  February 6, 2016.
 *  Pairs.java 
 *  This program determines the number of pairs that are equal from a sequence of integers.
 */

package apps;

import java.util.Arrays;
import libraries.StdIn;
import libraries.StdOut;
import libraries.StdRandom;

public class PairApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating an array of N integers
		StdOut.print("Enter the number of elements in the sequence: ");
		int N = StdIn.readInt();		
		int[] sequence = new int[N];

		for(int x=0; x<N; x++)
			sequence[x] = StdRandom.uniform(50);

		StdOut.print("The random sequence is: ");
		for(int i=0; i<N; i++)
			StdOut.print(sequence[i] + " ");

		int count = 0, i;
		Arrays.sort(sequence);
		for(i=0; i < N-1; i++)
			if(binarySearch(sequence, i+1, N-1, sequence[i]) != -1)
				count++;	
		StdOut.print("\nThe number of pairs is: " + count);	

	}// main

	public static int binarySearch(int arr[], int low, int high, int x)
	{
	    if (high >= low)
	    {
	        int mid = low + (high - low)/2;
	        if (x == arr[mid])
	            return mid;
	        if (x > arr[mid])
	            return binarySearch(arr, (mid + 1), high, x);
	        else
	            return binarySearch(arr, low, (mid -1), x);
	    }
	    return -1;
	}

}// class
