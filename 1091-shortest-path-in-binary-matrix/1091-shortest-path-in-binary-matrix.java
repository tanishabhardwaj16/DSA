class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1}); // row, col, path length
        vis[0][0] = true;

        int[][] dirs = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], len = cur[2];

            if(r == n-1 && c == n-1)
                return len;

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n &&
                   grid[nr][nc] == 0 && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc, len + 1});
                }
            }
        }
        return -1;
    }
}
