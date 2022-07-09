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
// levelorder return a list include every level of the tree, store same level 
// in a list
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // a queue to store node
        Queue<TreeNode> queue = new LinkedList<>();
        // check empty or not
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> currentlevel = new ArrayList<>();
            for (int i = 0; i < length; i = i + 1){
                TreeNode tmp = queue.remove();
                currentlevel.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            result.add(currentlevel);
        }
        return result;
    }
}