class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen=0;
        for(char ch='A';ch<='Z';ch++){
            maxlen=Math.max(maxlen,maxLength(s,k,ch));
        }
        return maxlen;
    }
    private int maxLength(String s,int k,char target){
        int start=0;
        int e=0;
        int maxlen=0;
        int rem=k;
        for(e=0;e<s.length();e++){
            if(s.charAt(e)!=target){
                rem--;
            }
            while(rem<0){
                if(s.charAt(start)!=target){
                    rem++;
                }
                start++;
            }
            maxlen=Math.max(maxlen,e-start+1);
        }
        return maxlen;
    }
}