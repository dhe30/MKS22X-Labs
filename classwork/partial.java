public class partial{
  public static boolean partialSum(int start,int[] arr,int targetValue){
    if (start == arr.length){
      return false;
    } else if (targetValue == 0){
      return true;
    }
    if(partialSum(start + 1, arr, targetValue - arr[start])||partialSum(start + 1, arr, targetValue)){
      return true;
    }
    return false;
  }
  public static void main(String[] args){
    int[] arr = {1,1,1,0};
    System.out.println(partialSum(0,arr,4));
  }
}
