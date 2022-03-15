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
    int picker = (int)(Math.random() * (end - start + 1)) + start;
    swarp(data, start, picker);
    int i = 0;
    boolean red = false;
    while(start != end){
      if (data[start + 1] > data[start - i]){
        swarp(data, start + 1, end);
        end -= 1;
      } else if (data[start + 1] < data[start - i]){
        start += 1;
        i++;
      } else {
        if (red){
          start += 1;
          red = false;
          i++;
        } else {
          swarp(data, start + 1, end);
          end -= 1;
          red = true;
        }
      }
    }

    swarp(data, start, start - i);
    return start;
  }

  /*return the value that is the kth smallest value of the array.
*@param data must have a length > 0
*@param k is 0 to data.length-1 inclusive
*@postcondition The array may be modified. */
  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length - 1;
    k -= 1;
    int adam = partition(data, start, end);
    while (adam != k){
      if (adam > k){
        end = adam - 1;
        adam = partition(data, start, end);
      } else {
        start = adam + 1;
        k -= adam;
        adam = partition(data, start, end);
      }
    }
    return data[adam];
  }
  public static void main(String[] args){
    // int[] a = {1,2,3,4,5,99,99,99,99};
    // System.out.println(partition(a,0,a.length - 1));
    // System.out.println(Arrays.toString(a));
    int [] data = new int[] {993,994,995,4,3,2,1,0,997,998,999};
    System.out.println(quickselect(data, 2));
    // System.out.println("Original: "+Arrays.toString(data));
    // int pivot = partition( data , 3, 7);
    // System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
    // System.out.println("Modified: "+Arrays.toString(data));
    // System.out.println();
  }
}
