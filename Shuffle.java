
import java.util.Arrays;

/* Assignment #2: Shuffle.java 
 * Exercise #2 
 * Course: COTI 4255 - Analysis of Algorithms
 * Authors: Yadiel Cabrera (Student #: 801-10-0880)and Luis Flores (841- for COTI 4255 Course  
 * 
 * 
 * Description: 
 * 
 * This is a class that includes a static method hat accepts the array as input and
 * shuffle N/200 elements from the array. It exchanges the elements in a random fashion.  
 *
 * 
 */
public class Shuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating the array of N elements
		StdOut.print("Enter the number of elements in the array: ");
		int N = StdIn.readInt();		
		int[] inputArr = new int[N];
		
		int count = 0; 
		// Adding random elements values to the array
		for(int x=0; x<N; x++) {
			count++; 
			inputArr[x] = StdRandom.uniform(500);
		}

		// Sorting and printing the array
		Arrays.sort(inputArr);
		StdOut.println("The generated sorted array is: ");
		for(int i=0; i<N; i++)    
			StdOut.print(inputArr[i] + " ");
		System.out.println( );
		System.out.println("Number of elements in array is:" + count);
		
		
		// Calculate the number of exchanges, shuffle the array, and print it.
		int exchanges = N/200;
		StdOut.print("\nWith " + exchanges + " random exchanges the shuffled array is:");
		inputArr = shuffleAlg(inputArr, exchanges);
		StdOut.println();
		for(int i=0; i<N; i++)
			StdOut.print(inputArr[i] + " ");	
		
		// Display elapsed time of insertion sort using partially sorted array.
		StdOut.println();
		StdOut.print("The squared elapsed time of insertion sort is: ");
		StdOut.printf("%.15f\n",Math.pow(timeTrial(inputArr),3));

	}// main

	// Shuffle algorithm
	public static int[] shuffleAlg(int []a, int exchanges){			
		for(int x=0; x<exchanges; x++){		
			int i = StdRandom.uniform(a.length);
			int j = StdRandom.uniform(a.length);	

			int swap = a[i];
			a[i] = a[j];
			a[j] = swap;
		}		
		return a;	
	}// shuffle
	
	// Method for calculating the time of insertion sort
	public static double timeTrial(int[] arr){
		Stopwatch timer = new Stopwatch();
		Insertion.sort(arr);
		return timer.elapsedTime();		
	}//Timetrial	
	
}// class
