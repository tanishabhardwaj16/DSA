class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long[] prefix=new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        Deque<Integer>q=new ArrayDeque<>();
        int ans=n+1;
        for(int i=0;i<=n;i++){
            while(!q.isEmpty() && prefix[i]-prefix[q.peekFirst()]>=k){
                ans=Math.min(ans,i-q.pollFirst());
            }
            while(!q.isEmpty() && prefix[i]<=prefix[q.peekLast()]){
                q.pollLast();
            }
            q.offerLast(i);
        }
        return ans==n+1 ? -1 : ans;
    }
}