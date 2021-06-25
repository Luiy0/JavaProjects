/*
 * MergeTest.java
 * This is a source file with a class that tests the merge method.
 */

package Tests;

public class MergeTest {

	// Serves as the entry point for the application.
	public static void main(String[] args) {
		int[] arr = {10, 12, 20, 27, 13, 15, 22, 25};
		int[] temp = new int[arr.length];
		
		System.out.println("This is arr:");
		displayArray(arr);
		System.out.println();
		
		int hi = arr.length - 1;
		int mid = hi / 2;  // correct only if lo == 0
		merge(arr, temp, 0, mid, hi);
		
		System.out.println("After merge, this is arr:");
		displayArray(arr);
	}
	
	// Displays the contents of an array.
	public static void displayArray(int[] arr) {
		for (int elem : arr)
			System.out.print(elem + " ");
		System.out.println();
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

}

