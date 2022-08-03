/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 */
 /**
     * 递归法，相比求MaxDepth要复杂点
     * 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
 */

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left ==null && root.right != null){
            return 1+minDepth(root.right);
        }
        if(root.left !=null && root.right == null){
            return 1+minDepth(root.left);
        }
        
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
        
        
    }
}
class Solution {
    /**
     * 递归法，相比求MaxDepth要复杂点
     * 因为最小深度是从根节点到最近**叶子节点**的最短路径上的节点数量
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }
}

class Solution {
    /**
      * 迭代法，层序遍历, 当遇到一个叶子节点时就返回当时的深度，就是最小值
      */
     public int minDepth(TreeNode root) {
         if (root == null) {
             return 0;
         }
         Deque<TreeNode> deque = new LinkedList<>();
         deque.offer(root);
         int depth = 0;
         while (!deque.isEmpty()) {
             int size = deque.size();
             depth++;
             for (int i = 0; i < size; i++) {
                 TreeNode poll = deque.poll();
                 if (poll.left == null && poll.right == null) {
                     // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                     return depth;
                 }
                 if (poll.left != null) {
                     deque.offer(poll.left);
                 }
                 if (poll.right != null) {
                     deque.offer(poll.right);
                 }
             }
         }
         return depth;
     }
 }