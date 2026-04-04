class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int s=0;
        int e=m-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int maxno=0;
            for(int i=0;i<n;i++){
                if(mat[i][mid]>mat[maxno][mid]){
                    maxno=i;
                }
            }
            int left=(mid-1>=0) ? mat[maxno][mid-1] : -1;
            int right=(mid+1<m) ? mat[maxno][mid+1] : -1;
            if(mat[maxno][mid]>left && mat[maxno][mid]>right){
                return new int[]{maxno,mid};
            }else if(left>mat[maxno][mid]){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}