class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder result=new StringBuilder();
        if(s.length() != goal.length()) return false;
        result.append(s).append(s);
        if(result.toString().contains(goal)) return true;
        else return false;
    }
}