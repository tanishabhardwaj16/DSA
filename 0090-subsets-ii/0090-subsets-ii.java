class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>>set=new HashSet<>();
        List<Integer>op=new ArrayList<>();
        solve(nums,0,op,set);
        List<List<Integer>>res=new ArrayList<>(set);
        Collections.sort(res,(a,b)->{
            int i=0;
            while(i<a.size() && i<b.size()){
                if(!a.get(i).equals(b.get(i))){
                    return a.get(i)-b.get(i);
                }
                i++;
            }
            return a.size()-b.size();
        });
        return res;
    }
    public static void solve(int[] nums,int i,List<Integer>op,HashSet<ArrayList<Integer>>set){
        if(i==nums.length){
            set.add(new ArrayList<>(op));
            return;
        }
        op.add(nums[i]);
        solve(nums,i+1,op,set);
        op.remove(op.size()-1);
        solve(nums,i+1,op,set);
    }
}