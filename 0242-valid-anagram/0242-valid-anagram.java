class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>smap=new HashMap<>();
        HashMap<Character,Integer>tmap=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(char c : s.toCharArray()){
            smap.put(c,smap.getOrDefault(c,0)+1);
        }
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        if(smap.equals(tmap)) return true;
        return false;
    }
}