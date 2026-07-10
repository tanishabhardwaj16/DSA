class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set=new HashSet<>();
        int st=0,e=0;
        int len=0;
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