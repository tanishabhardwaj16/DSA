class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int s=1;
        int e=0;
        for(int n : nums){
            e=Math.max(e,n);
        }
        int ans=e;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(divisor(nums,threshold,mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean divisor(int[] nums,int threshold,int d){
        int sum=0;
        for(int n : nums){
            sum+=(n+d-1)/d;
            if(sum>threshold) return false;
        }
        return sum<=threshold;
    }
}