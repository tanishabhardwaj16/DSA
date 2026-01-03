class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int i=0;i<n;i++) dist[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]<Integer.MAX_VALUE && dist[j][k]<Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int cntCity=n;
        int city=-1;
        for(int c=0;c<n;c++){
            int count=0;
            for(int nei=0;nei<n;nei++){
                if(c != nei && dist[c][nei]<=distanceThreshold)
                count++;
            }
            if(count<=cntCity){
                cntCity=count;
                city=c;
            }    
        }
        return city;
    }
}