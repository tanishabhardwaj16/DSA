class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long min=getmin(nums);
        long max=getmax(nums);
        return max-min;
    }
    public long getmin(int[] nums){
        int n=nums.length;
        int[] pse=new int[n];
        int[] nse=new int[n];
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]>nums[i]){
                s.pop();
            }
            pse[i]=s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]>=nums[i]){
                s.pop();
            }
            nse[i]=s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        long sum=0;
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            sum+=(long) nums[i]*left*right;
        }
        return sum;
    }
    public long getmax(int[] nums){
        int n=nums.length;
        int[] pge=new int[n];
        int[] nge=new int[n];
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]<nums[i]){
                s.pop();
            }
            pge[i]=s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]<=nums[i]){
                s.pop();
            }
            nge[i]=s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        long sum=0;
        for(int i=0;i<n;i++){
            long left=i-pge[i];
            long right=nge[i]-i;
            sum+=(long) nums[i]*left*right;
        }
        return sum;
    }
}