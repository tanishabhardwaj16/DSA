class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        String[] words=s.split("\\s+");
        StringBuilder result=new StringBuilder();
        int i=0, j=words.length-1;
        while(i<j){
            String temp=words[i];
            words[i]=words[j];
            words[j]=temp;
            i++;
            j--;
        }
        for(int word=0;word<words.length;word++){
            result.append(words[word]).append(" ");
        }
        return result.toString().trim();
    }
}