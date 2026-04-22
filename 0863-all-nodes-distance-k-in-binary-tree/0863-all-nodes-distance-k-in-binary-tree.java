/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parentmap=new HashMap<>();
        List<Integer>res=new ArrayList<>();
        buildparent(root,null,parentmap);
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>vis=new HashSet<>();
        q.add(target);
        vis.add(target);
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(dist==k) break;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                TreeNode parent=parentmap.get(curr);
                if(curr.left!=null && !vis.contains(curr.left)){
                    vis.add(curr.left);
                    q.add(curr.left);
                }
                if(curr.right!=null && !vis.contains(curr.right)){
                    vis.add(curr.right);
                    q.add(curr.right);
                }
                if(parent!=null && !vis.contains(parent)){
                    vis.add(parent);
                    q.add(parent);
            }
          }
          dist++;
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
    public static void buildparent(TreeNode root,TreeNode parent,Map<TreeNode,TreeNode>map){
        if(root==null) return;
        map.put(root,parent);
        buildparent(root.left,root,map);
        buildparent(root.right,root,map);
    }
}