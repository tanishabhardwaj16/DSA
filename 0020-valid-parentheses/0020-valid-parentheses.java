class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch =='(' || ch=='[' || ch=='{'){
                stack.push(ch);
           }else{
            if(stack.isEmpty())return false;
            char stackElement=stack.pop();
            if(ch ==')' && stackElement!='('){
                return false;
            }else if(ch==']' && stackElement!='['){
                return false;
            }else if(ch=='}' && stackElement!='{'){
                return false;
            }
           }
        }
        return stack.isEmpty() ? true : false;
    }
}