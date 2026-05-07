class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1000000007;
        Stack<Integer>s=new Stack<>();
        int[] pse=new int[n];
        int[] nse=new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            pse[i]=s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            nse[i]=s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        long sum=0;
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            long contri=(long)arr[i]*left*right;
            sum=(sum+contri)%mod;
        }
        return (int)sum;
    }
}