class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st=0;
        int e=0;
        int len=0;
        HashSet<Character>set=new HashSet<>();
        for(e=0;e<s.length();e++){
            while(set.contains(s.charAt(e))){
                set.remove(s.charAt(st));
                st++;
            }
            set.add(s.charAt(e));
            len=Math.max(len,e-st+1);
        }
        return len;
    }
}