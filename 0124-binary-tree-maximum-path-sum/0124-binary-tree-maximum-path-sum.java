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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxsum;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int leftsum=Math.max(0,dfs(root.left));
        int rightsum=Math.max(0,dfs(root.right));
        maxsum=Math.max(maxsum,leftsum+root.val+rightsum);
        return root.val+Math.max(leftsum,rightsum);
    }
}