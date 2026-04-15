class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer>s=new Stack<>();
        int maxarea=0;
        for(int i=0;i<=n;i++){
            int curr=(i==n) ? 0 : heights[i];
            while(!s.isEmpty() && heights[s.peek()]>curr){
                int ele=heights[s.pop()];
                int nse=i;
                int pse= s.isEmpty() ? -1 : s.peek();
                int width=nse-pse-1;
                maxarea=Math.max(ele*width,maxarea);
            }
            s.push(i);
        }
        return maxarea;
    }
}