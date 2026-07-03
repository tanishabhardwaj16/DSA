class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currmax=nums[0];
        int maxsum=nums[0];
        int currmin=nums[0];
        int minsum=nums[0];
        int n=nums.length;
        int total=nums[0];
        for(int i=1;i<n;i++){
            total+=nums[i];
            currmax=Math.max(nums[i],nums[i]+currmax);
            maxsum=Math.max(maxsum,currmax);
            currmin=Math.min(nums[i],nums[i]+currmin);
            minsum=Math.min(minsum,currmin);
        }
        if(maxsum<0) return maxsum;
        return Math.max(maxsum,total-minsum);
    }
}