class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=0;
        int e=totalsum(weights);
        for(int w: weights){
            s=Math.max(s,w);
        }
        int ans=e;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(leastcapacity(weights,days,mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public int totalsum(int[] weights){
        int add=0;
        for(int i=0;i<weights.length;i++){
            add+=weights[i];
        }
        return add;
    }
    public boolean leastcapacity(int[] weights,int days,int cap){
        int d=1;
        int sum=0;
        for(int w : weights){
            sum+=w;
            if(sum>cap){
                d++;
                sum=w;
            }
        }
        return d<=days;
    }
}