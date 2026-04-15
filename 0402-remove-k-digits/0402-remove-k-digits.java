class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>s=new Stack<>();
        for(char ch : num.toCharArray()){
            while(!s.isEmpty() && k>0 && s.peek()>ch){
                s.pop();
                k--;
            }
            s.push(ch);
        }
        while(k>0){
            s.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        for(char ch : s){
            sb.append(ch);
        }
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }
}