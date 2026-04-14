class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1000000007;
        Stack<Integer>s=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            left[i]=s.isEmpty() ? i+1 : i-s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            right[i]=s.isEmpty() ? n-i : s.peek()-i;
            s.push(i);
        }
        long sum=0;
        for(int i=0;i<n;i++){
            long contri=(long)arr[i]*left[i]*right[i];
            sum=(sum+contri)%mod;
        }
        return (int)sum;
    }
}