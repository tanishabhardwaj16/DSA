class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int zero=0;
        int maxlen=0;
        for(int end=0;end<nums.length;end++){
            if(nums[end]==0)zero++;
            while(zero>k){
                if(nums[start]==0)zero--;
                start++;
            }
            maxlen=Math.max(maxlen,end-start+1);
        }
        return maxlen;
    }
}