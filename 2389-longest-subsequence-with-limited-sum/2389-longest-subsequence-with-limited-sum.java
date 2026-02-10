class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int q=queries.length;
        int[] result=new int[q];
        for(int i=0;i<q;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(prefix[j]<=queries[i]){
                    count=j+1;
                }else{
                    break;
                }
            }
            result[i]=count;
        }
        return result;
    }
}