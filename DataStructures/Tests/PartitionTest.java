/*
 * PartitionTest.java
 * This is a source file with a class that tests the partition method.
 */

package Tests;

public class PartitionTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		int[] arr = {15, 22, 13, 27, 12, 10, 20, 25};
		
		System.out.println("This is arr:");
		displayArraySlice(arr, 0, arr.length - 1);
		System.out.println();
		
		int pivotIdx = partition(arr, 0, arr.length - 1);
		
		System.out.println("After partition, this is arr:");
		displayArraySlice(arr, 0, arr.length - 1);
		System.out.println();
		
		System.out.println("The first partition is:");
		displayArraySlice(arr, 0, pivotIdx - 1);
		System.out.println();
		
		System.out.println("The pivot is " + arr[pivotIdx]);
		System.out.println();
		
		System.out.println("The second partition is:");
		displayArraySlice(arr, pivotIdx + 1, arr.length - 1);
		System.out.println();
	}

	// Displays the contents of an array.
	public static void displayArraySlice(int[] arr, int lo, int hi) {
		for (int idx = lo; idx <= hi; idx++)
			System.out.print(arr[idx] + " ");
		System.out.println();
	}

	// Partitions an array in two halves, one with the elements < pivot
	// and the other with elements >= pivot.
	private static int partition(int arr[], int lo, int hi)
	{
		int pivotIdx = lo;
		int pivot = arr[pivotIdx];
		for (int idx = lo + 1; idx <= hi; idx++)
			if (arr[idx] < pivot) {
				pivotIdx++;
				swap(arr, idx, pivotIdx);
			}
		if (lo != pivotIdx)
			swap(arr, lo, pivotIdx);
		return pivotIdx;
	}
	
	// Swaps the array elements at the given indexes.
	private static void swap(int arr[], int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}

