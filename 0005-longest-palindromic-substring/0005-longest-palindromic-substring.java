class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxlen=0;
        int left=0;
        int right=0;
        String result="";
        for(int i=0;i<n;i++){
            left=i;
            right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>maxlen){
                maxlen=Math.max(maxlen,right-left-1);
                result=s.substring(left+1,right);
            }
            left=i;
            right=i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>maxlen){
                maxlen=Math.max(maxlen,right-left-1);
                result=s.substring(left+1,right);
            }           
        }
        return result;
    }
}