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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
        int maxwidth=0;
        while(!q.isEmpty()){
            int size=q.size();
            int minindex=q.peek().index;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int idx=curr.index-minindex;
                if(i==0) first=idx;
                if(i==size-1) last=idx;
                if(curr.root.left!=null){
                    q.add(new Pair(curr.root.left,2*idx+1));
                }
                if(curr.root.right!=null){
                    q.add(new Pair(curr.root.right,2*idx+2));
                }
            }
            maxwidth=Math.max(maxwidth,last-first+1);
        }
        return maxwidth;
    }
    class Pair{
        TreeNode root;
        int index;
        Pair(TreeNode r,int i){
            root=r;
            index=i;
        }
    }
}