public class partial{
  public static boolean partialSum(int start,int[] arr,int targetValue){
    if (targetValue == 0){
      return true;
    } else if (start == arr.length){
      return false;
    }
    return (partialSum(start + 1, arr, targetValue - arr[start])||partialSum(start + 1, arr, targetValue));
  }

  public static boolean splitArray(int[] nums) {
    return splitArray(nums, 0, 0, 0);
  }
  public static boolean splitArray(int[] nums, int start, int nums1, int nums2) {
    if (start != nums.length){
      return splitArray(nums,start + 1,nums1+nums[start],nums2)||splitArray(nums,start + 1,nums1,nums2+nums[start]);
    } else {
      return nums1 == nums2;
    }
  }

  public static boolean groupSum5(int start, int[] nums, int target) {
    if (target == 0 && start == nums.length){
      return true;
    } else if (start == nums.length){
      return false;
    } else if(nums[start]%5 == 0){
      return (groupSum5(start + 1, nums, target - nums[start]));
    } else if(nums[start] == 1){
      if (start != 0){
        if(nums[start - 1]%5 == 0){
          return (groupSum5(start + 1, nums, target));
        }
      }
    }
    return (groupSum5(start + 1, nums, target - nums[start])) || (groupSum5(start + 1, nums, target));

  }

  public static void main(String[] args){
    int[] arr = {1,2,1,3,7};
    System.out.println(partialSum(0,arr,9));
  }
}
