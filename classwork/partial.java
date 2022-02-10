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
  public static int sumArray(int[] nums, int start, int sum){
    if (start == nums.length){
      return sum;
    }
    return sumArray(nums, start + 1, sum + nums[start]);
  }
  // public static boolean splitArray(int[] nums) {
  //   splitArray(nums, 0, 0);
  // }
  // public static boolean splitArray(int[] nums, int sum, int start, int[] nums1, int[]nums2) {
  //   return (nums,sum)
  // }
  public static void main(String[] args){
    int[] arr = {1,1,1,0};
    System.out.println(sumArray(arr,0,0));
  }
}
