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
 class newnode{
    int maxsum;
    int minval;
    int maxval;
    public newnode(int sum,int minval,int maxval){
        this.maxsum=sum;
        this.minval=minval;
        this.maxval=maxval;
    }
 }
class Solution {
    int max=0;
    public  newnode helper(TreeNode root){
        if(root==null){
            return new newnode(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        newnode left=helper(root.left);
        newnode right=helper(root.right);
        if(left.maxval<root.val && right.minval>root.val){
            int currsum=left.maxsum+root.val+right.maxsum;
            max=Math.max(currsum,max);
            int minval=Math.min(left.minval,root.val);
            int maxval=Math.max(right.maxval,root.val);
            return new newnode(currsum,minval,maxval);
        }
        return new newnode(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
}