import java.util.LinkedList;
import java.util.List;

/*
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
 */
//回溯


class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length ==0) return result;
        backTracking(candidates,target,0,0);
        return result;
    }

    // 回溯算法主函数
    private void backTracking(int[] candidates,int target,int sum, int start){
        if (sum == target) {
            // 找到目标和
            result.add(new LinkedList<>(path));
            return;
        }
        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            path.add(candidates[i]);
            sum = sum + candidates[i];
            // 递归遍历下一层回溯树
            backTracking(candidates, target, sum, i);
            // 撤销选择 candidates[i]
            sum = sum- candidates[i];
            path.remove(path.size()-1);
        }
    }
}