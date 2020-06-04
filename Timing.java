//Name: Palmer Robins

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Example timing analysis for Sorting
 */
public class Timing {


  /**
   * Experiment class interface.
   */
  public interface Experiment {
    public void run(int n);
  }

  /**
   * Experiment for bubble sorting random integers
   * @param n Size of experiment
   */
  public static void bubbleSortRandom(int n) {
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; ++i)
      arr[i] = (int)(Math.random()*Integer.MAX_VALUE);
    Sort.bubbleSort(arr, (i1, i2) -> i1.compareTo(i2));
  }

  public static void bubbleSortOrdered(int n) {
  	Integer[] arr = new Integer[n];
  	for (int i = 0; i < n; ++i) {
  		arr[i] = i;
  	}
  	Sort.bubbleSort(arr, (i1, i2) -> i1.compareTo(i2));
  }

  public static void bubbleSortReversed(int n) {
  	Integer[] arr = new Integer[n];
  	int rev = 999999999;
  	for (int i = 0; i < n; ++i) {
  		arr[i] = rev;
  		rev--;
  	}
  	Sort.bubbleSort(arr, (i1, i2) -> i1.compareTo(i2));
  }

  public static void bubbleSortUnique(int n) {
  	Integer[] arr = new Integer[n];
  	Random rand = new Random();
  	for (int i = 0; i < n; ++i)
  		arr[i] = rand.nextInt(8 - 1 + 1) + 1;
  	Sort.bubbleSort(arr, (i1, i2) -> i1.compareTo(i2));
  }

  /**
   * Experiment for slow sorting random integers
   * @param n Size of experiment
   */
  public static void slowSortRandom(int n) {
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; ++i)
      arr[i] = (int)(Math.random()*Integer.MAX_VALUE);
    Sort.slowSort(arr, (i1, i2) -> i1.compareTo(i2));
  }

  public static void slowSortOrdered(int n) {
  	Integer[] arr = new Integer[n];
  	for (int i = 0; i < n; ++i) {
  		arr[i] = i;
  	}
  	Sort.slowSort(arr, (i1, i2) -> i1.compareTo(i2));
  }
 //This is doing selection sort
  public static void slowSortReversed(int n) {
  	Integer[] arr = new Integer[n];
  	int rev = 100;
  	for (int i = 0; i < n; ++i) {
  		arr[i] = rev;
  		rev--;
  	}
  	Sort.slowSort(arr, (i1, i2) -> i1.compareTo(i2));
  }
  //Selection Sort
  public static void slowSortUnique(int n) {
  	Integer[] arr = new Integer[n];
  	Random rand = new Random();
  	for (int i = 0; i < n; ++i)
  		arr[i] = rand.nextInt(8) + 1;
  	Sort.slowSort(arr, (i1, i2) -> i1.compareTo(i2));
  }

  /**
   * Experiment for sorting random integers
   * @param n Size of experiment
   */
  //Fast Sort here (heap sort)
  public static void sortRandom(int n) {
    Integer[] arr = new Integer[n];
    for(int i = 0; i < n; ++i)
      arr[i] = (int)(Math.random()*Integer.MAX_VALUE);
    Sort.sort(arr, (i1, i2) -> i1.compareTo(i2));
  }
  //Heap Sort
  public static void sortOrdered(int n) {
  	Integer[] arr = new Integer[n];
  	for (int i = 0; i < n; ++i) {
  		arr[i] = i;
  	}
  	Sort.sort(arr, (i1, i2) -> i1.compareTo(i2));
  }
  //Heap Sort
  public static void sortReversed(int n) {
  	Integer[] arr = new Integer[n];
  	int rev = 100;
  	for (int i = 0; i < n; ++i) {
  		arr[i] = rev;
  		rev--;
  	}
  	Sort.sort(arr, (i1, i2) -> i1.compareTo(i2));
  }
  //Heap Sort
  public static void sortUnique(int n) {
  	Integer[] arr = new Integer[n];
  	Random rand = new Random();
  	for (int i = 0; i < n; ++i)
  		arr[i] = rand.nextInt(8 - 1 + 1) + 1;
  	Sort.sort(arr, (i1, i2) -> i1.compareTo(i2));
  }

  /**
   * Time generic experiment
   * @param n Size of experiment
   * @param repeats Number of times to repeat experiment
   * @param e Function to time
   * @return Seconds taken for experiment
   */
  public static double TimeExperiment(int n, int repeats, Experiment e) {

    long start = System.nanoTime();

    for(int k = 0; k < repeats; ++k)
      e.run(n);

    long stop = System.nanoTime();
    double sec = (stop - start)/(double)1e9/repeats; //average elapsed time
    return sec;
  }

  /**
   * Run all timing functions and output to terminal and csv file
   * @param args Command-line arguments. Ignored here.
   * @throws FileNotFoundException Cannot open file.
   */
  public static void main(String[] args) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter("data_sorts.csv");
    System.out.printf("%10s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s %20s\n",
        "N", "Time Bubble Rand", "Time Bubble Ord.", "Time Bubble Rev.", "Time Bubble Uniq.",
          "Time Selection Rand", "Time Selection Ord.", "Time Selection Rev.", "Time Selection Uniq.", "Time Heap Rand",
            "Time Heap Ord.", "Time Heap Rev.", "Time Heap Uniq.");
    pw.println("N, Time Bubble Rand, Time Bubble Ord, Time Bubble Rev, Time Bubble Uniq,Time Slow Rand,Time Slow Ord, Time Slow Rev, Time Slow Uniq, Time Fast Rand,Time Fast Ord, Time Fast Rev,Time Fast Uniq");

    int N1 = (int)Math.pow(2, 14);
    int N3 = (int)Math.pow(2, 20);
    for(int n = 2; n <= N3; n*=2) {
      System.out.printf("%10s ", n);
      pw.print(n);

      double bsr = 0;
      if(n <= N1)
        bsr = TimeExperiment(n, Math.max(10, N1/n), m -> bubbleSortRandom(m));
      System.out.printf("%20e ", bsr);
      pw.print("," + bsr);

      double bso = 0;
      if(n <= N1)
        bso = TimeExperiment(n, Math.max(10, N1/n), m -> bubbleSortOrdered(m));
      System.out.printf("%20e ", bso);
      pw.print("," + bso);

      double bsrev = 0;
      if(n <= N1)
        bsrev = TimeExperiment(n, Math.max(10, N1/n), m -> bubbleSortReversed(m));
      System.out.printf("%20e ", bsrev);
      pw.print("," + bsrev);

      double bsu = 0;
      if(n <= N1)
        bsu = TimeExperiment(n, Math.max(10, N1/n), m -> bubbleSortUnique(m));
      System.out.printf("%20e ", bsu);
      pw.print("," + bsu);

      double ssr = 0;
      if(n <= N1)
        ssr = TimeExperiment(n, Math.max(10, N1/n), m -> slowSortRandom(m));
      System.out.printf("%20e ", ssr);
      pw.print("," + ssr);

      double sso = 0;
      if(n <= N1)
        sso = TimeExperiment(n, Math.max(10, N1/n), m -> slowSortOrdered(m));
      System.out.printf("%20e ", sso);
      pw.print("," + sso);

      double ssrev = 0;
      if(n <= N1)
        ssrev = TimeExperiment(n, Math.max(10, N1/n), m -> slowSortReversed(m));
      System.out.printf("%20e ", ssrev);
      pw.print("," + ssrev);

      double ssu = 0;
      if(n <= N1)
        ssu = TimeExperiment(n, Math.max(10, N1/n), m -> slowSortUnique(m));
      System.out.printf("%20e ", ssu);
      pw.print("," + ssu);

      double sr = 0;
      if(n <= N3)
        sr = TimeExperiment(n, Math.max(10, N3/n), m -> sortRandom(m));
      System.out.printf("%20e", sr);
      pw.print("," + sr);

      double so = 0;
      if(n <= N3)
        so = TimeExperiment(n, Math.max(10, N3/n), m -> sortOrdered(m));
      System.out.printf("%20e", so);
      pw.print("," + so);

      double srev = 0;
      if(n <= N3)
        srev = TimeExperiment(n, Math.max(10, N3/n), m -> sortReversed(m));
      System.out.printf("%20e", srev);
      pw.print("," + srev);

      double su = 0;
      if(n <= N3)
        su = TimeExperiment(n, Math.max(10, N3/n), m -> sortUnique(m));
      System.out.printf("%20e", su);
      pw.print("," + su);

      System.out.println();
      pw.println();
    }
    pw.flush();
    pw.close();
  }
}
