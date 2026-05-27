class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(count>0) res.append(s.charAt(i));
                count++;
            }else{
                count--;
                if(count>0) res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}