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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<Integer>();
        if(root == null) return out;
        Stack<TreeNode> saveNode = new Stack<TreeNode>();
        TreeNode cur = new TreeNode();
        cur = root;
        while(!saveNode.isEmpty() || cur != null){
            // find the left node
            if(cur != null){
                saveNode.push(cur);
                cur = cur.left;
            }
            else{
                cur = saveNode.pop();
                out.add(cur.val);
                cur = cur.right;
            }
        }
        return out;
    }
}