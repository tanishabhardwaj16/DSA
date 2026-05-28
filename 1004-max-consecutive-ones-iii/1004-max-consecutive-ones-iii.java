class Solution {
    public int longestOnes(int[] nums, int k) {
        int s=0;
        int e=0;
        int zero=0;
        int maxlen=0;
        for(e=0;e<nums.length;e++){
            if(nums[e]==0) zero++;
            while(zero>k){
                if(nums[s]==0) zero--;
                s++;
            }
            maxlen=Math.max(maxlen,e-s+1);
        }
        return maxlen;
    }
}