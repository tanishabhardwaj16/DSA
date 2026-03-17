class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key=entry.getKey();
            int count=entry.getValue();
            if(count==1){
                ans=key;
                break;
            }
        }
        return ans;
    }
}