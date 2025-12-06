class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original==color)return image;
        dfs(image,sr,sc,original,color);
        return image;
    }
    public static void dfs(int[][] image,int r,int c,int original,int newC){
        int m=image.length;
        int n=image[0].length;
        if(r<0 || r>=m || c<0 || c>=n || image[r][c]!=original){
            return;
        }
        image[r][c]=newC;
        dfs(image,r+1,c,original,newC);
        dfs(image,r-1,c,original,newC);
        dfs(image,r,c+1,original,newC);
        dfs(image,r,c-1,original,newC);
    }
}