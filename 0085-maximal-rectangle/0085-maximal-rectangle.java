class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] heights=new int[m];
        int maxarea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    heights[j]+=1;
                }else{
                    heights[j]=0;
                }
            }
            maxarea=Math.max(maxarea,largestarea(heights));
        }
        return maxarea;
    }
    public int largestarea(int[] heights){
        int n=heights.length;
        int maxarea=0;
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<=n;i++){
            int curr=(i==n) ? 0 : heights[i];
            while(!s.isEmpty() && heights[s.peek()]>curr){
                int ele=heights[s.pop()];
                int nse=i;
                int pse=s.isEmpty() ? -1 : s.peek();
                int width=nse-pse-1;
                maxarea=Math.max(ele*width,maxarea);
            }
            s.push(i);
        }
        return maxarea;
    }
}