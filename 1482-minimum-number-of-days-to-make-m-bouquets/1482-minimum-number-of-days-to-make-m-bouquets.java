class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int s=Integer.MAX_VALUE;
        int e=Integer.MIN_VALUE;
        if((long)m*k > bloomDay.length) return -1;
        int ans=0;
        for(int b : bloomDay){
            s=Math.min(s,b);
            e=Math.max(e,b);
        }
        while(s<=e){
            int mid=s+(e-s)/2;
            if(!possible(bloomDay,mid,m,k)){
                s=mid+1;
            }else{
                ans=mid;
                e=mid-1;
            }
        }
        return ans;
    }

    static boolean possible(int[] bloomDay,int day,int m,int k){
        int count=0;
        int ans=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
            }else{
                ans+=(count/k);
                count=0;
            }
        }
        ans+=(count/k);
        return ans>=m;
    }
}