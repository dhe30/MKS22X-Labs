import java.util.*;
import java.io.*;
public class Merge{

  /*merge takes two sorted arrays and returns a new array that combines all
   *elements of both arrays in asorted order.
   *@left a sorted array (this is a precondition)
   *@right a sorted array (this is a precondition)
   *@return a sorted array that contains all elements of left and right
   */
  public static int [] merge(int [] left, int[] right){
    //********************
    //COMPLETE THIS METHOD
    //********************
    int[] adam = new int[left.length + right.length];
    int eft = 0;
    int ight = 0;
    int i = 0;
    while(i <= adam.length){
      if (ight == right.length){
        for(int a = eft; a < left.length; a++){
          adam[i] = left[a];
          i++;
        }
      } else if (eft == left.length){
        for(int b = ight; b < right.length; b++){
          //System.out.println("index: " + b + " value: " + right[b] + " rightlength: " + right.length + " index: " + i);
          adam[i] = right[b];
          i++;
        }
      } else if (left[eft] > right[ight]){
        adam[i] = right[ight];
        ight++;
      } else if(left[eft] < right[ight]){
        adam[i] = left[eft];
        eft++;
      } else{
        adam[i] = left[eft];
        i++;
        adam[i] = right[ight];
        eft++;
        ight++;
      }
      i++;
    }
    return adam;//so this compiles.
  }

  /*mergesortH is the actual mergesort method.
  *@data the array to be sorted
  *@return a new array that is the sorted version of data.
  */
  public static int[] mergesortH(int [] data){
    //********************
    //COMPLETE THIS METHOD
    //********************
    //if more than 1 element{
      //left = copy half of data
      //right = copy other half of data
      //sort each half and merge them together
    //}
    if(data.length > 1){
      int[] left = new int[data.length / 2];
      int[] right = new int[data.length - left.length];

      for (int i = 0; i < data.length / 2; i++){
        left[i] = data[i];
      }
      int a = 0;
      for (int i = data.length / 2; i < data.length; i++){
        right[a] = data[i];
        a++;
      }
      return merge(left, right);
    }
    return data; //so this compiles
  }

  /*mergesort uses the recursive mergesortH method to create a sorted
  *version of the array. It then copies the data back into the original
  *array. (This is for compatibility with prior sort testers)
  *@param data the array to be sorted, this will be modified by the method
  */
  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }
  public static void main(String[] args){
    int[] a = {1,2,3,4,27};
    int[] b = {5,6,7,8};
    int[] c = merge(a,b);
    System.out.println(Arrays.toString(c));
  }
}
