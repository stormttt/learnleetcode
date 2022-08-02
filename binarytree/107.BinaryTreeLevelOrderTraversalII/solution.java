import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */

 //正常bfs然后把结果倒转
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if(root == null){
            return result;
        }
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> levelNode = new ArrayList<Integer>();
            int levelSize = que.size();
            for(int i = 0; i< levelSize;i=i+1){
                TreeNode needAdd = que.poll();
                levelNode.add(needAdd.val);
                if(needAdd.left != null){
                    que.add(needAdd.left);
                }
                if(needAdd.right != null){
                    que.add(needAdd.right);
                }
            }
            // 还可以正常add然后反转整个arraylist输出，例如用forloop 从后往前遍历然后添加到一个新的arraylist
            result.add(0, levelNode);
        }
        return result;
    }
}