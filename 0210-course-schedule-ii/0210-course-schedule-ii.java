class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int a=p[0];
            int b=p[1];
            adj.get(b).add(a);
        }
        int[] vis=new int[numCourses];
        int[] pathVis=new int[numCourses];
        Stack<Integer>s=new Stack<>();
        int[] ans=new int[numCourses];
        int index=0;
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis,s)){
                    return new int[0];
                }
            }
        }
        while(!s.isEmpty()){
            ans[index++]=s.pop();
        }
        return ans;
    }
    public boolean dfs(int node,List<List<Integer>> adj,int[] vis,int[]  pathVis,Stack<Integer>s){
        vis[node]=1;
        pathVis[node]=1;
        for(int neigh:adj.get(node)){
            if(vis[neigh]==0){
                if(dfs(neigh,adj,vis,pathVis,s)){
                    return true;
                }
            }else if(pathVis[neigh]==1){
                return true;
            }
        }
        pathVis[node]=0;
        s.push(node);
        return false;
    }
  
}