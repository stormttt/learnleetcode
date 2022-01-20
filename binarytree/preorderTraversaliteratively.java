
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> outPut = new ArrayList<Integer>();
        if(root == null) return outPut;
        Stack<TreeNode> saveNode= new Stack<TreeNode>();
        saveNode.push(root);
        while(!saveNode.isEmpty()){
            root = saveNode.pop();
            outPut.add(root.val);
            if(root.right != null){
                saveNode.push(root.right);
            }
            if(root.left != null){
                saveNode.push(root.left);
            }         
            
        }
        return outPut;
        
    }
}