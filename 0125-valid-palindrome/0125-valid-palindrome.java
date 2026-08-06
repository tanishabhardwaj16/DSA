class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch>='a' && ch<='z' || ch>='0' && ch<='9' || ch>='A' && ch<='Z'){
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}