class Solution {
    List<List<Integer>>adj=new ArrayList<>();
    List<List<Integer>>bridges=new ArrayList<>();
    int[] time,low;
    boolean[] vis;
    int timer=0;
    public void dfs(int node,int parent){
        vis[node]=true;
        time[node]=low[node]=timer++;
        for(int neigh:adj.get(node)){
            if(neigh==parent) continue;
            if(!vis[neigh]){
                dfs(neigh,node);
                low[node]=Math.min(low[node],low[neigh]);
            }
            if(low[neigh]>time[node]){
                bridges.add(Arrays.asList(node,neigh));
            }else{
                low[node]=Math.min(low[node],time[neigh]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> e:connections){
            int u=e.get(0);
            int v=e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        time=new int[n];
        low=new int[n];
        vis=new boolean[n];
        dfs(0,-1);
        return bridges;
    }
}