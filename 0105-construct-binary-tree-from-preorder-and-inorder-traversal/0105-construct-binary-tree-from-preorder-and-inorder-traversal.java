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
    Map<Integer,Integer> inMap=new HashMap<>();
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder,int start,int end){
        if(start>end) return null;
        int rootval=preorder[preindex++];
        TreeNode root=new TreeNode(rootval);
        int inIndex=inMap.get(rootval);
        root.left=helper(preorder,start,inIndex-1);
        root.right=helper(preorder,inIndex+1,end);
        return root;
    }
}