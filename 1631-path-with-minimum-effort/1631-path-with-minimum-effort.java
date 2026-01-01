class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int currDist=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==n-1 && c==m-1) return currDist;
            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int diff=Math.abs(heights[r][c]-heights[nr][nc]);
                    int newDist=Math.max(currDist,diff);
                    if(newDist<dist[nr][nc]){
                        dist[nr][nc]=newDist;
                        pq.add(new int[]{newDist,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}