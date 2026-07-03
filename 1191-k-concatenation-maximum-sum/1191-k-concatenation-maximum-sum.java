class Solution {
    long mod=1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long total=0;
        for(int x:arr){
            total+=x;
        }
        if(k==1) return (int)(kadane(arr)%mod);
        long best=kadaneTwo(arr);
        if(total>0){
            best+=(long)(k-2)*total;
        }
        return (int) (best%mod);
    }
    public long kadane(int[] arr){
        int curr=0;
        int max=0;
        for(int x : arr){
            curr=Math.max(0,curr+x);
            max=Math.max(curr,max);
        }
        return max;
    }
    public long kadaneTwo(int[] arr){
        int curr=0;
        int max=0;
        for(int i=0;i<arr.length*2;i++){
            curr=Math.max(0,curr+arr[i%arr.length]);
            max=Math.max(curr,max);
        }
        return max;
    }
}