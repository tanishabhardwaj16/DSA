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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode node=p.node;
            int col=p.col;
            int row=p.row;
            map.putIfAbsent(col,new TreeMap<>());
            map.get(col).putIfAbsent(row,new PriorityQueue<>());
            map.get(col).get(row).add(node.val);
            if(node.left!=null){
                q.add(new Pair(node.left,col-1,row+1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,col+1,row+1));
            }
        }
        List<List<Integer>>res=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> rows:map.values()){
            List<Integer>list=new ArrayList<>();
            for(PriorityQueue<Integer>pq:rows.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
    class Pair {
        TreeNode node;
        int col, row;       
        Pair(TreeNode n, int c, int r) {
            node = n;
            col = c;
            row = r;
        }
    }
}