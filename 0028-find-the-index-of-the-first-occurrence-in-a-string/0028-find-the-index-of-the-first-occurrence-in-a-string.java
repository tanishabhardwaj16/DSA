class Solution {
    public int strStr(String haystack, String needle) {
        int h=haystack.length();
        int n=needle.length();
        if(n>h) return -1;
        for(int i=0;i<=h - n;i++){
            if(isTrue(haystack,needle,i)){
                return i;
            }
        }
        return -1;
    }
    public boolean isTrue(String s1,String s2,int start){
        for(int i=0;i<s2.length();i++){
            if(s1.charAt(i+start)!=s2.charAt(i)) return false;
        }
        return true;
    }
}