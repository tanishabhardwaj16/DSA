class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarray(nums,k)-subarray(nums,k-1);
    }
    private int subarray(int[] nums,int k){
        int s=0;
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int e=0;e<nums.length;e++){
            if(!map.containsKey(nums[e])){
                k--;
            }
            map.put(nums[e],map.getOrDefault(nums[e],0)+1);
            while(k<0){
                if(map.get(nums[s])==1){
                    k++;
                }
                map.put(nums[s],map.get(nums[s])-1);
                if(map.get(nums[s])==0)map.remove(nums[s]);
                s++;
            }
            count+=e-s+1;
        }
        return count;
    }
}
