class Solution {
    public int[] searchRange(int[] nums, int target) {
       int[] result={-1,-1};
       int s=binarysearch(nums,target,true);
       int e=binarysearch(nums,target,false);
       result[0]=s;
       result[1]=e;
       return result;
    }
    public int binarysearch(int[] nums,int target,boolean isSearchingLeft){
        int s=0;
        int e=nums.length-1;
        int i=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]<target){
                s=mid+1;
            }else if(nums[mid]>target){
                e=mid-1;
            }else{
                i=mid;
                if(isSearchingLeft){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
        }
        return i;
    }
}