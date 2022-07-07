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
    public List<Integer> postorderTraversal(TreeNode root) {
        //list output 
        List<Integer> out = new ArrayList<Integer>();
        //two stack to save node
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        //tempory treenode
        TreeNode tmp = new TreeNode();
        if (root == null){
            return out;
        }
        s1.push(root);
        //make sure the left node last push in s2 
        while(!s1.isEmpty()){
            tmp = s1.pop();
            s2.push(tmp);
            if(tmp.left != null){
                s1.push(tmp.left);
            }
            if(tmp.right != null){
                s1.push(tmp.right);
            }
        }
        while(!s2.isEmpty()){
            out.add(s2.pop().val);
        }
        return out;
    }
}