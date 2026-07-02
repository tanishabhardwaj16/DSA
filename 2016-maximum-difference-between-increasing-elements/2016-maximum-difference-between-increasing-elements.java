class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int maxProfit=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }else{
                int profit=nums[i]-min;
                maxProfit=Math.max(maxProfit,profit);
            }
        }
        return maxProfit==0 ? -1 : maxProfit;
    }
}