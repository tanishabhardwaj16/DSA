class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return oddno(nums,k)-oddno(nums,k-1);
    }
    private int oddno(int[] nums,int k){
        int s=0;
        int count=0;
        for(int e=0;e<nums.length;e++){
            if(k<0)return 0;
            if(nums[e]%2==1){
                k--;
            }
            while(k<0){
                if(nums[s]%2==1){
                    k++;
                }
                s++;
            }
            count+=e-s+1;
        }
        return count;
    }
}