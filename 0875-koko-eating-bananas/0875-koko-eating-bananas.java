class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        for(int p : piles){
            e=Math.max(e,p);
        }
        int ans=e;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(caneat(piles,h,mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    public boolean caneat(int[] piles,int h,int k){
        int hours=0;
        for(int p : piles){
            hours+=(p+k-1)/k;
            if(hours>h) return false;
        }
        return hours<=h;
    }
}