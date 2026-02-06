class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double maxavg=0;
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
       maxavg=sum/k;
        for(int i=1;i<=n-k;i++){
            sum=sum-nums[i-1]+nums[i+k-1];
            double curravg=sum/k;
            maxavg=Math.max(maxavg,curravg);
        }
        return maxavg;
    }
}