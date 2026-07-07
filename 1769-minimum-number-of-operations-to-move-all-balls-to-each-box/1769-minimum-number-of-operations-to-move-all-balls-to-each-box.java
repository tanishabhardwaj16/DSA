class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] left=new int[n];
        int[] right=new int[n];
        int[] ans=new int[n];
        int balls=0,moves=0;
        for(int i=0;i<n;i++){
            left[i]=moves;
            if(boxes.charAt(i)=='1')
                balls++;
            moves+=balls;
        }
        balls=0;
        moves=0;
        for(int i=n-1;i>=0;i--){
            right[i]=moves;
            if(boxes.charAt(i)=='1')
                balls++;
            moves+=balls;
        }
        for(int i=0;i<n;i++){
            ans[i]=left[i]+right[i];
        }
        return ans;
    }
}