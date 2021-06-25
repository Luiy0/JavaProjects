/* Assignment #2: DoublingTest.java 
 * Exercise #1 
 * Author: Robert Sedgewick
 * Course: COTI 4255 - Analysis of Algorithms
 * Modified by: Yadiel Cabrera (801-10-0880) and Luis Flores (841-10-2500) for COTI 4255 Course  
 * 
 * Description: 
 * 
 * This is a modified version for Doubling Test, using the requirements assigned by 
 * the professor. 
 *
 * 
 */
public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private DoublingTest() { }

    /**
     * Returns the amount of time to call <tt>Insertion.sort()</tt> with <em>N</em>
     * random 6-digit integers.
     * @param N the number of integers
     * @return amount of time (in seconds) to call <tt>Insertion.sort()</tt>
     *   with <em>N</em> random 6-digit integers
     */
    public static double timeTrial(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        Insertion.sort(a);
        return timer.elapsedTime();
    }


    public static void main(String[] args) { 
    	
    	int count = 1; 
    	Stopwatch timer = new Stopwatch();
        
    	//Create array and count time for each run, as specified for exercise #1 
        for (int N = 75000; true; N = 75000) {
            System.out.println("Time #" + count + " with: " + N +" elements."); 
            double time = timeTrial(N);
            StdOut.printf(" %5.1f\n", time);
            StdOut.println("Total elapsed time = " + timer.elapsedTime());
            count++; 
            System.out.println(" "); 
            if (count == 100)
            	break; 
        } 
    } 
} 

