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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode build(int[] preorder,int min,int max){
        if(i>=preorder.length || preorder[i]<min || preorder[i]>max) return null;
        int val=preorder[i++];
        TreeNode root=new TreeNode(val);
        root.left=build(preorder,min,val);
        root.right=build(preorder,val,max);
        return root;
    }
}