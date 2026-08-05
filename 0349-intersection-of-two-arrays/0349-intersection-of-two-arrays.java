class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set=new HashSet<>();
        HashSet<Integer>ans=new HashSet<>();
        for(int n:nums2){
            set.add(n);
        }
        for(int i=0;i<nums1.length;i++){
            if(set.contains(nums1[i])) ans.add(nums1[i]);
        }
        int[] res=new int[ans.size()];
        int idx=0;
        for(int a : ans){
            res[idx++]=a;
        }
        return res;
    }
}