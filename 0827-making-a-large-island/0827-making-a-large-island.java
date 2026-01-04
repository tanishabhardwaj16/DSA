class Solution {
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            parent[py] = px;
            size[px] += size[py];
        }
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DSU dsu=new DSU(n*n);
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==1){
                    int id1=r*n+c;
                    for(int[] d:dirs){
                        int nr=r+d[0];
                        int nc=c+d[1];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                            int id2=nr*n+nc;
                            dsu.union(id1,id2);
                        }
                    }
                }
            }
        }
        int ans=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c]==0){
                    Set<Integer>set=new HashSet<>();
                    int total=1;
                    for(int[] d:dirs){
                        int nr=r+d[0];
                        int nc=c+d[1];
                        if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                            int root=dsu.find(nr*n+nc);
                            if(set.add(root)){
                                total+=dsu.size[root];
                            }
                        }
                    }
                    ans=Math.max(ans,total);
                }
            }
        }
        if(ans==0) return n*n;
        return ans;
    }
}