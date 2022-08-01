/*
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
// 加了限制大小1000以下可以用数组，但是此题练习用set。
// 注意hashmap 和hashset区别 还有python和javascript中的set
// 还可以排序之后用双指针

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        result.addAll(resSet);
        return result;
    }
}
