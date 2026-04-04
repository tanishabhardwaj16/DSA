class Solution {
    public int splitArray(int[] nums, int k) {
        int s=0;
        int e=totalsum(nums);
        for(int n:nums){
            s=Math.max(s,n);
        }
        int ans=e;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(isPossible(nums,k,mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public int totalsum(int[] nums){
        int add=0;
        for(int i=0;i<nums.length;i++){
            add+=nums[i];
        }
        return add;
    }
    public boolean isPossible(int[] nums,int k,int cap){
        int d=1;
        int sum=0;
        for(int n:nums){
            sum+=n;
            if(sum>cap){
                d++;
                sum=n;
            }
        }
        return d<=k;
    }
}