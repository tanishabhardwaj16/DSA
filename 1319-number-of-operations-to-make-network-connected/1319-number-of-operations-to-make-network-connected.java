class Solution {
    class DSU{
        int[] parent,rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
            int find(int x){
                if(parent[x]!=x){
                    parent[x]=find(parent[x]);
                }
                return parent[x];
            }
            boolean union(int x,int y){
                int px=find(x);
                int py=find(y);
                if(px==py)return false;
                if(rank[px]<rank[py]){
                    parent[px]=py;
                }else if(rank[px]>rank[py]){
                    parent[py]=px;
                }else{
                    parent[py]=px;
                    rank[px]++;
                }
                return true;
            }
        }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        DSU dsu=new DSU(n);
        for(int[] c:connections){
            dsu.union(c[0],c[1]);
        }
        int components=0;
        for(int i=0;i<n;i++){
            if(dsu.find(i)==i) components++;
        }
        return components-1;
    }
}