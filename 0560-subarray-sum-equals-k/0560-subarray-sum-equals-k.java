class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            if(ele==k) count++;
            int rem=ele-k;
            if(map.containsKey(rem)) count+=map.get(rem);
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        return count;
    }
}