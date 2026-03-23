class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                if(count>0){
                    result.append(s.charAt(i));
                }
                count++;
            }else{
                if(count>1){
                    result.append(s.charAt(i));
                }
                count--;
            }
        }
        return result.toString();
    }
}