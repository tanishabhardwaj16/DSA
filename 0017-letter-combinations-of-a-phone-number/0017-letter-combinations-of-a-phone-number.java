class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0)return new ArrayList<>();
        String[] map={"", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};
         solve(0,digits,new StringBuilder(),res,map);
         return res;
    }
    public void solve(int i,String digits,StringBuilder op,List<String>res,String[] map){
        if(i==digits.length()){
            res.add(op.toString());
            return;
        }
        String letters=map[digits.charAt(i)-'0'];
        for(char ch : letters.toCharArray()){
            op.append(ch);
            solve(i+1,digits,op,res,map);
            op.deleteCharAt(op.length()-1);
        }
    }
}