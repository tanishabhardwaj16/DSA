class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
                result.append(Character.toLowerCase(ch));
            }
        }
        return result.toString().equals(result.reverse().toString());
    }
}