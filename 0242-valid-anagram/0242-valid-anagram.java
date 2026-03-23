class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        int n=s.length() , m=t.length();
        if(n != m) return false;
        for(int i=0;i<n;i++){
            char schar=s.charAt(i);
            if(m1.containsKey(schar)){
                m1.put(schar,m1.getOrDefault(schar,0)+1);
            }else{
                m1.put(schar,0);
            }
        }
        for(int i=0;i<m;i++){
            char tchar=t.charAt(i);
            if(m2.containsKey(tchar)){
                m2.put(tchar,m2.getOrDefault(tchar,0)+1);
            }else{
                m2.put(tchar,0);
            }
        }
        if(m1.equals(m2)){
            return true;
        }else{
            return false;
        }    
    }
}