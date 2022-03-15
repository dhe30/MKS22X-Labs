import java.util.*;
import java.io.*;
public class Preliminary{
  public static void swarp(int[] a, int thisIndex, int thereIndex){
    int store = a[thereIndex];
    a[thereIndex] = a[thisIndex];
    a[thisIndex] = store;
  }
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
    swarp(data, start, picker);
    while(start != end){
      if (data[start + 1] > data[start]){
        swarp(data, start + 1, end);
        end -= 1;
      } else {
        swarp(data, start + 1, start);
        start += 1;
      }
    }
    return start;
  }
  public static void main(String[] args){
    int[] a = {1,2,3,4,5,6,7,8,99};
    System.out.println(partition(a,0,a.length - 1));
    System.out.println(Arrays.toString(a));
  }
}
