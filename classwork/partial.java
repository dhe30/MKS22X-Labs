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

  public static boolean groupSum6(int start, int[] nums, int target) {
    if (target == 0 && start == nums.length){
      return true;
    } else if (start == nums.length){
      return false;
    } else if(nums[start]%6 == 0){
      return (groupSum6(start + 1, nums, target - nums[start]));
    }
    return (groupSum6(start + 1, nums, target - nums[start])) || (groupSum6(start + 1, nums, target));
  }

  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (target == 0){
      return true;
    } else if (start >= nums.length){
      return false;
    }
    return (groupNoAdj(start + 1, nums, target)) || (groupNoAdj(start + 2, nums, target - nums[start]));
  }
  public boolean groupSumClump(int start, int[] nums, int target) {
    if (target == 0){
      return true;
    } else if (start >= nums.length){
      return false;
    } else if (start < nums.length - 1){
        if (nums[start] == nums[start + 1]){
          int ans = 0;
          for (int i = start; i < nums.length; i++){
            if (nums[i] != nums[start]){
              i = nums.length;
            } else {
              ans+=1;
            }
          }
          return (groupSumClump(start + ans, nums, target)) || (groupSumClump(start + ans, nums, target - (nums[start] * ans)));
        }
      }
    return (groupSumClump(start + 1, nums, target)) || (groupSumClump(start + 1, nums, target - nums[start]));
  }
  public static boolean splitOdd10(int[] nums) {
    return splitOdd10(nums,0,0,0);
  }
  public static boolean splitOdd10(int[] nums, int start, int nums1, int nums2) {
    if (start != nums.length){
      return splitOdd10(nums,start + 1,nums1+nums[start],nums2)||splitOdd10(nums,start + 1,nums1,nums2+nums[start]);
    } else {
      return nums1%10 == 0 && nums2%2 == 1 || nums2%10 == 0 && nums1%2 == 1;
    }
  }
  public static boolean split53(int[] nums) {
    return split53(nums, 0, 0, 0);
  }
  public static boolean split53(int[] nums, int start, int nums1, int nums2) {
    if (start != nums.length){
      if (nums[start]%5 == 0){
        return split53(nums,start + 1,nums1+nums[start],nums2);
      } else if (nums[start]%3 == 0){
        return split53(nums,start + 1,nums1,nums2+nums[start]);
      } else {
        return split53(nums,start + 1,nums1+nums[start],nums2)||split53(nums,start + 1,nums1,nums2+nums[start]);
      }
    } else {
      return nums1 == nums2;
    }
  }
  public static void main(String[] args){
    int[] arr = {2,5,10,4,2};
    System.out.println(groupNoAdj(0,arr,7));
  }
}
