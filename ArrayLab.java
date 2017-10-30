/**
 * A collection of methods related to int[].
 */

//we ran out of time due to not understanding how to use testingoutput initally 
public class ArrayLab {

  /**
   * Return whether k is in array[start..end].
   * Precondition: the length of array is at least end+1
   * @param array the array of int values.
   * @param start the index of the start of the range to be searched.
   * @param end the index of the end of the range to be searched.
   * @param k the number to search for.
   */
  public static boolean contains(int[] array, int start, int end, int k) {
    for(int i = start; i <= end; i++){
      if(array[i] == k){
        return true;
      }
    }
    return false;
  }

  /**
   * Create a String that has the contents of list[0..n-1] on one line, 
   * separated by spaces and surrounded by { and }.
   * @param list the sorted array.
   * @param n the number of items in list to put in the string.
   * @return  the first n elements of the array, separated by spaces, and surrounded by { and }.
   */
  public static String arrayToString(int[] list, int n) {
    String s = "";
    for(int i = 0; i < n; i++){
      if (i >= 1){
        s = s + " ";
      }
      s = s + list[i];
    }
    s = "{" + s + "}";
    return s;
  }

  /**
   * Remove k from list[0..n-1].
   * Precondition: list[0..n-1] is sorted, and k is an element of list[0..n-1].
   * Postcondition: list[0..n-2] is sorted.
   * @param list the sorted array.
   * @param n the number of items in list.
   * @param k the number to remove from list.
   */
  public static void remove(int[] list, int n, int k) {
  }

  /**
   * Insert k into list where it belongs.
   * Precondition: list[0..n-1] is sorted, and list[n] is unused.
   * Postcondition: list[0..n] is sorted.
   * @param list the sorted array.
   * @param n the number of items in list.
   * @param k the number to add to list.
   */
  public static void insert(int[] list, int n, int k) {
  }
}