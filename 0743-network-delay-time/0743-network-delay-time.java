class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:times){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }
        int[] dist=new int[n+1];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new int[]{0,k});
        dist[k]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int time=curr[0];
            int node=curr[1];
            if(time>dist[node])continue;
            for(int[] neigh:adj.get(node)){
                int next=neigh[0];
                int wt=neigh[1];
                if(time+wt<dist[next]){
                    dist[next]=time+wt;
                    pq.add(new int[]{dist[next],next});
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }else{
                ans=Math.max(ans,dist[i]);
            }
        }
        return ans;
    }
}