/* Assignment #2: Insertion.java 
 * Exercise 1 and 3 
 * Author: Robert Sedgewick
 * Course: COTI 4255 - Analysis of Algorithms
 * Modified by: Yadiel Cabrera (801-10-0880) and Luis Flores (841-10-2500) for COTI 4255 Course  
 * 
 * Description: 
 * 
 * This is a modified version of the insertion sort provided by the author
 * that receives a array of 75,000 elements as input. 
 *
 
 */

public class Insertion {

    // This class should not be instantiated.
    private Insertion() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int [] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * Rearranges the subarray a[lo..hi] in ascending order, using the natural order.
     * @param a the array to be sorted
     * @param lo left endpoint
     * @param hi right endpoint
     */
    public static void sort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
        assert isSorted(a, lo, hi);
    }

    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]
    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param a the array
     * @return a permutation <tt>p[]</tt> such that <tt>a[p[0]]</tt>, <tt>a[p[1]]</tt>,
     *    ..., <tt>a[p[N-1]]</tt> are in ascending order
     */
    public static int[] indexSort(int[] a) {
        int N = a.length;
        int[] index = new int[N];
        for (int i = 0; i < N; i++)
            index[i] = i;

        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--)
                exch(index, j, j-1);

        return index;
    }

   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(int i, int j) {
        return i < j;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
 

   // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        int  [] anArray; 
        anArray = new int [75000];
        
        
        //Fill the array with 75000 random numbers 
        // unsorted array 
        for (int i = 0; i < 75000; i++) { 
        	anArray[i] = StdRandom.uniform(1000); 
        }
        
        Insertion.sort(anArray);
        
        Stopwatch timer = new Stopwatch();
        // Take sorted array as an input and start tracking time, used for exercise #3 
        for (int i = 0; i < 100; i++){ 
        	Insertion.sort(anArray);
    	    StdOut.println(timer.elapsedTime());
        }
        
        //show(anArray);
        //System.out.println(" "); 
       
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
