/*
 * RecursiveSorting.java
 * This is a source file with a class that contains recursive sorting 
 * methods.
 */

package Algorithms;

public class RecursiveSort {

	// Prevents instantiation of this class.
	private RecursiveSort() { }
	
	// Sorts an array using merge sort.
	public static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int[] temp, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergeSort(arr, temp, lo, mid);      // sort left half
			mergeSort(arr, temp, mid + 1, hi);  // sort right half
			merge(arr, temp, lo, mid, hi);      // merge both halves
		}
	}

	// Merges two sorted halves of an array using a temporary auxiliary array.
	// Precondition: arr[lo..mid] and arr[mid+1..hi] are sorted
	private static void merge(int[] arr, int[] temp, int lo, int mid, int hi) {
		int left = lo;
		int right = mid + 1;
		int idx = lo;
		while (left <= mid && right <= hi) {
			if (arr[left] < arr[right])
				temp[idx++] = arr[left++];
			else
				temp[idx++] = arr[right++];
		}
		while (left <= mid)
			temp[idx++] = arr[left++];
		while (right <= hi)
			temp[idx++] = arr[right++];
		
		for (idx = 0; idx <= hi; idx++)
			arr[idx] = temp[idx];
	}
	
	// Sorts an array using quick sort.
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int arr[], int lo, int hi) {
		if (lo < hi) {
			int pivotIdx = partition(arr, lo, hi);  // partition about pivot
			quickSort(arr, lo, pivotIdx - 1);       // sort first partition
			quickSort(arr, pivotIdx + 1, hi);       // sort second partition
		}
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

