class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>op=new ArrayList<>();
        int sum=0;
        solve(candidates,target,0,0,op,res);
        return res;
    }
    public void solve(int[] candidates,int target,int sum,int index,List<Integer>op,List<List<Integer>>res){
        if(index==candidates.length) return;
        if(sum>target) return;
        if(sum==target){
            res.add(new ArrayList<>(op));
            return;
        }
        op.add(candidates[index]);
        solve(candidates,target,sum+candidates[index],index,op,res);  //i repetition
        op.remove(op.size()-1);
        solve(candidates,target,sum,index+1,op,res);
    }
}