import java.util.*;
import java.io.*;
public class Preliminary{
  /*Modify the array such that:
*1. A random index from start to end inclusive is chosen, the
* corresponding element is designated the pivot element.
*2. all elements in range that are smaller than the pivot element
* are placed before the pivot element.
*3. all elements in range that are larger than the pivot element are
*placed after the pivot element.
*4. Only the indices from start to end inclusive are considered in range
*@return the index of the final position of the pivot element.
*/
  public static int partition ( int [] data, int start, int end){
    int picker = (int)(Math.random() * end - start + 1) + start;
    int store = data[picker];
    data[picker] = data[start];
    data[start] = store;
    return store;
  }
  public static void main(String[] args){
    int[] a = {999,99,9,0,1};
    System.out.println(partition(a,0,a.length));
    System.out.println(Arrays.toString(a));
  }
}
