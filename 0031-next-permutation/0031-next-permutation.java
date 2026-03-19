class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx!=-1){
            for(int j=n-1;j>=0;j--){
                if(nums[j]>nums[idx]){
                    swap(nums,j,idx);
                    break;
                }
            }
        }
        reverse(nums,idx+1,n-1);
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums,int s,int e){
        while(s<e){
            swap(nums,s++,e--);
        }
    }
}