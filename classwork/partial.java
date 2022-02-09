public class partial{
  public static boolean partialSum(int start,int[] arr,int targetValue){
    if (start == arr.length){
      return false;
    } else if (targetValue == 0){
      return true;
    }
    boolean boo1 = partialSum(start, arr, targetValue - arr[start]);
    boolean boo2 =partialSum(start + 1, arr, targetValue);
    if(targetValue - arr[start] ){
      return true;
    }
    return partialSum(start + 1, arr, targetValue);
  }
  public static void main(String[] args){
    int[] arr = {2,3,4,6};
    System.out.println(partialSum(0,arr,10));
  }
}
