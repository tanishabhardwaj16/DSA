class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>s=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num : nums2){
            while(!s.isEmpty() && s.peek()<num){
                map.put(s.pop(),num);
            }
            s.push(num);
        }
        while(!s.isEmpty()){
            map.put(s.pop(),-1);
        }
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=map.get(nums1[i]);
        }
        return res;
    }
}