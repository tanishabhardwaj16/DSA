class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n=s.length();
        if(n==0)return 0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        int sign=1;
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if(s.charAt(i)=='-'){
                sign=-1;
            }
            i++;
        }
        StringBuilder sb=new StringBuilder();
        while(i<n){
            char ch=s.charAt(i);
            if(ch<'0' || ch>'9') break;
            sb.append(ch);
            i++;
        }
        long num=0;
        for(int j=0;j<sb.length();j++){
            int digit=sb.charAt(j)-'0';
            if(num>(Integer.MAX_VALUE-digit)/10){
                return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num=num*10+digit;
        }
        return (int) num*sign;
    }
}