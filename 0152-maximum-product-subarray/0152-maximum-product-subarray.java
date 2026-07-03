class Solution {
    public int maxProduct(int[] nums) {
        int currmax=nums[0];
        int currmin=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=currmax;
                currmax=currmin;
                currmin=temp;
            }
            currmax=Math.max(nums[i],currmax*nums[i]);
            currmin=Math.min(nums[i],currmin*nums[i]);
            ans=Math.max(ans,currmax);
        }
        return ans;
    }
}