class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f:flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int[] dist=new int[n];
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,src,0});
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int stops=curr[0];
            int city=curr[1];
            int cost=curr[2];
            if(stops>k)continue;
            for(int[] neigh:adj.get(city)){
                int next=neigh[0];
                int price=neigh[1];
                if(cost+price <dist[next]){
                    dist[next]=cost+price;
                    q.add(new int[]{stops+1,next,dist[next]});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}