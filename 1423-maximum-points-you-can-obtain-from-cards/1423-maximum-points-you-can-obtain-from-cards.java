class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ls=0;
        int rs=0;
        int maxsum=0;
        for(int i=0;i<k;i++){
            ls+=cardPoints[i];
        }
        maxsum=ls;
        int ri=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            ls-=cardPoints[i];
            rs+=cardPoints[ri];
            ri--;
            maxsum=Math.max(maxsum,ls+rs);
        }
        return maxsum;
    }
}