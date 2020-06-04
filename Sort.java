//Name: Palmer Robins

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Set of sorting algorithms.
 */
public class Sort {

  /**
   * Swap two elements in an array
   *
   * @param <T> Type of array
   * @param arr Array
   * @param i Index of first element
   * @param j Index of second element
   */
  public static <T> void swap(T[] arr, int i, int j) {
    T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  /**
   * Bubble sort array into ordering defined by the input comparator.
   *
   * Must be an inplace implementation.
   *
   * @param <T> Type of array
   * @param arr Array
   * @param c Comparator for elements of array.
   */
  public static <T> void bubbleSort(T[] arr, Comparator<T> c) {
    //TODO Implement bubble sort
    for (int i = 0; i < arr.length - 1; ++i) {
      for (int j = 0; j < arr.length - 1; ++j) {
        if (c.compare(arr[j], arr[j + 1]) > 0)
          swap(arr, j, j + 1);
      }
    }
  }

  public static <T> void selectionSort(T[] arr, Comparator<T> c) {
    //TODO Implement either selection sort or insertion sort
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
    	int min = i;
    	for (int j = i + 1; j < n; j++) 
    		if (c.compare(arr[j], arr[min]) < 0) 
    			min = j;
    	swap(arr, min, i);    
    }
  }

  /**
   * Insertion sort array into ordering defined by the input comparator.
   *
   * Must be an inplace implementation.
   *
   * @param <T> Type of array
   * @param arr Array
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  public static <T> void insertionSort(T[] arr, Comparator<T> c) {
    //TODO Implement either selection sort or insertion sort
  	for (int i = 1; i < arr.length; i++) {
  		for (int j = i; j > 0; j--) {
  			if (c.compare(arr[j], arr[j - 1]) < 0) {
  				swap(arr, j - 1, j);
  			}
  		}
  	}
  }

  /**
   * Sort array into ordering defined by the input comparator using an
   *        algorithm with quadratic time complexity.
   *
   * Simply make this function call the slow sorting algorithm you implemented.
   * One of:
   *  (a) selection sort,
   *  (b) insertion sort
   *
   * @param <T> Type of array
   * @param arr Array
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  public static <T> void slowSort(T[] arr, Comparator<T> c) {
    //TODO Uncomment based on whether you implemented selection sort or
    //     insertion sort
    //insertionSort(arr, c);
    selectionSort(arr, c);
  }

  /**
   * Heap sort array into ordering defined by the input comparator.
   *
   * Must be an inplace implementation.
   *
   * @param <T> Type of array
   * @param arr Array
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  public static <T> void heapSort(T[] arr, Comparator<T> c) {
    //TODO Implement either heap sort, merge sort, or quick sort
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
    	heapify(arr, n, i, c);
    }

    for (int i = n - 1; i >= 0; i--){
    	swap(arr, 0, i);
    	heapify(arr, i, 0, c);
    }
  }

  public static <T> void heapify(T[] arr, int n, int i, Comparator<T> c) {
  	int largest = i;
  	int l = 2*i + 1;
  	int r = 2*i + 2;

  	if (l < n && c.compare(arr[l], arr[largest]) > 0) 
  		largest = l;

  	if (r < n && c.compare(arr[r], arr[largest]) > 0) 
  		largest = r;

  	if (largest != i) {
  		swap(arr, i, largest);
  		heapify(arr, n, largest, c);
  	}
  }

  /**
   * Merge sort array into ordering defined by the input comparator.
   *
   * Recursive helper method. Simply call the recursive algorithm.
   *
   * @param <T> Type of array
   * @param arr Array
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  public static <T> void mergeSort(T[] arr, Comparator<T> c) {
    mergeSort(arr, 0, arr.length, c);
  }

  /**
   * Merge sort array into ordering defined by the input comparator.
   *
   * Does not need to be inplace. I recommend using an ArrayList to facilitate
   * the implementation of the merge step.
   *
   * @param <T> Type of array
   * @param arr Array
   * @param first Index of the first element of the sublist
   * @param last Index of one after the last element of the sublist
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  private static <T> void mergeSort(T[] arr, int first, int last, Comparator<T> c) {
    //TODO Implement either heap sort, merge sort, or quick sort
  }

  /**
   * Quick sort array into ordering defined by the input comparator.
   *
   * Recursive helper method. Simply call the recursive algorithm.
   *
   * @param <T> Type of array
   * @param arr Array
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  public static <T> void quickSort(T[] arr, Comparator<T> c) {
    quickSort(arr, 0, arr.length, c);
  }

  /**
   * Quick sort array into ordering defined by the input comparator.
   *
   * Must be an inplace implementation.
   *
   * @param <T> Type of array
   * @param arr Array
   * @param first Index of the first element of the sublist
   * @param last Index of one after the last element of the sublist
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  private static <T> void quickSort(T[] arr, int left, int right, Comparator<T> c) {
    //TODO Implement either heap sort, merge sort, or quick sort
  }

  /**
   * Sort array into ordering defined by the input comparator using an
   *        algorithm with loglinear time complexity.
   *
   * Simply make this function call the fast sorting algorithm you implemented.
   * One of:
   *  (a) heap sort,
   *  (b) merge sort,
   *  (c) quick sort
   *
   * @param <T> Type of array
   * @param arr Array
   * @param c Comparator for elements of array. Has function compare(T t1, T t2)
   *          that returns a negative value if t1 &lt; t2, zero if t1 = t2, and a
   *          positive value if t1 &gt; t2.
   */
  public static <T> void sort(T[] arr, Comparator<T> c) {
    //TODO Uncomment based on whether you implemented heap sort, merge sort, or
    //     quick sort
    heapSort(arr, c);
    //mergeSort(arr, c);
    //quickSort(arr, c);
  }

  /**
   * Radix sort array of integers into nondecreasing order. Should do radix on
   * decimal representation of int type, i.e., number of buckets is always 10.
   *
   * Does not need to be inplace.
   *
   * @param arr int array
   */
  public static void radixSort(int[] arr) {
    //TODO BONUS Implement radix sort
  }
}
