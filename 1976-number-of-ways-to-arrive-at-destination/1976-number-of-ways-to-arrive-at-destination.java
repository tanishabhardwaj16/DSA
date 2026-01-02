class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD=1000000007;
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r:roads){
            adj.get(r[0]).add(new int[]{r[1],r[2]});
            adj.get(r[1]).add(new int[]{r[0],r[2]});
        }
        long[] dist=new long[n];
        long[] ways=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<long[]>pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long time=curr[0];
            int node=(int) curr[1];
            if(time>dist[node]) continue;
            for(int[] neigh:adj.get(node)){
                int next=neigh[0];
                long wt=neigh[1];
                if(time+wt<dist[next]){
                    dist[next]=time+wt;
                    ways[next]=ways[node];
                    pq.add(new long[]{dist[next],next});
                }else if(time+wt==dist[next]){
                    ways[next]=(ways[next]+ways[node])%MOD;
                }
            }
        }
        return (int)(ways[n-1]%MOD);
    }
}