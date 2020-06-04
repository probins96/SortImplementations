//Name: Palmer Robins

import java.util.Arrays;
import java.util.Comparator;

/**
 * Unit tests for sorting algorithms
 */
public class TestSort {

  /**
   * Sorting class interface, for use to allow generic tests for sorting
   * algorithms.
   */
  public interface Sorter<T> {
    void sort(T[] arr, Comparator<T> c);
  }

  /**
   * Test sorting algorithm on randomly ordered integers into nondecreasing
   * order.
   * @param s Generic sorter over an array of integers.
   * @return Pass/fail indicator for unit test
   */
  public static boolean testSortRandom(Sorter<Integer> s) {
    Integer[] arr = {3, 2, 5, 6, 8, 4, 3, 1};
    Integer[] sorted = {1, 2, 3, 3, 4, 5, 6, 8};

    s.sort(arr, (i1, i2) -> i1.compareTo(i2));

    return Arrays.equals(arr, sorted);
  }

  /**
   * Test sorting algorithm on ordered integers into nondecreasing order.
   * @param s Generic sorter over an array of integers.
   * @return Pass/fail indicator for unit test
   */
  public static boolean testSortSorted(Sorter<Integer> s) {
    Integer[] arr = {1, 2, 3, 3, 4, 5, 6, 8};
    Integer[] sorted = {1, 2, 3, 3, 4, 5, 6, 8};

    s.sort(arr, (i1, i2) -> i1.compareTo(i2));

    return Arrays.equals(arr, sorted);
  }

  /**
   * Test sorting algorithm on reverse ordered integers into nondecreasing
   * order.
   * @param s Generic sorter over an array of integers.
   * @return Pass/fail indicator for unit test
   */
  public static boolean testSortReverse(Sorter<Integer> s) {
    Integer[] arr = {8, 6, 5, 4, 3, 3, 2, 1};
    Integer[] sorted = {1, 2, 3, 3, 4, 5, 6, 8};

    s.sort(arr, (i1, i2) -> i1.compareTo(i2));

    return Arrays.equals(arr, sorted);
  }

  /**
   * Test sorting algorithm on randomly ordered strings into nonincreasing
   * order.
   * @param s Generic sorter over an array of integers.
   * @return Pass/fail indicator for unit test
   */
  public static boolean testSortDescendingStrings(Sorter<String> s) {
    String[] arr = {"a", "h", "b", "z", "b", "e", "d"};
    String[] sorted = {"z", "h", "e", "d", "b", "b", "a"};

    s.sort(arr, (s1, s2) -> -s1.compareTo(s2));

    return Arrays.equals(arr, sorted);
  }

  /**
   * Test sorting algorithm on a series of unit tests: (1) randomly ordered
   * integers into nondescreasing order, (2) ordered integers into nondecreasing
   * order, (3) reverse ordered integers into nondecreasing order, and (4)
   * randomly ordered strings into nonincreasing order.
   * @param <T> Useless generic parameter to fool Java.
   * @param s Generic sorter.
   */
  @SuppressWarnings({"unchecked"})
  public static <T> void testSort(Sorter<T> s) {
    System.out.printf("%20s\t%10b\n", "random integers",
        testSortRandom((Sorter<Integer>)s));
    System.out.printf("%20s\t%10b\n", "sorted integers",
        testSortSorted((Sorter<Integer>)s));
    System.out.printf("%20s\t%10b\n", "reverse integers",
        testSortReverse((Sorter<Integer>)s));
    System.out.printf("%20s\t%10b\n", "descending strings",
        testSortDescendingStrings((Sorter<String>)s));
  }

  /**
   * Test radix sorting algorithm on randomly ordered integers.
   * @return Pass/fail indicator for unit test
   */
  public static boolean testRadixSortRandom() {
    int[] arr = {3, 2, 5, 6, 8, 4, 3, 1};
    int[] sorted = {1, 2, 3, 3, 4, 5, 6, 8};

    Sort.radixSort(arr);

    return Arrays.equals(arr, sorted);
  }

  /**
   * Test radix sorting algorithm on ordered integers.
   * @return Pass/fail indicator for unit test
   */
  public static boolean testRadixSortSorted() {
    int[] arr = {1, 2, 3, 3, 4, 5, 6, 8};
    int[] sorted = {1, 2, 3, 3, 4, 5, 6, 8};

    Sort.radixSort(arr);

    return Arrays.equals(arr, sorted);
  }

  /**
   * Test radix sorting algorithm on reverse ordered integers.
   * @return Pass/fail indicator for unit test
   */
  public static boolean testRadixSortReverse() {
    int[] arr = {8, 6, 5, 4, 3, 3, 2, 1};
    int[] sorted = {1, 2, 3, 3, 4, 5, 6, 8};

    Sort.radixSort(arr);

    return Arrays.equals(arr, sorted);
  }

  /**
   * Test radix sorting algorithm on a series of unit tests: (1) randomly
   * ordered integers, (2) ordered integers, (3) reverse ordered integers.
   */
  public static void testRadixSort() {
    System.out.printf("%20s\t%10b\n", "random ints",
        testRadixSortRandom());
    System.out.printf("%20s\t%10b\n", "sorted ints",
        testRadixSortSorted());
    System.out.printf("%20s\t%10b\n", "reverse ints",
        testRadixSortReverse());
  }

  /**
   * Test all sorting algorithms in Sort.java.
   * @param args Ignored.
   */
  public static void main(String[] args) {
    System.out.printf("%20s\n", "Testing bubble sort");
    testSort((arr, c) -> Sort.bubbleSort(arr, c));
    System.out.printf("%20s\n", "Testing selection sort");
    testSort((arr, c) -> Sort.selectionSort(arr, c));
    System.out.printf("%20s\n", "Testing insertion sort");
    testSort((arr, c) -> Sort.insertionSort(arr, c));
    System.out.printf("%20s\n", "Testing slow sort");
    testSort((arr, c) -> Sort.slowSort(arr, c));
    System.out.printf("%20s\n", "Testing heap sort");
    testSort((arr, c) -> Sort.heapSort(arr, c));
    System.out.printf("%20s\n", "Testing merge sort");
    testSort((arr, c) -> Sort.mergeSort(arr, c));
    System.out.printf("%20s\n", "Testing quick sort");
    testSort((arr, c) -> Sort.quickSort(arr, c));
    System.out.printf("%20s\n", "Testing sort");
    testSort((arr, c) -> Sort.sort(arr, c));
    System.out.printf("%20s\n", "Testing radix sort");
    testRadixSort();
  }
}
