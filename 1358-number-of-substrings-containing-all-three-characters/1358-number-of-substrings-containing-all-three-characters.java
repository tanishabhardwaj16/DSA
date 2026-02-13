class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1,b=-1,c=-1;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') a=i;
            else if(s.charAt(i)=='b') b=i;
            else c=i;
            if(a!=-1 && b!=-1 && c!=-1){
                count+=Math.min(a,Math.min(b,c))+1;
            }
        }
        return count;
    }
}