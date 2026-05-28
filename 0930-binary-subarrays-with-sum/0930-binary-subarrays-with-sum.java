class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    public int atmost(int[] nums,int goal){
        int ans=0;
        int s=0;
        int e=0;
        int count=0;
        if(goal<0) return 0;
        for(e=0;e<nums.length;e++){
            ans+=nums[e];
            while(ans>goal){
                ans-=nums[s];
                s++;
            }
            count+=e-s+1;
        }
        return count;
    }
}