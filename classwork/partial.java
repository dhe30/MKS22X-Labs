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
  public static boolean splitArray(int[] nums) {
    return splitArray(nums, 0, 0, 0);
  }
  public static boolean splitArray(int[] nums, int start, int nums1, int nums2) {
    if (start != nums.length){
      return splitArray(nums,start + 1,nums1+nums[start],nums2)||splitArray(nums,start + 1,nums1,nums2+nums[start]);
    } else {
      if (nums1 == nums2){
        return true;
      }
        return false;
    }
  }
  public static void main(String[] args){
    int[] arr = {1,2,1,3,7};
    System.out.println(splitArray(arr));
  }
}
