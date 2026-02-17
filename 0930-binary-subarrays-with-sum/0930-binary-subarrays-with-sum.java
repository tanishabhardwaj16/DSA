class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    private int atmost(int[] nums,int goal){
        int ans=0;
        int e,s=0;
        int res=0;
        if(goal<0)return 0;
        for(e=0;e<nums.length;e++){
            ans+=nums[e];
            while(ans>goal){
                ans-=nums[s];
                s++;
            }
            res+=e-s+1;
        }
        return res;
    }
}