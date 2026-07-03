class Solution {
    public int longestConsecutive(int[] nums) {
        int longest=0;
        HashSet<Integer>set=new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : set){
            if(!set.contains(num-1)){
                int current=num;
                int len=1;
                while(set.contains(current+1)){
                current++;
                len++;
             }
            longest=Math.max(len,longest);
            }
        }
        return longest;
    }
}