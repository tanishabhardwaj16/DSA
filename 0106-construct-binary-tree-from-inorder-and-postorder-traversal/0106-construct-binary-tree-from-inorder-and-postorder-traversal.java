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
    int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        postindex=postorder.length-1;
        return helper(postorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] postorder,int start,int end){
        if(start>end) return null;
        int rootval=postorder[postindex--];
        TreeNode root=new TreeNode(rootval);
        int inIndex=inMap.get(rootval);
        root.right=helper(postorder,inIndex+1,end);
        root.left=helper(postorder,start,inIndex-1);
        return root;
    }
}