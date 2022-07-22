/*
 Given an array of positive integers nums and a positive integer target, 
 return the minimal length of a contiguous subarray [numsl, numsl+1, ..., 
 numsr-1, numsr] of which the sum is greater than or equal to target. 
 If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */

 //滑动窗口
 class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length + 1;
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = 0;
        for(;rightIndex<nums.length;rightIndex = rightIndex + 1){
            sum = sum + nums[rightIndex];
            while(sum>=target){
                int tmp = result;
                result = rightIndex - leftIndex + 1;
                if(tmp < result){
                    result = tmp;
                }
                sum = sum - nums[leftIndex];
                leftIndex = leftIndex + 1;
            }
        }
        if(result == nums.length + 1){
            return 0;
        }
        return result;
    }
}