class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen=0;
        for(char ch='A';ch<='Z';ch++){
            maxlen=Math.max(maxlen,maxlength(s,k,ch));
        }
        return maxlen;
    }
    public int maxlength(String s,int k,int target){
        int maxlen=0;
        int st=0;
        int e=0;
        int rem=k;
        for(e=0;e<s.length();e++){
            if(s.charAt(e)!=target) rem--;
            while(rem<0){
                if(s.charAt(st)!=target) rem++;
                st++;
            }
            maxlen=Math.max(maxlen,e-st+1);
        }
        return maxlen;
    }
}