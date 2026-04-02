class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>op=new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,target,0,op,res);
        return res;
    }
    public void solve(int[] candidates,int target,int index,List<Integer>op,List<List<Integer>>res){
        if(target==0){
            res.add(new ArrayList<>(op));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target)break;
            op.add(candidates[i]);
            solve(candidates,target-candidates[i],i+1,op,res);
            op.remove(op.size()-1);
        }
    }
}