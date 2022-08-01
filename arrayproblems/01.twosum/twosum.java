import java.util.HashMap;
import java.util.Map;

/* Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, 
and you may not use the same element twice.
You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/

// use map
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // output array to return
        int[] output = new int[2];
        // a map to save the number in nums
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        // loop the array, store one number and then use target to find
        // another number in array
        for(int i =0; i<nums.length;i++){
            // if the map contain the key equals to target-nums[i]
            // then we find the number
            if(map.containsKey(target - nums[i])){
                output[0] = map.get(target - nums[i]);
                output[1] = map.get(num[i]);
                return output;
            }
            map.put(num[i], i);
        }
        return output;
    }
}