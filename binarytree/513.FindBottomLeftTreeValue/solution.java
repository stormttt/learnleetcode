/*
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */
// recursion

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
    private int result;
    private int currentMaxDeep = -1;
    public int findBottomLeftValue(TreeNode root) {
        result = root.val;
        findBottomLeftValueHelper(root,0);
        return result;
    }
    private void findBottomLeftValueHelper(TreeNode root,int deep){
        if(root ==null) return;
        if(root.left == null && root.right ==null){
            if(deep > currentMaxDeep){
                result = root.val;
                currentMaxDeep = deep;
            }
        }
        if(root.left != null){
            deep++;
            findBottomLeftValueHelper(root.left, deep);
            deep--;
        }
        if(root.right != null){
            deep++;
            findBottomLeftValueHelper(root.right, deep);
            deep--;
        }
        return;
    }
}

// iteration
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        int result = 0;
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0;i<size;i++){
                TreeNode tmp = que.poll();
                if(i == 0){
                    result = tmp.val;
                }
                
                if(tmp.left != null){
                    que.offer(tmp.left);
                } 
                if(tmp.right != null){
                    que.offer(tmp.right);
                }
            }
        }
        return result;
    }
}