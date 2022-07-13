import java.util.Queue;

import javax.swing.tree.TreeNode;

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

class SolutionRecursion {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetrichelper(root.left,root.right);
    }
    public boolean isSymmetrichelper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return (isSymmetrichelper(left.left,right.right) && isSymmetrichelper(left.right,right.left));
    }

}

class SolutionIteration{
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null){
            return true;
        }
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if(l == null && r == null){
                continue;
            }
            if(l == null || r == null){
                return false;
            }
            if (l.val != r.val) return false;
            q.offer(l.left);
            q.offer(r.right);
            q.offer(l.right);
            q.offer(r.left);
        }
        return true;
    }
}