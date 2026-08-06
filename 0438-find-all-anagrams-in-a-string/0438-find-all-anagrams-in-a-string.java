class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        if(s.length()<p.length()) return ans;
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int l=0 , count=map.size();
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            if(map.containsKey(ch)) {
                map.put(ch,map.get(ch)-1);
               if(map.get(ch)==0) count--;
            }
            if(r-l+1==p.length()){
                if(count==0) ans.add(l);
                char left=s.charAt(l);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)==1) count++;
                }
                l++; 
            }
        }
        return ans;
    }
}