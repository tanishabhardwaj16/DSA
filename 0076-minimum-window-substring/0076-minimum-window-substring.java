class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int st=0;
        int e=0;
        int count=0;
        int minstart=0;
        int minlen=Integer.MAX_VALUE;
        int[] freq=new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        for(e=0;e<s.length();e++){
            char echar=s.charAt(e);
            if(freq[echar]>0) count++;
            freq[echar]--;
            while(count==t.length()){
                if(e-st+1<minlen){
                    minlen=e-st+1;
                    minstart=st;
                }
                char schar=s.charAt(st);
                freq[schar]++;
                if(freq[schar]>0) count--;
                st++;
            }
        }
        if(minlen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minstart, minstart + minlen);
    }
}