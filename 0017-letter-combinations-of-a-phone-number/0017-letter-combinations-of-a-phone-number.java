class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();
        Map<Character,String> map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result=new ArrayList<>();
        result.add("");
        for( char d : digits.toCharArray()){
            String letters= map.get(d);
            List<String> next=new ArrayList<>();
            for(String s : result){
                for(char c : letters.toCharArray()){
                    next.add(s+c);
                }
            }
            result=next;
        }
        return result;
    }
}