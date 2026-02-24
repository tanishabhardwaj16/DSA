class Solution {
    public int removeDuplicates(int[] nums) {
        int s=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!= nums[s]){
                s++;
                nums[s]=nums[i];
            }
        }
        return s+1;
    }
}