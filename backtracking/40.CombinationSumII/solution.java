/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */
// 使用标记数组

class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        //加标志数组，用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backTracking(candidates, target, 0, flag);
        return lists;
    }

    public void backTracking(int[] arr, int target, int index, boolean[] flag) {
        if (sum == target) {
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += arr[i];
            deque.push(arr[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backTracking(arr, target, i + 1, flag);
            int temp = deque.pop();
            flag[i] = false;
            sum -= temp;
        }
    }
}
不使用标记数组

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();
  int sum = 0;
  
  public List<List<Integer>> combinationSum2( int[] candidates, int target ) {
    //为了将重复的数字都放到一起，所以先进行排序
    Arrays.sort( candidates );
    backTracking( candidates, target, 0 );
    return res;
  }
  
  private void backTracking( int[] candidates, int target, int start ) {
    if ( sum == target ) {
      res.add( new ArrayList<>( path ) );
      return;
    }
    for ( int i = start; i < candidates.length && sum + candidates[i] <= target; i++ ) {
      //正确剔除重复解的办法
      //跳过同一树层使用过的元素
      if ( i > start && candidates[i] == candidates[i - 1] ) {
        continue;
      }

      sum += candidates[i];
      path.add( candidates[i] );
      // i+1 代表当前组内元素只选取一次
      backTracking( candidates, target, i + 1 );

      int temp = path.getLast();
      sum -= temp;
      path.removeLast();
    }
  }
}