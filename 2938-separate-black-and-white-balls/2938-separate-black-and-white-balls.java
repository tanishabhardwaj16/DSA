class Solution {
    public long minimumSteps(String s) {
        int i=0;
        int j=s.length()-1;
        long count=0;
        while(i<j){
            if(s.charAt(i)=='0')i++;
            else if(s.charAt(j)=='1')j--;
            else{
                count+=j-i;
                i++;
            j--;
            }
        }
        return count;
    }
}