class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        int n=s.length() , m=t.length();
        if(n != m) return false;
        for(int i=0;i<n;i++){
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            if(map.containsKey(schar)){
                if(map.get(schar)!=tchar) return false;
            }else if(map.containsValue(tchar)){
                return false;
            }else{
                map.put(schar,tchar);
            }
        }
        return true;
    }
}