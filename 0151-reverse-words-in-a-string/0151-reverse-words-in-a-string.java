class Solution {
    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        StringBuilder res=new StringBuilder();
        int i=0,j=words.length-1;
        while(i<j){
            String temp=words[i];
            words[i]=words[j];
            words[j]=temp;
            i++;
            j--;
        }
        for(String word : words){
            res.append(word).append(" ");
        }
        return res.toString().trim();
    }
}